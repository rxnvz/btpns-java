package org.example.controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RestAPISend {

    public void allMaba() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        String mabaString = "";
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("showMahasiswa", false, false, false, null);
            //String message = "Assalamualaikum";
            channel.basicPublish("", "showMahasiswa", null, mabaString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mabaString + "'");
        }
    }

    public void insertMhs(String mahasiswaString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("insertMahasiswa", false, false, false, null);
            //String message = "Assalamualaikum";
            channel.basicPublish("", "insertMahasiswa", null, mahasiswaString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mahasiswaString + "'");
        }
    }

    public void updateMhsById(String mahasiswaString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("updateMahasiswaById", false, false, false, null);
            //String message = "Assalamualaikum";
            channel.basicPublish("", "updateMahasiswaById", null, mahasiswaString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mahasiswaString + "'");
        }
    }

    public void absensiMhs(String mahasiswaString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("absensiMahasiswa", false, false, false, null);
            //String message = "Assalamualaikum";
            channel.basicPublish("", "absensiMahasiswa", null, mahasiswaString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mahasiswaString + "'");
        }
    }
}
