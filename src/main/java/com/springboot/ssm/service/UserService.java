package com.springboot.ssm.service;

import com.github.pagehelper.PageInfo;
import com.springboot.ssm.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    // 查询所有用户信息
    List<User> getAll();

    // 分页查询用户信息
    PageInfo<User> page(User user, Pageable pageable);
}
