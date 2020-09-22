package com.cictec.yyjk.fatigue.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cictec.yyjk.commons.utils.StringUtils;

/**
 * <p>
 * Description: 调用ffmpeg脚本转化H264视频为MP4,系统需安装FFmpeg，适用于Linux环境
 * </p>
 * <p>
 * Title: RunShell.java
 * </p>
 * <p>
 * </p>
 * <p>
 * Company: 北京中航讯科技股份公司西安研发中心
 * </p>
 * 
 * @author Rwq
 * 
 *         <pre>
 * Histroy:
 *          2018年10月30日 下午5:14:32  Rwq  Create
 *         </pre>
 */
public class RunShell {
	private static final Logger LOG = LoggerFactory.getLogger(RunShell.class);
	
	/**
	 * <p>
	 * Description: 调用sh脚本
	 * </p>
	 * <p>
	 * Function: runShell
	 * </p>
	 * <p>
	 * return value:int
	 * </p>
	 * <p>
	 * @param shPath ：脚本存放路径
	 * <p>
	 * @param infilePath :脚本参数$1
	 * <p>
	 * @param outfilePath : 脚本参数$2
	 * <p>
	 * @return
	 * </p>
	 * <p>
	 * throws Exception:
	 * </p>
	 * <p>
	 * History: 2018年10月30日 下午5:31:00 Rwq
	 * </p>
	 *
	 */
	public static int runShell(String shPath,String infilePath,String outfilePath){
		  try {
			  if(StringUtils.isEmpty(shPath)){
				LOG.info("未配置shell脚本路径..");
				  return 0;
			  }
			  if(StringUtils.isEmpty(infilePath) && StringUtils.isEmpty(outfilePath)){
				LOG.info("未配置转换文件路径...");
				  return 0;
			  }
			  
			  StringBuffer cmd =new StringBuffer();
			  cmd.append(shPath).append(" ");
			  cmd.append(infilePath).append(" ");
			  cmd.append(outfilePath);
			  
		      Process ps = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",cmd.toString()});
		      return ps.waitFor(); 
		    } catch (Exception e) { 
			LOG.error("调用sh脚本异常，原因{}", e);
		    } 
		  return 0;
	  }
	 
	
	
	  public static void main(String[] args){ 
		  try {
			  String shPath ="/usr/local/cictecmid/web/ff.sh";
			  String infilePath = "/usr/local/cictecmid/middleware/qingyan/data/images/2018/10/25/test.h264";
			  String outfilePath = "/usr/local/cictecmid/middleware/qingyan/data/images/2018/10/25/test.mp4";
			  String cmd = shPath+" "+infilePath+" "+outfilePath;
		      Process ps = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",cmd});
		      ps.waitFor(); 
		    } catch (Exception e) { 
		      e.printStackTrace(); 
		    } 
	  } 
	  
	  
	  
}
