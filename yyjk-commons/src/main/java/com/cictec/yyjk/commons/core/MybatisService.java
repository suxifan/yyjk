package com.cictec.yyjk.commons.core;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cictec.yyjk.commons.utils.PMSUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.entity.Example;


/**
 * MybatisService<br>
 * <blockquote> 该类中已经实例化了<br>
 * 基于实体的Mapper即 Mapper<T>,
 * <b>所以在Service的具体实例化中不需要重复定义相同实体的Mapper</b> </blockquote>
 * 
 * @author ql
 *
 * @param <T>
 */
@Transactional
@SuppressWarnings("unchecked")
public abstract class MybatisService<T> implements Service<T> {
	private static final Logger LOG = LoggerFactory.getLogger(MybatisService.class);
    @Autowired
    protected Mapper<T> mapper;

	private Class<T> modelClass; // 当前泛型真实类型的Class


	public MybatisService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

	/**
	 * 获取所有实体
	 */
	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	/**
	 * 【单表】根据实体类不为null的字段进行查询,条件全部使用=号and条件
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public List<T> select(T record) {
		return mapper.select(record);
	}

	/**
	 * 【单表】根据实体类不为null的字段查询总数,条件全部使用=号and条件
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public int selectCount(T record) {
		return mapper.selectCount(record);
	}

	/**
	 * 【单表】根据主键进行查询,必须保证结果唯一 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public T selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}
	
	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号 只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * 
	 * @param record
	 * @return
	 */
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}
	
	/**
	 * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
	 * 
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws TooManyResultsException
	 */
	@Override
	public T selectOneBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
	}

	/**
	 * 【单表】插入一条数据 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
	 * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长 <br>
	 * 保存一个实体，null的属性也会保存，不会使用数据库默认值</br>
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public int insert(T record) {
		return mapper.insert(record);
	}

	/**
	 * 【单表】插入一条数据,只插入不为null的字段,不会影响有默认值的字段
	 * 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
	 * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}
	
	/**
	 * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
	 */
    @Override
	public int insertList(List<T> models) {
    	return mapper.insertList(models);
    }

	/**
	 * 【单表】根据实体类不为null的字段进行查询,条件全部使用=号and条件
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public int delete(T key) {
		return mapper.delete(key);
	}

	/**
	 * 【单表】通过主键进行删除,这里最多只会删除一条数据 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	/** 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段 */
	@Override
	public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }
	
	@Override
	public int deleteByField(String fieldName, Object value) {
		try {
			
			// 方法1：
//			T model = modelClass.newInstance();
//			field.setAccessible(true);
//			field.set(model, field.get(record));
//			mapper.delete(model);
			
			if(value == null){
				try {
					throw new Exception(PMSUtils.format("delete 异常   {} 属性 为 NULL 不做更新", fieldName));
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
				}
			}
			
			Example example = new Example(modelClass.newInstance().getClass());
			example.createCriteria().andEqualTo(fieldName, value);
			
			return mapper.deleteByExample(example);
		} catch (InstantiationException | IllegalAccessException | SecurityException
				| IllegalArgumentException e) {
			LOG.error(e.getMessage(), e);
			return 0;
		}
	}
	
	/**
	 * 通过Model中某个成员变量名称（非数据表中column的名称）删除,value需符合unique约束
	 * 
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws TooManyResultsException
	 */
	@Override
	public int deleteByFieldSelective(String fieldName, T record) {
		if(record == null){
			return 0;
		}
		
		try {
			Field field = modelClass.getDeclaredField(fieldName);
			
			// 方法1：
//			T model = modelClass.newInstance();
			field.setAccessible(true);
//			field.set(model, field.get(record));
//			mapper.delete(model);
			
			Object value = field.get(record);
			if(value == null){
				try {
					throw new Exception(PMSUtils.format("delete异常   {} 属性 为 NULL 不做条件", fieldName));
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
				}
			}
			
			Example example = new Example(modelClass.newInstance().getClass());
			example.createCriteria().andEqualTo(fieldName, value);
			
			return mapper.deleteByExample(example);
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException
				| IllegalArgumentException e) {
			LOG.error(e.getMessage(), e);
			return 0;
		}
	}
	
	/**
	 * 【单表】【根据主键更新实体全部字段，null值会被更新】根据主键进行更新,这里最多只会更新一条数据 参数为实体类
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public int updateByPrimaryKey(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	/**
	 * 【单表】【根据主键更新属性不为null的值】根据主键进行更新 只会更新不是null的数据
	 * 
	 * @param <T
	 *            extend T>
	 */
	@Override
	public int updateByPrimaryKeySelective(T record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	
	/**
	 * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
	 * 
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws TooManyResultsException
	 */
	@Override
	public int updateByField(String fieldName, T record) {
		if(record == null){
			return 0;
		}
		
		try {
			Field field = modelClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object value = field.get(record);
			if(value == null){
				try {
					throw new Exception(PMSUtils.format("update 异常   {} 属性 为 NULL 不能作为条件", fieldName));
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
				}
			}
			
			Example example = new Example(modelClass.newInstance().getClass());
			example.createCriteria().andEqualTo(fieldName, value);

			return mapper.updateByExample(record, example);
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException
				| IllegalArgumentException e) {
			LOG.error(e.getMessage(), e);
			return 0;
		}
        
	}

	/**
	 * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
	 * 
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws TooManyResultsException
	 */
	@Override
	public int updateByFieldSelective(String fieldName, T record) {
		if(record == null){
			return 0;
		}
		
		try {
			Field field = modelClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			Object value = field.get(record);
			if(value == null){
				try {
					throw new Exception(PMSUtils.format("update 异常   {} 属性 为 NULL 不能作为条件", fieldName));
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
				}
			}
			
			Example example = new Example(modelClass.newInstance().getClass());
			example.createCriteria().andEqualTo(fieldName, value);

			return mapper.updateByExampleSelective(record, example);
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException
				| IllegalArgumentException e) {
			LOG.error(e.getMessage(), e);
			return 0;
		}
	}
	
	/**
	 * 【单表】单表分页
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            条数
	 * @param record
	 *            条件实体(可以是Map)
	 * @return
	 */
	@Override
	public PageInfo<T> selectPage(int pageNum, int pageSize, T record) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<T>(mapper.select(record));
	}
	
	@Override
	public PageInfo<T> selectPage(int pageNum, int pageSize, String orderBy, T record) {
		PageHelper.startPage(pageNum, pageSize);
//		PageHelper.startPage(pageNum, pageSize, orderBy);
		return new PageInfo<T>(mapper.select(record));
	}

}