package com.jr.server;

import com.jr.biz.impl.empBizImpl;
import com.jr.entry.Emp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n = Integer.parseInt(request.getParameter("i"));
        if (n == 5) {
            delete(request,response);
        } else if (n == 3) {
            empBizImpl empBiz = new empBizImpl();
            List<Emp> list = empBiz.queryAll();

            HttpSession session = request.getSession();
            session.setAttribute("sr", list);
            response.sendRedirect("info.jsp");
        }else if(n==6){
            selsectByNo(request,response);
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int str = Integer.parseInt(request.getParameter("i"));
        if(str==2){
            login(request,response);
        }else if(str ==3){
            empBizImpl empBiz = new empBizImpl();
            List<Emp> list = empBiz.queryAll();

            HttpSession session = request.getSession();
            session.setAttribute("sr",list);
            response.sendRedirect("info.jsp");
        }else if(str==4) {
            register(request,response);
        }else if(str==7){
//           System.out.println("hahah");

            try {
                upedateByNo(request,response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }



    public  void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        String uname = request.getParameter("uname");
        Emp emp = new Emp();
        emp.setEmpno(empno);
        emp.setEname(uname);
        empBizImpl empBiz = new empBizImpl();
        boolean boo = empBiz.login(emp);
        if(boo){
            request.getRequestDispatcher("emp?i=3").forward(request,response);
        }else {
            response.sendRedirect("index.jsp");
        }
    }

    public  void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int  rempno = Integer.parseInt(request.getParameter("rempno"));
        String rname = request.getParameter("rname");
        Emp emp = new Emp();
        emp.setEmpno(rempno);
        emp.setEname(rname);
        empBizImpl empBiz = new empBizImpl();
        boolean b = empBiz.register(emp);
        if(b){
            response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("register.jsp");
        }

    }
    public  void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        empBizImpl empBiz = new empBizImpl();
        boolean remove = empBiz.removeEmp(empno);
        if(remove){
            request.getRequestDispatcher("emp?i=3").forward(request,response);
        }else {
            request.getRequestDispatcher("info.jsp").forward(request,response);
        }

    }
    public  void selsectByNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int e = Integer.parseInt(request.getParameter("empno"));
        empBizImpl empBiz = new empBizImpl();
        List<Emp> list = empBiz.queryByNo(e);
        HttpSession session = request.getSession();
        session.setAttribute("ss",list);
        response.sendRedirect("update.jsp");

    }

    public  void upedateByNo(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        Emp emp = new Emp();
//        System.out.println("修稿方法");
        int empno = Integer.parseInt(request.getParameter("empno"));
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        int mgr = Integer.parseInt(request.getParameter("mgr"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        emp.setHiredate(simpleDateFormat.parse(request.getParameter("hiredate")));
        System.out.println(emp.getHiredate() );
        double sal = Double.parseDouble(request.getParameter("sal"));
        double comm =  Double.parseDouble(request.getParameter("comm"));
        int deptno = Integer.parseInt(request.getParameter("deptno"));

        emp.setEmpno(empno);
        emp.setEname(ename);
        emp.setJob(job);
        emp.setMgr(mgr);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setDeptno(deptno);
        empBizImpl empBiz = new empBizImpl();
        boolean change = empBiz.changeEmp(emp);
        if(change){
            request.getRequestDispatcher("emp?i=3").forward(request,response);
        }
        else {
            response.sendRedirect("update.jsp");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
