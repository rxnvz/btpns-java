import java.io.*;
import java.util.*;

public class MainMaba {
    public static void main(String[] args) throws Exception{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String key = "";
        String name = "";
        String id = "";
        String UTS = "";
        String UAS = "";
        String TGS = "";
        
        ArrayList<Mahasiswa> maba = new ArrayList<Mahasiswa>();

        
        while (!key.equalsIgnoreCase("6")) {
            System.out.println("Selamat datang! \nSilahkan pilih 1 diantara 6 menu (1-6):");
            key = br.readLine();
            switch (key) {
                case "1": //Menu tambah data
                    System.out.println("Selamat datang di menu menambah data maba!");
                    System.out.print("Masukkan ID maba: ");    
                    id = br.readLine();
                    System.out.print("Masukkan Nama maba: ");
                    name = br.readLine();
                    System.out.print("Masukkan Nilai UTS: ");
                    UTS = br.readLine();
                    System.out.print("Masukkan Nilai UAS: ");
                    UAS = br.readLine();
                    System.out.print("Masukkan Nilai Tugas: ");
                    TGS = br.readLine();

                    maba.add(new Mahasiswa(id, name, UTS, UAS, TGS));
                    System.out.println("Data berhasil dimasukkan!\n\n");
                    
                    break;
                
                case "2": //Menu edit data by ID
                    System.out.println("Selamat datang di menu edit data maba!");
                    System.out.print("Masukkan ID maba yang ingin diedit: ");
                    id = br.readLine();

                    for (int i = 0; i < maba.size(); i++) {
                        if (maba.get(i).getID().equalsIgnoreCase(id)) {
                            System.out.println("Nama mahasiswa: " + maba.get(i).nama);
                            System.out.print("Masukkan nama baru: ");
                            name = br.readLine();
                            System.out.println("Nilai mahasiswa: " + maba.get(i).UTS);
                            System.out.print("Masukkan nilai UTS baru: ");
                            UTS = br.readLine();
                            System.out.println("Nilai mahasiswa: " + maba.get(i).UAS);
                            System.out.print("Masukkan nilai UAS baru: ");
                            UAS = br.readLine();
                            System.out.println("Nilai mahasiswa: " + maba.get(i).TGS);
                            System.out.print("Masukkan nilai Tugas baru: ");
                            TGS = br.readLine();

                            maba.get(i).setNama(name);
                            maba.get(i).setUTS(UTS);
                            maba.get(i).setUAS(UAS);
                            maba.get(i).setTGS(TGS);

                            System.out.println("Data berhasil diedit!\n\n");
                        }
                    }

                    break;

                case "3": //Menu delete data by ID
                    System.out.println("Selamat datang di menu hapus data maba!");
                    System.out.print("Masukkan ID maba yang ingin dihapus: ");
                    id = br.readLine();

                    for (int i = 0; i < maba.size(); i++) {
                        if (maba.get(i).getID().equalsIgnoreCase(id)) { //Kalo, id maba di arraylist sesuai dengan id yang dimasukkan
                            maba.remove(i);
                            System.out.println("Data berhasil dihapus!\n\n");
                        }
                    }
                    break;

                case "4": //Menu print data mahasiswa
                        System.out.println("Mahasiswa barunya: ");
                        // Iterator itr = maba.iterator();
                        String leftAlignFormat = "| %-15s | %-10f | %-10f | %-10f | %-10f |%n";
                        System.out.format("+-----------------+------------+------------+------------+------------+%n");
                        System.out.format("| Nama Maba       | UTS        | UAS        | TUGAS      | NILAI AKHIR|%n");
                        System.out.format("+-----------------+------------+------------+------------+------------+%n");

                        for (int i = 0; i < maba.size(); i++) {
                            System.out.format(leftAlignFormat, maba.get(i).nama, maba.get(i).getUTS(), maba.get(i).getUAS(), maba.get(i).getTGS(), maba.get(i).NilaiAkhir());
                        }
                        System.out.format("+-----------------+------------+------------+------------+------------+%n");
                        System.out.println("\n\n");

                    break;

                case "5":
                    FileWriter wr = new FileWriter("DataMahasiswa.txt");
                    BufferedWriter brw = new BufferedWriter(wr);

                    String leftAlignFormats = "| %-15s | %-10f | %-10f | %-10f | %-10f |\n";
                    brw.write("+-----------------+------------+------------+------------+------------+\n");
                    brw.write("| Nama Maba       | UTS        | UAS        | TUGAS      | NILAI AKHIR|\n");
                    brw.write("+-----------------+------------+------------+------------+------------+\n");

                    Iterator itrt = maba.iterator();
                    while (itrt.hasNext()) {
                        Mahasiswa mb = (Mahasiswa)itrt.next();
                        brw.write("| " + mb.nama + "           |       " + mb.UTS + " |       " + mb.UAS + " |       " + mb.TGS + " |       " + mb.NilaiAkhir() + " |" + "\n");
                    }
                    brw.write("+-----------------+------------+------------+------------+------------+\n");

                    brw.close();
                    System.out.println("Data berhasil di print! Cek file DataMahasiswa.txt!\n\n");
                    break;
            
                default:
                    System.out.println("Terima kasih sudah menggunakan program ini!");
                    br.close();
                    r.close();
            }
        }
    }
}