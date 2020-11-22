import java.util.*;

public class Maba {
    public static void main(String[] args) {
        //Tugas 03_02_01
        // Mahasiswa[] maba = {
        //     new Mahasiswa("3145150242", "Irene Nurintan", "Wanita"),
        //     new Mahasiswa("3134145151", "Arya Rizki Andaru", "Pria"),
        //     new Mahasiswa("3144135115", "Aryo Rizki Andaru", "Pria")
        // };

        // for (int i = 0; i < maba.length; i++) {
        //     maba[i].printData();
        // }

        //Tugas 03_02_02
        Mahasiswa rne = new Mahasiswa("3145150242", "Irene Nurintan", "Wanita");
        Mahasiswa ry = new Mahasiswa("3134145151", "Arya Rizki Andaru", "Pria");
        Mahasiswa ryo = new Mahasiswa("3144135115", "Aryo Rizki Andaru", "Pria");

        ArrayList<Mahasiswa> maba = new ArrayList<Mahasiswa>();
        maba.add(rne);
        maba.add(ry);
        maba.add(ryo);

        Iterator itr = maba.iterator();
        while (itr.hasNext()) {
            Mahasiswa mb = (Mahasiswa)itr.next();
            System.out.println("Mahasiswa dengan ID " + mb.id + " bernama " + mb.nama + " dan berjenis kelamin " + mb.gender);
        }
    }
}
