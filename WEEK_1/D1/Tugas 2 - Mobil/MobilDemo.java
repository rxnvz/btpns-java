public class MobilDemo {
    public static void main(String[] args) {
        Mobil mobilBaru = new Mobil();
        Mobil mobilBaru2 = new Mobil();

        mobilBaru.Merk("Ford");
        mobilBaru.Warna("Kuning");
        mobilBaru.Gigi(5);
        mobilBaru.Kecepatan(120);
        mobilBaru.PrintState();

        mobilBaru.TambahGigi(10);
        mobilBaru.KurangGigi(2);
        mobilBaru.Mengerem(20);

        // mobilBaru2.Merk("Toyota");
        // mobilBaru2.Warna("Biru");
        // mobilBaru2.Gigi(10);
        // mobilBaru2.Kecepatan(150);
        // mobilBaru2.PrintState();

        // mobilBaru2.TambahGigi(10);
        // mobilBaru2.KurangGigi(2);
        // mobilBaru2.Mengerem(50);
    }
}
