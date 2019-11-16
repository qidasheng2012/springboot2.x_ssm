package com.springboot.ssm.mapper.system;

import com.springboot.ssm.domain.User;

import java.util.List;

public interface UserMapper {
    // 查询所有用户信息
    List<User> getAll();
}
