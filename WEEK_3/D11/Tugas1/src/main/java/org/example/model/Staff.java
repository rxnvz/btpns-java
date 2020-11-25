package org.example.model;

import java.util.ArrayList;

public class Staff extends Worker {
    int makan;  //deklarasi tunjangan makan
    String email; //deklarasi arraylist email

//    public Staff(long IDKaryawan, String nama, String email, int pulsa, int gajiPokok, int makan, int absensiHari) { //constructor class Staff
//        this.IDKaryawan = IDKaryawan;
//        this.nama = nama;
//        this.email = email;
//        this.pulsa = pulsa;
//        this.gajiPokok = gajiPokok;
//        this.makan = makan;
//        this.absensiHari = absensiHari;
//    }

    // -------------------------- SETTER & GETTER ID --------------------------
    public long getIDKaryawan() {
        return IDKaryawan;
    }
    public void setIDKaryawan(long IDKaryawan) {
        this.IDKaryawan = IDKaryawan;
    }

    // -------------------------- SETTER & GETTER NAMA --------------------------
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    // -------------------------- SETTER & GETTER EMAIL --------------------------
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // -------------------------- SETTER & GETTER TUNJANGAN PULSA --------------------------
    public int getPulsa() {
        return pulsa;
    }
    public void setPulsa(int pulsa) {
        this.pulsa = pulsa;
    }

    // -------------------------- SETTER & GETTER GAJI POKOK --------------------------
    public int getGajiPokok() {
        return gajiPokok;
    }
    public void setGajiPokok(int gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    // -------------------------- SETTER & GETTER TUNJANGAN MAKAN --------------------------
    public int getMakan() {
        return makan;
    }
    public void setMakan(int makan) {
        this.makan = makan;
    }

    // -------------------------- SETTER & GETTER ABSENSI --------------------------
    public int getAbsensiHari() {
        return absensiHari;
    }
    public void setAbsensiHari(int absensiHari) {
        this.absensiHari = absensiHari;
    }

}

// Setelahnya, buat interface StaffService