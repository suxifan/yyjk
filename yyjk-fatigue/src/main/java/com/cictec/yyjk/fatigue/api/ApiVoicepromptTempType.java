package com.cictec.yyjk.fatigue.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.commons.utils.UUIDGenerator;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTemp;
import com.cictec.yyjk.fatigue.model.entity.VoicepromptTempType;
import com.cictec.yyjk.fatigue.model.vo.VoicepromptTempTypeVo;
import com.cictec.yyjk.fatigue.service.VoicepromptTempService;
import com.cictec.yyjk.fatigue.service.VoicepromptTempTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Created by xpguo on 2020/07/21.
 */
@RestController
@RequestMapping("/msgsend")
public class ApiVoicepromptTempType {
	@Resource
	private VoicepromptTempTypeService voicepromptTempTypeService;
	@Resource
	private VoicepromptTempService voicepromptTempService;

	@PostMapping("/addNewVoicetempTypeData")
	public Result addNewVoicetempTypeData(@RequestBody VoicepromptTempType voicepromptTempType) {
		voicepromptTempType.setVoicetempTypeUuid(UUIDGenerator.genUuidStr());
		voicepromptTempTypeService.insertSelective(voicepromptTempType);
		Map<String, String> result = new HashMap<String, String>();
		result.put("voicetempTypeUuid", voicepromptTempType.getVoicetempTypeUuid());
		return ResultUtil.getSuccessResult(result);
	}

	@PostMapping("/delNewVoicetempTypeById")
	public Result delNewVoicetempTypeById(@RequestBody VoicepromptTempTypeVo vo) {
		voicepromptTempTypeService.deleteByPrimaryKey(vo);
		// 删除子表
		voicepromptTempService.deleteByField("voicetempTypeUuid", vo.getVoicetempTypeUuid());
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/editNewVoicetempTypeById")
	public Result editNewVoicetempTypeById(@RequestBody VoicepromptTempType voicepromptTempType) {
		voicepromptTempTypeService.updateByPrimaryKeySelective(voicepromptTempType);
		return ResultUtil.getSuccessResult();
	}

	@PostMapping("/getVoicetempTypeData")
	public Result getVoicetempTypeData(@RequestBody VoicepromptTempTypeVo vo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (vo.getPageNum() != null && vo.getPageSize() != 0) {
			return typeDatapageList(vo);
		}

		List<VoicepromptTempType> list = voicepromptTempTypeService.selectVoicepromptType(vo);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/typeDatapageList")
	public Result typeDatapageList(@RequestBody VoicepromptTempTypeVo vo) {
		// 分页数据请求处理
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<VoicepromptTempType> list = voicepromptTempTypeService.selectVoicepromptType(vo);
		return ResultUtil.getSuccessResult(new PageInfo<VoicepromptTempType>(list));

	}

	@PostMapping("/getVmContentsByVtUuid")
	public Result getVmContentsByVtUuid(@RequestBody VoicepromptTempTypeVo vo) {

		// 判定是否包含分页参数，如果包含则为分页数据请求
		if (vo.getPageNum() != null && vo.getPageSize() != 0) {
			return vtUuidpageList(vo);
		}

		List<VoicepromptTemp> list = voicepromptTempTypeService.getVmContentsByVtUuid(vo);

		return ResultUtil.getSuccessResult(list);
	}

	@PostMapping("/vtUuidpageList")
	public Result vtUuidpageList(@RequestBody VoicepromptTempTypeVo vo) {
		// 分页数据请求处理
		PageHelper.startPage(vo.getPageNum(), vo.getPageSize());
		List<VoicepromptTemp> list = voicepromptTempTypeService.getVmContentsByVtUuid(vo);
		return ResultUtil.getSuccessResult(new PageInfo<VoicepromptTemp>(list));

	}

}
