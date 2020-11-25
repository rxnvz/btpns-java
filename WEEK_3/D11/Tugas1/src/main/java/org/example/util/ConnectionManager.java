package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    public Connection con;
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String db = "jdbc:mysql://localhost:3306/tugas11?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";
    public String uname = "root";
    public String pass = "admin1";

    public Connection on() {
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(db, uname, pass);

        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        return con;
    }

    public void off() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
