package com.jk.yyb.service.hystrix;

import com.jk.yyb.entity.SysUser;
import com.jk.yyb.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceHystrix implements UserService {
    @Override
    public String show() {
        return "网络为题，请收货欧充实";
    }

    @Override
    public List<SysUser> selectList() {
        return null;
    }

    @Override
    public String insert(SysUser user) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public SysUser FindId(Integer id) {
        return null;
    }
}
