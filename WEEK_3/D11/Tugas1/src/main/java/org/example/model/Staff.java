package org.example.model;

import java.util.ArrayList;

public class Staff extends Worker {
    int makan;  //deklarasi tunjangan makan
    ArrayList email = new ArrayList(); //deklarasi arraylist email

    public Staff() {
        this.IDKaryawan = counter.incrementAndGet(); //ini buat, id-nya auto increment
    }

    Staff(String nama, ArrayList email, int pulsa, int gajiPokok, int makan, int absensiHari) { //constructor class Staff
        this.IDKaryawan = counter.incrementAndGet();
        this.nama = nama;
        this.email = email;
        this.pulsa = pulsa;
        this.gajiPokok = gajiPokok;
        this.makan = makan;
        this.absensiHari = absensiHari;
    }

    // -------------------------- SETTER & GETTER ID --------------------------
    public long getIDKaryawan() {
        return this.IDKaryawan;
    }
    public void setIDKaryawan(long IDKaryawan) {
        this.IDKaryawan = IDKaryawan;
    }

    // -------------------------- SETTER & GETTER NAMA --------------------------
    public String getNama() {
        return this.nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    // -------------------------- SETTER & GETTER EMAIL --------------------------
    public ArrayList getEmail() {
        return this.email;
    }
    public void setEmail(ArrayList email) {
        this.email = email;
    }

    // -------------------------- SETTER & GETTER TUNJANGAN PULSA --------------------------
    public int getPulsa() {
        return this.pulsa;
    }
    public void setPulsa(int pulsa) {
        this.pulsa = pulsa;
    }

    // -------------------------- SETTER & GETTER GAJI POKOK --------------------------
    public int getGajiPokok() {
        return this.gajiPokok;
    }
    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    // -------------------------- SETTER & GETTER TUNJANGAN MAKAN --------------------------
    public int getMakan() {
        return this.makan;
    }
    public void setMakan(int makan) {
        this.makan = makan;
    }

    // -------------------------- SETTER & GETTER ABSENSI --------------------------
    public int getAbsensiHari() {
        return this.absensiHari;
    }
    public void setAbsensiHari(int absensiHari) {
        this.absensiHari = absensiHari;
    }

}

// Setelahnya, buat interface StaffService