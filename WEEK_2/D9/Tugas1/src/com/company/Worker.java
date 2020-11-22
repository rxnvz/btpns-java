package com.company;

public abstract class Worker {
    String IDKaryawan;
    String nama;
    int tunjanganPulsa;
    int gajiPokok;
    int absensi = 20;

    public abstract String getID();
    public abstract String getNama();
    public abstract int getGaji();
}
