package com.jr.biz.impl;

import com.jr.biz.IEmpBiz;
import com.jr.entry.Emp;

import java.util.List;

public class empBizImpl implements IEmpBiz {
    @Override
    public boolean login(Emp emp) {
        return false;
    }

    @Override
    public boolean register(Emp emp) {
   return  false;
    }

    @Override
    public List<Emp> queryAll() {
        return null;
    }

    @Override
    public boolean removeEmp(int empno) {
        return false;
    }

    @Override
    public boolean changeEmp(Emp emp) {
        return false;
    }

    @Override
    public List<Emp> queryByNo(int empno) {
        return null;
    }


}
