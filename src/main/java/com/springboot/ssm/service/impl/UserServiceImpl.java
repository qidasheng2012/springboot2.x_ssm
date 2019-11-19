package com.springboot.ssm.service.impl;

import com.springboot.ssm.entity.User;
import com.springboot.ssm.mapper.UserMapper;
import com.springboot.ssm.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author apple
 * @since 2019-11-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
