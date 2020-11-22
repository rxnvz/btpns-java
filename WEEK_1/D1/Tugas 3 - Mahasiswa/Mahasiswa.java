public class Mahasiswa {
    String nama = "";
    String jk = "";
    int umur = 0;

    public void setNama(String newName) {
        nama = newName;
    }
    String getNama() {
        return nama;
    }
    public void setJK(String newGender) {
        jk = newGender;
    }
    String getGender() {
        return jk;
    }
    public void setAge(int newAge) {
        umur = newAge;
    }
    int getAge() {
        return umur;
    }

    public void printMHS() {
        System.out.println("Nama: " + getNama() +
                            "\nJenis Kelamin: " + getGender() + 
                            "\nUmur: " + getAge() +"tahun");
    }
}
