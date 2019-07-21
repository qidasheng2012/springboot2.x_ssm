package com.springboot.ssm.service;

import com.springboot.ssm.domain.User;

import java.util.List;

/**
 * @author qp
 * @date 2019/7/21 17:06
 */
public interface UserService {
    // 查询所有学生信息
    List<User> getAll();
}
