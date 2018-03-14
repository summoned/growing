package com.demo.security;

import com.demo.dao.mapper.DemoMapper;
import com.demo.model.DemoUserDetails;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by summoned on 2018/2/28.
 */

@Service
public class DemoUserDetailsService implements UserDetailsService{
  @Resource
  private DemoMapper demoMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    DemoUserDetails userDetails = demoMapper.getUserDetils(username);
    if(userDetails == null)
      throw new UsernameNotFoundException("该用户不存在");
    return userDetails;
  }
}
