package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonExample3{
    public static void main(String args[]){
        JSONObject obj = new JSONObject();
        obj.put("name","sonoo");
        obj.put("age",new Integer(27));
        obj.put("salary",new Double(600000));

        JSONObject obj1 = new JSONObject();
        obj1.put("name","sanaa");
        obj1.put("age",new Integer(26));
        obj1.put("salary",new Double(700000));

        JSONObject obj2 = new JSONObject();
        obj2.put("name","sinii");
        obj2.put("age",new Integer(25));
        obj2.put("salary",new Double(800000));

        JSONObject x = new JSONObject();
        x.put("physics", 80);
        x.put("calculus", 90);
        x.put("biology",78);
        JSONObject y = new JSONObject();
        y.put("physics", 75);
        y.put("calculus", 90);
        y.put("biology",85);
        JSONObject z = new JSONObject();
        z.put("physics", 0);
        z.put("calculus", 0);
        z.put("biology", 0);

        JSONObject data1 = new JSONObject();
        data1.put("fullname", "siapa");
        data1.put("adress", "bumi");
        data1.put("status", "active");
        data1.put("grades", x);
        JSONObject data2 = new JSONObject();
        data2.put("fullname", "siapaya");
        data2.put("adress", "bumiya");
        data2.put("status", "away");
        data2.put("grades", y);
        JSONObject data3 = new JSONObject();
        data3.put("fullname", "siapani");
        data3.put("adress", "bumini");
        data3.put("status", "gone");
        data3.put("grades", z);

        JSONObject d1 = new JSONObject();
        d1.put("ss", data1);
        JSONObject d2 = new JSONObject();
        d2.put("sy", data2);
        JSONObject d3 = new JSONObject();
        d3.put("sn", data3);

        JSONArray dArr = new JSONArray();
        dArr.add(d1);
        dArr.add(d2);
        dArr.add(d3);

        JSONObject done = new JSONObject();
        done.put("Siswa", dArr);


//        Ini masukkin object tiga di atas ke array
        JSONArray arr = new JSONArray();
        arr.add(obj);
        arr.add(obj1);
        arr.add(obj2);

//        Ini masukkin array tadi ke JSONobject employees
        JSONObject emp = new JSONObject();
        emp.put("Employees",arr);

//        Ngambil value array dari JSONObject emp
        JSONArray arrEmp = (JSONArray) emp.get("Employees");

        for (int i = 0; i < arrEmp.size(); i++) {
            JSONObject empTemp = (JSONObject) arrEmp.get(i); //Taro ke tempat sementara buat nge-get tiap index i di array
            String nama = (String) empTemp.get("name");
            Integer age = (Integer) empTemp.get("age");
            Double sal = (Double) empTemp.get("salary");

            System.out.println("Nama: " + nama);
            System.out.println("Age: " + age);
            System.out.println("Salary: " + sal + "\n");
        }

        System.out.print(emp);
    }}


