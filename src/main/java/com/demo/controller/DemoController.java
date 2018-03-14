package com.demo.controller;

import com.demo.dao.mapper.DemoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by summoned on 2018/2/24.
 */

@RestController
@RequestMapping(value = "/call")
public class DemoController {
  @Resource
  private DemoMapper demoMapper;

  @RequestMapping(value = "/test")
  public String test(){
    return "hello wolrd";
  }

  @RequestMapping(value = "/testDb")
  public String testDb(){
    int b = demoMapper.getB(2);
    return Integer.toString(b);
  }
}
