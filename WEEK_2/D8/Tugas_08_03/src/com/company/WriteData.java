package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteData extends Thread {
    FileWriter fw;
    BufferedWriter bw;
    String data = "";
    String[] isi;
    String[] dataIsi;

    public WriteData (String a) {
        data = a;
    }

    public void run() {
        try {
            fw = new FileWriter("FileRata2.txt");
            bw = new BufferedWriter(fw);

            isi = data.split("\\n");
            bw.write("Nama,Rata2\n");
            for (String str: isi ) {
                dataIsi = str.split(",");
                bw.write(dataIsi[0] + ",");

                Double Fis = Double.parseDouble(dataIsi[1]);
                Double Kim = Double.parseDouble(dataIsi[2]);
                Double Bio = Double.parseDouble(dataIsi[3]);
                long ave = Math.round((Fis+Kim+Bio)/3);

                bw.write(String.valueOf(ave) + "\n");
            }
            System.out.println("File Rata-rata berhasil di buat! Silahkan cek FileRata2.txt\n\n");
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
