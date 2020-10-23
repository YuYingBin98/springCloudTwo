package com.jk.yyb.controller;

import com.jk.yyb.entity.OrderEntity;
import com.jk.yyb.entity.SysUser;
import com.jk.yyb.service.OrderService;
import com.jk.yyb.utils.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private OrderService orderService;

    @RequestMapping("orderfind")
    public String find(Model model){
        model.addAttribute("orderList",orderService.find());
        return "orderShow";
    }

    @RequestMapping("add")
    @ResponseBody
    public String insert(OrderEntity order){
        orderService.insert(order);
        return "success";
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model){
        model.addAttribute("order",new OrderEntity());
        return "add";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer id){
        orderService.delete(id);
        return "redirect:orderfind";
    }

    @RequestMapping("select")
    public String select(Integer id,Model model) {
        model.addAttribute("order",orderService.select(id));
        return "add";
    }
}
