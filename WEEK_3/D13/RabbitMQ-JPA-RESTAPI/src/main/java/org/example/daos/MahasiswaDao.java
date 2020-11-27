package org.example.daos;

import com.google.gson.Gson;
import org.example.entities.Mahasiswa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MahasiswaDao {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public MahasiswaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    public List<Mahasiswa> allMaba(){
        return entityManager.createQuery("SELECT m FROM Mahasiswa m", Mahasiswa.class).getResultList();
    }

    public void persist(String mabaString) {
        Mahasiswa mhs = new Gson().fromJson(mabaString, Mahasiswa.class);
        entityManager.persist(mhs);
    }

    public Mahasiswa find(int idMhs) {
        return entityManager.find(Mahasiswa.class, idMhs);
    }

    public void update(String mabaString) {
        Mahasiswa maba = new Gson().fromJson(mabaString, Mahasiswa.class);
        Mahasiswa mhs = entityManager.find(Mahasiswa.class, maba.getIdMhs());
        mhs.setFullname(maba.getFullname());
        mhs.setAddress(maba.getAddress());
        mhs.setStatus(maba.getStatus());
        entityManager.merge(mhs);
    }

    public void absen(String idMhs) {
        Mahasiswa mhs = entityManager.find(Mahasiswa.class, Integer.valueOf(idMhs));
        mhs.setAbsensi(mhs.getAbsensi()+1);
        entityManager.merge(mhs);
    }
}
