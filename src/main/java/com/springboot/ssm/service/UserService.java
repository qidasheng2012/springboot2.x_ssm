package com.springboot.ssm.service;

import com.springboot.ssm.domain.User;

import java.util.List;

public interface UserService {
    // 查询所有用户信息
    List<User> selectAll();

    // 根据ids查询用户信息
    List<User> selectByIds(String ids);

    // 新增一个用户
    int addOne(User user);
}
