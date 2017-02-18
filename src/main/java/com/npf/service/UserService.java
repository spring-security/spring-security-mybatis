package com.npf.service;

import com.npf.entity.User;

public interface UserService {

	public User findById(int id);
    
	public User findBySsoId(String ssoId);
}
