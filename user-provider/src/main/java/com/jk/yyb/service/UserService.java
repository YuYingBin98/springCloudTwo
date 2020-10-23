package com.jk.yyb.service;


import com.jk.yyb.entity.SysUser;

import java.util.List;

public interface UserService {
    List<SysUser> selectList();

    void insert(SysUser user);

    void delete(Integer id);

    SysUser findId(Integer id);
}
