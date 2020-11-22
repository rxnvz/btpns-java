import java.util.*;
import java.io.*;

public class ShowData extends Thread {

    ArrayList<Mahasiswa> mhs;

    public ShowData(ArrayList<Mahasiswa> x) {
        mhs = x;
    }

    public void run() {
        String leftAlignFormat = "%-4s  %-15s  %-10.01f %-10.01f %-10.01f %n";
        System.out.format("ID    Nama             Inggris    Fisika     Algoritma \n");
        System.out.format("-------------------------------------------------------\n");
        Collections.sort(mhs, Mahasiswa.urutin);
        Iterator itr = mhs.iterator();
        while (itr.hasNext()) {
            Mahasiswa c = (Mahasiswa)itr.next();
            System.out.format(leftAlignFormat, c.getID(), c.getNama(), c.getEn(), c.getFis(), c.getAl());
        }
    }
}
