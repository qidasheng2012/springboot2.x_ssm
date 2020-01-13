package com.springboot.ssm.controller;

import com.springboot.ssm.aspect.OperationLogAble;
import com.springboot.ssm.domain.User;
import com.springboot.ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    @ResponseBody
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/save")
    @ResponseBody
    @OperationLogAble(resource = "user")
    public String save(@RequestBody User user) {
        boolean status = userService.save(user);

        return status ? "成功" : "失败";
    }

}
