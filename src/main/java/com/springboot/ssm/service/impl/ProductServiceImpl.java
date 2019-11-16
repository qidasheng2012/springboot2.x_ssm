package com.springboot.ssm.service.impl;

import com.springboot.ssm.domain.Product;
import com.springboot.ssm.mapper.server.ProductMapper;
import com.springboot.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getAll() {
        return productMapper.getAll();
    }
}
