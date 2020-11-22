package com.company;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.regex.Pattern;

public class ServerProgram {
    public static Properties props = new Properties();
    public static InputStream input = null;
    public static ServerSocket ss;
    public static Socket s;
    public static DataInputStream dis;
    public static String strClient;

    public static InputStreamReader r = null;
    public static BufferedReader br = null;

    public static String uname = "";
    public static String passw = "";

    public static String key = "";
    public static String q = "";
    public static String dirr = "";
    public static String file = "";
    public static String data = "";


    public static FileWriter fw;
    public static BufferedWriter bw;

    public static FileReader fr;
    public static BufferedReader fbr;

    public static int i;
    public static int id;
    public static String username;
    public static String fullname;
    public static String address;
    public static String status;
    public static int fis;
    public static int kal;
    public static int bio;

    public static Connection con;
    public static Statement stmt;

    public static FTPClient ftpClient = new FTPClient();

    public static void main(String[] args) {
        try {
            input = new FileInputStream("config.properties");
            props.load(input);
            int localPort = Integer.parseInt(props.getProperty("localPort"));

            String FTPServer = props.getProperty("server");
            String FTPUname = props.getProperty("username");
            String FTPPassw = props.getProperty("password");
            int FTPPort = Integer.parseInt(props.getProperty("port"));

            r = new InputStreamReader(System.in);
            br = new BufferedReader(r);

            System.out.print("Masukkan username: ");
            uname = br.readLine();
            System.out.print("Masukkan password: ");
            passw = br.readLine();

            if (Pattern.matches("\\w*@gmail.com", uname) && Pattern.matches("\\w{8,20}+", passw)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ujian-15?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","admin1");

                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * from user");
                rs.next();
                if (uname.equals(rs.getString(2)) && passw.equals(rs.getString(3))) { //Ini cek, apa username sama passwornya sesuai sama yang di db apa ngga
                    con.close();

                    while (!key.equals("7")) {
                        System.out.print("""
                                        Selamat datang!
                                        1. Start Socket Server and Client DB
                                        2. FTP and DB Connection Started
                                        3. Get Data from FTP Server
                                        4. Send Data to DB
                                        5. Input, Edit and Delete Data from DB
                                        6. Send Report to FTP Server
                                        7. Exit - Close all Connection
                                        Pilih menu:\s""");
                        key = br.readLine();

                        switch (key) {
                            case "1":
                                ss = new ServerSocket(localPort);
                                s = ss.accept();

                                dis = new DataInputStream(s.getInputStream());
                                strClient = (String)dis.readUTF();

                                DBInput input = new DBInput(strClient);
                                input.run();
                                break;

                            case "2":
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                con= DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/ujian-15?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","admin1");
                                System.out.println("Berhasil koneksi ke database!");

                                ftpClient.connect(FTPServer, FTPPort);
                                ftpClient.login(FTPUname, FTPPassw);
                                ftpClient.enterLocalPassiveMode();
                                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                                System.out.println("Berhasil koneksi ke FTP!\n\n");
                                break;

                            case "3":
                                FTPFile[] dir = ftpClient.listDirectories("/");
                                printDir(dir);
                                System.out.print("Masukkan direktori: ");
                                dirr = br.readLine();
                                FTPFile[] dird = ftpClient.mlistDir("/"+dirr);
                                printFiles(dird);
                                System.out.print("Masukkan nama dan extension file yang ingin diunduh: ");
                                file = br.readLine();

                                FileDownload fd = new FileDownload(FTPServer, FTPPort, FTPUname, FTPPassw, dirr, file);
                                fd.start();

                                break;

                            case "4":
                                System.out.print("Masukkan nama dan extension file yang ingin di-input ke database: ");
                                file = br.readLine();

                                inputFTP(file);
                                break;

                            case "5":
                                System.out.print("""

                                        Selamat datang di menu manipulasi database!
                                        Ketik 'input' untuk memasukkan data
                                        Ketik 'edit' untuk mengedit by id
                                        Ketik 'delete' untung menghapus by id
                                        Menu yang dipilih:\s""");
                                q = br.readLine();

                                switch (q) {
                                    case "input":
                                        addData();
                                        break;

                                    case "edit":
                                        updateData();
                                        break;

                                    case "delete":
                                        deleteData();
                                        break;
                                }
                                break;

                            case "6":
                                exportSend();
                                break;

                            default:
                                System.out.println("Terima kasih sudah menggunakan program ini!");
                                ss.close(); 
                                br.close();
                                r.close();
                                con.close();
                        }
                    }
                } else {
                    System.out.println("Email dan password tidak sesuai!");
                }
            } else {
                System.out.println("Gunakan format email dan password yang benar!");
            }
        } catch (Exception e) {
            System.out.println("ERROR MAIN SERVER! -- " + e);
        }
    }

    private static void printDir(FTPFile[] files) {
        for (FTPFile file : files) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "\\" + details;
            }
            System.out.println(details);
        }
    }
    private static void printFiles(FTPFile[] files) {
        for (FTPFile file : files) {
            String details = file.getName();
            details += "\t\t" + file.getSize();

            System.out.println(details);
        }
    }

    public static void inputFTP(String a) {
        try {
            fr = new FileReader(a);
            fbr = new BufferedReader(fr);

            while ((i = fbr.read()) != -1) {
                 data += (char)i;
            }

            JSONObject js = (JSONObject) JSONValue.parse(data);

            JSONObject charles = (JSONObject) js.get("charles");
            JSONObject cg = (JSONObject) charles.get("grades");

            JSONObject steve = (JSONObject) js.get("steve");
            JSONObject sg = (JSONObject) steve.get("grades");

            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO mahasiswa VALUES (null, " +
                    "'"+charles.get("fullname")+"', " +
                    "'"+charles.get("address")+"', " +
                    "'"+charles.get("status")+"', " +
                    "'"+cg.get("physics")+"', " +
                    "'"+cg.get("calculus")+"'," +
                    "'"+cg.get("biologi")+"')");

            stmt.executeUpdate("INSERT INTO mahasiswa VALUES (null, " +
                    "'"+steve.get("fullname")+"', " +
                    "'"+steve.get("address")+"', " +
                    "'"+steve.get("status")+"', " +
                    "'"+sg.get("physics")+"', " +
                    "'"+sg.get("calculus")+"'," +
                    "'"+sg.get("biologi")+"')");

            System.out.println("Data berhasil dimasukkan!");

        } catch (Exception e) {
            System.out.println("ERROR INPUT DATA FTP TO DB! -- " + e);
        }
    }

    public static void showData() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from mahasiswa");

            String format = "| %-2d | %-15s | %-10s | %-10s | %-2d      | %-2d       | %-2d      |%n";
            System.out.printf("+----+-----------------+------------+------------+---------+---------+----------+%n");
            System.out.printf("| ID |  Fullname       |   Adress   |   Status   | Physics | Calculus | Biologi |%n");
            System.out.printf("+----+-----------------+------------+------------+---------+---------+----------+%n");
            while (rs.next()) {
                System.out.printf(format,
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
            System.out.printf("+----+-----------------+------------+------------+---------+---------+----------+%n");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }

    }
    public static void addData() {
        try {
            System.out.println("Selamat Datang di menu tambah data!");
            System.out.print("Masukkan nama lengkap baru: ");
            fullname = br.readLine();
            System.out.print("Masukkan alamat baru: ");
            address = br.readLine();
            System.out.print("Masukkan status user baru: ");
            status = br.readLine();
            System.out.print("Masukkan nilai fisika user: ");
            fis = Integer.parseInt(br.readLine());
            System.out.print("Masukkan nilai kalkulus user: ");
            kal = Integer.parseInt(br.readLine());
            System.out.print("Masukkan nilai biologi: ");
            bio = Integer.parseInt(br.readLine());

            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO mahasiswa VALUES (null, " +
                    "'"+fullname+"', " +
                    "'"+address+"', " +
                    "'"+status+"', " +
                    "'"+fis+"', " +
                    "'"+kal+"'," +
                    "'"+bio+"')");
            System.out.println("Data berhasil ditambahkan! \n");
            showData();
            System.out.println("");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
    public static void updateData(){
        showData();
        try {
            System.out.println("Selamat Datang di menu edit data!");
            System.out.print("Masukkan ID siswa yang ingin edit: ");
            id = Integer.parseInt(br.readLine());

            System.out.print("Masukkan nama lengkap baru: ");
            fullname = br.readLine();
            System.out.print("Masukkan alamat baru: ");
            address = br.readLine();
            System.out.print("Masukkan status user baru: ");
            status = br.readLine();
            System.out.print("Masukkan nilai fisika user: ");
            fis = Integer.parseInt(br.readLine());
            System.out.print("Masukkan nilai kalkulus user: ");
            kal = Integer.parseInt(br.readLine());
            System.out.print("Masukkan nilai biologi: ");
            bio = Integer.parseInt(br.readLine());

            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE mahasiswa SET " +
                    "fullname = '"+fullname+"', " +
                    "address = '"+address+"', " +
                    "status = '"+status+"', " +
                    "gradePhysics = '"+fis+"', " +
                    "gradeCalculus = '"+kal+"'," +
                    "gradeBiology = '"+bio+"'" +
                    "WHERE idMhs = '"+id+"'");
            System.out.println("Data berhasil di edit! \n");
            showData();
            System.out.println("");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
    public static void deleteData() {
        showData();
        try {
            System.out.print("Masukkan ID mahasiswa yang ingin dihapus: ");
            id = Integer.parseInt(br.readLine());

            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM mahasiswa WHERE idMhs = '"+id+"' ");
            System.out.println("Data berhasil dihapus! \n\n");
            showData();
            System.out.println("");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }

    public static void exportSend() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from mahasiswa");

            fw = new FileWriter("result_irene.csv");
            bw = new BufferedWriter(fw);

            while (rs.next()) {
                bw.write(rs.getInt(1) + "," +
                        rs.getString(2) + "," +
                        rs.getString(3) + "," +
                        rs.getString(4) + "," +
                        rs.getInt(5) + "," +
                        rs.getInt(6) + "," +
                        rs.getInt(7) + "\n");
            }
            System.out.println("File berhasil di buat!\n");
            bw.close();
            fw.close();

            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File firstLocalFile = new File("C:/Users/btpnshifted/Documents/BTPNS/PRACTICE JAVA/WEEK_2/D9/Ujian15/result_irene.csv");

            String firstRemoteFile = "result_irene.csv";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("File berhasil di upload!\n\n");
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }

}
