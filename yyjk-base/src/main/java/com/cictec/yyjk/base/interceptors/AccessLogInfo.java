package com.cictec.yyjk.base.interceptors;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLogInfo {
	// 访问模块名
	String modelName() default "";

	// 访问页面名称
	String pageName() default "";
}
