package com.springboot.ssm.controller;

import com.springboot.ssm.annotation.LogAnnotation;
import com.springboot.ssm.domain.User;
import com.springboot.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toUserListPage")
    public String toUserListPage() {
        return "user/userList";
    }

    @LogAnnotation(description = "获取所有用户信息", clazz = User.class)
    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(User user) {
        return userService.getAll();
    }

}
