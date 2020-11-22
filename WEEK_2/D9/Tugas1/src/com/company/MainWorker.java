package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.ArrayList;

public class MainWorker {
    public static InputStreamReader r = new InputStreamReader(System.in);
    public static BufferedReader br = new BufferedReader(r);

    public static FileWriter fw;
    public static BufferedWriter bw;

    public static FileReader fr;
    public static BufferedReader fbr;

    public static ArrayList<Staff> stf = new ArrayList<Staff>();
    public static ArrayList<Manager> mnj = new ArrayList<Manager>();

    public static String key = "";
    public static String tipe;
    public static int i;

    public static String nama;
    public static String id;
    public static String telpn;
    public static String mail;
    public static int trans;
    public static ArrayList<String> telp = new ArrayList<String> ();
    public static ArrayList<String> email  = new ArrayList<String> ();

    public static void main(String[] args) throws Exception{
        while (!key.equals("4")) {
            System.out.print("""
                    Selamat datang!
                    Ketik '1' untuk tambah staff
                    Ketik '2' untuk convert ke JSON
                    Ketik '3' untuk baca data JSON dari file .txt
                    Ketik '4' untuk keluar
                    Silahkan pilih menu:\s""");
            key = br.readLine();

            switch (key) {
                case "1":
                    System.out.print("""

                            Selamat datang di menu tambah karyawan!
                            Ketik 'mnj' untuk Manajer
                            Ketik 'stf' untuk Staff
                            Jenis karyawan yang ingin ditambahkan:\s""");

                    tipe = br.readLine();
                    switch (tipe) {
                        case "mnj":
                            addManager();
                            break;

                        case "stf":
                            addStaff();
                            break;
                    }
                    break;

                case "2":
                    System.out.print("""

                            Selamat datang di menu convert data to JSON!
                            Ketik 'mnj' untuk Manajer
                            Ketik 'stf' untuk Staff
                            Jenis karyawan yang ingin di-convert:\s""");

                    tipe = br.readLine();
                    switch (tipe) {
                        case "mnj":
                            JSONManager();
                            break;

                        case "stf":
                            JSONStaff();
                            break;
                    }
                    break;

                case "3":
                    System.out.print("""

                            Selamat datang di menu baca data dari txt!
                            Masukkan file yang ingin dibaca:\s""");
                    tipe = br.readLine();
                    switch (tipe) {
                        case "Manager.txt":
                            readManager(tipe);
                            break;

                        case "Staff.txt":
                            readStaff(tipe);
                            break;
                    }
                    break;

                default:
                    System.out.println("Terima kasih sudah menggunakan program ini!");
                    br.close();
                    r.close();
            }
        }
    }

    public static void addManager() {
        try {
            System.out.print("Masukkan ID manajer: ");
            id = br.readLine();
            System.out.print("Masukkan nama manajer: ");
            nama = br.readLine();
            System.out.print("Masukkan nomor telpon: ");
            telpn = br.readLine();
            telp.add(telpn);


            mnj.add(new Manager(id, nama, telp));
            System.out.println("Data berhasil dimasukkan!\n\n");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
    public static void addStaff() {
        try {
            System.out.print("Masukkan ID staf: ");
            id = br.readLine();
            System.out.print("Masukkan nama staf: ");
            nama = br.readLine();
            System.out.print("Masukkan email staf: ");
            mail = br.readLine();
            email.add(mail);

            stf.add(new Staff(id, nama, email));
            System.out.println("Data berhasil dimasukkan!\n\n");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }

    public static void JSONManager() {
        JSONArray jManager = new JSONArray();
        JSONObject objMNJ = new JSONObject();
        for (Manager x: mnj ) {
            JSONObject temp = new JSONObject();
            temp.put("ID", x.getID());
            temp.put("Nama", x.getNama());
            temp.put("Telpon", x.getTelp().get(0));
            temp.put("Jabatan", x.getJabatan());
            temp.put("Tunjangan Pulsa", x.getPulsa());
            temp.put("Tunjangan Transport", x.getTrans());
            temp.put("Tunjangan Entertainment", x.getEnt());
            temp.put("Gaji Pokok", x.getGaji());

            jManager.add(temp);
            objMNJ.put("Manager", jManager);
        }
//        System.out.println("Managernya: " + objMNJ);

        try {
            fw = new FileWriter("Manager.txt");
            bw = new BufferedWriter(fw);

            String mnjTXT = JSONValue.toJSONString(objMNJ);
            bw.write(mnjTXT);
            bw.close();
            fw.close();
            System.out.println("File berhasil dibuat! Cek Manager.txt\n\n");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
    public static void JSONStaff() {
        JSONArray jStaff = new JSONArray();
        JSONObject objStaff = new JSONObject();
        for (Staff x: stf ) {
            JSONObject temp = new JSONObject();
            temp.put("ID", x.getID());
            temp.put("Nama", x.getNama());
            temp.put("Email", x.getEmail().get(0));
            temp.put("Jabatan", x.getJabatan());
            temp.put("Tunjangan Pulsa", x.getPulsa());
            temp.put("Tunjangan Makan", x.getMakan());
            temp.put("Gaji Pokok", x.getGaji());

            jStaff.add(temp);
            objStaff.put("Staff", jStaff);
        }
//        System.out.println("Staffnya: " + objStaff);

        try {
            fw = new FileWriter("Staff.txt");
            bw = new BufferedWriter(fw);

            String stfTXT = JSONValue.toJSONString(objStaff);
            bw.write(stfTXT);
            bw.close();
            fw.close();
            System.out.println("File berhasil dibuat! Cek Staff.txt!\n\n");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }

    public static void readManager(String x) {
        String dataMana = "";

        try {
            fr = new FileReader(x);
            fbr = new BufferedReader(fr);

            while ((i = fbr.read()) != -1) {
                dataMana += (char)i;
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }

        JSONObject dataMN = (JSONObject) JSONValue.parse(dataMana);
        JSONArray mnArr = (JSONArray) dataMN.get("Manager");

        for (int j = 0; j < mnArr.size(); j++) {
            JSONObject y = (JSONObject) mnArr.get(j);

            System.out.println("ID: " + y.get("ID"));
            System.out.println("Nama: " + y.get("Nama"));
            System.out.println("Jabatan: " + y.get("Jabatan"));
            System.out.print("Telpon: " + y.get("Telpon"));
            System.out.println("Tunjangan Pulsa: " + y.get("Tunjangan Pulsa"));
            System.out.println("Tunjangan Hiburan: " + y.get("Tunjangan Entertainment"));
            System.out.println("Tunjangan Transport: " + y.get("Tunjangan Transport"));
            System.out.println("Gaji Pokok: " + y.get("Gaji Pokok") + "\n\n");

        }
    }
    public static void readStaff(String x) {
        String dataStaff = "";

        try {
            fr = new FileReader(x);
            fbr = new BufferedReader(fr);

            while ((i = fbr.read()) != -1) {
                dataStaff += (char)i;
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }

        JSONObject dataST = (JSONObject) JSONValue.parse(dataStaff);
        JSONArray stArr = (JSONArray) dataST.get("Staff");

        for (int j = 0; j < stArr.size(); j++) {
            JSONObject y = (JSONObject) stArr.get(j);

            System.out.println("ID: " + y.get("ID"));
            System.out.println("Nama: " + y.get("Nama"));
            System.out.println("Jabatan: " + y.get("Jabatan"));
            System.out.println("Email: " + y.get("Email"));
            System.out.println("Tunjangan Pulsa: " + y.get("Tunjangan Pulsa"));
            System.out.println("Tunjangan Makan: " + y.get("Tunjangan Makan"));
            System.out.println("Gaji Pokok: " + y.get("Gaji Pokok") + "\n\n");

        }
    }
}
