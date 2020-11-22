package com.company;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileUpload extends Thread{

    FTPClient ftpClient = new FTPClient();

    public void run() {
        try {
            ftpClient.connect("ftp.myth.co.id", 21); //inisialisasi host sama port
            ftpClient.login("ftpuser@myth.co.id", "password"); //inisialisasi username sama password
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            //ini ngedefine Path file yang mau di upload
            File firstLocalFile = new File("C:/Users/btpnshifted/Documents/BTPNS/PRACTICE JAVA/WEEK_2/D9/Tugas2/FileProses.txt");

            String firstRemoteFile = "FileProsesJSONIrene.txt"; //ini define nama sama extension file yang bakal diterima di sana
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading file");
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
