package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBInput extends Thread {
    String data = "";

    public static Connection con;
    public static Statement stmt;

    public DBInput(String a) {
        data = a;
    }

    public void run() {
        JSONObject js = (JSONObject) JSONValue.parse(data);

        JSONObject soleh = (JSONObject) js.get("soleh");
        JSONObject sg = (JSONObject) soleh.get("grades");

        JSONObject ridwan = (JSONObject) js.get("ridwan");
        JSONObject rg = (JSONObject) ridwan.get("grades");

        JSONObject purwoko = (JSONObject) js.get("purwoko");
        JSONObject pg = (JSONObject) purwoko.get("grades");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ujian-15?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","admin1");


            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO mahasiswa VALUES (null, " +
                    "'"+soleh.get("fullname")+"', " +
                    "'"+soleh.get("address")+"', " +
                    "'"+soleh.get("status")+"', " +
                    "'"+sg.get("physics")+"', " +
                    "'"+sg.get("calculus")+"'," +
                    "'"+sg.get("biologi")+"')");

            stmt.executeUpdate("INSERT INTO mahasiswa VALUES (null, " +
                    "'"+ridwan.get("fullname")+"', " +
                    "'"+ridwan.get("address")+"', " +
                    "'"+ridwan.get("status")+"', " +
                    "'"+rg.get("physics")+"', " +
                    "'"+rg.get("calculus")+"'," +
                    "'"+rg.get("biologi")+"')");

            stmt.executeUpdate("INSERT INTO mahasiswa VALUES (null, " +
                    "'"+purwoko.get("fullname")+"', " +
                    "'"+purwoko.get("address")+"', " +
                    "'"+purwoko.get("status")+"', " +
                    "'"+pg.get("physics")+"', " +
                    "'"+pg.get("calculus")+"'," +
                    "'"+pg.get("biologi")+"')");

            con.close();
        } catch (Exception e) {
            System.out.println("ERROR DB INPUT! -- " + e);
        }
    }
}
