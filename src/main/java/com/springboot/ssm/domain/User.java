package com.springboot.ssm.domain;

import lombok.Data;

@Data
public class User {
    // 主键id
    private Integer id;
    private String name;
    private Integer age;
}
