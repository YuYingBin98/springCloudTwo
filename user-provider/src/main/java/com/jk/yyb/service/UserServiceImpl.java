package com.jk.yyb.service;

import com.jk.yyb.entity.SysUser;
import com.jk.yyb.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public List<SysUser> selectList() {
        return userMapper.selectList();
    }

    @Override
    public void insert(SysUser user) {
        if(user.getId()!=null){
            userMapper.update(user);
        }else{
            userMapper.insert(user);
        }
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public SysUser findId(Integer id) {
        return userMapper.findId(id);
    }
}
