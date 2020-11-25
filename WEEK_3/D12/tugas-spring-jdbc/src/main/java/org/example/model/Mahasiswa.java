package org.example.model;

public class Mahasiswa {
    public int idMhs;
    public String fullname;
    public String address;
    public String status;
    public int absensi;

    public Mahasiswa(){
    }

    public Mahasiswa(int idMhs, String fullname, String address, String status, int absensi) {
        this.idMhs = idMhs;
        this.fullname = fullname;
        this.address = address;
        this.status = status;
        this.absensi = absensi;
    }

    // -------------------- SETTER & GETTER ID --------------------
    public int getIdMhs() {
        return idMhs;
    }
    public void setIdMhs(int idMhs) {
        this.idMhs = idMhs;
    }

    // -------------------- SETTER & GETTER NAME --------------------
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    // -------------------- SETTER & GETTER ADDRESS --------------------
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    // -------------------- SETTER & GETTER STATUS --------------------
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // -------------------- SETTER & GETTER ABSENSI --------------------
    public int getAbsensi() {
        return absensi;
    }
    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }
}
