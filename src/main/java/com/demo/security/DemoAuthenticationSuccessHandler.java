package com.demo.security;

import com.demo.model.DemoUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by summoned on 2018/2/28.
 */
public class DemoAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    //DemoUserDetails userDetails = (DemoUserDetails)authentication.getPrincipal();
    //super.onAuthenticationSuccess(request, response, authentication);
  }
}
