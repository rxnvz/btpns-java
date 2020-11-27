package org.example.db.service;

import com.google.gson.Gson;
import org.example.db.model.Nasabah;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class NasabahDao {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public NasabahDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public void regisNB(String nbString) {
        Nasabah nb = new Gson().fromJson(nbString, Nasabah.class);
        entityManager.persist(nb);
    }

    public void doLogin(String tryToLogin) {
        Nasabah who = new Gson().fromJson(tryToLogin, Nasabah.class);

        String mail = who.getEmail();
        String pass = who.getPassword();
        int id = who.getIdNasabah();

        Nasabah a = entityManager.find(Nasabah.class, id);
        String dataMail = a.getEmail();
        String dataPass = a.getPassword();

        if (dataMail.equals(mail) && dataPass.equals(pass)) {
            a.setStatus(true);
        }
    }

    public List<Nasabah> showData(String idNasabah) {
        return entityManager.createQuery("SELECT n FROM Nasabah n WHERE idNasabah = '"+idNasabah+"'", Nasabah.class).getResultList();
    }

    // Mas Hary, maaf cuma bisa segini. Mentok banget astagfirullah ;_;
    // Emang sednag tidak hoki saya hari ini huhuhuhu :<

    // Juga, makasih banyak (banget-banget-banget) mas atas ilmu-ilmunya!<3
    // Sehat selalu, mas Hary!
}
