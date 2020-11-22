import java.io.*;
import java.util.*;

public class MahasiswaIO {
    public static void main(String[] args) throws Exception{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String key = "";
        String name = "";
        String id = "";
        String nilai = "";
        
        ArrayList<Mahasiswa> maba = new ArrayList<Mahasiswa>();

        
        while (!key.equalsIgnoreCase("6")) {
            System.out.println("Selamat datang! \nSilahkan pilih 1 diantara 6 menu (1-6):");
            key = br.readLine();
            switch (key) {
                case "1": //add data done
                    System.out.println("Selamat datang di menu menambah data maba!");
                    System.out.print("Masukkan ID maba: ");    
                    id = br.readLine();
                    System.out.print("Masukkan Nama maba: ");
                    name = br.readLine();
                    System.out.print("Masukkan Nilai maba: ");
                    nilai = br.readLine();

                    maba.add(new Mahasiswa(id, name, nilai));
                    System.out.println("Data berhasil dimasukkan!\n\n");
                    
                    break;
                
                case "2": //edit data done
                    System.out.println("Selamat datang di menu edit data maba!");
                    System.out.print("Masukkan ID maba yang ingin diedit: ");
                    id = br.readLine();

                    for (int i = 0; i < maba.size(); i++) {
                        if (maba.get(i).getID().equalsIgnoreCase(id)) {
                            System.out.println("Nama mahasiswa: " + maba.get(i).nama);
                            System.out.print("Masukkan nama baru: ");
                            name = br.readLine();
                            System.out.println("Nilai mahasiswa: " + maba.get(i).nilai);
                            System.out.print("Masukkan nilai baru: ");
                            nilai = br.readLine();

                            maba.get(i).setNama(name); //Untuk update nama dari id yang dimasukkan
                            maba.get(i).setNilai(nilai); //Untuk update nilai dari id yang dimasukkan

                            System.out.println("Data berhasil diedit!\n\n");
                        }
                    }

                    break;

                case "3": //delet data done
                    System.out.println("Selamat datang di menu hapus data maba!");
                    System.out.print("Masukkan ID maba yang ingin dihapus: ");
                    id = br.readLine();

                    for (int i = 0; i < maba.size(); i++) {
                        if (maba.get(i).getID().equalsIgnoreCase(id)) { //Kalo, id maba di arraylist sesuai dengan id yang dimasukkan
                            maba.remove(i);
                            System.out.println("Data berhasil dihapus!\n");
                        }
                    }
                    break;

                case "4": //sort data by id done
                        System.out.println("Mahasiswa barunya: ");
                        Collections.sort(maba, Mahasiswa.urutin); //Ngurutin di arraylist maba dengan komparator dari Mahasiswa.urutin
                        Iterator itr = maba.iterator();
                        while (itr.hasNext()) {
                            Mahasiswa mb = (Mahasiswa)itr.next();
                            System.out.println("ID: " + mb.id + " Nama: " + mb.nama + " Nilai: " + mb.nilai);
                        }
                        System.out.println("\n");

                    break;

                case "5": //print data done
                    FileWriter wr = new FileWriter("DataMahasiswa.txt");
                    BufferedWriter brw = new BufferedWriter(wr);
                    Iterator itrt = maba.iterator();
                    while (itrt.hasNext()) {
                        Mahasiswa mb = (Mahasiswa)itrt.next();
                        brw.write("ID: " + mb.id + " Nama: " + mb.nama + " Nilai: " + mb.nilai + "\n");
                    }
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