package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class ShowData extends Thread{
    String data = "";

    public ShowData (String a) {
        data = a;
    }

    public void run() {
        JSONObject js = (JSONObject) JSONValue.parse(data); //ini buat ngeconversiin balik string ke bentuk json objek
        JSONArray jsArr = (JSONArray) js.get("Siswa"); //terus nge-get data arraynya aja yang di siswa
        System.out.println("Isi json: " + jsArr); // ini buat ngecek aja datanya bener apa ngga

        for (int i = 0; i < jsArr.size(); i++) {
            JSONObject isian = (JSONObject) jsArr.get(i); //inisialisasi objek json yang nyimpen array tadi
            System.out.println("Nama: " + isian.get("Nama"));
            System.out.println("Nilai Fisika: " + isian.get("Fisika"));
            System.out.println("Nilai Kimia: " + isian.get("Kimia"));
            System.out.println("Nilai Biologi: " + isian.get("Biologi") + "\n");
        }
    }
}
