package com.npf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.npf.entity.Role;
import com.npf.entity.User;
import com.npf.service.UserService;
import com.npf.util.State;

@Service("myUserDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

	 @Autowired
	 private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String ssoId)throws UsernameNotFoundException {
		User user = userService.findBySsoId(ssoId);
        System.out.println("User : "+user);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        boolean enabled = user.getState().equals(State.Active);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoleList()){
            System.out.println("role : "+role);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleType()));
        }
        return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(), 
        		enabled, true, true, true, authorities);
	}
}
