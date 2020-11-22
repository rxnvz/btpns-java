import java.util.*;

public class Staff extends Worker {
    
    String jabatan;
    int tunjanganMakan;

    Staff(String IDKaryawan, String nama, int tunjanganPulsa, int gajiPokok) {
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.jabatan = "Staff";
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

    public void tjgMakan(int absen) {
        this.tunjanganMakan = absen * 20000;
    }
    public int getMakan() {
        return this.tunjanganMakan;
    }

    public void gajiTotalnya(int gapok, int tuma, int tupul) {
        this.gajiTotal = gapok + tuma + tupul;
    }
    public int getGatot() {
        return this.gajiTotal;
    }

    public static Comparator<Staff> urut = new Comparator<Staff> () {
        public int compare(Staff s1, Staff s2) {
            String stf1 = s1.getID();
            String stf2 = s2.getID();

            return stf1.compareTo(stf2);
        }
    };
    
}
