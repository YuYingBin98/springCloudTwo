package com.jk.yyb.controller;

import com.jk.yyb.config.RedisConstant;
import com.jk.yyb.entity.SysUser;
import com.jk.yyb.service.UserService;
import com.jk.yyb.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("select")
    public String selectList(Model model){
        model.addAttribute("userList",userService.selectList());
        return "userShow";
    }

    @RequestMapping("add")
    public String insert(SysUser user){
        redisUtil.delAllKeys(RedisConstant.USER_LIST_KEY);
        userService.insert(user);
        return "success";
    }

    @RequestMapping("toAdd")
    public String toAdd(Model model){
        model.addAttribute("user",new SysUser());
        return "add";
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        userService.delete(id);
        redisUtil.del(RedisConstant.USER_LIST_KEY);
        return "redirect:select";
    }

    @RequestMapping("findId")
    public String findId(Integer id,Model model){
        model.addAttribute("user",userService.FindId(id));
        return "add";
    }
}
