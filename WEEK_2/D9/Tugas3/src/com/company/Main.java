package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

public class Main {
    public static InputStreamReader r = new InputStreamReader(System.in);
    public static BufferedReader br = new BufferedReader(r);

    public static String uname = "";
    public static String passw = "";

    public static String key = "";

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

    public static void main(String[] args) {
        try {
            // Untuk koneksi ke database
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tugas-3?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","admin1");

            //Ini untuk ngambil username sama password dari tabel user buat login
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from user");
            rs.next();

            System.out.print("Masukkan username: ");
            uname = br.readLine();
            System.out.print("Masukkan password: ");
            passw = br.readLine();

            if (Pattern.matches("\\w*@gmail.com", uname) && Pattern.matches("\\w{8,20}+", passw)) {
                if (uname.equals(rs.getString(2)) && passw.equals(rs.getString(3))) { //Ini cek, apa username sama passwornya sesuai sama yang di db apa ngga
                    while (!key.equals("99")) {
                        System.out.print("""
                                        Selamat datang!
                                        Ketik '1' untuk input data
                                        Ketik '2' untuk edit data
                                        Ketik '3' delete data
                                        Ketik '99' untuk keluar
                                        Silahkan pilih menu:\s""");
                        key = br.readLine();

                        switch (key) {
                            case "1":
                                addData();
                                break;

                            case "2":
                                updateData();
                                break;

                            case "3":
                                deleteData();
                                break;

                            default:
                                System.out.println("Terima kasih sudah menggunakan program ini!");
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
            System.out.println("ERROR! -- " + e);
        }
    }

    public static void showData() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from siswa");

            String format = "| %-2d | %-15s | %-15s | %-10s | %-10s | %-2d      | %-2d       | %-2d      |%n";
            System.out.printf("+----+-----------------+-----------------+------------+------------+---------+----------+---------+%n");
            System.out.printf("| ID |  Username       |  Fullname       |   Adress   |   Status   | Physics | Calculus | Biologi |%n");
            System.out.printf("+----+-----------------+-----------------+------------+------------+---------+----------+---------+%n");
            while (rs.next()) {
                System.out.printf(format,
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
            System.out.printf("+----+-----------------+-----------------+------------+------------+---------+----------+---------+%n");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }

    }

    public static void addData() {
        try {
            System.out.println("Selamat Datang di menu tambah data!");
            System.out.print("Masukkan username baru: ");
            username = br.readLine();
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
            stmt.executeUpdate("INSERT INTO siswa VALUES (null, " +
                                    "'"+username+"', " +
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

            System.out.print("Masukkan username baru: ");
            username = br.readLine();
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
            stmt.executeUpdate("UPDATE siswa SET " +
                    "username = '"+username+"', " +
                    "fullname = '"+fullname+"', " +
                    "address = '"+address+"', " +
                    "status = '"+status+"', " +
                    "physics = '"+fis+"', " +
                    "calculus = '"+kal+"'," +
                    "biology = '"+bio+"'" +
                    "WHERE id = '"+id+"'");
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
            System.out.print("Masukkan ID siswa yang ingin dihapus: ");
            id = Integer.parseInt(br.readLine());

            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM siswa WHERE id = '"+id+"' ");
            System.out.println("Data berhasil dihapus! \n\n");
            showData();
            System.out.println("");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }

    }
}
