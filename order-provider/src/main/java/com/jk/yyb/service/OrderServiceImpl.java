package com.jk.yyb.service;

import com.jk.yyb.entity.OrderEntity;
import com.jk.yyb.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderMapper orderMapper;

    @Override
    public List<OrderEntity> find() {
        return orderMapper.find();
    }

    @Override
    public void delete(Integer id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(OrderEntity order) {
        if(order.getOrderId()!=null){
            orderMapper.update(order);
        }else{
            orderMapper.insert(order);
        }
    }

    @Override
    public OrderEntity select(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }
}
