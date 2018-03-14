package com.demo.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by summoned on 2018/2/28.
 */
public class DemoLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint{
  public DemoLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
    super(loginFormUrl);
  }

//  @Override
//  protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
//    return String.format("http://%s/account/ns/login#/page/login", request.getServerName());
//  }
}
