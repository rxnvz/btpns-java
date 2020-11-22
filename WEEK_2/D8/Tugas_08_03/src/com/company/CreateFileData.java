package com.company;

import java.io.*;

public class CreateFileData extends Thread {
    FileWriter fw;
    BufferedWriter bw;
    String data = "";
    String[] isi;
    String[] dataIsi;

    public CreateFileData (String a) {
        data = a;
    }

    public void run() {
        try {
            fw = new FileWriter("FileProses.txt");
            bw = new BufferedWriter(fw);

            isi = data.split("\\n");
            for (String str: isi ) {
                dataIsi = str.split(",");
                for (int j = 0; j < dataIsi.length; j++) {
                    if (j == 0) {
                        bw.write("Nama: " + dataIsi[j] + "\n");
                    } else if (j == 1) {
                        bw.write("Nilai Fisika: " + dataIsi[j] + "\n");
                    } else if (j == 2) {
                        bw.write("Nilai Kimia: " + dataIsi[j] + "\n");
                    } else if (j == 3) {
                        bw.write("Nilai Biologi: " + dataIsi[j] + "\n\n");
                    }
                }
            }
            System.out.println("File berhasil di buat! Silahkan cek FileProses.txt\n\n");
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
