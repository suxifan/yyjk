package ${basePackage}.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ${commonsPackage}.core.Result;
import ${commonsPackage}.core.ResultUtil;
import ${basePackage}.model.entity.${modelNameUpperCamel};
import ${basePackage}.model.vo.${modelNameUpperCamel}Vo;
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;


/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("/api${baseRequestMapping}")
public class Api${modelNameUpperCamel} {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.insertSelective(${modelNameLowerCamel});
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteByPrimaryKey(id);
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.updateByPrimaryKeySelective(${modelNameLowerCamel});
        return ResultUtil.getSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.selectByPrimaryKey(id);
        return ResultUtil.getSuccessResult(${modelNameLowerCamel});
    }

	@PostMapping("/list")
    public Result list(@RequestBody ${modelNameUpperCamel}Vo ${modelNameLowerCamel}Vo) {
    
    	// 判定是否包含分页参数，如果包含则为分页数据请求
    	if(${modelNameLowerCamel}Vo.getPageSize() != null && ${modelNameLowerCamel}Vo.getPageSize() != 0){
    		return pageList(${modelNameLowerCamel}Vo);
    	}
    	
    	// TODO 根据具体业务重写
    	List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.select(null);
    	
		return ResultUtil.getSuccessResult(list);
    }
    
	@PostMapping("/pageList")
	public Result pageList (@RequestBody ${modelNameUpperCamel}Vo ${modelNameLowerCamel}Vo) {
		/*
		 * 方法一：
		 */
		// 分页数据请求处理
		PageHelper.startPage(${modelNameLowerCamel}Vo.getPageNumber(), ${modelNameLowerCamel}Vo.getPageSize());
		// TODO 根据具体业务重写
    	List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.select(null);
    	return ResultUtil.getSuccessResult(new PageInfo<${modelNameUpperCamel}>(list));
    	
    	/*
    	 * 方法二：
    	 */
//		String orderBy = sort + " " + order;
// 		PageInfo<${modelNameUpperCamel}> pageInfo = ${modelNameLowerCamel}Service.selectPage(${modelNameLowerCamel}Vo.getPageNumber(), ${modelNameLowerCamel}Vo.getPageSize(), null);
//		return ResultUtil.getSuccessResult(pageInfo);
		
	}
	
}
