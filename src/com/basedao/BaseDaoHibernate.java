package com.basedao;

import org.springframework.orm.hibernate3.support.*;
import org.hibernate.*;
import java.util.List;
import java.io.Serializable;



public class BaseDaoHibernate<T> extends HibernateDaoSupport
	implements BaseDao<T>
{
	
	public T get(Class<T> entityClazz , Serializable id)
	{
		return (T)getSessionFactory().getCurrentSession()
			.get(entityClazz , id);
	}
	
	public Serializable save(T entity)
	{
		return getSessionFactory().getCurrentSession()
			.save(entity);
	}
	
	public void update(T entity)
	{
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}
	
	public void delete(T entity)
	{
		getSessionFactory().getCurrentSession().delete(entity);
	}
	
	public void delete(Class<T> entityClazz , Serializable id)
	{
		delete(get(entityClazz , id));
	}
	
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("select en from "
			+ entityClazz.getSimpleName() + " en");
	}
	protected List<T> find(String hql)
	{
		return getSessionFactory().getCurrentSession()
			.createQuery(hql)
			.list();
	}
	protected List<T> find(String hql , Object... params)
	{
		
		Query query = getSessionFactory().getCurrentSession()
			.createQuery(hql);
		
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i + "" , params[i]);
		}
		return query.list();
	}
}
