/**
 * 泛型dao组件
 * add by jacky
 */
package bookShopping.dao.imp;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;







import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import bookShopping.dao.IBaseDao;
import bookShopping.tools.Pager;
import bookShopping.tools.SystemContext;



/**
 * @author Administrator
 *
 */
@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {
	
	private SessionFactory sessionFactory;
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;
	
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession() {
		Session s=null;
		try
		{
			s= sessionFactory.getCurrentSession();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage().toString());
		}
		
		return s;
	}

	/* (non-Javadoc)
	 * 添加一个对象
	 */
	@Override
	public T add(T t) {
		getSession().save(t);
		return t;
	}

	/* (non-Javadoc)
	 * 更新一个对象
	 */
	@Override
	public void update(T t) {
		getSession().update(t);
	}

	/* (non-Javadoc)
	 * 删除一个对象，依据主健id
	 */
	@Override
	public void delete(long id) {
		//getSession().delete(this.load(id));
		getSession().delete(load(id));
	}

	/* (non-Javadoc)
	 * 加载一个对象，依据主健id
	 */
	@Override
	public T load(long id) {
		return (T)getSession().load(getClz(), id);
	}

	/* (non-Javadoc)
	 * 依据hql语句和带参数数组，查询数据，并返回查询结果列表
	 */
	public List<T> list(String hql, Object[] args) {
		return this.list(hql, args, null);
	}

	/* (non-Javadoc)
	 * 依据hql语句和查询一个参数，查询数据，并返回查询结果列表
	 */
	public List<T> list(String hql, Object arg) {
		return this.list(hql, new Object[]{arg});
	}

	/* (non-Javadoc)
	 *  依据hql语句，不带参数的，查询数据，并返回查询结果列表
	 */
	@Override
	public List<T> list(String hql) {
		return this.list(hql,null);
	}
	
	private String initSort(String hql) {
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(sort!=null&&!"".equals(sort.trim())) {
			hql+=" order by "+sort;
			if(!"desc".equals(order)) hql+=" asc";
			else hql+=" desc";
		}
		return hql;
	}
	
	@SuppressWarnings("rawtypes")
	private void setAliasParameter(Query query,Map<String,Object> alias) {
		if(alias!=null) {
			Set<String> keys = alias.keySet();
			for(String key:keys) {
				Object val = alias.get(key);
				if(val instanceof Collection) {
					//查询条件是列表
					query.setParameterList(key, (Collection)val);
				} else {
					query.setParameter(key, val);
				}
			}
		}
	}
	
	private void setParameter(Query query,Object[] args) {
		if(args!=null&&args.length>0) {
			int index = 0;
			for(Object arg:args) {
				query.setParameter(index++, arg);
			}
		}
	}

	/* (non-Javadoc)
	 *  依据hql语句，带查询参数数组和别名，查询数据，并返回查询结果列表
	 */
	@Override
	public List<T> list(String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(hql);
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.list();
	}

	/* (non-Javadoc)
	 * 依据hql语句，带别名，查询数据，并返回查询结果列表
	 */
	@Override
	public List<T> listByAlias(String hql, Map<String, Object> alias) {
		return this.list(hql, null, alias);
	}

	/* (non-Javadoc)
	 * 依据hql语句，带参数数组，分页查询数据，并返回查询结果
	 */
	@Override
	public Pager<T> find(String hql, Object[] args) {
		return this.find(hql, args, null);
	}

	/* (non-Javadoc)
	 * 依据hql语句，带参数，分页查询数据，并返回查询结果
	 */
	@Override
	public Pager<T> find(String hql, Object arg) {
		return this.find(hql, new Object[]{arg});
	}

	/* (non-Javadoc)
	 * 根据hql语句，分页查询数据，并返回查询结果
	 */
	@Override
	public Pager<T> find(String hql) {
		return this.find(hql,null);
	}
	
	@SuppressWarnings("rawtypes")
	private void setPagers(Query query,Pager pages) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSize==null||pageSize<0) pageSize = 15;
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}
	
	private String getCountHql(String hql,boolean isHql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) "+e;
		if(isHql)
			c = c.replaceAll("fetch", "");
		return c;
	}

	/* (non-Javadoc)
	 * 依据hql语句，带参数数组和别名，分页查询数据，并返回查询结果列表
	 */
	@Override
	public Pager<T> find(String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(hql);
		String cq = getCountHql(hql,true);
		Query cquery = getSession().createQuery(cq);
		Query query = getSession().createQuery(hql);
		//设置别名参数
		setAliasParameter(query, alias);
		setAliasParameter(cquery, alias);
		//设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		Pager<T> pages = new Pager<T>();
		setPagers(query,pages);
		List<T> datas = query.list();
		pages.setDatas(datas);
		long total = (Long)cquery.uniqueResult();
		pages.setTotal(total);
		return pages;
	}

	/* (non-Javadoc)
	 * 依据hql语句和别名，分页查询数据，并返回查询结果列表
	 */
	@Override
	public Pager<T> findByAlias(String hql, Map<String, Object> alias) {
		return this.find(hql,null, alias);
	}

	/* (non-Javadoc)
	 * 依据hql语句，带参数数组，查询唯一的一个对象
	 */
	@Override
	public Object queryObject(String hql, Object[] args) {
		return this.queryObject(hql, args,null);
	}

	/* (non-Javadoc)
	 * 依据hql语句，带一个参数，查询唯一的一个对象
	 */
	@Override
	public Object queryObject(String hql, Object arg) {
		return this.queryObject(hql, new Object[]{arg});
	}

	/* (non-Javadoc)
	 * 依据hql语句，查询唯一的一个对象
	 */
	@Override
	public Object queryObject(String hql) {
		return this.queryObject(hql,null);
	}
	
	/*
	 *根据hql语句，带参数数组，带别名，查询唯一的一个对象 
	 */
	@Override
	public Object queryObject(String hql, Object[] args,
			Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.uniqueResult();
	}
	/*
	 *根据hql语句，带别名 ，查询唯一的一个对象
	 */
	@Override
	public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
		return this.queryObject(hql,null,alias);
	}


	/* (non-Javadoc)
	 * 依据hql语句，带参数数组，更新一个对象
	 */
	@Override
	public void updateByHql(String hql, Object[] args) {
		Query query = getSession().createQuery(hql);
		setParameter(query, args);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 *依据hql语句，带一个参数，更新一个对象
	 */
	@Override
	public void updateByHql(String hql, Object arg) {
		this.updateByHql(hql,new Object[]{arg});
	}

	/* (non-Javadoc)
	 * 依据hql语句，更新一个对象
	 */
	@Override
	public void updateByHql(String hql) {
		this.updateByHql(hql,null);
	}
	
	/* (non-Javadoc)
	 * 依据sql语句，带参数数组，更新一个对象
	 */
	@Override
	public void updateBySql(String sql, Object[] args) {
		Query query = getSession().createSQLQuery(sql);
		setParameter(query, args);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 *依据sql语句，带一个参数，更新一个对象
	 */
	@Override
	public void updateBySql(String sql, Object arg) {
		this.updateBySql(sql,new Object[]{arg});
	}

	/* (non-Javadoc)
	 * 依据sql语句，更新一个对象
	 */
	@Override
	public void updateBySql(String sql) {
		this.updateBySql(sql,null);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，带参数数组，并返回查询结果列表  
	 * clz=Subject.class（类名）,hasEntity=true（判断是否为实体类，如果是则为true，否则为false）
	 */
	@Override
	public <N extends Object>List<N> listBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, args, null, clz, hasEntity);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，带一个参数，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>List<N> listBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity) {
		return this.listBySql(sql, new Object[]{arg}, clz, hasEntity);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>List<N> listBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, clz, hasEntity);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，带参数数组和别名，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>List<N> listBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		SQLQuery sq = getSession().createSQLQuery(sql);
		setAliasParameter(sq, alias);
		setParameter(sq, args);
		if(hasEntity) {
			sq.addEntity(clz);
		} else 
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		return sq.list();
	}

	/* (non-Javadoc)
	 *依据原生sql语句，带别名，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>List<N> listByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, alias, clz, hasEntity);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，带参数数组，分页查询数据，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args, Class<?> clz,
			boolean hasEntity) {
		return this.findBySql(sql, args, null, clz, hasEntity);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，带一个参数，分页查询数据，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>Pager<N> findBySql(String sql, Object arg, Class<?> clz,
			boolean hasEntity) {
		return this.findBySql(sql, new Object[]{arg}, clz, hasEntity);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，分页查询数据，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, clz, hasEntity);
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，带参数数组，带别名，分页查询数据，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>Pager<N> findBySql(String sql, Object[] args,
			Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		String cq = getCountHql(sql,false);
		SQLQuery sq = getSession().createSQLQuery(sql);
		SQLQuery cquery = getSession().createSQLQuery(cq);
		setAliasParameter(sq, alias);
		setAliasParameter(cquery, alias);
		setParameter(sq, args);
		setParameter(cquery, args);
		Pager<N> pages = new Pager<N>();
		setPagers(sq, pages);
		if(hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		}
		List<N> datas = sq.list();
		pages.setDatas(datas);
		long total = ((BigInteger)cquery.uniqueResult()).longValue();
		pages.setTotal(total);
		return pages;
	}

	/* (non-Javadoc)
	 * 依据原生sql语句，带别名，分页查询数据，并返回查询结果列表  clz=Subject.class,hasEntity=true
	 */
	@Override
	public <N extends Object>Pager<N> findByAliasSql(String sql, Map<String, Object> alias,
			Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, alias, clz, hasEntity);
	}
	/*
	 * (non-Javadoc)
	 * 删除对象
	 */
	@Override
	public void deleteObject(T t) {
		
		getSession().delete(t);
	}
	
	/*
	 * (non-Javadoc)
	 * 根据sql语句删除
	 */
	@Override
	public void deleteSql(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public long queryHql(String hql) {
		return (Long) getSession().createQuery(hql).uniqueResult();		
	}
	
}
