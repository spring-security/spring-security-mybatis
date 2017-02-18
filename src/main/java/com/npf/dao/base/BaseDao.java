package com.npf.dao.base;

import java.io.Serializable;

public interface BaseDao<PK extends Serializable, T> {
     
	public T getEntityByKey(PK key);
	
	public T createEntity(T entity);
	
	public T updateEntity(T entity);
	
	public void deleteEntity(T entity);

 
}