package com.jk.yyb.service;

import com.jk.yyb.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> selectList();

    void inser(Emp emp);
}
