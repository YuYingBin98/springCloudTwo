package com.jk.yyb.service;

import com.jk.yyb.entity.OrderEntity;
import com.jk.yyb.entity.SysUser;
import com.jk.yyb.service.hystrix.UserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user-proviser", fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping("/show")
    String show();

    @RequestMapping("select")
    public List<SysUser> selectList();

    @RequestMapping("add")
    public String insert(@RequestBody SysUser user);

    @RequestMapping("delete")
    public void delete(@RequestParam Integer id);

    @RequestMapping("findId")
    public SysUser FindId(@RequestParam Integer id);

}
