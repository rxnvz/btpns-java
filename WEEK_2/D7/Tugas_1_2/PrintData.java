import java.util.*;
import java.io.*;

public class PrintData extends Thread {
    
    ArrayList<Mahasiswa> mhs;

    public PrintData (ArrayList<Mahasiswa> x) {
        mhs = x;
    }

    public void run() {
        try {
            FileWriter wr = new FileWriter("DataMahasiswa.txt");
            BufferedWriter brw = new BufferedWriter(wr);
    
            brw.write("ID    Nama             Inggris    Fisika     Algoritma \n");
            brw.write("-------------------------------------------------------\n");
            Collections.sort(mhs, Mahasiswa.urutin);
            Iterator itrt = mhs.iterator();
            while (itrt.hasNext()) {
                Mahasiswa mh = (Mahasiswa)itrt.next();
                brw.write(mh.getID() + "    " + mh.getNama() + "              " + mh.getEn() + "       " + mh.getFis() + "       " + mh.getAl() + "\n");
            }
            brw.close();
        } catch (Exception e) {
            System.out.println("ERROR!: " + e);
        }
    }
}
