package com.jk.yyb.service;

import com.jk.yyb.entity.OrderEntity;

import java.util.List;

public interface OrderService {

    List<OrderEntity> find();

    void delete(Integer id);

    void insert(OrderEntity order);

    OrderEntity select(Integer id);
}
