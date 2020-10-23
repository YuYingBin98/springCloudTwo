package com.jk.yyb.contorller;

import com.jk.yyb.entity.OrderEntity;
import com.jk.yyb.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("orderfind")
    public List<OrderEntity> find(){
        List<OrderEntity> orderList=orderService.find();
        return orderList;
    }

    @RequestMapping("delete")
    public void delete(@RequestParam Integer id){
        orderService.delete(id);
    }

    @RequestMapping("add")
    public String insert(@RequestBody OrderEntity order){
        orderService.insert(order);
        return "success";
    }

    @RequestMapping("select")
    public OrderEntity select(@RequestParam Integer id) {
        return orderService.select(id);
    }
}
