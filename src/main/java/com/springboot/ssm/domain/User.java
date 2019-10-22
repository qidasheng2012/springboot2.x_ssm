package com.springboot.ssm.domain;

import lombok.Data;

@Data
public class User {
    // 主键id
    private Integer id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
}
