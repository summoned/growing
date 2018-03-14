package com.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.security.web.authentication.rememberme.InvalidCookieException;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by summoned on 2018/2/28.
 */

public class DemoRememberService extends AbstractRememberMeServices{

  private static final String COOKIE_KEY = "_demo";

  public DemoRememberService(String key, UserDetailsService userDetailsService) {
    super(key, userDetailsService);
  }

  @Override
  protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
    String userName = successfulAuthentication.getName();
    int tokenLifetime = getTokenValiditySeconds();
    long expiryTime = System.currentTimeMillis();
    expiryTime += 1000L * (tokenLifetime < 0 ? TWO_WEEKS_S : tokenLifetime);
    setCookies(new String[]{userName, Long.toString(expiryTime)}, request, response);
  }

  private void setCookies(String[] tokens, HttpServletRequest request, HttpServletResponse response){
    String cookieValue = encodeCookie(tokens);
    Cookie cookie = new Cookie(COOKIE_KEY, cookieValue);
    cookie.setPath(getCookiePath(request));
    cookie.setSecure(false);
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
  }

  private String getCookiePath(HttpServletRequest request){
    String contextPath = request.getContextPath();
    return contextPath.length() > 0 ? contextPath : "/";
  }

  @Override
  protected String extractRememberMeCookie(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();

    if ((cookies == null) || (cookies.length == 0)) {
      return null;
    }

    for (Cookie cookie : cookies) {
      if (COOKIE_KEY.equals(cookie.getName())) {
        return cookie.getValue();
      }
    }
    return null;
  }

  @Override
  protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response) throws RememberMeAuthenticationException, UsernameNotFoundException {
    if(cookieTokens == null || cookieTokens.length != 2){
      throw new InvalidCookieException("cookie tokens invalid");
    }
    String userName = cookieTokens[0];
    String expireTime = cookieTokens[1];
    long tokenExpireTime = Long.parseLong(expireTime);
    if(tokenExpireTime >= System.currentTimeMillis()){
      throw new InvalidCookieException("cookie has expired");
    }
    return getUserDetailsService().loadUserByUsername(userName);
  }
}
