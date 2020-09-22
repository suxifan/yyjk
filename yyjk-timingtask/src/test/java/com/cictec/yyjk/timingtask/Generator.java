package com.cictec.yyjk.timingtask;

import org.yyjk.generator.CodeGenerator;
import org.yyjk.generator.GeneratorEntity;

public class Generator {

	private static GeneratorEntity getGeneratorEntity() {
		GeneratorEntity entity = new GeneratorEntity();
		entity.setCommons_package("com.cictec.yyjk.commons"); // 通用引用所在包路径
		entity.setBase_package("com.cictec.yyjk.timingtask");// 生成代码所在的基础包名称，可根据自己公司的项目修改（注意：这个配置修改之后需要手工修改src目录项目默认的包路径，使其保持一致，不然会找不到类）

		entity.setModel_package(".model.entity"); // 生成的Model所在包
		entity.setMapper_package(".mapper"); // 生成的Mapper所在包
		entity.setModel_vo_package(".model.vo"); // 生成的Model所在包
		entity.setService_package(".service"); // 生成的Service所在包
		entity.setService_impl_package(".service.impl");// 生成的ServiceImpl所在包
		entity.setController_package(".controller"); // 生成的Controller所在包

		entity.setMapper_interface_reference(".core.Mapper");// Mapper插件基础接口的完全限定名

		entity.setJdbcDiverClassName("org.postgresql.Driver");
		entity.setJdbcUrl("jdbc:postgresql://117.34.118.30:25432/datacenter_yb");
		entity.setJdbcUserName("postgres");
		entity.setJdbcPassword("YuWGG07y");

		entity.setJavaPath("/src/main/java");
		entity.setResourcesPath("/src/main/resources/");

		return entity;
	}

	public static void main(String[] args) {

		CodeGenerator GeneratorCode = new CodeGenerator(getGeneratorEntity());

		GeneratorCode.genCodeByCustomModelName("t_safe_device_rid_control", "TSafeDeviceRidControl");

	}
}
