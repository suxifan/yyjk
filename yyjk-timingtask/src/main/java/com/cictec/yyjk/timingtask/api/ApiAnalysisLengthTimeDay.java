package com.cictec.yyjk.timingtask.api;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;
import com.cictec.yyjk.timingtask.model.entity.AnalysisLengthTimeDay;
import com.cictec.yyjk.timingtask.service.AnalysisLengthTimeDayService;


/**
* Created by xpguo on 2019/06/28.
*/
@RestController
@RequestMapping("/api/analysis/length/time/day")
public class ApiAnalysisLengthTimeDay {
    @Resource
    private AnalysisLengthTimeDayService analysisLengthTimeDayService;

    @PostMapping("/add")
    public Result add(@RequestBody AnalysisLengthTimeDay analysisLengthTimeDay) {
        analysisLengthTimeDayService.insertSelective(analysisLengthTimeDay);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        analysisLengthTimeDayService.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody AnalysisLengthTimeDay analysisLengthTimeDay) {
        analysisLengthTimeDayService.updateByPrimaryKeySelective(analysisLengthTimeDay);
        return ResultUtil.getSuccessResult();
    }

}
