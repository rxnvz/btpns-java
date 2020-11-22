import java.util.*;
import java.io.*;

public class MainWorker {
    public static void main(String[] args) throws Exception {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
    
        ArrayList<Staff> stf = new ArrayList<Staff>();
        ArrayList<Manager> mnj = new ArrayList<Manager>();

        String key = "";
        String tipe;
        String absen;

        String nama;
        String id;
        int tunjanganPulsa;
        int gajiPokok;
        
        while (!key.equalsIgnoreCase("exit")) {
            System.out.println("Selamat datang!" +
                               "\nKetik 'add' untuk tambah staff" +
                               "\nKetik 'abs' untuk absensi" +
                               "\nKetik 'tjg' untuk menghitung tunjangan" + 
                               "\nKetik 'gatot' untuk menampilkan data keseluruhan gaji" +
                               "\nKetik 'print' untuk menampilkan data keseluruhan karyawan" +
                               "\nKetik 'exit' untuk keluar" +
                               "\nSilahkan pilih menu:");
            key = br.readLine();

            switch (key) {
                case "add": //buat nambah data karyawan
                    System.out.print("\nSelamat datang di menu tambah karyawan!" +
                                       "\nKetik 'mnj' untuk Manajer" +
                                       "\nKetik 'stf' untuk Staff" + 
                                       "\nJenis karyawan yang ingin ditambahkan: ");
                    tipe = br.readLine();
                    switch (tipe) {
                        case "mnj":
                            System.out.print("Masukkan ID manajer: ");    
                            id = br.readLine();
                            System.out.print("Masukkan nama manajer: ");
                            nama = br.readLine();
                            System.out.print("Masukkan gaji pokok: ");
                            gajiPokok = Integer.parseInt(br.readLine());
                            System.out.print("Masukkan tunjangan pulsa: ");
                            tunjanganPulsa = Integer.parseInt(br.readLine());
            
                            mnj.add(new Manager(id, nama, gajiPokok, tunjanganPulsa));
                            System.out.println("Data berhasil dimasukkan!\n\n");
                            break;
            
                        case "stf":
                            System.out.print("Masukkan ID staff: ");    
                            id = br.readLine();
                            System.out.print("Masukkan nama staff: ");
                            nama = br.readLine();
                            System.out.print("Masukkan gaji pokok: ");
                            gajiPokok = Integer.parseInt(br.readLine());
                            System.out.print("Masukkan tunjangan pulsa: ");
                            tunjanganPulsa = Integer.parseInt(br.readLine());
            
                            stf.add(new Staff(id, nama, gajiPokok, tunjanganPulsa));
                            System.out.println("Data berhasil dimasukkan!\n\n");
                            break;
                    }
                    break;

                case "abs": //untuk nambah absensi
                    System.out.print("\nSelamat datang di menu tambah absensi karyawan!" +
                                       "\nKetik 'mnj' untuk Manajer" +
                                       "\nKetik 'stf' untuk Staff" + 
                                       "\nJenis karyawan yang ingin ditambahkan absensinya: ");
                    tipe = br.readLine();
                    switch (tipe) {
                        case "mnj":
                            System.out.print("Masukkan ID manajer yang ingin ditambah absensinya: ");
                            id = br.readLine();
                            absenManager(mnj, id);
                            break;

                        case "stf":
                            System.out.print("Masukkan ID staff yang ingin ditambah absensinya: ");
                            id = br.readLine();
                            absenStaff(stf, id);
                            break;
                    }
                    break;

                case "tjg": //untuk hitung tunjangan
                    System.out.print("\nSelamat datang di menu hitung tunjangan!" +
                                    "\nKetik 'mnj' untuk Manajer" +
                                    "\nKetik 'stf' untuk Staff" + 
                                    "\nJenis karyawan yang ingin dihitung tunjangannya: ");
                    tipe = br.readLine();
                    switch (tipe) {
                        case "mnj":
                            System.out.print("\nSelamat datang di menu hitung tunjangan manajer!" +
                                            "\nKetik 'trans' untuk tunjangan transport" +
                                            "\nKetik 'ent' untuk tunjangan entertainment" + 
                                            "\nJenis tunjangan yang ingin dihitung: ");
                            tipe = br.readLine();
                            switch (tipe) {
                                case "trans":
                                    System.out.print("Masukkan ID manajer yang ingin dihitung tunjangan transportnya: ");
                                    id = br.readLine();
                                    tunjanganTrans(mnj, id);
                                    break;
                            
                                case "ent":
                                    System.out.print("Masukkan ID manajer yang ingin dihitung tunjangan entertainment-nya: ");
                                    id = br.readLine();
                                    tunjanganEnt(mnj, id);
                                    break;
                            }
                            break;
                        
                        case "stf":
                            System.out.print("Masukkan ID staf yang ingin dihitung tunjangannya: ");
                            id = br.readLine();
                            tunjanganStaff(stf, id);
                            break;
                    }
                    break;

                case "gatot": //hitung keseluruhan gaji
                    System.out.print("\nSelamat datang di menu hitung gaji total!" +
                                    "\nKetik 'mnj' untuk Manajer" +
                                    "\nKetik 'stf' untuk Staff" + 
                                    "\nJenis karyawan yang ingin dihitung gaji totalnya: ");
                    tipe = br.readLine();
                    switch (tipe) {
                        case "mnj":
                            gajiTotalManager(mnj);
                            break;
                    
                        case "stf":
                            gajiTotalStaff(stf);
                            break;
                    }
                    break;

                case "print": //print di commandline + txt
                    printData(mnj, stf);
                    printDataTxt(mnj, stf);
                    break;

                default:
                    System.out.println("Terima kasih sudah menggunakan program ini!");
                    br.close();
                    r.close();
            }
        }   
    }

    // public static void addStaff(ArrayList<Staff> y) {
    //     try {
            
    //     } catch (Exception e) {
    //         System.out.println("ERROR!: " + e);
    //     }
    // }
    
    // Absensi manager
    public static void absenManager(ArrayList<Manager> x, String id) {
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getID().equalsIgnoreCase(id)) {
                x.get(i).tambahAbsensi();
                System.out.println("Absensi berhasil ditambah!\n\n");
            }
        }
    }
    // Absensi staff
    public static void absenStaff(ArrayList<Staff> y, String id) {
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).getID().equalsIgnoreCase(id)) {
                y.get(i).tambahAbsensi();
                System.out.println("Absensi berhasil ditambah!\n\n");
            }
        }
    }

    // Tunjangan transportasi manager
    public static void tunjanganTrans(ArrayList<Manager> x, String id) {
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getID().equalsIgnoreCase(id)) {
                x.get(i).tjgTrans(x.get(i).getAbsensi());
                System.out.println("Tunjangan Transportasi berhasil ditambahkan!\n\n");
            }
        }
    }
    // Tunjangan entertaintment manager
    public static void tunjanganEnt(ArrayList<Manager> x, String id) {
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            int tjg = 0;

            for (int i = 0; i < x.size(); i++) {
                if (x.get(i).getID().equalsIgnoreCase(id)) {
                    System.out.print("Masukkan jumlah hari tunjangan: ");
                    tjg = Integer.parseInt(br.readLine());
                    x.get(i).tjgEnt(tjg);
                    System.out.println("Absensi berhasil ditambah!\n\n");
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
    // Tunjangan makan staff
    public static void tunjanganStaff(ArrayList<Staff> y, String id) {
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).getID().equalsIgnoreCase(id)) {
                y.get(i).tjgMakan(y.get(i).getAbsensi());
                System.out.println("Tunjangan Makan berhasil ditambah!\n\n");
            }
        }
    }

    // Gaji Total Manager
    public static void gajiTotalManager(ArrayList<Manager> x) {
        for (int i = 0; i < x.size(); i++) {
            x.get(i).gajiTotalnya(x.get(i).getGaji(), x.get(i).getTrans(), x.get(i).getEnt(), x.get(i).getPulsa());
        }
        System.out.println("Gaji pokok sudah dihitung! Silahkan cek dimenu 'print'!\n\n");
    }
    // Gaji Total Staff 
    public static void gajiTotalStaff(ArrayList<Staff> y) {
        for (int i = 0; i < y.size(); i++) {
            y.get(i).gajiTotalnya(y.get(i).getGaji(), y.get(i).getMakan(), y.get(i).getPulsa());
        }
        System.out.println("Gaji pokok sudah dihitung! Silahkan cek dimenu 'print'!\n\n");
    }

    // Print data to console
    public static void printData(ArrayList<Manager> x, ArrayList<Staff> y) {
        String leftAlignFormat = "%-4s  %-15s  %-15s  %-4d %n";
        System.out.format("ID    Nama             Jabatan          Gaji Total %n");
        System.out.format("---------------------------------------------------\n");
        Collections.sort(x, Manager.urut);
        Iterator itr = x.iterator();
        while (itr.hasNext()) {
            Manager c = (Manager)itr.next();
            System.out.format(leftAlignFormat, c.IDKaryawan, c.nama, c.jabatan, c.getGatot());
        }
        Collections.sort(y, Staff.urut);
        Iterator itrs = y.iterator();
        while (itrs.hasNext()) {
            Staff d = (Staff)itrs.next();
            System.out.format(leftAlignFormat, d.IDKaryawan, d.nama, d.jabatan, d.getGatot());
        }
    }
    // Print data to txt file
    public static void printDataTxt(ArrayList<Manager> x, ArrayList<Staff> y) {
        try {
            FileWriter wr = new FileWriter("DataPekerja.txt");
            BufferedWriter brw = new BufferedWriter(wr);
    
            brw.write("ID    Nama             Jabatan          Total Gaji \n");
            brw.write("---------------------------------------------------\n");
            Iterator itrt = x.iterator();
            while (itrt.hasNext()) {
                Manager mn = (Manager)itrt.next();
                brw.write(mn.IDKaryawan + "    " + mn.nama + "              " + mn.jabatan + "          " + mn.getGatot() + "\n");
            }
            Iterator itr = y.iterator();
            while (itr.hasNext()) {
                Staff st = (Staff)itr.next();
                brw.write(st.IDKaryawan + "    " + st.nama + "              " + st.jabatan + "            " + st.getGatot() + "\n");
            }
            brw.close();
        } catch (Exception e) {
            System.out.println("ERROR!: " + e);
        }
    }
}
