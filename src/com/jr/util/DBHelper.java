package com.jr.util;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBHelper {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        getcon();
    }
//    Connection con ;
//    PreparedStatement pre;
//    ResultSet res;
    public static Connection getcon() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = ConnectionPropertiesTransform.class.getClassLoader().getResourceAsStream("JDBC.properties");

        Properties properties = new Properties();
        properties.load(is);

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");
        Class.forName(driverClass);
        Connection con = DriverManager.getConnection(url,username,password);
//        System.out.println(con);
        return  con;

    }

    public static void  closeAll(ResultSet res, PreparedStatement pre,Connection con){
        if(res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pre!=null){
            try {
                pre.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
