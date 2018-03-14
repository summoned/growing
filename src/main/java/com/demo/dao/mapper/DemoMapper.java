package com.demo.dao.mapper;

import com.demo.model.DemoUserDetails;
import org.apache.ibatis.annotations.Param;

/**
 * Created by summoned on 2018/2/24.
 */
public interface DemoMapper {
  int getB(@Param("a") int a);

  DemoUserDetails getUserDetils(@Param("username") String username);
}
