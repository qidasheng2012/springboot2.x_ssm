package com.springboot.ssm.controller;

import com.alibaba.excel.EasyExcel;
import com.springboot.ssm.annotation.LogAnnotation;
import com.springboot.ssm.domain.User;
import com.springboot.ssm.listener.UserDataListener;
import com.springboot.ssm.service.UserService;
import com.springboot.ssm.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @LogAnnotation(description = "获取所有用户信息", clazz = User.class)
    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(User user) {
        return userService.getAll();
    }

    // easyexcel导出到指定位置Excel
    @GetMapping("/export4File")
    @ResponseBody
    public String export4File() {
        ExcelUtils.export4File("D://", "用户表file", "用户信息file", User.class, userService.getAll());
        return "导出成功";
    }

    // easyexcel导出Excel到web
    @GetMapping("/export4Web")
    public void export4Web(HttpServletResponse response) {
        try {
            ExcelUtils.export4Web(response, "用户表web", "用户信息web", User.class, userService.getAll());
        } catch (Exception e) {
            log.error("报表导出失败:", e);
        }
    }

    // easyexcel读取文件
    @GetMapping("/read4File")
    @ResponseBody
    public String read4File() {
        String fileName = "d://用户表导入.xlsx";
        EasyExcel.read(fileName, User.class, new UserDataListener(userService)).sheet().doRead();
        return "读取成功";
    }

    // easyexcel上传文件
    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), User.class, new UserDataListener(userService)).sheet().doRead();
        return "上传成功";
    }

}
