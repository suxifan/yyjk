package org.yyjk.generator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneratorEntity {

	private String commons_package;
	private String base_package;
	private String api_package;
	
	private String model_package;
	private String mapper_package;
	private String model_vo_package;
	private String service_package;
	private String service_impl_package;
	private String controller_package;
	private String mapper_interface_reference;
	
	
	public String getApi_package() {
		if(api_package == null){
			api_package = base_package.substring(0, base_package.lastIndexOf(".")) + ".api";
		}
		return api_package;
	}
	public String getCommons_package() {
		return commons_package;
	}
	public void setCommons_package(String commons_package) {
		this.commons_package = commons_package;
	}
	public String getBase_package() {
		return base_package;
	}
	public void setBase_package(String base_package) {
		this.base_package = base_package;
	}
	public String getModel_package() {
		return model_package;
	}
	public void setModel_package(String model_package) {
		this.model_package = getBase_package() + model_package;
	}
	public String getMapper_package() {
		return mapper_package;
	}
	public void setMapper_package(String mapper_package) {
		this.mapper_package = getBase_package() + mapper_package;
	}
	public String getModel_vo_package() {
		return model_vo_package;
	}
	public void setModel_vo_package(String model_vo_package) {
		this.model_vo_package = getBase_package() +  model_vo_package;
	}
	public String getService_package() {
		return service_package;
	}
	public void setService_package(String service_package) {
		this.service_package = getBase_package() + service_package;
	}
	public String getService_impl_package() {
		return service_impl_package;
	}
	public void setService_impl_package(String service_impl_package) {
		this.service_impl_package = getBase_package() + service_impl_package;
	}
	public String getController_package() {
		return controller_package;
	}
	public void setController_package(String controller_package) {
		this.controller_package = getBase_package() + controller_package;
	}
	public String getMapper_interface_reference() {
		return mapper_interface_reference;
	}
	public void setMapper_interface_reference(String mapper_interface_reference) {
		this.mapper_interface_reference = getCommons_package() + mapper_interface_reference;
	}
	
	
	private String jdbcUrl;
	private String jdbcUserName;
	private String jdbcPassword;
	private String jdbcDiverClassName;

	private String projectPath;
	private String templateFliePath;
	private String javaPath;
	private String resourcesPath;


	private String author = "xpguo";
	private String date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());// @date
	
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getJdbcUserName() {
		return jdbcUserName;
	}
	public void setJdbcUserName(String jdbcUserName) {
		this.jdbcUserName = jdbcUserName;
	}
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	
	public String getJdbcDiverClassName() {
		return jdbcDiverClassName;
	}
	public void setJdbcDiverClassName(String jdbcDiverClassName) {
		this.jdbcDiverClassName = jdbcDiverClassName;
	}
	public String getProjectPath() {
		if(projectPath == null){
			this.projectPath = System.getProperty("user.dir");
		}
		return projectPath;
	}
//	public void setProjectPath(String projectPath) {
//		this.projectPath = projectPath;
//	}
	public String getTemplateFliePath() {
		if(templateFliePath == null){
			String path =   System.getProperty("user.dir");
			File file=new File(path);
			String _path = file.getPath();
			_path = _path.substring(0, _path.lastIndexOf("\\"));
			_path = _path + "/yyjk-generator/src/main/resources/template";
			
			templateFliePath = _path;
			
		}
		
		return templateFliePath;
	}
	public void setTemplateFliePath(String templateFliePath) {

		this.templateFliePath = templateFliePath;
	}
	public String getJavaPath() {
		return javaPath;
	}
	public void setJavaPath(String javaPath) {
		this.javaPath = javaPath;
	}
	public String getResourcesPath() {
		return resourcesPath;
	}
	public void setResourcesPath(String resourcesPath) {
		this.resourcesPath = resourcesPath;
	}
	public String getPackagePathVo() {
		return packageConvertPath(model_vo_package);
	}
	public String getPackagePathService() {
		return packageConvertPath(service_package);
	}
	public String getPackagePathServiceImpl() {
		return packageConvertPath(service_impl_package);
	}
	public String getPackagePathController() {
		return packageConvertPath(controller_package);
	}
	public String getPackagePathControllerApi() {
		return packageConvertPath(api_package);
	}
	public String getAuthor() {
		return author;
	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
	public String getDate() {
		return date;
	}
//	public void setDate(String date) {
//		this.date = date;
//	}

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }
}
