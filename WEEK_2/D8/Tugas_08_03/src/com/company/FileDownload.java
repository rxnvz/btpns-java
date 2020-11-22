package com.company;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileDownload extends Thread{
    String server;
    int port;
    String user;
    String pass;
    String path;
    String file;
    FTPClient ftpClient = new FTPClient();

    public FileDownload(String a, int b, String c, String d, String e, String f) {
        server = a;
        port = b;
        user = c;
        pass = d;
        path = e;
        file = f;
    }

    public void run() {
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            String remoteFile1 = "/" + path + "/" + file;
            File downloadFile1 = new File("C:/Users/btpnshifted/Documents/BTPNS/PRACTICE JAVA/WEEK_2/D8/Tugas_08_03/" + file);
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File berhasil di download! Silahkan cek di path yang telah ditentukan");
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
