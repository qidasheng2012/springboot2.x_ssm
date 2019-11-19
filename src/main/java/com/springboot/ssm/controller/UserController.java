package com.springboot.ssm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping("/page")
    public IPage<User> page(@RequestParam long current, @RequestParam long size) {
        Page<User> page = new Page(current, size);
        return userService.page(page);
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        return userService.save(user) ? "添加成功！" : "添加失败！";
    }

    @PutMapping("/update")
    public String update(@RequestBody User user) {
        return userService.updateById(user) ? "修改成功！" : "修改失败！";
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        return userService.removeById(id) ? "删除成功！" : "删除失败！";
    }

}
