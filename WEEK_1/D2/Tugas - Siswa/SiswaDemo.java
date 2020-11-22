public class SiswaDemo {
    public static void main(String[] args) {
        
        Siswa rne = new Siswa("Irene N", 99, "Wanita"); //ini buat siswa baru
        rne.printData(); //ini buat nge-print nama sama gender-nya
        rne.setLahir(13, 3, 1997); //ini nge-set tanggal-bulan-tahun lahir
        rne.ageCount(rne.getTahun()); //ini buat nyari umur sekarang (2020) dari tahun yang di setLahir
        rne.setNilaiHuruf(rne.getNilai()); //ini buat dapetin nilai huruf dari nilai yang diinput tadi
        rne.classAge(rne.getAge()); //ini buat dapetin, pas umur berapa, lagi apa 
        rne.historyAge(rne.getTahun()); //ini buat ngedapetin, ditahun sekian, umurnya sekian (sampai 2020)

    }
}
