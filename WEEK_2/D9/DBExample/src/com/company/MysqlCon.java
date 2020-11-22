package com.company;

import java.sql.*;
class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","admin1");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
//            stmt.executeUpdate("insert into emp values(null,'Irfan',50000)");
//            int result=stmt.executeUpdate("update emp set name='Vimal',age=10000 where id=5");
            int result=stmt.executeUpdate("delete from emp where id=3");
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}

