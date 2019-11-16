package com.springboot.ssm.mapper.server;

import com.springboot.ssm.domain.Product;

import java.util.List;

public interface ProductMapper {
    // 查询所有产品信息
    List<Product> getAll();
}
