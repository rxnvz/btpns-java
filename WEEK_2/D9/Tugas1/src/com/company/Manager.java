package com.company;

import java.util.ArrayList;

public class Manager extends Worker{
    String jabatan;
    int tunjanganTrans;
    int tunjanganEnt;
    ArrayList telp = new ArrayList();

    Manager(String IDKaryawan, String nama, ArrayList<String> telp) {
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.telp = telp;
        this.jabatan = "Manajer";
        this.tunjanganTrans = 750000;
        this.tunjanganEnt = 1500000;
        this.tunjanganPulsa = 700000;
        this.gajiPokok = 15000000;
    }

    public String getID() {
        return this.IDKaryawan;
    }
    public String getNama() {
        return this.nama;
    }
    public ArrayList<String> getTelp() {
        return this.telp;
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
    public int getTrans() {
        return this.tunjanganTrans;
    }
    public int getEnt() {
        return this.tunjanganEnt;
    }
}
