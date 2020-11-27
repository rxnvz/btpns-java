package org.example.restapi.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class APIReceive {
    String nasabah;

    public void receiveFromDB() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("fromDatabase", false, false, false, null);
        System.out.println(" [*] Waiting for messages from database");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            this.nasabah = message;
        };
        channel.basicConsume("fromDatabase", true, deliverCallback, consumerTag -> { });
    }

    public String getMaba() {
        return this.nasabah;
    }
}
