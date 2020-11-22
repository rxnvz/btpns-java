package com.company;

import java.util.ArrayList;

public class Staff extends Worker {
    String jabatan;
    int tunjanganMakan;
    ArrayList email = new ArrayList();

    Staff(String IDKaryawan, String nama, ArrayList email) {
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.email = email;
        this.jabatan = "Staff";
        this.tunjanganMakan = 500000;
        this.tunjanganPulsa = 700000;
        this.gajiPokok = 10000000;
    }

    public String getID() {
        return this.IDKaryawan;
    }
    public String getNama() {
        return this.nama;
    }
    public ArrayList<String> getEmail() {
        return this.email;
    }
    public String getJabatan() {
        return this.jabatan;
    }

    public int getGaji() {
        return this.gajiPokok;
    }
    public int getPulsa() {
        return this.tunjanganPulsa;
    }
    public int getMakan() {
        return this.tunjanganMakan;
    }
}
