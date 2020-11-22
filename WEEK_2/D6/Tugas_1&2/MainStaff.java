import java.util.*;
import java.io.*;

public class MainStaff {
    public static void main(String[] args) throws Exception{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String key = "";
        String nama = "";
        String id = "";
        String jabatan = "";
        String absen = "";
        
        ArrayList<Staff> wrk = new ArrayList<Staff>();

        while (!key.equalsIgnoreCase("exit")) {
            System.out.println("Selamat datang! \nKetik 'add' untuk tambah staff \nKetik 'abs' untuk absensi \nKetik 'show' untuk menampilkan data \nKetik 'exit' untuk keluar \nSilahkan pilih menu:");
            key = br.readLine();
            switch (key) {
                case "add":
                    System.out.println("Selamat datang di menu menambah data staf!");
                    System.out.print("Masukkan ID staf: ");    
                    id = br.readLine();
                    System.out.print("Masukkan nama staf: ");
                    nama = br.readLine();
                    System.out.print("Masukkan jabatan staf: ");
                    jabatan = br.readLine();

                    wrk.add(new Staff(id, nama, jabatan));
                    System.out.println("Data berhasil dimasukkan!\n\n");
                    
                    break;
                
                case "abs":
                    System.out.println("Selamat datang di menu tambah absensi staff!");
                    System.out.print("Masukkan ID staff yang ingin ditambah absensinya: ");
                    id = br.readLine();

                    for (int i = 0; i < wrk.size(); i++) {
                        if (wrk.get(i).getID().equalsIgnoreCase(id)) {
                            wrk.get(i).tambahAbsensi(1);
                            System.out.println("Absensi berhasil ditambah!\n\n");
                        }
                    }

                    break;

                case "show":
                    printData(wrk);
                    System.out.println("");
                    break;
            
                default:
                    System.out.println("Terima kasih sudah menggunakan program ini!");
                    br.close();
                    r.close();
            }
        }
    }

    public static void printData(ArrayList<Staff> x) {
        String leftAlignFormat = "%-4s  %-15s  %-15s  %-4d %n";
        System.out.format("ID    Nama Karyawan    Jabatan          Absensi/hari %n");
        Collections.sort(x, Staff.urut);
        Iterator itr = x.iterator();
        while (itr.hasNext()) {
            Staff c = (Staff)itr.next();
            System.out.format(leftAlignFormat, c.IDKaryawan, c.nama, c.jabatan, c.getAbsensi());
        }
    }
}
