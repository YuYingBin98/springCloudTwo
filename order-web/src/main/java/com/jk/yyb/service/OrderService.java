package com.jk.yyb.service;

import com.jk.yyb.entity.OrderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order-provider")
public interface OrderService {

    @RequestMapping("orderfind")
    public List<OrderEntity> find();

    @RequestMapping("delete")
    public void delete(@RequestParam Integer id);

    @RequestMapping("add")
    public String insert(@RequestBody OrderEntity order);

    @RequestMapping("select")
    public OrderEntity select(@RequestParam Integer id);
}
