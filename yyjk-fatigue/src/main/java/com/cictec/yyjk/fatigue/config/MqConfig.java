package com.cictec.yyjk.fatigue.config;


 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

 @Configuration
 @ImportResource(locations = { "classpath:rabbitmq/spring-config-rabbitmq.xml"
 })
 /**
  * 配置第二套mq
  * @author benzhao
  *
  */
 public class MqConfig {

	 @Value("${rabbitmq2.virtual-host}")
	 private String virtualHost;
	 
	 @Value("${rabbitmq2.host}")
	 private String rabbitHost;
	 
	 @Value("${rabbitmq2.port}")
	 private String rabbitPort;
	 
	 @Value("${rabbitmq2.username}")
	 private String rabbitUser;
	 
	 @Value("${rabbitmq2.password}")
	 private String rabbitPassword;
	 private Logger logger = LoggerFactory.getLogger(getClass());
	 /**
	  * <方法描述>创建链接  实例化  持久化
	  * @return  CachingConnectionFactory
	  */
	 @Bean("connectionFactoryTwo")
	 public CachingConnectionFactory connectionFactory(){
		 CachingConnectionFactory ccf=new CachingConnectionFactory();
		 ccf.setVirtualHost(virtualHost);
		 ccf.setHost(rabbitHost);
		 ccf.setUsername(rabbitUser);
		 ccf.setPort(Integer.valueOf(rabbitPort));
		 ccf.setPassword(rabbitPassword);
		 //绑定队列到交换机
		 //channel.queueBind(queueName,rabbitmqUtil.exchangeName,"");
		 return ccf;
	 }
	 /**
	  * <方法描述>创建rabbitMq管理者
	  * @return  CachingConnectionFactory
	  */
	
	 @Bean(name="RabbitAdminTwo") 
	 public RabbitAdmin rabbitAdmin( ) {
	        return new RabbitAdmin(connectionFactory());
	 }
	 /**
	  * <方法描述>模板  发送
	  * @return  RabbitTemplate
	  */
	 @Bean(name="AmqpTemplateTwo")
	 public RabbitTemplate rabbitTemplate() {
	     RabbitTemplate template = new RabbitTemplate(this.connectionFactory());
	    // template.setMessageConverter(this.producerJackson2MessageConverter());
	     return template;
	 }
	 
	 @Bean
	 public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
	        return new Jackson2JsonMessageConverter();
	 }


 }