import java.util.*;

public class Staff extends Worker {
    Staff(String IDKaryawan, String nama, String jabatan) {
        // super(IDKaryawan, nama);
        this.IDKaryawan = IDKaryawan;
        this.nama = nama;
        this.jabatan = jabatan;
    }
    public String getJabatan() {
        return this.jabatan;
    }
    
    public String getID() {
        return this.IDKaryawan;
    }
    public String getNama() {
        return this.nama;
    }

    public void tambahAbsensi(int absensi) {
        this.absensi = getAbsensi() + absensi;
    }
    public int getAbsensi() {
        return this.absensi;
    }
    
    public static Comparator<Staff> urut = new Comparator<Staff> () {
        public int compare(Staff w1, Staff w2) {
            String work1 = w1.getID();
            String work2 = w2.getID();

            return work1.compareTo(work2);
        }
    };
}
