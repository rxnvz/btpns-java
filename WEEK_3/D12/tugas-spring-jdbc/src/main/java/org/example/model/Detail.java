package org.example.model;

public class Detail {
    public int idDetail;
    public int idMhs;
    public int physics;
    public int calculus;
    public int biology;

    public Detail(){
    }

    public Detail (int idDetail, int idMhs, int physics, int calculus, int biology) {
        this.idDetail = idDetail;
        this.idMhs = idMhs;
        this.physics = physics;
        this.calculus = calculus;
        this.biology = biology;
    }

    // -------------------- SETTER & GETTER ID DETAIL --------------------
    public int getIdDetail() {
        return idDetail;
    }
    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    // -------------------- SETTER & GETTER ID MAHASISWA --------------------
    public int getIdMhs() {
        return idMhs;
    }
    public void setIdMhs(int idMhs) {
        this.idMhs = idMhs;
    }

    // -------------------- SETTER & GETTER PHYSICS --------------------
    public int getPhysics() {
        return physics;
    }
    public void setPhysics(int physics) {
        this.physics = physics;
    }

    // -------------------- SETTER & GETTER CALCULUS --------------------
    public int getCalculus() {
        return calculus;
    }
    public void setCalculus(int calculus) {
        this.calculus = calculus;
    }

    // -------------------- SETTER & GETTER BIOLOGY --------------------
    public int getBiology() {
        return biology;
    }
    public void setBiology(int biology) {
        this.biology = biology;
    }
}
