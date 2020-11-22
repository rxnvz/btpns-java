import java.util.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Manager extends Worker {
    
    String jabatan;
    int tunjanganTrans;
    int tunjanganEnt;

    Manager(String IDKaryawan, String nama, int tunjanganPulsa, int gajiPokok) {
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.jabatan = "Manajer";
        this.tunjanganPulsa = tunjanganPulsa;
        this.gajiPokok = gajiPokok;
    }

    public String getID() {
        return this.IDKaryawan;
    }
    public String getNama() {
        return this.nama;
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

    public int getAbsensi() {
        return this.absensi;
    }
    public void tambahAbsensi() {
        this.absensi = getAbsensi() + 1;
    }

    public void tjgTrans(int absen) {
        this.tunjanganTrans = absen * 50000;
    }
    public int getTrans() {
        return this.tunjanganTrans;
    }

    public void tjgEnt(int ent) {
        this.tunjanganEnt = ent * 500000;
    }
    public int getEnt() {
        return this.tunjanganEnt;
    }

    public void gajiTotalnya(int gapok, int tuntran, int tunent, int tupul) {
        this.gajiTotal = gapok + tuntran + tunent + tupul;
    }
    public int getGatot() {
        return this.gajiTotal;
    }

    public static Comparator<Manager> urut = new Comparator<Manager> () {
        public int compare(Manager m1, Manager m2) {
            String mnj1 = m1.getID();
            String mnj2 = m2.getID();

            return mnj1.compareTo(mnj2);
        }
    };
}
