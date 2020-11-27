package org.example;

import org.example.daos.DBReceive;
import org.example.daos.MahasiswaDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ReceiverMaba {

    public static DBReceive receive = new DBReceive();

    public static void main(String[] args) {
        try{
            System.out.println(" [*] Waiting for messages..");
            receive.showMahasiswa();
            receive.addMahasiswa();
            receive.updateMahasiswa();
            receive.absensiMahasiswa();
        }catch (Exception e){
            System.out.println("Error DatabaseMain = " + e);
        }
    }
}
