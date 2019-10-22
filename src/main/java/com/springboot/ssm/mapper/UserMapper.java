package com.springboot.ssm.mapper;

import com.springboot.ssm.domain.User;

import java.util.List;

public interface UserMapper {
    // 查询所有学生信息
    List<User> getAll();
}
