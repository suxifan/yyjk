package com.cictec.yyjk.fatigue.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.base.mapper.BusLineMapper;
import com.cictec.yyjk.base.mapper.BusMapper;
import com.cictec.yyjk.base.mapper.BusSysOrgMapper;
import com.cictec.yyjk.base.mapper.DwDimOtherDeviceMapper;
import com.cictec.yyjk.base.model.entity.Bus;
import com.cictec.yyjk.base.model.entity.BusLine;
import com.cictec.yyjk.base.model.entity.BusSysOrg;
import com.cictec.yyjk.base.model.entity.DwDimOtherDevice;
import com.cictec.yyjk.base.model.vo.TreeNode2;
import com.cictec.yyjk.base.utils.TreeUtils;
import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.mapper.TempDeviceSendTaskDetailMapper;
import com.cictec.yyjk.fatigue.mapper.TempDeviceSendTaskMapper;
import com.cictec.yyjk.fatigue.model.entity.TDevice;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTask;
import com.cictec.yyjk.fatigue.model.entity.TempDeviceSendTaskDetail;
import com.cictec.yyjk.fatigue.rabbitmq.sender.JsxwSendTaskService;
import com.cictec.yyjk.fatigue.service.TempDeviceSendTaskService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;


/**
 * Created by xpguo on 2019/11/21.
 */
@Service
@Transactional
public class TempDeviceSendTaskServiceImpl extends AbstractService<TempDeviceSendTask> implements TempDeviceSendTaskService {
	private static final Logger LOG = LoggerFactory.getLogger(TempDeviceSendTaskServiceImpl.class);
    @Resource
    private TempDeviceSendTaskMapper tempDeviceSendTaskMapper;
    
    @Resource
	private TempDeviceSendTaskDetailMapper tempDeviceSendTaskDetailMapper; // 任务详情Mapper
    
    @Resource
    private JsxwSendTaskService jsxwSendTaskService;
    
    @Resource
	private BusSysOrgMapper busSysOrgMapper;// 组织结构dao
    
    @Resource
	private BusLineMapper busLineMapper;// 线路dao
    
    @Resource
	private BusMapper busMapper;// 车辆dao
    
    @Resource
	private DwDimOtherDeviceMapper dwDimOtherDeviceMapper;// 设备dao

	@Override
	public List<TempDeviceSendTask> selectTaskPage(TempDeviceSendTask vo) {
		return tempDeviceSendTaskMapper.selectTaskPage(vo);
	}

	@Override
	public int saveTask(TempDeviceSendTask vo) {
		int i = tempDeviceSendTaskMapper.insertSelective(vo);
		String taskUuid = vo.getTaskUuid();
		List<TDevice> devList = vo.getDevList();
		List<String> devCodes = new ArrayList<String>();
		for(TDevice dev:devList){
			TempDeviceSendTaskDetail taskDetail = new TempDeviceSendTaskDetail();
			taskDetail.setTaskDetailUuid(UUIDGenerator.genUuidStr());
			taskDetail.setTaskUuid(taskUuid);
			taskDetail.setDevUuid(dev.getDevUuid());
			devCodes.add(dev.getDevCode());
			taskDetail.setDevCode(dev.getDevCode());
			taskDetail.setTaskStatus("0");
			tempDeviceSendTaskDetailMapper.insertSelective(taskDetail);
		}
		putMsgToMQ(taskUuid,devCodes,vo.getJsonData());
		return i;
	}

	@Override
	public int saveTask2(TempDeviceSendTask vo) {
		List<String> devCodes = new ArrayList<String>();
		List<TDevice> devList = vo.getDevList();
		for(TDevice dev:devList){
			devCodes.add(dev.getDevCode());
		}
		putMsgToMQ(vo.getTaskUuid(),devCodes,vo.getJsonData());
		return 0;
	}
	
	/**
	 * 推送MQ消息 json 结构 ；{"messageType":"sendParams","taskUuid":"111111111",
	 * "jsonData" : [ {"alarmType" : "adas" , "data" : { "alarmSpeed":
	 * 255,"alarmVoice":255} } ,{"alarmType" : "dsm" , "data" : {
	 * "photoResolution": 6,"videoResolution":7} }],
	 * "devCodes":["13912345670","13800000000"] }
	 ***/
	private void putMsgToMQ(String taskUuid,List<String> devCodes,List<Object> jsonData) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("messageType", "sendParams");
		map.put("taskUuid", taskUuid);
		map.put("jsonData", jsonData);
		map.put("devCodes", devCodes);
		try {
			jsxwSendTaskService.saveJsxwSendTask(map);
		} catch (Exception e) {
			LOG.error("推送MQ消息异常，原因{}", e);
		}
		
	}

	@Override
	public List<TreeNode2> orgLineBusTreeGet() {
		BusSysOrg vo = new BusSysOrg();
		//vo.setOrgUuid();
		vo.setOrgDropFlag("0");
		vo.setOrgType(1);
		List<BusSysOrg> list = busSysOrgMapper.selectTBusSysOrgList(vo);
		if (list != null && list.size() > 0) {
			List<TreeNode2> trees = TreeUtils.buildTree2(list);
			for (TreeNode2 node : trees) {
				if (node.getpId() == null) {// 总公司
					node.setLevelsType("0");
					node.setOpen(true);
				}
				// getAllChilrens(node);
				if (node.getChildren().size() > 0) {
					Set<TreeNode2> childs = node.getChildren();
					for (TreeNode2 child : childs) {
						addLineAndBusNodes(child);
					}
				} else {
					addLineAndBusNodes(node);
				}
			}
			return trees;
		}
		return Collections.emptyList();
	}


	private void addLineAndBusNodes(TreeNode2 node) {
		// 分公司
		node.setLevelsType("1");
		node.setOpen(false);
		Example example = new Example(BusLine.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("lineOrgUuid", node.getId());
		criteria.andEqualTo("lineIsvalid", "1");
		criteria.andEqualTo("lineDropFlag", "0");
		List<BusLine> lineList = busLineMapper.selectByExample(example);
		if (lineList != null && lineList.size() > 0) {
			for (BusLine line : lineList) {
				TreeNode2 lineNode = new TreeNode2();
				lineNode.setId(line.getLineUuid());
				lineNode.setName(line.getLineName());
				lineNode.setpId(node.getId());
				lineNode.setOpen(false);
				lineNode.setLevelsType("2");
				
				// 查询线路下的车辆
				Example busExample = new Example(Bus.class);
				Criteria busCriteria = busExample.createCriteria();
				busCriteria.andEqualTo("busLineUuid", line.getLineUuid());
				busCriteria.andEqualTo("busIsvalid", "1");
				busCriteria.andEqualTo("busDropFlag", "0");
				List<Bus> busList = busMapper.selectByExample(busExample);
				/*BusVo param = new BusVo();
				param.setLineId( line.getLineUuid());
				param.setBusIsvalid("1");
				param.setBusDropFlag("0");
				List<Bus> busList = busMapper.getBusListByWarnDev(param);*/
				if (busList != null && busList.size() > 0) {
				node.addChild(lineNode);	
					for (Bus bus : busList) {
						TreeNode2 busNode = new TreeNode2();
						busNode.setId(bus.getBusUuid());
						busNode.setName(bus.getBusPlateNumber());
						busNode.setpId(line.getLineUuid());
						busNode.setOpen(false);
						busNode.setLevelsType("3");
						
						
						// 查询车辆下的minieye设备
						String busUuid = bus.getBusUuid();
						List<DwDimOtherDevice> devList = dwDimOtherDeviceMapper.getDeviceInfoByMinieye(busUuid);
						if (devList != null && devList.size() > 0) {
						lineNode.addChild(busNode);
							for (DwDimOtherDevice dev : devList) {
								TreeNode2 devNode = new TreeNode2();
								devNode.setId(dev.getDevUuid());
								devNode.setName(dev.getDevCode());
								devNode.setpId(busUuid);
								devNode.setOpen(false);
								devNode.setLevelsType("4");
								busNode.addChild(devNode);
							}
						}
						
					}
				}
			}
		}
	}

}
