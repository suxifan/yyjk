package com.cictec.yyjk.commons.utils.elasticsearch;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.carrotsearch.hppc.cursors.ObjectObjectCursor;
import com.cictec.yyjk.commons.utils.DateUtils;
import com.cictec.yyjk.commons.utils.PropertiesUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * elasticsearch 相关操作工具类
 * 
 * <br>
 * 【数据对应关系】 <br>
 * index(索引) --> 数据库名 <br>
 * type(类型) --> 表名 <br>
 * document(文档) --> 表中一行数据
 * 
 * @author Administrator
 *
 */
//@SuppressWarnings({ "rawtypes", "unchecked" })
public class ESClientUtils {
	
	private static Logger LOG = LoggerFactory.getLogger(ESClientUtils.class);

	private static Client client;
	
	/**
	 * 获得连接
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public static Client getClient() throws UnknownHostException {
		String host = PropertiesUtils.getString("elasticsearch.ip", "127.0.0.1"); // es服务器的host
		int port = PropertiesUtils.getIntValue("elasticsearch.port", 9300); // es服务器暴露给client的port
		String clusterName = PropertiesUtils.getString("elasticsearch.cluster.name"); // 集群名称
		
		// String host = "127.0.0.1"; // es服务器的host
		// int port = 9300; // es服务器暴露给client的port
		// String clusterName = "cictec"; // 集群名称

		
		
		
		// Client client =
		// TransportClient.builder().build().addTransportAddress(new
		// InetSocketTransportAddress(InetAddress.getByName(host), port)); //
		// 单机环境
		
		Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName).build(); // 设置集群名称
		Client client = TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
		return client;

	}
	
	public static Client getClient(String ip, int port, String clusterName) throws UnknownHostException {
		// String host = PropertiesUtils.getString("elasticsearch.ip"); //
		// es服务器的host
		// int port = PropertiesUtils.getIntValue("elasticsearch.port", 9300);
		// // es服务器暴露给client的port
		// String clusterName =
		// PropertiesUtils.getString("elasticsearch.cluster.name"); // 集群名称
		
		// String host = "127.0.0.1"; // es服务器的host
		// int port = 9300; // es服务器暴露给client的port
		// String clusterName = "cictec"; // 集群名称

		
		
		
		// Client client =
		// TransportClient.builder().build().addTransportAddress(new
		// InetSocketTransportAddress(InetAddress.getByName(host), port)); //
		// 单机环境
		
		Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName).build(); // 设置集群名称
		Client client = TransportClient.builder().settings(settings).build().addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), port));
		return client;

	}
	
	public static void addDocumentList(Client client, List<ESModel> eSModelList) throws UnknownHostException, JsonProcessingException {
		if(eSModelList == null || eSModelList.size() == 0){
			return;
		}
		
		
//		Client client = getClient();

		// 批量处理request
		BulkRequestBuilder bulkRequest = client.prepareBulk();

		for (ESModel model : eSModelList) {
			bulkRequest.add(new IndexRequest(model.getIndex(), model.getType(), model.getId()).source(model.getJsonString()));
		}

		// 执行批量处理request
		BulkResponse bulkResponse = bulkRequest.get();

		// 处理错误信息
		if (bulkResponse.hasFailures()) {
			LOG.error("====================批量创建索引过程中出现错误 下面是错误信息==========================");
			LOG.info("====================批量创建索引过程中出现错误 下面是错误信息==========================");
			long count = 0L;
			for (BulkItemResponse bulkItemResponse : bulkResponse) {
				System.out.println("发生错误的 索引id为 : " + bulkItemResponse.getId() + " ，错误信息为："
						+ bulkItemResponse.getFailureMessage());
				LOG.error("发生错误的 索引id为 : " + bulkItemResponse.getId() + " ，错误信息为："
						+ bulkItemResponse.getFailureMessage());
				count++;
			}
			LOG.info("====================批量创建索引过程中出现错误 上面是错误信息 共有: " + count + " 条记录==========================");
			LOG.error("====================批量创建索引过程中出现错误 上面是错误信息 共有: " + count + " 条记录==========================");
		}

		client.close();
	}
	
	/**
	 * 批量新增
	 * 
	 * @param eSModelList
	 *            es存储模型的列表(具体看ESModel)
	 * @throws UnknownHostException
	 * @throws JsonProcessingException
	 */
	public static void addDocumentList(List<ESModel> eSModelList) throws UnknownHostException, JsonProcessingException {
		
		if(eSModelList == null || eSModelList.size() == 0){
			return;
		}
		
		Client client = getClient();
		addDocumentList(client, eSModelList);
	}
	
	/**
	 * 新增document
	 * 
	 * @param index
	 *            索引名称
	 * @param type
	 *            类型名称
	 * @param goods
	 *            存储模型对象
	 * @throws UnknownHostException
	 */
	public static void addDocument(String index, String type, ESModel model) throws UnknownHostException {
		
		if(client == null){
			client = getClient();
		}

		client.prepareIndex(index, type, model.getId()).setSource(model.getJsonString()).get();

		// 单条插入 不关闭连接
//		client.close();
	}

	/**
	 * 新增document
	 * 
	 * @param model
	 * @throws UnknownHostException
	 */
	public static void addDocument(ESModel model) throws UnknownHostException {
		
		if(client == null){
			client = getClient();
		}

		client.prepareIndex(model.getIndex(), model.getType(), model.getId()).setSource(model.getJsonString()).get();

		// 单条插入 不关闭连接
//		client.close();
	}

	/**
	 * 删除document
	 * 
	 * @param index
	 *            索引名称
	 * @param type
	 *            类型名称
	 * @param modelId
	 *            要删除存储模型对象的id
	 * @throws UnknownHostException
	 */
	public static void deleteDocument(String index, String type, String modelId) throws UnknownHostException {
//		Client client = getClient();
		if(client == null){
			client = getClient();
		}

		client.prepareDelete(index, type, modelId + "").get();
//		client.close();
	}
	
	public static void deleteIndex(ESModel esModel) throws UnknownHostException {
//		Client client = getClient();
		if(client == null){
			client = getClient();
		}
		
		client.prepareDelete(esModel.getIndex(), esModel.getType(), esModel.getId()).get();
		
//		client.close();
	}
	
	/**
	 * 批量刪除索引
	 * 
	 * @param listVedio
	 * @return
	 */
	public static int deleteIndex(List<ESModel> eSModelList) throws UnknownHostException {
		
		Client client = getClient();

		BulkRequestBuilder deleteBulk = client.prepareBulk();
		for (ESModel esModel : eSModelList) {
			deleteBulk.add(client.prepareDelete(esModel.getIndex(), esModel.getType(), esModel.getId()));
		}
		deleteBulk.execute().actionGet();
		
		client.close();
		return 1;
	}
	
	/**
	 * 批量刪除索引
	 * 
	 * @param client
	 * @param eSModelList
	 * @return
	 * @throws UnknownHostException
	 */
	public static int deleteIndex(Client client, List<ESModel> eSModelList) throws UnknownHostException {
		BulkRequestBuilder deleteBulk = client.prepareBulk();
		for (ESModel esModel : eSModelList) {
			deleteBulk.add(client.prepareDelete(esModel.getIndex(), esModel.getType(), esModel.getId()));
		}
		deleteBulk.execute().actionGet();
		return 1;
	}

	/**
	 * 更新document
	 * 
	 * @param index
	 *            索引名称
	 * @param type
	 *            类型名称
	 * @param goods
	 *            商品dto
	 * @throws JsonProcessingException
	 * @throws UnknownHostException
	 */
	public static void updateDocument(String index, String type, ESModel model)
			throws UnknownHostException, JsonProcessingException {
		// 如果新增的时候index存在，就是更新操作
		addDocument(index, type, model);
	}
	
	/**
	 * 判断指定的索引名是否存在
	 * 
	 * @param indices
	 *            索引名
	 * @return 存在：true; 不存在：false;
	 * @throws Exception
	 */
	public static boolean isExistsIndex(String... indices) throws Exception {
		if(client == null){
			client = getClient();
		}
		
		IndicesExistsResponse  response = client.admin().indices().exists(new IndicesExistsRequest().indices(indices)).actionGet();
        return response.isExists();
	}
	
	/**
	 * 判断指定的索引的类型是否存在
	 * 
	 * @param indexName
	 *            索引名
	 * @param indexType
	 *            索引类型
	 * @return 存在：true; 不存在：false;
	 */
	public static boolean isExistsType(String indexName, String type) throws Exception {
		return isExistsType(new String[] { indexName }, type);
	}
	
	/**
	 * 判断指定的索引的类型是否存在
	 * 
	 * @param indices
	 *            索引名
	 * @param indexType
	 *            索引类型
	 * @return 存在：true; 不存在：false;
	 */
	public static boolean isExistsType(String[] indices, String... types) throws Exception {
		if(client == null){
			client = getClient();
		}
		
		if(!isExistsIndex(indices)){
			return false;
		}
		
		TypesExistsResponse response = client.admin().indices().typesExists(new TypesExistsRequest(indices, types)).actionGet();
		return response.isExists();
	}
	
	/**
	 * 【默认连接】获取所有的index
	 * 
	 * @return
	 */
	public static String[] getIndices(){
		return getIndices(client);
	}
	
	/**
	 * 获取所有的index，client为null时候去默认连接
	 * 
	 * @return
	 */
	public static String[] getIndices(Client client) {
		if (client == null) {
			try {
				client = getClient();
			} catch (UnknownHostException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		GetIndexResponse response = client.admin().indices().prepareGetIndex().execute().actionGet();
		System.out.println(response.getIndices().length);
		
		String[] indices = response.getIndices();
		return indices;
	}

	/**
	 * 【默认连接】获取所有的type，client为null时候去默认连接
	 * 
	 * @param indexName
	 * @return
	 */
	public static List<String> getTypes(String indexName){
		return getTypes(client, indexName);
	}
	
	/**
	 * 获取所有的type
	 * 
	 * @param indexName
	 * @return
	 */
	public static List<String> getTypes(Client client, String indexName) {
//		GetIndexResponse response = client.admin().indices().prepareGetIndex().execute().actionGet();
//		System.out.println(response.getIndices().length);
		List<String> types = new ArrayList<String>();

		GetMappingsResponse res = null;
		try {
			res = client.admin().indices().getMappings(new GetMappingsRequest().indices(indexName)).get();
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(), e);
		} catch (ExecutionException e) {
			LOG.error(e.getMessage(), e);
		}

		if (res != null) {
			ImmutableOpenMap<String, MappingMetaData> mapping = res.mappings().get(indexName);
			for (ObjectObjectCursor<String, MappingMetaData> c : mapping) {
				types.add(c.key);
				// System.out.println("type = " + c.key);
				// System.out.println("columns = " + c.value.source());
			}
		}
		return types;
	}
	
	/**
	 * 【默认连接】获取指定索引指定type的所有字段，client为null时候去默认连接
	 * 
	 * @param indexName
	 * @param type
	 * @return
	 */
	public static Map<String, Object> getTypeColumns(String indexName, String type) {
		return getTypeColumns(client, indexName, type);
	}
	
	/**
	 * 获取指定索引指定type的所有字段
	 * 
	 * @param client
	 * @param indexName
	 * @param type
	 * @return
	 */
	public static Map<String, Object> getTypeColumns(Client client, String indexName, String type) {
		if (client == null) {
			try {
				client = getClient();
			} catch (UnknownHostException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		
//		GetIndexResponse response = client.admin().indices().prepareGetIndex().execute().actionGet();
//		System.out.println(response.getIndices().length);
//		List<String> types = new ArrayList<String>();

		Map<String, Object> source = new HashMap<String, Object>();
		GetMappingsResponse res = null;
		try {
			res = client.admin().indices().getMappings(new GetMappingsRequest().indices(indexName)).get();
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(), e);
		} catch (ExecutionException e) {
			LOG.error(e.getMessage(), e);
		}

		
		if (res != null) {
			ImmutableOpenMap<String, MappingMetaData> mapping = res.mappings().get(indexName);
			for (ObjectObjectCursor<String, MappingMetaData> c : mapping) {
				// System.out.println("type = " + c.key);
				// System.out.println("columns = " + c.value.source());
				if(type.equals(c.key)){
					try {
						source = c.value.getSourceAsMap();
					} catch (IOException e) {
						LOG.error(e.getMessage(), e);
					}
					break;
				}
			}
		}
		return source;
	}
	
	
	/**
	 * elasticsearch 批量查询封装【滚动查询，此方式可以返回大于 es默认结果集10000条数据】 <br>
	 * 可参考：http://blog.csdn.net/u014431852/article/details/52830938<br>
	 * http://blog.csdn.net/peterwanghao/article/details/75037600<br>
	 * 
	 * @param client
	 *            客户端（为null时候使用默认连接池）
	 * @param indexNames
	 *            数据库
	 * @param types
	 *            表
	 * @param boolQueryBuilder
	 *            查询条件
	 * @param size
	 *            查询分页大小 默认 10000
	 * @param timeValue
	 *            游标维持多长时间
	 * @param isClose
	 *            查询完是否关闭客户端，默认不关闭
	 * @return
	 */
	public static List<ESModel> scanEsModel(Client client, String[] indexNames, String[] types, BoolQueryBuilder boolQueryBuilder, int size, long timeValue, boolean isClose) {
		if (client == null) {
			try {
				client = getClient();
			} catch (UnknownHostException e) {
				LOG.error(e.getMessage(), e);
			}
		}

		int _size = size / 5;
		if( _size == 0){
			_size = 2000;
		}
		
		SearchResponse searchResponse = client.prepareSearch(indexNames).setTypes(types)
				 .setSearchType(SearchType.SCAN)
				 .setQuery(boolQueryBuilder)
				// 实际返回的数量为5*index的主分片个数
//				.setSize(5*2000)
				.setSize(_size)
				// 这个游标维持多长时间
				.setScroll(new TimeValue(30000))
				.execute()
				.actionGet();

		// 第一次查询，只返回数量和一个scrollId
		String msg = "ScrollId:" + searchResponse.getScrollId()
				+ "\nTotalHits:" + searchResponse.getHits().getTotalHits()
				+ "\nTotalHits:" + searchResponse.getHits().hits().length;
		System.out.println(msg);
//		System.out.println(searchResponse.getScrollId());
//		System.out.println(searchResponse.getHits().getTotalHits());
//		System.out.println(searchResponse.getHits().hits().length);
		System.out.println("------------------------------");
		// 使用上次的scrollId继续访问
		List<ESModel> list = new ArrayList<ESModel>();
		do {
			int num = scanData(client, searchResponse, list);
			if (num == 0)
				break;
		} while (true);
		System.out.println("------------------------------END");
		System.out.println("------------------------------list.size:"+ list.size());
		
		if(isClose){
			client.close();
		}
		return list;
	}
	
	/**
	 * elasticsearch 批量查询封装【滚动查询】，此方式可以返回大于 es默认结果集10000条数据】默认默认
	 * 10000一分片，游标维持多长时间30000毫秒 <br>
	 * <b>注意客户端 不关闭</b><br>
	 * 
	 * @param client
	 * @param indexNames
	 *            数据库
	 * @param types
	 *            表
	 * @param boolQueryBuilder
	 *            查询条件
	 * @return
	 */
	public static List<ESModel> scanEsModel(Client client, String[] indexNames, String[] types, BoolQueryBuilder boolQueryBuilder) {
		return scanEsModel(client, indexNames, types, boolQueryBuilder, 1, 30000, false);
//		if (client == null) {
//			try {
//				client = getClient();
//			} catch (UnknownHostException e) {
		// LOG.error(e.getMessage(),e);
//			}
//		}
//
//		SearchResponse searchResponse = client.prepareSearch(indexNames).setTypes(types)
//				 .setSearchType(SearchType.SCAN)
//				 .setQuery(boolQueryBuilder)
		// // 实际返回的数量为5*index的主分片个数
//				.setSize(5*2000)
		// // 这个游标维持多长时间
//				.setScroll(new TimeValue(30000))
//				.execute()
//				.actionGet();
//
		// // 第一次查询，只返回数量和一个scrollId
//		String msg = "ScrollId:" + searchResponse.getScrollId()
//				+ "\nTotalHits:" + searchResponse.getHits().getTotalHits()
//				+ "\nTotalHits:" + searchResponse.getHits().hits().length;
//		System.out.println(msg);
////		System.out.println(searchResponse.getScrollId());
////		System.out.println(searchResponse.getHits().getTotalHits());
////		System.out.println(searchResponse.getHits().hits().length);
//		System.out.println("------------------------------");
		// // 使用上次的scrollId继续访问
//		List<ESModel> list = new ArrayList<ESModel>();
//		do {
//			int num = scanData(client, searchResponse, list);
//			if (num == 0)
//				break;
//		} while (true);
//		System.out.println("------------------------------END");
//		System.out.println("------------------------------list.size:"+ list.size());
//		return list;

	}
	
	/**
	 * elasticsearch 批量查询封装【滚动查询】，此方式可以返回大于 es默认结果集10000条数据】默认默认
	 * 10000一分片，游标维持多长时间30000毫秒 <br>
	 * <b>默认客户端查询，客户端 不关闭<b><br>
	 * 
	 * @param indexNames
	 *            数据库
	 * @param types
	 *            表
	 * @param boolQueryBuilder
	 *            查询条件
	 * @return
	 */
	public static List<ESModel> scanEsModel(String[] indexNames, String[] types, BoolQueryBuilder boolQueryBuilder) {
		if (client == null) {
			try {
				client = getClient();
			} catch (UnknownHostException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return scanEsModel(client, indexNames, types, boolQueryBuilder);
	}
	
	private static int scanData(Client client, SearchResponse searchResponse, List<ESModel> list) {
		SearchResponse _searchResponse = client
				.prepareSearchScroll(searchResponse.getScrollId())
				.setScroll(TimeValue.timeValueMinutes(8))
				.execute().actionGet();
//		System.out.println(_searchResponse.getScrollId());
//		System.out.println(_searchResponse.getHits().getTotalHits());
		
		int num = _searchResponse.getHits().hits().length;
		System.out.println(num);
		try {
			List<ESModel> _list = new ArrayList<ESModel>();
			for (SearchHit hit : _searchResponse.getHits()) {
				ESModel esModel = new ESModel();
				esModel.setId(hit.getId());
				esModel.setIndex(hit.getIndex());
				esModel.setType(hit.getType());
				esModel.setJsonString(hit.getSourceAsString());
//				list.add(esModel);
				_list.add(esModel);
			}
			if(_list.size() > 0){
				System.out.println("当前分片dataSize:" + _list.size());
				list.addAll(_list);
			}
		} catch (JSONException e) {
			LOG.error(e.getMessage(), e);
		}
		return num;
	}
	
	/**
	 * elasticsearch 批量查询封装【普通查询】最大返回10000条
	 * 
	 * @param client
	 * @param indexNames
	 * @param types
	 * @param boolQueryBuilder
	 * @return
	 * @throws Exception
	 */
	public static List<ESModel> searchEsModel(Client client, String[] indexNames, String[] types, BoolQueryBuilder boolQueryBuilder) throws Exception {

		if(!ESClientUtils.isExistsType(types, types)){
			return new ArrayList<ESModel>();
		}
		
//		Client client = getClient();
		SearchResponse response = client.prepareSearch(indexNames)
				.setTypes(types)
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(boolQueryBuilder)
				.setSize(10000)
				.execute()
				.actionGet();
		// 获取命中数
//		System.out.println(response.getHits().totalHits());
		// 获取响应字符串
//		System.out.println(response.toString());
		// 遍历查询结果输出相关度分值和文档内容
		SearchHits searchHits =  response.getHits();
		
		List<ESModel> dataList = new ArrayList<>();
		ESModel esModel = null;
		for(SearchHit searchHit : searchHits){
//	        System.out.println(searchHit.getScore());
//	        System.out.println(searchHit.getSourceAsString());
			esModel = new ESModel();
			esModel.setId(searchHit.getId());
			esModel.setIndex(searchHit.getIndex());
			esModel.setType(searchHit.getType());
			esModel.setJsonString(searchHit.getSourceAsString());
			dataList.add(esModel);
		}
		
		client.close();
		
		return dataList;
	}
	
	public static void main(String ...strings) throws Exception{
		Date startDate = DateUtils.getStartDateTime("2016-08-16");
		Date endDate = DateUtils.getEndDateTime("2016-08-16");

		System.out.println(isExistsIndex("bus-enteroutstation"));
	}

}