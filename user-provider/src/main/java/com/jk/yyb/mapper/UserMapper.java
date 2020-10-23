package com.jk.yyb.mapper;

import com.jk.yyb.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<SysUser> selectList();

    void insert(SysUser user);

    void delete(Integer id);

    SysUser findId(Integer id);

    void update(SysUser user);
}
