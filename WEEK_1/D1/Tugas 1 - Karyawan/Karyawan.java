public class Karyawan {
    String nama = ""; //inisialisasi variabel untuk nama karyawan
    String jabatan = ""; //inisialisasi variabel untuk jabatan
    int gaji = 0; //inisialisasi variabel untuk gaji

    //Menge-set nama karyawan yang didapat dari KaryawanDemo.java dan dimasukkan ke variabel 'nama'
    public void setName( String newName ) {
        nama = newName;
    }
    //Mengembalikan nilai ke variabel sesuai tipe data (string)
    String getName() {
        return nama;
    }

    //Menge-set jabatan karyawan yang didapat dari KaryawanDemo.java dan dimasukkan ke variabel 'jabatan'
    public void setJabatan( String newJabatan ) {
        jabatan = newJabatan;
    }
    //Mengembalikan nilai ke variabel sesuai tipe data (string)
    String getJabatan() {
        return jabatan;
    }

    //Menge-set gaji karyawan sesuai dengan jabatannya
    // public void setGaji() {
    //     switch (getJabatan().toLowerCase()) {
    //         case "manajer":
    //             gaji = 10000000;
    //             break;
    //         case "supervisor":
    //             gaji = 7000000;
    //             break;
    //         case "staff":
    //             gaji = 5000000;
    //             break;
        
    //         default:
    //             break;
    //     }
    // }
    
    //Menge-set gaji karyawan yang didapat dari KaryawanDemo.java dan dimasukkan ke variabel 'gaji'
    public void setGaji( int newGaji ) {
        gaji = newGaji;
    }
    //Mengembalikan nilai ke variabel sesuai tipe data (int)
    int getGaji() {
        return gaji;
    }

    //Menampilkan keseluruhan data nama, jabatan, dan gaji karyawan yang diinput di KaryawanDemo.java
    public void printKaryawan() {
        System.out.println("Nama: " + getName() +
                           "\nJabatan: " + getJabatan() + 
                           "\nGaji: " + getGaji());
    }
}
