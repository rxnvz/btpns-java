package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static ServerSocket ss;
    public static Socket s;
    public static String strClient;
    public static DataInputStream dis = null;
    public static DataOutputStream dout = null;
    public static FileReader fr = null;
    public static BufferedReader br = null;
    public static String data = "";
    public static int i;

    public static void main(String[] args) {
        try {
            ss = new ServerSocket(666); // menginisialisasi port yang bakal dipake sama server
            s = ss.accept();

            dis = new DataInputStream(s.getInputStream()); // ini buat ngebaca dari client
            dout = new DataOutputStream(s.getOutputStream()); // ini buat nulis/ngirim ke server

            fr = new FileReader("file.txt"); //ini buat baca file
            br = new BufferedReader(fr); //sama, cuma biar lebih aman aja

            while ((i = br.read()) != -1) { //selama, karakternya != -1
                data += (char)i; //karakternya bakal terus disimpen ke variable data
            }

            JSONArray arr = new JSONArray(); // ini buat define new array json
            JSONObject dataObj = new JSONObject(); // kalo ini buat define new object json

            String[] isi = data.split("\\n"); //data yang tadi di split enter terus disimpen ke isi[]
            for (String str: isi) {
                String[] dataIsi = str.split(","); //data isi tadi di split lagi berdasarkan (,)
                JSONObject temp = new JSONObject(); // ini define objek baru sementara buat nyimpen data yang didapet
                for (int j = 0; j < dataIsi.length; j++) {
                    temp.put("Nama", dataIsi[0]);
                    temp.put("Fisika", dataIsi[1]);
                    temp.put("Kimia", dataIsi[2]);
                    temp.put("Biologi", dataIsi[3]);
                }
                arr.add(temp); //data sementara tadi disimpen ke array
                dataObj.put("Siswa", arr); //abis itu, arraynya disimpen ke dataobjek
            }

            //data objek yang tadi di convert ke str soalnya writeUTF cuma bisa kirim string
            String datanya = dataObj.toString();

            dout.writeUTF(datanya);
            dout.flush();

            strClient = dis.readUTF(); //ini buat baca client manggil menu apaan aja
            if (strClient.equals("4")) {
                ss.close();
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
