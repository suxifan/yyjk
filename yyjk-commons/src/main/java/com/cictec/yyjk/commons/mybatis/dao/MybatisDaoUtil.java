package com.cictec.yyjk.commons.mybatis.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cictec.yyjk.commons.spring.utils.SpringContextHolder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 封装sqlSession对象，这里直接调用xml的名称传参即可，如果想要写sql可以使用sqlMapper类
 * 
 * @author ql
 *
 * @param <T>
 */
@Component
public class MybatisDaoUtil<T> {

	private static final Log logger = LogFactory.getLog(MybatisDaoUtil.class);
	@Autowired
	@Qualifier("sqlSessionTemplate")
	public SqlSession sqlSession;

	/*public MybatisDaoUtil(SqlSession sqlSession, Class<T> entityClass) {
		super();
		this.sqlSession = sqlSession;
		this.entityClass = entityClass;
	}

	protected Class<T> entityClass;

	public MybatisDaoUtil(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
*/
	public SqlSession getSqlSession() {
		if (sqlSession == null) {
//			sqlSession = SpringContextHolder.getBean("sqlSession");
			sqlSession = SpringContextHolder.getBean("sqlSessionTemplate");
		}
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	/**
	 * Execute an insert statement.
	 * @param statement  Unique identifier matching the statement to execute.
	 * @return int The number of rows affected by the insert.
	 */
	public int insert(String statement) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
		}
		return this.getSqlSession().insert(statement);
	}

	/**
	 * @param statement (Unique identifier matching the statement to execute)
	 * @param parameter (A parameter object to pass to the statement)
	 * @return (int The number of rows affected by the insert.)
	 */
	public int insert(String statement, Object parameter) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		return this.getSqlSession().insert(statement, parameter);
	}
	
	/**
	 * 批量插入（这里事物目前没有保证）,sql 得手动写成foreach形式，默认1000条一插入
	 * 
	 * @param statement
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public void insertBatch(String statement, List list) {
		
		insertBatch(statement, list, null);
	}
	
	/**
	 * 批量插入（这里事物目前没有保证）,sql 得手动写成foreach形式，默认1000条一插入
	 * 
	 * @param statement
	 *            sql语句
	 * @param list
	 *            数据对象
	 * @param pageSize
	 *            为null时候默认1000
	 */
	@SuppressWarnings("rawtypes")
	public void insertBatch(String statement, List list, Integer pageSize) {
		// 存储原始记录
		int total = list.size();
		pageSize = (pageSize == null  || pageSize == 0) ? 1000 : pageSize;

		int pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

		for (int i = 0; i < pages; i++) {
			List subList = null;
			if (pages - i > 1) {
				subList = list.subList(i * pageSize, (i + 1) * pageSize);
				// System.out.println(i * pageSize + "\t" + ( (i + 1) * pageSize));
			} else {
				subList = list.subList(i * pageSize, total);
				// System.out.println(i * pageSize + "\t" + (total));
			}
			
			insert(statement, subList);
		}
	}

	/**
	 * Execute a delete statement. The number of rows affected will be returned.
	 * @param statement Unique identifier matching the statement to execute.
	 * @return int The number of rows affected by the delete.
	 */
	public int delete(String statement) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
		}
		return this.getSqlSession().delete(statement);
	}

	/**
	 * @param statement (Unique identifier matching the statement to execute)
	 * @param entity (A parameter object to pass to the statement)
	 * @return (int The number of rows affected by the insert.)
	 */
	public int delete(String statement, Object parameter) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}

		return this.getSqlSession().delete(statement, parameter);
	}

	/**
	 * Execute an update statement. The number of rows affected will be
	 * returned.
	 * @param statement Unique identifier matching the statement to execute.
	 * @return int The number of rows affected by the update.
	 */
	public int update(String statement) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
		}

		return this.getSqlSession().update(statement);
	}

	/**
	 * @param statement (Unique identifier matching the statement to execute)
	 * @param parameter (A parameter object to pass to the statement)
	 * @return (int The number of rows affected by the insert.)
	 */
	public int update(String statement, Object parameter) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}

		return this.getSqlSession().update(statement, parameter);
	}

	/**
	 * Retrieve a single row mapped from the statement key and parameter.
	 * @param <T> the returned object type
	 * @param statement Unique identifier matching the statement to use.
	 * @param parameter A parameter object to pass to the statement.
	 * @return Mapped object
	 */
	public T selectOne(String statement, Object parameter) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		return this.getSqlSession().selectOne(statement, parameter);
	}

	/**
	 * Retrieve a single row mapped from the statement key
	 * @param <T> the returned object type
	 * @param statement
	 * @return Mapped object
	 */
	public T selectOne(String statement) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
		}
		return this.getSqlSession().selectOne(statement);
	}

	/**
	 * Retrieve a single row mapped from the statement using a
	 * {@code ResultHandler}.
	 * @param statement Unique identifier matching the statement to use.
	 * @param handler ResultHandler that will handle each retrieved row
	 * @return Mapped object
	 */
	public void select(String statement, ResultHandler handler) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
		}
		this.getSqlSession().select(statement, handler);
	}

	/**
	 * Retrieve a single row mapped from the statement key and parameter using a
	 * {@code ResultHandler}.
	 * 
	 * @param statement Unique identifier matching the statement to use.
	 * @param parameter A parameter object to pass to the statement.
	 * @param handler ResultHandler that will handle each retrieved row
	 * @return Mapped object
	 */
	public void select(String statement, Object parameter, ResultHandler handler) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		this.getSqlSession().select(statement, parameter, handler);
	}

	/**
	 * Retrieve a single row mapped from the statement key and parameter using a
	 * {@code ResultHandler} and {@code RowBounds}
	 * 
	 * @param statement Unique identifier matching the statement to use.
	 * @param rowBounds RowBound instance to limit the query results
	 * @param handler ResultHandler that will handle each retrieved row
	 * @return Mapped object
	 */
	public void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		this.getSqlSession().select(statement, parameter, rowBounds, handler);
	}

	/**
	 * Retrieve a list of mapped objects from the statement key and parameter.
	 * 
	 * @param <E> the returned list element type
	 * @param statement Unique identifier matching the statement to use.
	 * @return List of mapped object
	 */
	public List<T> selectList(String statement) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
		}
		return this.getSqlSession().selectList(statement);
	}

	/**
	 * Retrieve a list of mapped objects from the statement key and parameter.
	 * @param <E> the returned list element type
	 * @param statement Unique identifier matching the statement to use.
	 * @param parameter A parameter object to pass to the statement.
	 * @return List of mapped object
	 */
	public List<T> selectList(String statement, Object parameter) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		return this.getSqlSession().selectList(statement, parameter);
	}

	/**
	 * Retrieve a list of mapped objects from the statement key and parameter,
	 * within the specified row bounds.
	 * @param <E> the returned list element type
	 * @param statement Unique identifier matching the statement to use.
	 * @param parameter A parameter object to pass to the statement.
	 * @param rowBounds Bounds to limit object retrieval
	 * @return List of mapped object
	 */
	public List<T> selectList(String statement, Object parameter, RowBounds rowBounds) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		return this.getSqlSession().selectList(statement, parameter, rowBounds);
	}
	
	/**
	 * 分页查询(也可直接使用PageInfo进行常规查询sql的分页操作)
	 * 
	 * @param statement
	 * @param parameter
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public PageInfo<T> selectPage(String statement, Object parameter)  {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		 
		PageHelper.startPage(parameter);
		List<T> list = this.selectList(statement, parameter);
		return new PageInfo<T>(list);
	}
	
	/**
	 * 分页查询(也可直接使用PageInfo进行常规查询sql的分页操作)
	 * 
	 * @param statement
	 * @param parameter
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<T> selectPage(String statement, Object parameter, int pageNum, int pageSize) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		PageHelper.startPage(pageNum, pageSize);
		List<T> list = this.selectList(statement, parameter);
		return new PageInfo<T>(list);
	}
	
	public PageInfo<T> selectListPage(String statement, Object parameter)  {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
		}
		 
		PageHelper.startPage(parameter);
		List<T> list = this.selectList(statement, parameter);
		return new PageInfo<T>(list);
	}

	/**
	 * The selectMap is a special case in that it is designed to convert a list
	 * of results into a Map based on one of the properties in the resulting
	 * objects. Eg. Return a of Map[Integer,Author] for
	 * selectMap("selectAuthors","id")
	 * 
	 * @param <K> the returned Map keys type
	 * @param <V> the returned Map values type
	 * @param statement Unique identifier matching the statement to use.
	 * @param mapKey The property to use as key for each value in the list.
	 * @return Map containing key pair data.
	 */
	public Map<?, ?> selectMap(String statement, String mapKey) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("mapKey" + "------>" + mapKey);
		}
		return this.getSqlSession().selectMap(statement, mapKey);
	}

	/**
	 * The selectMap is a special case in that it is designed to convert a list
	 * of results into a Map based on one of the properties in the resulting
	 * objects.
	 * @param <K> the returned Map keys type
	 * @param <V> the returned Map values type
	 * @param statement Unique identifier matching the statement to use.
	 * @param parameter A parameter object to pass to the statement.
	 * @param mapKey The property to use as key for each value in the list.
	 * @return Map containing key pair data.
	 */
	public Map<?, ?> selectMap(String statement, Object parameter, String mapKey) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
			logger.debug("mapKey" + "------>" + mapKey);
		}
		return this.getSqlSession().selectMap(statement, parameter, mapKey);
	}

	/**
	 * The selectMap is a special case in that it is designed to convert a list
	 * of results into a Map based on one of the properties in the resulting
	 * objects.
	 * 
	 * @param <K> the returned Map keys type
	 * @param <V> the returned Map values type
	 * @param statement Unique identifier matching the statement to use.
	 * @param parameter A parameter object to pass to the statement.
	 * @param mapKey The property to use as key for each value in the list.
	 * @param rowBounds Bounds to limit object retrieval
	 * @return Map containing key pair data.
	 */
	public Map<?, ?> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds) {
		if(logger.isDebugEnabled()){
			logger.debug("statement" + "------>" + statement);
			logger.debug("parameter" + "------>" + parameter);
			logger.debug("mapKey" + "------>" + mapKey);
		}
		return this.getSqlSession().selectMap(statement, parameter, mapKey, rowBounds);
	}
}
