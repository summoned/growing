package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by summoned on 2018/2/26.
 */

@Controller
public class IndexController {

  @RequestMapping("/")
  public String welcome(HttpServletRequest request, Model model){
    return "index";
  }

  @RequestMapping("/vue")
  public String welcomeVue(HttpServletRequest request, Model model){
    return "index";
  }

  @RequestMapping("/account/ns/login")
  public String login(HttpServletRequest request, Model model){
    return "index";
  }
}
