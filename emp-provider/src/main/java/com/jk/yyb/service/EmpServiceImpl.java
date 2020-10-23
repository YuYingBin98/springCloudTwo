package com.jk.yyb.service;

import com.jk.yyb.entity.Emp;
import com.jk.yyb.mapper.EmpMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{

    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> selectList() {
        return empMapper.selectList();
    }

    @Override
    public void inser(Emp emp) {
        empMapper.insertSelective(emp);
    }
}
