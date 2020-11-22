import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

public class MainMahasiswa extends Thread {
    public static void main(String[] args) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        
        FileReader fru = new FileReader("username.txt");
        FileReader frp = new FileReader("password.txt");
        BufferedReader bru = new BufferedReader(fru);
        BufferedReader brp = new BufferedReader(frp);
        
        ArrayList<Mahasiswa> mhs = new ArrayList<Mahasiswa>();

        PrintData t1 = new PrintData(mhs);
        ShowData t2 = new ShowData(mhs);
        
        String key = "";
        int id = 0;
        String uname = "";
        String passw = "";

        String unamef ="";
        String passwf ="";
        
        int i;
        int j;
        while ((i=bru.read())!=-1) {
            unamef += (char)i;
        }
        bru.close();    
        fru.close(); 

        while ((j=brp.read())!=-1) {
            passwf += (char)j;
        }
        brp.close();    
        frp.close();
        

        System.out.print("Masukkan username: ");
        uname = br.readLine();
        System.out.print("Masukkan password: ");
        passw = br.readLine();

        if (Pattern.matches("\\w*@gmail.com", uname) && Pattern.matches("\\w{8,20}+", passw)) {
            if (uname.equals(unamef) && passw.equals(passwf)) {
                while (!key.equalsIgnoreCase("exit")) {
                    System.out.println("Selamat datang!" +
                                        "\nKetik 'add' untuk tambah mahasiswa" +
                                        "\nKetik 'show' untuk menampilkan data mahasiswa" +
                                        "\nKetik 'exit' untuk keluar" +
                                        "\nSilahkan pilih menu:");
                    key = br.readLine();

                    switch (key) {
                        case "add":
                            addMhs(mhs);
                            break;

                        case "show":
                            t1.start();
                            t2.start();
                            break;
                    
                        default:
                            System.out.println("Terima kasih sudah menggunakan program ini!");
                            br.close();
                            r.close();
                    }
                }
            } else {
                System.out.println("Email dan password tidak sesuai!");
            }
        } else {
            System.out.println("Gunakan format email dan password yang benar!");
        }
    }

    // Tambah mahasiswa baru
    public static void addMhs(ArrayList<Mahasiswa> x) {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            int id;
            String nama;
            double nilaiEn;
            double nilaiFis;
            double nilaiAl;

            System.out.println("Selamat datang di menu menambah data maba!");
            System.out.print("Masukkan ID maba: ");    
            id = Integer.parseInt(br.readLine());
            System.out.print("Masukkan Nama maba: ");
            nama = br.readLine();
            System.out.print("Masukkan Nilai Bahasa Inggris: ");
            nilaiEn = Double.parseDouble(br.readLine());
            System.out.print("Masukkan Nilai Fisika: ");
            nilaiFis = Double.parseDouble(br.readLine());
            System.out.print("Masukkan Nilai Algoritma: ");
            nilaiAl = Double.parseDouble(br.readLine());

            x.add(new Mahasiswa(id, nama, nilaiEn, nilaiFis, nilaiAl));
            System.out.println("Data berhasil dimasukkan!\n\n");

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
