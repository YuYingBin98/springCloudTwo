package com.jk.yyb.mapper;

import com.jk.yyb.entity.Dep;

public interface DepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dep record);

    int insertSelective(Dep record);

    Dep selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);
}