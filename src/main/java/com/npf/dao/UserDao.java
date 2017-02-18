package com.npf.dao;

import com.npf.dao.base.BaseDao;

public interface UserDao<User> extends BaseDao<Integer,User> {

	public User findBySsoId(String ssoId);
	
}
