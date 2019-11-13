package com.springboot.ssm.controller;

import com.springboot.ssm.domain.User;
import com.springboot.ssm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/selectAll")
    public List<User> selectAll() {
        return userService.selectAll();
    }

    @GetMapping("/selectByIds/{ids}")
    public List<User> selectByIds(@PathVariable String ids) {
        return userService.selectByIds(ids);
    }

    @PostMapping("/addOne")
    public int addOne(@RequestBody User user) {
        return userService.addOne(user);
    }
}
