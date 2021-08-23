package com.springboot.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.ssm.domain.User;
import com.springboot.ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toUserListPage")
    public String toUserListPage() {
        return "user/userList";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/page")
    @ResponseBody
    public PageInfo<User> page(User user, Pageable pageable) {
        return userService.page(user, pageable);
    }
}
