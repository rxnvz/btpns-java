public class Mobil {
    int tahun = 0;
    String merk = "";
    int kecepatan = 0;

    public Mobil (String merk, int tahun, int kecepatan) {
        this.tahun = tahun;
        this.merk = merk;
        this.kecepatan = kecepatan;
    }

    int getTahun() {
        return this.tahun;
    }
    String getMerk() {
        return this.merk;
    }
    int getSpeed() {
        return this.kecepatan;
    }

    public void Tambah_Kecepatan(int kecepatan, int inc) {
        this.kecepatan = kecepatan + inc;
        System.out.println("Mobil " + getMerk() + " menambah kecepatan sebesar " + inc + " menjadi " + this.kecepatan + "km/jam.");
    }

    public void Kurangi_Kecepatan(int kecepatan, int dec) {
        this.kecepatan = kecepatan - dec;
        System.out.println("Mobil " + getMerk() + " mengurangi kecepatan sebesar " + dec + " menjadi " + this.kecepatan + "km/jam.");
    }

    public void printData() {
        System.out.println("Merk: " + getMerk() + "   Tahun: " + getTahun() + "   Kecepatan: " + getSpeed());
    }
}
