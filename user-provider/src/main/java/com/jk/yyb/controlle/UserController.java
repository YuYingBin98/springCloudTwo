package com.jk.yyb.controlle;

import com.jk.yyb.config.RedisConstant;
import com.jk.yyb.entity.SysUser;
import com.jk.yyb.service.UserService;
import com.jk.yyb.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService usrService;
    @Resource
    private RedisUtil redisUtil;
    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("select")
    public List<SysUser> selectList() {
        List<SysUser> userList = (List<SysUser>) redisUtil.get(RedisConstant.USER_LIST_KEY);
        if (userList == null || userList.isEmpty()) {
            userList = usrService.selectList();

            redisUtil.set(RedisConstant.USER_LIST_KEY, userList, 60);
        }
        return userList;
    }

    @RequestMapping("add")
    public String insert(@RequestBody SysUser user) {
        redisUtil.delAllKeys(RedisConstant.USER_LIST_KEY);
        usrService.insert(user);
        return "success";
    }

    @RequestMapping("delete")
    public void delete(@RequestParam Integer id) {
        usrService.delete(id);
        redisUtil.del(RedisConstant.USER_LIST_KEY);
    }

    @RequestMapping("findId")
    public SysUser FindId(@RequestParam Integer id) {
        return usrService.findId(id);
    }
}
