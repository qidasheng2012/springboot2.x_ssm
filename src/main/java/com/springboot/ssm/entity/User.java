package com.springboot.ssm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.springboot.ssm.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author apple
 * @since 2019-11-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_user")
public class User extends BaseEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;


}
