package com.springboot.ssm.domain;

import lombok.Data;

/**
 * @author qp
 * @date 2019/7/21 16:57
 */
@Data
public class User {
    // 主键id
    private Integer id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
}
