package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class SocketServer {
    public static String config;
    public static String file;
    public static ServerSocket ss;
    public static Socket s;
    public static String strClient;
    public static Properties prop = new Properties();
    public static InputStream input = null;
    public static DataInputStream dis = null;
    public static DataOutputStream dout = null;
    public static FileReader fr = null;
    public static BufferedReader br = null;
    public static String data = "";
    public static int i;


    public static void main(String[] args) {
        config = args[0];
        file = args[1];

        try {
            input = new FileInputStream(config);
            prop.load(input);
            int localPort = Integer.parseInt(prop.getProperty("localPort"));

            ss = new ServerSocket(localPort);
            s = ss.accept();

            dis = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            while ((i = br.read()) != -1) {
                data += (char)i;
            }

            dout.writeUTF(data);
            dout.flush();

            strClient = dis.readUTF();
            if (strClient.equals("5")) {
                ss.close();
            }
        } catch (Exception e) {
            System.out.print("ERROR! -- " + e);
        }
    }
}
