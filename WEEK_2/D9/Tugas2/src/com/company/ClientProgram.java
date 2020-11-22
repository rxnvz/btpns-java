package com.company;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientProgram {
    public static Socket s;
    public static DataInputStream dis;
    public static DataOutputStream dout;
    public static String key ="";
    public static String strClient;
    public static String strSrever;
    public static InputStreamReader r = null;
    public static BufferedReader br = null;

    public static void main(String[] args) {
        try {
            r = new InputStreamReader(System.in); //inisialisasi buat ngebaca di console
            br = new BufferedReader(r); //sama, cuma biar lebi aman

            while (!key.equals("99")) { //selama, kita nga input "99"
                System.out.print("""
                        Selamat Datang!
                        1. Konek ke Socket
                        2. Buat File FileProcess.txt
                        3. Tampil ke layar, dan Connet FTP - Kirim melalui FTP
                        4. Putus koneksi
                        99.Keluar
                        Silahkan masukkan menu yang diinginkan!:\s""");
                key = br.readLine();
                switch (key) {
                    case "1":
                        s = new Socket ("localhost", 666); //inisialisasi port sama host yang dipake
                        dis = new DataInputStream(s.getInputStream());
                        dout = new DataOutputStream(s.getOutputStream());
                        strSrever = (String)dis.readUTF(); //ini buat nyimpen string json yang dikirim dari server tadi
                        System.out.println("Koneksi tersambung!");
                        break;

                    case "2":
                        CreateFile cf = new CreateFile(strSrever);
                        cf.start();
                        break;

                    case "3":
                        ShowData sd = new ShowData(strSrever);
                        sd.start();
                        FileUpload fu = new FileUpload();
                        fu.start();
                        break;

                    case "4":
                        dout.writeUTF("5");
                        dout.flush();

                        dout.close();
                        s.close();
                        break;

                    default:
                        System.out.println("Terima kasih sudah menggunakan program ini!");
                        br.close();
                        r.close();
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
