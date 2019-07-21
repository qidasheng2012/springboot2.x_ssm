package com.springboot.ssm.mapper;

import com.springboot.ssm.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qp
 * @date 2019/7/21 17:00
 */
@Mapper
@Repository
public interface UserMapper {
    // 查询所有学生信息
    List<User> getAll();
}
