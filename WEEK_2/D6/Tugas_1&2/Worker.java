public abstract class Worker {
    String IDKaryawan;
    String nama;
    int absensi;
    String jabatan;

    // Karena ini class abstract, jadinya kita gaperlu ada constructor method -- soalnya gabisa diinisialisasi juga
    // public Worker (String IDKaryawan, String nama) {
    //     System.out.println("Constructing an Employee");
    //     this.IDKaryawan = IDKaryawan;
    //     this.nama = nama;
    // }
    
    public abstract String getID();
    public abstract String getNama();
    public abstract String getJabatan();
    public abstract void tambahAbsensi(int absensi);
    public abstract int getAbsensi();
}
