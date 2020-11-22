package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CreateFile extends Thread{
    FileWriter fw;
    BufferedWriter bw;
    String data = "";
    String[] isi;
    String[] dataIsi;

    public CreateFile (String a) {
        data = a;
    }

    public void run() {
        JSONObject js = (JSONObject) JSONValue.parse(data); //ini buat ngeconversiin balik string ke bentuk json objek
        JSONArray jsArr = (JSONArray) js.get("Siswa"); //terus nge-get data arraynya aja yang di siswa
//        System.out.println("Isi json: " + jsArr); // ini buat ngecek aja datanya bener ada apa ngga

        try {
            fw = new FileWriter("FileProses.txt"); //ini buat ngebikin file baru
            bw = new BufferedWriter(fw); //ini buat ngamanin

            for (int i = 0; i < jsArr.size(); i++) {
                JSONObject isian = (JSONObject) jsArr.get(i); //inisialisasi objek json yang nyimpen array tadi
                bw.write("Nama: " + isian.get("Nama") + "\n");
                bw.write("Nilai Fisika: " + isian.get("Fisika") + "\n");
                bw.write("Nilai Kimia: " + isian.get("Kimia") + "\n");
                bw.write("Nilai Biologi: " + isian.get("Biologi") + "\n\n");
            }
            System.out.println("File berhasil di buat! Silahkan cek FileProses.txt\n\n");
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
