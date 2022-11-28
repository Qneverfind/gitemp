package com.jr.biz;

import com.jr.entry.Emp;

import java.util.List;

public interface IEmpBiz {

    //登录
    public  boolean login(Emp emp);

    //注册
    public  boolean register(Emp emp);

    //查询全部
    public List<Emp> queryAll();

    //通过empno删除
    public  boolean removeEmp(int empno);

    //通过empno修改
    public  boolean changeEmp(Emp emp);

}

