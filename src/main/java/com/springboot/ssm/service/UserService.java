package com.springboot.ssm.service;

import com.springboot.ssm.domain.User;

import java.util.List;

public interface UserService {
    // 查询所有学生信息
    List<User> getAll();
}
