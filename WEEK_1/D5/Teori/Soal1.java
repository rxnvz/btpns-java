/**
 * === TEORI OBJECT DAN CLASS PADA JAVA ===
 * 
 * a. Class  : Suatu kesatuan state dan method dalam satu file yang akan menggambarkan object
 * b. Object : "Benda" yang dibuat dari class tersebut.
 * c. Contoh sederhana Class dan object:
 */

//Contoh class:
class InnerSoal1 {
    int nomor;
    String isi;

    public InnerSoal1 (int nomor, String isi){
        this.nomor = nomor;
        this.isi = isi;
    }
    public int getNomor() {
        return this.nomor;
    }

    public String getIsi() {
        return this.isi;
    }
}

public class Soal1 {
    public static void main(String[] args) {

        //Contoh object:
        InnerSoal1 s1 = new InnerSoal1(1, "Apahayo");

        //Print object:
        System.out.println("Nomor: " + s1.getNomor() + "\nIsi: " + s1.getIsi());
    }
}