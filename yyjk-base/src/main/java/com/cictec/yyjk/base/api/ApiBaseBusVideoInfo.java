package com.cictec.yyjk.base.api;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cictec.yyjk.base.interceptors.AccessLogInfo;
import com.cictec.yyjk.base.model.entity.BaseBusVideoInfo;
import com.cictec.yyjk.base.model.vo.BaseBusVideoInfoVo;
import com.cictec.yyjk.base.service.BaseBusVideoInfoService;
import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
* Created by xpguo on 2019/11/13.
*/
@RestController
@RequestMapping("/api/base/bus/video/info")
public class ApiBaseBusVideoInfo {
	private static final Logger LOG = LoggerFactory.getLogger(ApiBaseBusVideoInfo.class);
    @Resource
    private BaseBusVideoInfoService baseBusVideoInfoService;

	/**
	 * 设备设备批量设置，如果某个批次的车辆已设置，则更新
	 * 
	 * @param param
	 * @return
	 */
    @PostMapping("/add")
	public Result add(@RequestBody Map<String, Object> param) {
		String gridDatas = (String) param.get("list");
		if (PMSUtils.isNotEmpty(gridDatas)) {
			List<BaseBusVideoInfo> baseBusVideoInfos = JSON.parseArray(gridDatas, BaseBusVideoInfo.class);
			try {
				baseBusVideoInfoService.batchSet(baseBusVideoInfos);
			} catch (Exception e) {
				LOG.error("批量设置车辆视频设备位置关系失败，异常原因：{}", e);
				return ResultUtil.getErrorResult();
			}
		}
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
	public Result delete(@RequestParam Map<String, Object> param) {
		String uuid = (String) param.get("uuid");
		baseBusVideoInfoService.deleteByPrimaryKey(uuid);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
	public Result update(@RequestBody Map<String, Object> param) {
		String gridDatas = (String) param.get("list");
		if (PMSUtils.isNotEmpty(gridDatas)) {
			List<BaseBusVideoInfo> baseBusVideoInfos = JSON.parseArray(gridDatas, BaseBusVideoInfo.class);
			try {
				baseBusVideoInfoService.updateList(baseBusVideoInfos);
			} catch (Exception e) {
				LOG.error("更新车辆视频设备位置关系失败，异常原因：{}", e);
				return ResultUtil.getErrorResult();
			}
		}
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
	public Result detail(@RequestParam Map<String, Object> param) {
		String uuid = (String) param.get("uuid");
		BaseBusVideoInfo baseBusVideoInfo = baseBusVideoInfoService.selectByPrimaryKey(uuid);
        return ResultUtil.getSuccessResult(baseBusVideoInfo);
    }

	@AccessLogInfo(modelName = "系统管理", pageName = "通道配置")
	@PostMapping("/list")
    public Result list(@RequestBody BaseBusVideoInfoVo baseBusVideoInfoVo) {
		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (baseBusVideoInfoVo.getPageSize() != null && baseBusVideoInfoVo.getPageSize() != 0) {
			return pageList(baseBusVideoInfoVo);
		}
		List<BaseBusVideoInfo> list = null;
		try {
			list = baseBusVideoInfoService.queryBusVideos(baseBusVideoInfoVo);
		} catch (Exception e) {
			LOG.error("查询车辆视频设备位置关系失败，异常原因：{}", e);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult(list);
	}
    
	@PostMapping("/pageList")
	public Result pageList(@RequestBody BaseBusVideoInfoVo baseBusVideoInfoVo) {
		PageHelper.startPage(baseBusVideoInfoVo.getPageNumber(), baseBusVideoInfoVo.getPageSize());
		List<BaseBusVideoInfo> list = null;
		try {
			list = baseBusVideoInfoService.queryBusVideos(baseBusVideoInfoVo);
		} catch (Exception e) {
			LOG.error("分页查询车辆视频设备位置关系失败，异常原因：{}", e);
			return ResultUtil.getErrorResult();
		}
		return ResultUtil.getSuccessResult(new PageInfo<BaseBusVideoInfo>(list));
    }
}
