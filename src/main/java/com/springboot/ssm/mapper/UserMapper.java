package com.springboot.ssm.mapper;

import com.springboot.ssm.domain.User;

import java.util.List;

public interface UserMapper {
    // 查询所有用户信息
    List<User> getAll();

    // 根据条件查询用户信息
    List<User> getUsers(User user);
}
