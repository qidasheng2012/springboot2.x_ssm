package com.springboot.ssm.service;

import com.springboot.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 获取所有产品信息
     *
     * @return
     */
    List<Product> getAll();
}
