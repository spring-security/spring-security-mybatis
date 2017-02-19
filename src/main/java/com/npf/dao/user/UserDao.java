package com.npf.dao.user;

import com.npf.dao.base.BaseDao;
import com.npf.entity.User;

public interface UserDao extends BaseDao<Integer,User> {

	public User findBySsoId(String ssoId);
	
}
