package org.example.daos;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.example.entities.Mahasiswa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class DBReceive{
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private MahasiswaDao mabaDao;

    DBSend send = new DBSend();

    public void con() {
        this.entityManager = Persistence
                .createEntityManagerFactory("user-unit")
                .createEntityManager();
        mabaDao = new MahasiswaDao(entityManager);
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

    public void showMahasiswa(){
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("showMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mabaString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mabaString + "'");
                con();
                try {
                    List<Mahasiswa> maba = mabaDao.allMaba();
                    send.sendToAPI(new Gson().toJson(maba));
                } catch ( Exception e ) {
                    System.out.println("Error send maba = " + e);
                }
                com();
            };
            channel.basicConsume("showMahasiswa", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error showMahasiswa = " + e);
        }
    }

    public void addMahasiswa() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("insertMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mabaString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mabaString + "'");
                con();
                mabaDao.persist(mabaString);
                com();
            };
            channel.basicConsume("insertMahasiswa", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error insertMaba = " + e);
        }
    }

    public void updateMahasiswa() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("updateMahasiswaById", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mabaString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mabaString + "'");
                con();
                mabaDao.update(mabaString);
                com();
            };
            channel.basicConsume("updateMahasiswaById", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            System.out.println("Error updateMaba = " + e);
        }
    }

    public void absensiMahasiswa() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("absensiMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String idString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idString + "'");
                con();
                mabaDao.absen(idString);
                com();
            };
            channel.basicConsume("absensiMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error absensiMaba = " + e);
        }
    }
}
