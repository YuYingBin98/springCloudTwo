package com.jk.yyb.controller;

import com.jk.yyb.entity.Emp;
import com.jk.yyb.service.EmpService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmpController {

    @Resource
    private EmpService empService;

    @RequestMapping("select")
    public List<Emp> select(){
        List<Emp> empList=empService.selectList();
        return empList;
    }

    @RequestMapping("add")
    public String insert(@RequestBody Emp emp){
        empService.inser(emp);
        return "success";
    }
}
