public class Mobil {
    String merk = "";
    String warna = "";
    int gigi = 0;
    int kecepatan = 0;

    public void Merk(String newMerk) {
        merk = newMerk;
    }

    public void Warna(String newWarna) {
        warna = newWarna;
    }

    public void Gigi(int newGigi) {
        gigi = newGigi;
    }

    public void Kecepatan(int newKecepatan) {
        kecepatan = newKecepatan;
    }

    public void TambahGigi(int increment) {
        gigi = gigi + increment;

        System.out.println("Mobil dengan merk " + merk +
        " berwarna " + warna + " menambahkan gigi menjadi " + gigi);
    }

    public void KurangGigi(int decrement) {
        gigi = gigi - decrement;

        System.out.println("Mobil dengan merk " + merk +
        " berwarna " + warna + " mengurangi gigi menjadi " + gigi);
    }

    public void Mengerem(int decrement) {
        kecepatan = kecepatan - decrement;

        System.out.println("Mobil dengan merk " + merk +
        " berwarna " + warna + " mengurangi kecepatan menjadi " + kecepatan);
    }

    public void PrintState() {
        System.out.println("Mobil dengan merk " + merk +
                            " berwarna " + warna + " memiliki kecepatan " +
                            kecepatan + " dan gigi " + gigi);
    }
}
