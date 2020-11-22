import java.io.*;
import java.util.*;

public class BangunRuang {
    public static void main(String[] args) throws Exception{
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String key = "";
        String s = "";
        String p = "";
        String l = "";
        String t = "";
        String j = "";
        int vkub = 0;
        int vlok = 0;
        double vbol = 0;

        while (!key.equalsIgnoreCase("exit")) {
            System.out.println("Selamat datang! \nSilahkan ketik 'mulai' atau 'exit':");
            key = br.readLine();
            switch (key) {
                case "mulai":
                    System.out.print("Masukkan sisi kubus: ");
                    s = br.readLine();
                    vkub = volumeBangun(Integer.parseInt(s));
                    System.out.println("Volume kubus: " + vkub);

                    System.out.print("Masukkan panjang balok: ");
                    p = br.readLine();
                    System.out.print("Masukkan lebar balok: ");
                    l = br.readLine();
                    System.out.print("Masukkan tinggi balok: ");
                    t = br.readLine();
                    vlok = volumeBangun(Integer.parseInt(p), Integer.parseInt(l), Integer.parseInt(t));
                    System.out.println("Volume balok: " + vlok);

                    System.out.print("Masukkan jari-jari bola: ");
                    j = br.readLine();
                    vbol = volumeBangun(Double.parseDouble(j));
                    System.out.println("Volume bola: " + vbol);

                    System.out.println("Rata-rata volume keseluruhan: " + average(vkub, vlok, vbol));
                    System.out.println("Jumlah volume keseluruhan: " + summary(vkub, vlok, vbol));

                    break;
            
                default:
                    System.out.println("Terima kasih sudah menggunakan program ini!");
                    br.close();
                    r.close();
            }
        }
    }

    // volume kubus
    public static int volumeBangun(int sisi) {
        int volume = sisi * sisi * sisi;
        return volume;
    }

    // volume balok
    public static int volumeBangun(int panjang, int lebar, int tinggi) {
        int volume = panjang * lebar * tinggi;
        return volume;
    }

    // volume bola
    public static double volumeBangun(double jari) {
        double volume = (4 * 3.14 * jari * jari)/3;
        return volume;
    }

    // rata-rata volume
    public static double average(double kubus, double balok, double bola) {
        double average = (kubus + balok + bola)/3;
        return average;
    }

    // summary volume
    public static double summary(double kubus, double balok, double bola) {
        double average = kubus + balok + bola;
        return average;
    }
}
