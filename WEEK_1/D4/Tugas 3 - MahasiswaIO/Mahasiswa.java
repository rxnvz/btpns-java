import java.util.*;

public class Mahasiswa {
    String id = "";
    String nama = "";
    String nilai = "";

    public Mahasiswa (String id, String nama, String nilai) {
        this.id = id;
        this.nama = nama; 
        this.nilai = nilai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    String getID() {
        return this.id;
    }
    String getNama() {
        return this.nama;
    }
    String getNilai() {
        return this.nilai;
    }

    public static Comparator<Mahasiswa> urutin = new Comparator<Mahasiswa> () {
        public int compare(Mahasiswa s1, Mahasiswa s2) {
            String mhs1 = s1.getID();
            String mhs2 = s2.getID();

            return mhs1.compareTo(mhs2); //Karena saya Id-nya berbentuk str, jadinya dicompare berdasarkan urutan dikamus
                                         //Kalo, return int-nya kurang 0, artinya mhs1 saya memiliki posisi dikamus lebih dulu dari mhs2 -- sumber:codepolitan.
        }
    };
}
