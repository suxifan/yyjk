package org.yyjk.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CaseFormat;

import freemarker.template.TemplateExceptionHandler;

public class CodeGenerator {
	private static final Logger logger = LoggerFactory.getLogger(CodeGenerator.class);
	public static void main(String[] args) {
		// genCode("输入表名");
		// genCode("输入表名, 输入自定义Model名称");
		// genCodeByCustomModelName("输入表名","输入自定义Model名称");
		new CodeGenerator(new GeneratorEntity()).genCode("dw_dim_bus", "Bus");
	}
	
	private GeneratorEntity entity;
	
	public CodeGenerator(GeneratorEntity entity){
		this.entity = entity;
	}
    
	
	 /**
	 * 通过数据表名称生成代码，Model 名称通过解析数据表名称获得，下划线转大驼峰的形式。 如输入表名称 "t_user_detail" 将生成
	 * TUserDetail、TUserDetailMapper、TUserDetailService ...
	 * 
	 * @param tableNames
	 *            数据表名称...
	 */
	public static void genCode(String... tableNames) {
		for (String name : tableNames) {
			// 根据需求生成，不需要的注掉，模板有问题的话可以自己修改。
			String[] nameparams = name.split(",");
			String tableName = null;
			String modelName = null;
			if (name.indexOf(",") > 0) {
				// 表示生成的实体有别名
				tableName = nameparams[0];
				modelName = nameparams[1];
			} else {
				tableName = name;
			}

			new CodeGenerator(new GeneratorEntity()).genCodeByCustomModelName(tableName, modelName);
		}
	}

    /**
	 * 通过数据表名称，和自定义的 Model 名称生成代码 如输入表名称 "t_user_detail" 和自定义的 Model 名称 "User"
	 * 将生成 User、UserMapper、UserService ...
	 * 
	 * @param tableName
	 *            数据表名称
	 * @param modelName
	 *            自定义的 Model 名称
	 */
    public void genCodeByCustomModelName(String tableName, String modelName) {
        genModelAndMapper(tableName, modelName);
        genService(tableName, modelName);
//        genController(tableName, modelName);
        genApi(tableName, modelName);
        genVo(tableName, modelName);
    }


    public void genModelAndMapper(String tableName, String modelName) {
        Context context = new Context(ModelType.FLAT);
        context.setId("Potato");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(entity.getJdbcUrl());
        jdbcConnectionConfiguration.setUserId(entity.getJdbcUserName());
        jdbcConnectionConfiguration.setPassword(entity.getJdbcPassword());
        jdbcConnectionConfiguration.setDriverClass(entity.getJdbcDiverClassName());
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", entity.getMapper_interface_reference());
        context.addPluginConfiguration(pluginConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(entity.getProjectPath() + entity.getJavaPath());
        javaModelGeneratorConfiguration.setTargetPackage(entity.getModel_package());
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(entity.getProjectPath() + entity.getResourcesPath());
//        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        
        String basePackage = entity.getBase_package();
        String baseMapper = basePackage.substring(basePackage.lastIndexOf("."));
        sqlMapGeneratorConfiguration.setTargetPackage("mapper"+ baseMapper);
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(entity.getProjectPath() + entity.getJavaPath());
        javaClientGeneratorConfiguration.setTargetPackage(entity.getMapper_package());
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        if (StringUtils.isNotEmpty(modelName))tableConfiguration.setDomainObjectName(modelName);
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            boolean overwrite = true;
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
			throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
			throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }
        if (StringUtils.isEmpty(modelName)) modelName = tableNameConvertUpperCamel(tableName);
		logger.info(modelName + ".java 生成成功");
		logger.info(modelName + "Mapper.java 生成成功");
		logger.info(modelName + "Mapper.xml 生成成功");
    }

    public void genService(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", entity.getDate());
            data.put("author", entity.getAuthor());
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", entity.getBase_package());
            data.put("commonsPackage", entity.getCommons_package());

            File file = new File(entity.getProjectPath() + entity.getJavaPath() + entity.getPackagePathService() + modelNameUpperCamel + "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
			logger.info(modelNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(entity.getProjectPath() + entity.getJavaPath() + entity.getPackagePathServiceImpl() + modelNameUpperCamel + "ServiceImpl.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-impl.ftl").process(data,
                    new FileWriter(file1));
			logger.info(modelNameUpperCamel + "ServiceImpl.java 生成成功");
        } catch (Exception e) {
			throw new RuntimeException("生成Service失败", e);
        }
    }

    public void genApi(String tableName, String modelName) {
    	try {
    		freemarker.template.Configuration cfg = getConfiguration();
    		
    		Map<String, Object> data = new HashMap<>();
    		data.put("date", entity.getDate());
    		data.put("author", entity.getAuthor());
    		String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
    		data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
    		data.put("modelNameUpperCamel", modelNameUpperCamel);
    		data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
    		data.put("basePackage", entity.getBase_package());
    		data.put("apiPackage", entity.getApi_package());
    		data.put("commonsPackage", entity.getCommons_package());
    		
    		String _controllerPath = entity.getPackagePathController();
    		String _api = _controllerPath.substring(0, _controllerPath.lastIndexOf("controller")) + "/api/";
    		String apiName = entity.getProjectPath() + entity.getJavaPath() + _api+ "Api" +modelNameUpperCamel + ".java";
    		File file = new File(apiName);
    		if (!file.getParentFile().exists()) {
    			file.getParentFile().mkdirs();
    		}
    		//cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
    		cfg.getTemplate("api.ftl").process(data, new FileWriter(file));
    		
			logger.info("Api" + modelNameUpperCamel + ".java 生成成功");
    	} catch (Exception e) {
			throw new RuntimeException("生成Controller失败", e);
    	}
    	
    }

    public void genController(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", entity.getDate());
            data.put("author", entity.getAuthor());
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("baseRequestMapping", modelNameConvertMappingPath(modelNameUpperCamel));
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, modelNameUpperCamel));
            data.put("basePackage", entity.getBase_package());
            data.put("commonsPackage", entity.getCommons_package());

            File file = new File(entity.getProjectPath() + entity.getJavaPath() + entity.getPackagePathController() + modelNameUpperCamel + "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
            cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

			logger.info(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
			throw new RuntimeException("生成Controller失败", e);
        }

    }

    public void genVo(String tableName, String modelName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", entity.getDate());
            data.put("author", entity.getAuthor());
            String modelNameUpperCamel = StringUtils.isEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", entity.getBase_package());
            data.put("commonsPackage", entity.getCommons_package());

            File file = new File(entity.getProjectPath() + entity.getJavaPath()+ entity.getPackagePathVo() + modelNameUpperCamel + "Vo.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("vo.ftl").process(data, new FileWriter(file));
			logger.info(modelNameUpperCamel + "Vo.java 生成成功");

        } catch (Exception e) {
			throw new RuntimeException("生成Service失败", e);
        }
    }
    
    private freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(entity.getTemplateFliePath()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private String tableNameConvertLowerCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, tableName.toLowerCase());
    }

    private String tableNameConvertUpperCamel(String tableName) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName.toLowerCase());

    }

    private String tableNameConvertMappingPath(String tableName) {
		tableName = tableName.toLowerCase();// 兼容使用大写的表名
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private String modelNameConvertMappingPath(String modelName) {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, modelName);
        return tableNameConvertMappingPath(tableName);
    }

    private String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }
}
