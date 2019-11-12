package com.springboot.ssm.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
// @Table指定该实体类对应的表名,如表名为base_customer,类名为BaseCustomer可以不需要此注解
@Table(name = "user")
public class User {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示使用数据库自带的主键生成策略.
    // @GeneratedValue中generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;
    private String name;
    private Integer age;
}
