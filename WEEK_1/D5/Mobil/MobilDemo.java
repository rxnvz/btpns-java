public class MobilDemo {
    public static void main(String[] args) {
        Mobil mb1 = new Mobil("Ford", 2020, 35);
        Mobil mb2 = new Mobil("Toyota", 2019, 45);

        mb1.printData();
        mb1.Tambah_Kecepatan(mb1.getSpeed(), 50);
        mb1.Kurangi_Kecepatan(mb1.getSpeed(), 10);
        System.out.println(" ");
        mb2.printData();
        mb2.Tambah_Kecepatan(mb2.getSpeed(), 35);
        mb2.Kurangi_Kecepatan(mb2.getSpeed(), 5);
    }
}
