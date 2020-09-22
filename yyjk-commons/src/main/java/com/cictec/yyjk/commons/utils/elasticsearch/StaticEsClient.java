package com.cictec.yyjk.commons.utils.elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cictec.yyjk.commons.utils.PropertiesUtils;

@Configuration
public class StaticEsClient {
	@Bean(name = "client")  
	public  Client  getElasticClient() throws UnknownHostException {
		String ip = PropertiesUtils.getString("elasticsearch.ip","127.0.0.1");
		int port = PropertiesUtils.getIntValue("elasticsearch.port", 9300);
		String clusterName = PropertiesUtils.getString("elasticsearch.cluster.name");
		Settings settings = Settings.settingsBuilder()  
                .put("cluster.name", clusterName)  
                .build();  
		 Client  client=TransportClient.builder().settings(settings).build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), port));
		 return client;  
	}
}
