package bookShopping.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import bookShopping.tools.Pager;





/**
 * 公共的DAO处理对象，这个对象中包含了Hibernate的所有基本操作和对SQL的操作
 * @author jacky
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	/**
	 * 添加对象
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(long id);
	/**
	 * 根据id加载对象
	 * @param id
	 * @return
	 */
	public T load(long id);
	
	/***
	 * 基于参数的查询
	 * @param hql
	 * @param args[] 带多个参数
	 * @return
	 */
	public List<T> list(String hql, Object[] args);
	
	
	/***
	 * 基于参数的查询
	 * @param hql
	 * @param 一个参数
	 * @return
	 */
	
	public List<T> list(String hql, Object arg);
	
	
	
	/***
	 * 基于参数的查询
	 * @param hql
	 * @return
	 */
	public List<T> list(String hql);
	
	/***
	 * 基于参数加别名的混和查询
	 * @param hql
	 * @param args[]   string hql=from Student as s  where s.age=? and s.name=:name
	 * @param alias 别名
	 * @return
	 */
	public List<T> list(String hql, Object[] args, Map<String, Object> alias);
	
	
	
	/***
	 * 基于别名的查询
	 * @param hql
	 * @param alias 别名  string hql=from Student as as where s.name=:name
	 * @return
	 */
	
	public List<T> listByAlias(String hql, Map<String, Object> alias);
	
	
	/***
	 * 基于参数的分页查询
	 * @param hql
	 * @param args[]
	 * @return
	 */
	public Pager<T> find(String hql, Object[] args);
	
	
	/***
	 * 基于参数的分页查询
	 * @param hql
	 * @param args
	 * @return
	 */
	public Pager<T> find(String hql, Object arg);
	
	
	/***
	 * 基于参数的分页查询
	 * @param hql
	 * @return
	 */
	public Pager<T> find(String hql);
	
	/***
	 * 基于参数与别名的分页查询
	 * @param hql
	 * @param args[]
	 * @param alias
	 * @return
	 */
	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias);
	
	
	
	/***
	 * 基于参数与别名的分页查询
	 * @param hql
	 * @param alias
	 * @return
	 */
	
	public Pager<T> findByAlias(String hql, Map<String, Object> alias);
	
	/***
	 * 根据hql查询一个对象
	 * @param hql
	 * @param args[]
	 * @return
	 */
	public Object queryObject(String hql, Object[] args);
	
	
	/***
	 * 根据hql查询一个对象
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryObject(String hql, Object arg);
	
	
	/***
	 * 根据hql查询一个对象
	 * @param hql
	 * @return
	 */
	public Object queryObject(String hql);
	
	
	/***
	 * 根据hql查询一个对象，参数加别名
	 * @param hql
	 * @param args[]
	 * @return
	 */
	public Object queryObject(String hql, Object[] args,Map<String, Object> alias);
	
	
	/***
	 * 根据hql查询一个对象，参数加别名
	 * @param hql
	 * @return
	 */
	public Object queryObjectByAlias(String hql, Map<String, Object> alias);
	
	/***
	 * 根据hql更新对象
	 * @param hql
	 * @param args[]
	 */
	public void updateByHql(String hql, Object[] args);
	
	
	
	/***
	 * 根据hql更新对象
	 * @param hql
	 * @param args
	 */
	public void updateByHql(String hql, Object arg);
	
	
	/***
	 * 根据hql更新对象
	 * @param hql
	 */
	public void updateByHql(String hql);
	
	
	/***
	 * 根据sql更新对象
	 * @param sql
	 * @param args[]
	 */
	public void updateBySql(String sql, Object[] args);
	
	
	
	/***
	 * 根据sql更新对象
	 * @param sql
	 * @param args
	 */
	public void updateBySql(String sql, Object arg);
	
	
	
	/***
	 * 根据sql更新对象
	 * @param sql
	 */
	public void updateBySql(String sql);
	
	/***
	 * 根据sql查询对象
	 * @param sql
	 * @param args条件
	 * @param clz查询的实体对象
	 * @param hasEntity是否是hibernate所管理的实体,还是dto类
	 * @return
	 */
	public <N extends Object>List<N> listBySql(String sql, Object[] args, Class<?> clz,boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql, Object arg, Class<?> clz,boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql, Class<?> clz, boolean hasEntity);
	public <N extends Object>List<N> listBySql(String sql, Object[] args,Map<String, Object> alias, Class<?> clz, boolean hasEntity);
	public <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias,Class<?> clz, boolean hasEntity);
	
	/***
	 * 根据sql查询对象并分页
	 * @param sql
	 * @param args
	 * @param clz
	 * @param hasEntity
	 * @return
	 */
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql, Object arg, Class<?> clz,boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity);
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args,Map<String, Object> alias, Class<?> clz, boolean hasEntity);
	public <N extends Object>Pager<N> findByAliasSql(String sql, Map<String, Object> alias,Class<?> clz, boolean hasEntity);
	
	/**
	 * 删除对象
	 * @param t
	 */
	public void deleteObject(T t);
	/**
	 * 根据sql语句删除对象
	 * @param sql
	 */
	public void deleteSql(String sql);
	
	/**
	 * 根据sql语句查询
	 * @param sql
	 */
	public long queryHql(String hql);
	
}

