package org.example;

import org.example.controller.RestAPIReceive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainMaba {
    public static void main(String[] args) {
        SpringApplication.run(MainMaba.class, args);

        RestAPIReceive APIRecv = new RestAPIReceive();
        try {
            APIRecv.receiveFromDB();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
