package com.jr.dao.impl;

import com.jr.dao.IEmpDao;
import com.jr.entry.Emp;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empDaoImpl implements IEmpDao {
    Connection con ;
    PreparedStatement pre ;
    ResultSet res;

    @Override
    public List<Emp> selectEmp(Emp emp) {
        List<Emp> list = new ArrayList<>();
        try {
            con = DBHelper.getcon();
            String sql = "SELECT * FROM emp WHERE EMPNO=? AND ENAME=?";
            pre = con.prepareStatement(sql);
            pre.setInt(1,emp.getEmpno());
            pre.setString(2,emp.getEname());
            res= pre.executeQuery();
            while (res.next()){
                Emp emp1 = new Emp();
                emp1.setEmpno(res.getInt("EMPNO"));
                emp1.setEname(res.getString("ENAME"));
                list.add(emp1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(res,pre,con);
        }
        return  list;
    }

    @Override
    public int insertEmp(Emp emp) {
        String sql ="insert into emp values(?,?,null,null,null,null,null,null)";
        return upd(sql, emp.getEmpno(), emp.getEname());

    }

    @Override
    public List<Emp> selectAll() {
        List<Emp> list = new ArrayList<>();
        try {
            con = DBHelper.getcon();
            String sql = "SELECT * FROM emp ";
            pre = con.prepareStatement(sql);
            res= pre.executeQuery();
            while (res.next()){
                Emp emp1 = new Emp();
                emp1.setEmpno(res.getInt("EMPNO"));
                emp1.setEname(res.getString("ENAME"));
                emp1.setJob(res.getString("JOB"));
                emp1.setMgr(res.getInt("MGR"));
                emp1.setHiredate(res.getDate("HIREDATE"));
                emp1.setSal(res.getDouble("SAL"));
                emp1.setComm(res.getDouble("COMM"));
                emp1.setDeptno(res.getInt("DEPTNO"));
                list.add(emp1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(res,pre,con);
        }
        return  list;


    }

    @Override
    public int  dropEmp(int empno) {
        String sql="delete from emp where EMPNO =?";
        return upd(sql,empno);
    }

    @Override
    public int updateEmp(Emp emp) {
        String sql ="update emp set ENAME=?,JOB=?,MGR=?,HIREDATE=?,SAL=?,COMM=?,DEPTNO=? WHERE EMPNO=?";

        return  upd(sql,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno());

    }

    @Override
    public List<Emp> selectByNo(int empno) {
        List<Emp> list = new ArrayList<>();
        try {
            con = DBHelper.getcon();
            String sql = "SELECT * FROM emp  WHERE EMPNO=?";
            pre = con.prepareStatement(sql);
            pre.setInt(1,empno);
            res= pre.executeQuery();
            while (res.next()){
                Emp emp1 = new Emp();
                emp1.setEmpno(res.getInt("EMPNO"));
                emp1.setEname(res.getString("ENAME"));
                emp1.setJob(res.getString("JOB"));
                emp1.setMgr(res.getInt("MGR"));
                emp1.setHiredate(res.getDate("HIREDATE"));
                emp1.setSal(res.getDouble("SAL"));
                emp1.setComm(res.getDouble("COMM"));
                emp1.setDeptno(res.getInt("DEPTNO"));
                list.add(emp1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(res,pre,con);
        }
        return  list;
    }


    public  int upd (String sql , Object...objs){
        int num = 0;
        try {
            con = DBHelper.getcon();
           pre =  con.prepareStatement(sql);
           for(int i=0;i<objs.length;i++){
               pre.setObject(i+1,objs[i]);
           }
           num = pre.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(res,pre,con);
        }
        return  num;
    }
}
