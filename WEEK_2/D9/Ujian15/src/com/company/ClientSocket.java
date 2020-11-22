package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class ClientSocket {
    public static Properties props = new Properties();
    public static InputStream input = null;
    public static Socket s;
    public static DataInputStream dis;
    public static DataOutputStream dout;
    public static String strSrever;
    public static FileReader fr = null;
    public static BufferedReader br = null;
    public static String data = "";
    public static int i;

    public static void main(String[] args) {
        try {
            input = new FileInputStream("config.properties");
            props.load(input);

            String localServer = props.getProperty("localServer");
            int localPort = Integer.parseInt(props.getProperty("localPort"));

            s = new Socket(localServer, localPort);
            dis = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            fr = new FileReader("mahasiswa2_irene.json");
            br = new BufferedReader(fr);

            while ((i = br.read()) != -1) {
                data += (char)i;
            }

            dout.writeUTF(data);
            dout.flush();
            s.close();

        } catch (Exception e) {
            System.out.println("ERROR CLIENT SOCKET! -- " + e);
        }
    }
}
