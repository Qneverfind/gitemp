package com.jr.dao.impl;

import com.jr.dao.IEmpDao;
import com.jr.entry.Emp;

import java.util.List;

public class empDaoImpl implements IEmpDao {
    @Override
    public List<Emp> selectEmp(Emp emp) {
        return null;
    }

    @Override
    public int insertEmp(Emp emp) {
        return 0;
    }

    @Override
    public List<Emp> selectAll() {
        return null;
    }

    @Override
    public boolean dropEmp(int empno) {
        return false;
    }

    @Override
    public int updateEmp(Emp emp) {
        return 0;
    }
}
