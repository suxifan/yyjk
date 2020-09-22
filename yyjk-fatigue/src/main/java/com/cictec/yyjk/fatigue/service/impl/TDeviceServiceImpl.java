package com.cictec.yyjk.fatigue.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.core.AbstractService;
import com.cictec.yyjk.commons.utils.PMSUtils;
import com.cictec.yyjk.commons.utils.ShowDateTypes;
import com.cictec.yyjk.commons.utils.TimerUtils;
import com.cictec.yyjk.fatigue.mapper.TDeviceMapper;
import com.cictec.yyjk.fatigue.model.entity.TDevice;
import com.cictec.yyjk.fatigue.model.vo.TDeviceVo;
import com.cictec.yyjk.fatigue.service.TDeviceService;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2019/11/16.
 */
@Service
@Transactional
public class TDeviceServiceImpl extends AbstractService<TDevice> implements TDeviceService {
	@Resource
	private TDeviceMapper deviceMapper;

	@Override
	public Map<String, String> countDeviceStatus(TDeviceVo vo) {
		return deviceMapper.countDeviceStatus(vo);
	}

	@Override
	public List<TDevice> queryDeviveInfo(TDeviceVo vo) {
		List<TDevice> list = deviceMapper.queryDeviveInfo(vo);
		if (list == null) {
			return Collections.emptyList();
		}
		for (TDevice bean : list) {
			if (PMSUtils.isNotEmpty(bean.getOfflineTimeLabel())) {
				int warnTimes = Integer.parseInt(bean.getOfflineTimeLabel());
				int day = warnTimes / (60 * 24);
				int hour = (warnTimes - day * (60 * 24)) / (60);
				int min = warnTimes - day * (60 * 24) - hour * (60);
				String warnTimesStr = day + "天" + hour + "小时" + min + "分钟";
				bean.setOfflineTimeLabel(warnTimesStr);
			}
		}
		return list;
	}

	/**
	 * 查询分页功能，初次访问直接访问数据库且返回第一页数据，如果查询条件不变，以后页面在内存中分页，如果查询条件改变，改为查询数据库并返回第一页
	 * 
	 * initQueryMap 记录是否第一次访问及查询条件是否已改变
	 * 
	 * list保存数据库查询结果，作为内存分页数据源
	 * 
	 */
	static Map<String, TDeviceVo> initQueryMap = new HashMap<>();
	static List<TDevice> list = new ArrayList<>();

	@Override
	public PageInfo<TDevice> selfPageList(TDeviceVo vo) {
		// 设备在线不停变化，不能根据查询条件的变换来确定设备是否在线
		List<TDevice> list = queryDeviveInfoByCountOffLineTime(vo);
		if (initQueryMap.get("initQuery") == null) {// 第一次进来，查询数据库并返回第一页
			initQueryMap.put("initQuery", vo);
			PageInfo<TDevice> pageInfo = getFirstPage(vo, list);
			return pageInfo;
		} else {
			if (initQueryMap.get("initQuery").equals(vo)) {// 除了分页参数，查询条件不变，直接对上次查询结果内存分页
				return pageFromMemory(vo, list);
			} else {// 查询条件改变，1，更新查询条件到initQueryMap；2，去数据库查询后再分页并返回第一页
				initQueryMap.put("initQuery", vo);
				PageInfo<TDevice> pageInfo = getFirstPage(vo, list);
				return pageInfo;
			}
		}
	}

	public PageInfo<TDevice> selfPageList2(TDeviceVo vo) {
		if (initQueryMap.get("initQuery") == null) {// 第一次进来，查询数据库并返回第一页
			initQueryMap.put("initQuery", vo);
			Map<String, Object> map = pageFromDb(vo);
			list = (List) map.get("list");
			return (PageInfo<TDevice>) map.get("pageInfo");
		} else {
			if (initQueryMap.get("initQuery").equals(vo)) {// 除了分页参数，查询条件不变，直接对上次查询结果内存分页
				return pageFromMemory(vo, list);
			} else {// 查询条件改变，1，更新查询条件到initQueryMap；2，去数据库查询后再分页并返回第一页
				initQueryMap.put("initQuery", vo);
				Map<String, Object> map = pageFromDb(vo);
				list = (List) map.get("list");
				return (PageInfo<TDevice>) map.get("pageInfo");
			}
		}
	}

	/**
	 * 返回第一页
	 * 
	 * @param vo
	 * @return
	 */
	private PageInfo<TDevice> getFirstPage(TDeviceVo vo, List<TDevice> list) {
		List<TDevice> result = new ArrayList<>();
		if (list.size() <= vo.getPageSize()) {
			result.addAll(list);
		} else {
			result.addAll(list.subList(0, vo.getPageSize()));
		}

		PageInfo<TDevice> pageInfo = new PageInfo<>();
		pageInfo.setPageNum(1);
		pageInfo.setPageSize(vo.getPageSize());
		pageInfo.setTotal(list.size());
		pageInfo.setList(result);
		return pageInfo;
	}

	/**
	 * 查询数据库，并返回第一页
	 * 
	 * @param vo
	 * @return
	 */
	private Map<String, Object> pageFromDb(TDeviceVo vo) {
		List<TDevice> result = new ArrayList<>();
		List<TDevice> list = queryDeviveInfoByCountOffLineTime(vo);
		if (list.size() <= vo.getPageSize()) {
			result.addAll(list);
		} else {
			result.addAll(list.subList(0, vo.getPageSize()));
		}

		PageInfo<TDevice> pageInfo = new PageInfo<>();
		pageInfo.setPageNum(1);
		pageInfo.setPageSize(vo.getPageSize());
		pageInfo.setTotal(list.size());
		pageInfo.setList(result);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		resultMap.put("pageInfo", pageInfo);
		return resultMap;
	}

	/**
	 * 查询条件不变时，内存分页
	 * 
	 * @param vo
	 * @return
	 */
	private PageInfo<TDevice> pageFromMemory(TDeviceVo vo, List<TDevice> list) {
		List<TDevice> result = new ArrayList<>();
		int firstIndex = (vo.getPageNumber() - 1) * vo.getPageSize();
		int lastIndex = vo.getPageNumber() * vo.getPageSize();
		if (list.size() <= lastIndex) {
			int pageNum = (list.size() % vo.getPageSize() > 0) ? (list.size() / vo.getPageSize()) + 1
					: (list.size() / vo.getPageSize());
			vo.setPageNumber(pageNum);
			firstIndex = (pageNum - 1) * vo.getPageSize();
			result.addAll(list.subList(firstIndex, list.size()));
		} else {
			result.addAll(list.subList(firstIndex, lastIndex));
		}
		PageInfo<TDevice> pageInfo = new PageInfo<>();
		pageInfo.setPageNum(vo.getPageNumber());
		pageInfo.setPageSize(vo.getPageSize());
		pageInfo.setTotal(list.size());
		pageInfo.setList(result);
		return pageInfo;
	}

	@Override
	public List<TDevice> queryDeviveInfoByCountOffLineTime(TDeviceVo vo) {
		List<TDevice> result = new ArrayList<>();
		List<TDevice> list = deviceMapper.queryDeviveInfo(vo);
		// 存放一直没有上过线的设备（离线时间为空）
		List<TDevice> noOffLineTimeList = new ArrayList<>();
		// 存放离线的设备（离线时间不为空）
		List<TDevice> offLineTimeList = new ArrayList<>();
		if (list != null && list.size() > 0) {
			for (TDevice bean : list) {
				if (bean.getDevOnlineTime() == null || "在线".equals(bean.getDevOnlineStatus())) {
					noOffLineTimeList.add(bean);
				} else {
					Date now = new Date();
					long offLineTime = now.getTime() - bean.getDevOnlineTime().getTime();
					bean.setOfflineTime(offLineTime + "");
					bean.setOfflineTimeLabel(TimerUtils.dateDiffString(bean.getDevOnlineTime().getTime(), now.getTime(),
							ShowDateTypes.SEC));
					offLineTimeList.add(bean);
				}
			}
			if (noOffLineTimeList.size() > 0) {
				result.addAll(noOffLineTimeList);
			}
			// 对离线记录按时间倒序排序，并添加到输出列表中
			if (offLineTimeList.size() > 0) {
				Collections.sort(offLineTimeList, new Comparator<TDevice>() {
					@Override
					public int compare(TDevice arg0, TDevice arg1) {
						long interval = Long.parseLong(arg1.getOfflineTime()) - Long.parseLong(arg0.getOfflineTime());
						if (interval < 0) {
							return -1;
						} else {
							return 1;
						}
					}
				});
				result.addAll(offLineTimeList);
			}
		}
		return result;
	}

}
