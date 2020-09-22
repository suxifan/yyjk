package com.cictec.yyjk.fatigue.api;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTemp;
import com.cictec.yyjk.fatigue.model.vo.VoicepromptTempVo;
import com.cictec.yyjk.fatigue.service.VoicepromptTempService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2020/07/21.
 */
@RestController
@RequestMapping("/msgsend")
public class ApiVoicepromptTemp {
	@Resource
	private VoicepromptTempService voicepromptTempService;

	@PostMapping("/addVoicetempMessage")
	public Result addVoicetempMessage(@RequestBody VoicepromptTemp voicepromptTemp) {
		voicepromptTemp.setVoicetempUuid(UUIDGenerator.genUuidStr());
		voicepromptTempService.insertSelective(voicepromptTemp);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/delVoicetempMessageById")
	public Result delVoicetempMessageById(@RequestBody VoicepromptTemp vo) {
		voicepromptTempService.deleteByPrimaryKey(vo);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/editVoicetempMessage")
	public Result editVoicetempMessage(@RequestBody VoicepromptTemp voicepromptTemp) {
		voicepromptTempService.updateByPrimaryKeySelective(voicepromptTemp);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/list")
	public Result list(@RequestBody VoicepromptTempVo voicepromptTempVo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (voicepromptTempVo.getPageSize() != null && voicepromptTempVo.getPageSize() != 0) {
			return pageList(voicepromptTempVo);
		}

		// TODO 根据具体业务重写
		List<VoicepromptTemp> list = voicepromptTempService.select(null);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/pageList")
	public Result pageList(@RequestBody VoicepromptTempVo voicepromptTempVo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(voicepromptTempVo.getPageNumber(), voicepromptTempVo.getPageSize());
		// TODO 根据具体业务重写
		List<VoicepromptTemp> list = voicepromptTempService.select(null);
		return ResultUtil.getSuccessResult(new PageInfo<VoicepromptTemp>(list));

		/*
		 * 方法二：
		 */
		// String orderBy = sort + " " + order;
		// PageInfo<VoicepromptTemp> pageInfo =
		// voicepromptTempService.selectPage(voicepromptTempVo.getPageNumber(),
		// voicepromptTempVo.getPageSize(), null);
		// return ResultUtil.getSuccessResult(pageInfo);

	}

}
