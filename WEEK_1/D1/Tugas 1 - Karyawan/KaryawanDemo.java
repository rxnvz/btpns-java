public class KaryawanDemo {
    public static void main(String args[]) {
        Karyawan a = new Karyawan(); //Inisialisasi karyawan baru

        // a.setName("Irene N");
        // a.setJabatan("Manajer");
        // a.setGaji();
        // a.printKaryawan();

        a.setName("Irene N"); //Nge-set nama karyawan
        a.setJabatan("Manajer"); //Nge-set jabatan karyawan
        a.setGaji(10000000); //Nge-set gaji karyawan
        a.printKaryawan(); //Nge-print keseluruhan data karyawan (nama, jabatan, gaji)
    }
}
