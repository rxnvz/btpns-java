package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class ClientProgram {
    public static String config;
    public static Properties props = new Properties();
    public static InputStream input = null;
    public static Socket s;
    public static DataInputStream dis;
    public static DataOutputStream dout;
    public static String key ="";
    public static String strClient;
    public static String strSrever;
    public static InputStreamReader r = null;
    public static BufferedReader br = null;
    public static String pathFile = "";
    public static String fileName = "";

    public static void main(String[] args) {
        config = args[0];

        try {
            input = new FileInputStream(config);
            props.load(input);
            String localServer = props.getProperty("localServer");
            int localPort = Integer.parseInt(props.getProperty("localPort"));

            String FTPServer = props.getProperty("server");
            String FTPUname = props.getProperty("username");
            String FTPPassw = props.getProperty("password");
            int FTPPort = Integer.parseInt(props.getProperty("port"));

            r = new InputStreamReader(System.in);
            br = new BufferedReader(r);

            while (!key.equals("99")) {
                System.out.print("Selamat Datang!" +
                                "\n1. Konek ke Socket" +
                                "\n2. Buat File FileProcess.txt" +
                                "\n3. Tampil ke layar, Tulis ke File, dan Connet FTP - Kirim melalui FTP" +
                                "\n4. Download data dari server" +
                                "\n5. Putus koneksi" +
                                "\n99.Keluar" +
                                "\nSilahkan masukkan menu yang diinginkan!: ");
                key = br.readLine();
                switch (key) {
                    case "1":
                        s = new Socket (localServer, localPort);
                        dis = new DataInputStream(s.getInputStream());
                        dout = new DataOutputStream(s.getOutputStream());
                        strSrever = (String)dis.readUTF();
                        System.out.println("Koneksi tersambung!");
                        break;

                    case "2":
                        CreateFileData cf = new CreateFileData(strSrever);
                        cf.start();
                        break;

                    case "3":
                        ShowData sd = new ShowData(strSrever);
                        sd.start();
                        WriteData wd = new WriteData(strSrever);
                        wd.start();
                        FileUpload fu = new FileUpload(FTPServer, FTPPort, FTPUname, FTPPassw);
                        fu.start();
                        break;

                    case "4":
                        System.out.println("Masukkan path file yang ingin di download: ");
                        pathFile = br.readLine();
                        System.out.println("Masukkan nama file yang ingin di download (beserta extension-nya): ");
                        fileName = br.readLine();

                        FileDownload fd = new FileDownload(FTPServer, FTPPort, FTPUname, FTPPassw, pathFile, fileName);
                        fd.start();
                        break;

                    case "5":
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
            System.out.print("ERROR! -- " + e);
        }
    }

    public static void saveData() {

    }
}
