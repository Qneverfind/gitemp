package com.jr.biz.impl;

import com.jr.biz.IEmpBiz;
import com.jr.dao.impl.empDaoImpl;
import com.jr.entry.Emp;

import java.util.List;

public class empBizImpl implements IEmpBiz {
    empDaoImpl empDao =  new empDaoImpl();
    @Override
    public boolean login(Emp emp) {
      return empDao.selectEmp(emp).size()>0?true:false;
    }

    @Override
    public boolean register(Emp emp) {
   return  empDao.insertEmp(emp)==1?true:false;
    }

    @Override
    public List<Emp> queryAll() {
        return empDao.selectAll();
    }

    @Override
    public boolean removeEmp(int empno) {
        return empDao.dropEmp(empno)==1?true:false;
    }

    @Override
    public boolean changeEmp(Emp emp) {
        return empDao.updateEmp(emp)==1?true:false;
    }

    @Override
    public List<Emp> queryByNo(int empno) {
        return empDao.selectByNo(empno);
    }


}
