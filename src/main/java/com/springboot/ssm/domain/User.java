package com.springboot.ssm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class User {
    // 主键id
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
}
