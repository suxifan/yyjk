package com.cictec.yyjk.base.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cictec.yyjk.commons.core.Result;
import com.cictec.yyjk.commons.core.ResultUtil;

/**
 * 通用接口请求
* Created by Rwq on 2019/07/26.
*/
@RestController
@RequestMapping("/api/base/common")
public class ApiBaseCommon {
	
	@Autowired
	private Environment env;
	
	/**
	 * 获取城市默认坐标点
	* Created by Rwq on 2019/05/28.
	*/
    @PostMapping("/getCityCoordinatePoints")
    public Result getCityCoordinatePoints(@RequestBody Map<String, Object> paramMap) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("lat", env.getProperty("lat"));
        map.put("lng", env.getProperty("lng"));
        map.put("city", env.getProperty("city"));
        return ResultUtil.getSuccessResult(map);
    }
    
}
