package com.springboot.ssm.common.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MysqlBaseMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
