package com.jr.dao;

import com.jr.entry.Emp;

import java.util.List;

public interface IEmpDao {

    //登录dao层
    public List<Emp> selectEmp(Emp emp);

    //注册dao层
    public  int insertEmp(Emp emp);

    //查询全部
    public  List<Emp> selectAll();

    //通过empno删除
    public  int  dropEmp(int empno);

    //通过empno修改
    public  int updateEmp(Emp emp);


    public  List<Emp> selectByNo(int empno);

}
