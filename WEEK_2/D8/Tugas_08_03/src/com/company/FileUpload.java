package com.company;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileUpload extends Thread{
    String server;
    int port;
    String user;
    String pass;

    FTPClient ftpClient = new FTPClient();

    public FileUpload (String a, int b, String c, String d) {
        server = a;
        port = b;
        user = c;
        pass = d;
    }

    public void run() {
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File firstLocalFile = new File("C:/Users/btpnshifted/Documents/BTPNS/PRACTICE JAVA/WEEK_2/D8/Tugas_08_03/FileProses.txt");

            String firstRemoteFile = "FileProsesIrene.txt";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("File berhasil di upload!");
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
    }
}
