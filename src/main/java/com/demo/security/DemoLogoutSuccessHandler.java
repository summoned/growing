package com.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by summoned on 2018/2/28.
 */
public class DemoLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    if(response.isCommitted()){
      logger.debug("response has already been committed");
    }
    final String loginUrl = "/account/ns/login#/page/login";
    RedirectStrategy redirectStrategy = getRedirectStrategy();
    redirectStrategy.sendRedirect(request, response, loginUrl);
  }
}
