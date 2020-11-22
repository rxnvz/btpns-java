public class Mahasiswa {
    String id = "";
    String nama = "";
    String gender = "";

    public Mahasiswa (String id, String nama, String gender) {
        this.id = id;
        this.nama = nama; 
        this.gender = gender;
    }
    String getID() {
        return this.id;
    }
    String getNama() {
        return this.nama;
    }
    String getGender() {
        return this.gender;
    }

    public void printData() {
        System.out.println(getNama() + " adalah "+ getGender() + " dengan ID " + getID());
    }
}
