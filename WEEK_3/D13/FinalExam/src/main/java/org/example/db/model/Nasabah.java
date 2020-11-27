package org.example.db.model;

import javax.persistence.*;

@Entity
@Table(name = "nasabah")
public class Nasabah {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int idNasabah;
    public String fullname;
    public String ktp;
    public String email;
    public String password;
    public String address;
    public String noHP;
    public String ibuKandung;
    public String pendidikan;
    public String pekerjaan;
    public int penghasilan;
    public int uang;
    public boolean status = false;

    public Nasabah() {
    }

    public Nasabah(String email, String password) {

    }

    public Nasabah(String fullname, String ktp, String email, String password, String address, String noHP, String ibuKandung, String pendidikan, String pekerjaan, int penghasilan, int uang) {
        this.setFullname(fullname);
        this.setKtp(ktp);
        this.setEmail(email);
        this.setPassword(password);
        this.setAddress(address);
        this.setNoHP(noHP);
        this.setIbuKandung(ibuKandung);
        this.setPendidikan(pendidikan);
        this.setPekerjaan(pekerjaan);
        this.setPenghasilan(penghasilan);
        this.setUang(uang);
    }

    // -------------------- SETTER & GETTER ID --------------------
    public int getIdNasabah() {
        return idNasabah;
    }
    public void setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
    }

    // -------------------- SETTER & GETTER NAME --------------------
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // -------------------- SETTER & GETTER KTP --------------------
    public String getKtp() {
        return ktp;
    }
    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    // -------------------- SETTER & GETTER EMAIL --------------------
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // -------------------- SETTER & GETTER PASSWORD --------------------
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // -------------------- SETTER & GETTER ADDRESS --------------------
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // -------------------- SETTER & GETTER PHONE NUMBER --------------------
    public String getNoHP() {
        return noHP;
    }
    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    // -------------------- SETTER & GETTER IBU KANDUNG --------------------
    public String getIbuKandung() {
        return ibuKandung;
    }
    public void setIbuKandung(String ibuKandung) {
        this.ibuKandung = ibuKandung;
    }

    // -------------------- SETTER & GETTER PENDIDIKAN --------------------
    public String getPendidikan() {
        return pendidikan;
    }
    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    // -------------------- SETTER & GETTER PEKERJAAN --------------------
    public String getPekerjaan() {
        return pekerjaan;
    }
    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    // -------------------- SETTER & GETTER PENGHASILAN --------------------
    public int getPenghasilan() {
        return penghasilan;
    }
    public void setPenghasilan(int penghasilan) {
        this.penghasilan = penghasilan;
    }

    // -------------------- SETTER & GETTER UANG --------------------
    public int getUang() {
        return uang;
    }
    public void setUang(int uang) {
        this.uang = uang;
    }

    // -------------------- SETTER & GETTER STATUS LOGIN --------------------
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
