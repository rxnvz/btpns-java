package org.example.db.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class DBSend {
    public void sendToAPI (String nb) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("fromDatabase", false, false, false, null);
            //String message = "Assalamualaikum";
            channel.basicPublish("", "fromDatabase", null, nb.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + nb + "'");
        } catch (Exception e) {
            System.out.println("Gagal mengirim pesan ke RestApi.." + e);
        }
    }
}
