package com.npf.entity;

import java.io.Serializable;

import com.npf.util.RoleType;

public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private RoleType roleType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
}
