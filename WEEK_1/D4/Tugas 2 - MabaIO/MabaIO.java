import java.io.*;

public class MabaIO {
    public static void main(String[] args) {
        try {
            Mahasiswa rne = new Mahasiswa("3145150242", "Irene Nurintan", "80");
            Mahasiswa ry = new Mahasiswa("3134145151", "Arya Rizki Andaru", "80");
            Mahasiswa ryo = new Mahasiswa("3144135115", "Aryo Rizki Andaru", "80");

            FileOutputStream fout=new FileOutputStream("testmaba.txt");
            FileInputStream fin=new FileInputStream("testmaba.txt");
            BufferedOutputStream bout=new BufferedOutputStream(fout);

            String rner = "ID: " + rne.getID() + " Nama: " + rne.getNama() + " Nilai: " + rne.getNilai() + "\n";
            String ryr = "ID: " + ry.getID() + " Nama: " + ry.getNama() + " Nilai: " + ry.getNilai() + "\n";
            String ryor = "ID: " + ryo.getID() + " Nama: " + ryo.getNama() + " Nilai: " + ryo.getNilai() + "\n";
    
            byte b[]=rner.getBytes();
            byte c[]=ryr.getBytes();
            byte a[]=ryor.getBytes();
            bout.write(b);
            bout.write(c);
            bout.write(a);
            bout.flush();    
            bout.close();    
            fout.close();    
            System.out.println("success");  
    
            int i=0;    
            while((i=fin.read())!=-1){    
                System.out.print((char)i);    
            }    
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
