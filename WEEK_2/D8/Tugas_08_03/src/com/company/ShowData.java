package com.company;

public class ShowData extends Thread {
    String data = "";
    String[] isi;
    String[] dataIsi;

    public ShowData(String a) {
        data = a;
    }

    public void run() {
        try {
            isi = data.split("\\n");
            for (String str: isi ) {
                dataIsi = str.split(",");
                for (int j = 0; j < dataIsi.length; j++) {
                    if (j == 0) {
                        System.out.println("Nama: " + dataIsi[j]);
                    } else if (j == 1) {
                        System.out.println("Nilai Fisika: " + dataIsi[j]);
                    } else if (j == 2) {
                        System.out.println("Nilai Kimia: " + dataIsi[j]);
                    } else if (j == 3) {
                        System.out.println("Nilai Biologi: " + dataIsi[j] + "\n");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
