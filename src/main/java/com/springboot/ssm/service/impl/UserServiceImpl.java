package com.springboot.ssm.service.impl;

import com.springboot.ssm.domain.User;
import com.springboot.ssm.mapper.UserMapper;
import com.springboot.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qp
 * @date 2019/7/21 17:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
