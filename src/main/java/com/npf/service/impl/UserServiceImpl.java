package com.npf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npf.dao.UserDao;
import com.npf.entity.User;
import com.npf.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao<User> userDao;

	@Override
	public User findById(int id) {
		return userDao.getEntityByKey(id);
	}

	@Override
	public User findBySsoId(String ssoId) {
		return userDao.findBySsoId(ssoId);
	}

}
