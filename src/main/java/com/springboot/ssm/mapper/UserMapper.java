package com.springboot.ssm.mapper;

import com.springboot.ssm.domain.User;

import java.util.List;

public interface UserMapper {
    // 查询所有用户信息
    List<User> getAll();

    // 保存用户信息
    void saveBatch(List<User> list);
}
