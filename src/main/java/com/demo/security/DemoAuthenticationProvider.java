package com.demo.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by summoned on 2018/2/28.
 */
public class DemoAuthenticationProvider extends DaoAuthenticationProvider{
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    return super.authenticate(authentication);
  }
}
