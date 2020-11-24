package org.example.model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

// Pertama, buat abstract class Worker
public abstract class Worker {
    static final AtomicLong counter = new AtomicLong();
    long IDKaryawan;
    String nama;
    int pulsa;
    int gajiPokok;
    int absensiHari;

    public abstract long getIDKaryawan();
    public abstract String getNama();
    public abstract ArrayList getEmail();
    public abstract int getPulsa();
    public abstract int getGajiPokok();
    public abstract int getAbsensiHari();
}

// Setelahnya, buat class Staff