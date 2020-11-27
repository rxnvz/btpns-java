package org.example.restapi.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.concurrent.TimeoutException;

public class APISend {

    public void insertNasabah(String nbString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("insertNasabah", false, false, false, null);
            channel.basicPublish("", "insertNasabah", null, nbString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + nbString + "'");
        }
    }

    public void doLogin(String nbString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("doLogin", false, false, false, null);
            channel.basicPublish("", "doLogin", null, nbString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + nbString + "'");
        }
    }

    public void showData(String nbString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("showDataNIK", false, false, false, null);
            channel.basicPublish("", "showDataNIK", null, nbString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + nbString  + "'");
        }
    }
}
