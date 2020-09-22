package com.cictec.yyjk.timingtask.tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * 每个月一号创建当月到站数据表，用来保存当月数据 并删除前3个月的数据表
 * 
 */
// @Component
public class GrabAnalysisArriveVolumeDbOperTask {
	private static final Logger LOG = LoggerFactory.getLogger(GrabAnalysisArriveVolumeDbOperTask.class);
	@Autowired
	private Environment env;

	private static String createTableSql = "CREATE TABLE analysis_arrive_volume_day_%s ("
			+ "arrive_uuid varchar(64) NOT NULL primary key,"
			+ "org_uuid varchar(64) ,org_name varchar(50) ,line_uuid varchar(64) ,line_name varchar(50) ,"
			+ "line_type varchar(1) ,sta_uuid varchar(64) ,sta_seq varchar(64) ,sta_name varchar(50) ,"
			+ "bus_plate_number varchar(50) ,upload_time_date varchar(10) ,"
			+ "upload_time_in timestamp(6),upload_time_out timestamp(6),upload_time_hour int2," + "bus_class int2)";

	private static String copyTableSql = "INSERT INTO analysis_arrive_volume_day_%s SELECT * FROM  analysis_arrive_volume_day";

	private static String deleteTableSql = "DELETE FROM analysis_arrive_volume_day WHERE left(upload_time_date,7) = '%s'";

	private static String dropTableSql = "DROP TABLE analysis_arrive_volume_day_%s";

	private static String isExist = "select count(*) AS num  from information_schema.tables where  table_name = 'analysis_arrive_volume_day_%s'";

	/**
	 * 每月一号5点执行
	 */
	@Scheduled(cron = "0 10 5 1 * ?")
	public void start() {
		LOG.info("到站数据建表定时任务开始...");
		String className = env.getProperty("spring.datasource.driver-class-name");
		String url = env.getProperty("spring.datasource.url");
		String userName = env.getProperty("spring.datasource.username");
		String passWord = env.getProperty("spring.datasource.password");

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		String beforMonth = new SimpleDateFormat("MM").format(calendar.getTime());
		String beforYearMonth = new SimpleDateFormat("yyyy-MM").format(calendar.getTime());
		calendar.add(Calendar.MONTH, -6);
		String befor6Month = new SimpleDateFormat("yyyy-MM").format(calendar.getTime());

		Connection connection = null;
		Statement tatement = null;
		try {
			Class.forName(className);
			connection = DriverManager.getConnection(url, userName, passWord);
			tatement = connection.createStatement();
			tatement.execute(String.format("DROP TABLE IF EXISTS analysis_arrive_volume_day_%s", beforMonth));
			tatement.execute(String.format(createTableSql, beforMonth));
			Thread.sleep(2000);
			ResultSet res = tatement.executeQuery(String.format(isExist, beforMonth));
			boolean next = res.next();
			if (next && res.getInt("num") > 0) {
				// 建表成功后复制表
				tatement.execute(String.format(copyTableSql, beforMonth));
				// 删除上月到站数据
				tatement.execute(String.format(deleteTableSql, beforYearMonth));
				// 删除前6个月的数据表
				tatement.execute(String.format(dropTableSql, befor6Month));
			} else {
				LOG.info("创建表{}失败！未能拷贝数据", String.format("analysis_arrive_volume_day_%s", beforMonth));
			}
		} catch (Throwable ex) {
			LOG.error("到站数据建表异常！{}", ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.error("关闭连接失败，原因{}", e);
				}
			}
			if (tatement != null) {
				try {
					tatement.close();
				} catch (SQLException e) {
					LOG.error("关闭tatement失败，原因{}", e);
				}
			}
		}
		LOG.info("到站数据建表定时任务结束...");
	}
}
