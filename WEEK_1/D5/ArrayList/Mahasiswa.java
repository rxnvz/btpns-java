import java.util.*;

public class Mahasiswa {
    String id = "";
    String nama = "";
    double UTS = 0;
    double UAS = 0;
    double TGS = 0;

    public Mahasiswa (String id, String nama, String UTS, String UAS, String TGS) {
        this.id = id;
        this.nama = nama; 
        this.UTS = Double.parseDouble(UTS);
        this.UAS = Double.parseDouble(UAS);
        this.TGS = Double.parseDouble(TGS);
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setUTS(String UTS) {
        this.UTS = Double.parseDouble(UTS);
    }
    public void setUAS(String UAS) {
        this.UAS = Double.parseDouble(UAS);
    }
    public void setTGS(String TGS) {
        this.TGS = Double.parseDouble(TGS);
    }

    String getID() {
        return this.id;
    }
    String getNama() {
        return this.nama;
    }
    Double getUTS() {
        return this.UTS;
    }
    Double getUAS() {
        return this.UAS;
    }
    Double getTGS() {
        return this.TGS;
    }

    public double NilaiAkhir() {
        double nilai = (0.35 * getUTS()) + (0.45 * getUAS()) + (0.2 * getTGS());
        return nilai;
    }
}
