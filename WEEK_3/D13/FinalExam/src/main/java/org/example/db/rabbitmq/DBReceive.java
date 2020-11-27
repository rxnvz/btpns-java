package org.example.db.rabbitmq;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.example.db.model.Nasabah;
import org.example.db.service.NasabahDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class DBReceive {
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private NasabahDao naDao;

    DBSend send = new DBSend();

    public void con() {
        this.entityManager = Persistence
                .createEntityManagerFactory("user-unit")
                .createEntityManager();
        naDao = new NasabahDao(entityManager);
        try {
            entityManager.getTransaction().begin();
        } catch (IllegalStateException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void com() {
        try {
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void connectRabbitMQ() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    public void newNasabah() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("insertNasabah", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String nbString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + nbString + "'");
                con();
                naDao.regisNB(nbString);
                com();
            };
            channel.basicConsume("insertNasabah", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error Tambah Nasabah = " + e);
        }
    }

    public void loggedIn() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("doLogin", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String nbString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + nbString + "'");
                con();
                naDao.doLogin(nbString);
                com();
            };
            channel.basicConsume("doLogin", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error Login = " + e);
        }
    }

    public void dataNIK() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("showDataNIK", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String idString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idString + "'");
                con();
                try {
                    List<Nasabah> maba = naDao.showData(idString);
                    send.sendToAPI(new Gson().toJson(maba));
                } catch ( Exception e ) {
                    System.out.println("Error send maba = " + e);
                }
                com();
            };
            channel.basicConsume("showDataNIK", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error showMahasiswa = " + e);
        }
    }
}
