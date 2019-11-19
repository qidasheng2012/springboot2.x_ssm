package com.springboot.ssm.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.ssm.common.BaseController;
import com.springboot.ssm.entity.User;
import com.springboot.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 * @author apple
 * @since 2019-11-19
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService iUserService;

    @Override
    public IService getIService() {
        return iUserService;
    }
}
