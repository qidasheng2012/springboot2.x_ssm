package com.springboot.ssm.service;

import com.springboot.ssm.domain.User;

import java.util.List;

public interface UserService {
    // 查询所有用户信息
    List<User> getAll();
}
