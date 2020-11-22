import java.util.*;
import java.io.*;

public class Mahasiswa extends Thread {
    int id;
    String nama;
    double nilaiEn;
    double nilaiFis;
    double nilaiAl;

    public Mahasiswa(int id, String nama, double nilaiEn, double nilaiFis, double nilaiAl) {
        this.id = id;
        this.nama = nama;
        this.nilaiEn = nilaiEn;
        this.nilaiFis = nilaiFis;
        this.nilaiAl = nilaiAl;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setEn(double nilaiEn) {
        this.nilaiEn = nilaiEn;
    }
    public void setFis(double nilaiFis) {
        this.nilaiFis = nilaiFis;
    }
    public void setAl(double nilaiAl) {
        this.nilaiAl = nilaiAl;
    }

    int getID() {
        return id;
    }
    String getNama() {
        return nama;
    }
    double getEn() {
        return nilaiEn;
    }
    double getFis() {
        return nilaiFis;
    }
    double getAl() {
        return nilaiAl;
    }

    public static Comparator<Mahasiswa> urutin = new Comparator<Mahasiswa>() {
        public int compare(Mahasiswa m1, Mahasiswa m2) {
    
           int mhs1 = m1.getID();
           int mhs2 = m2.getID();
           return mhs1-mhs2;
       }
    };
}
