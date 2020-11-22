public class Siswa {
    String nama = ""; //inisialisasi nama siswanya
    int nilai = 0; //inisialisasi nilai siswanya
    String gender = ""; //inisialisasi gender siswanya
    int tglLahir = 0; //inisialisasi tanggal lahirnya
    int bulanLahir = 0; //inisialisasi bulan lahirnya
    int tahunLahir = 0; //inisialisasi tahun lahirnya
    char grade; //deklarasi grade untuk dipakai di-method setNilaiHuruf
    int umur; //deklarasi umur untuk dipakai di-method ageCount dan getAge
    String month; //deklarasi bulan (str) untuk dipakai di-method setLahir

    public Siswa(String nama, int nilai, String gender) {
        this.nama = nama;
        this.nilai = nilai;
        this.gender = gender;
    }
    String getName() {
        return this.nama;
    }
    int getNilai() {
        return this.nilai;
    }
    String getGender(){
        return this.gender;
    }


    //Method untuk mendapatkan tanggal lahir dimana bulannya string
    public void setLahir(int hari, int bulan, int tahun) {
        if (bulan > 12 && bulan < 1) {
            System.out.println("Bulan yang kamu masukkan salah");
        } else {
            this.tglLahir = hari; //ini masukkin hari ke tglLahir yang instance var 
            this.bulanLahir = bulan; //ini masukkin bulan ke bulanLahir yang instance var
            this.tahunLahir = tahun; //ini masukkin tahun ke tahunLahir yang instance var
            switch (bulanLahir) {
                case 1:  month = "Januari";
                        break;
                case 2:  month = "Februari";
                        break;
                case 3:  month = "Maret";
                        break;
                case 4:  month = "April";
                        break;
                case 5:  month = "Mei";
                        break;
                case 6:  month = "Juni";
                        break;
                case 7:  month = "Juli";
                        break;
                case 8:  month = "Agustus";
                        break;
                case 9:  month = "September";
                        break;
                case 10: month = "Oktober";
                        break;
                case 11: month = "November";
                        break;
                case 12: month = "Desember";
                        break;
            }
            System.out.println(getName() + " lahir pada " + tglLahir + " " + month + " " + tahunLahir );
        }
    }
    int getHari () { //ini buat nge-get tanggal lahir
        return this.tglLahir;
    }
    int getBulan () { //ini buat nge-get bulan lahir
        return this.bulanLahir;
    }
    int getTahun () { //ini buat nge-get tahun lahir
        return this.tahunLahir;
    }

    //Method untuk mendapatkan umur saat ini (thn 2020)
    public void ageCount(int tahunLahir) {
        umur = 2020 - tahunLahir;
        System.out.println("Saat ini " + getName() + " berumur " + umur + " tahun.");
    }
    int getAge() { //buat nge-get umur
        return umur;
    }
    
    //Method untuk mendapatkan nilai yang berupa huruf
    public void setNilaiHuruf(int nilainya) { //ini dapetin nilainya dari getNilai(), terus di convert
        if (nilainya >= 90) {
            grade = 'A';
        } else if (nilainya >= 80) {
            grade = 'B';
        } else if (nilainya >= 70) {
            grade = 'C';
        } else if (nilainya >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade " + getName() + " adalah: " + grade);
    }
    
    //Method untuk mendapatkan usia saat ini, sedang ngapain
    public void classAge(int umurnya) {
        if (umurnya < 15) {
            System.out.println(getName() + " masih kecil");
        } else  if (umurnya == 15) {
            System.out.println("Saat ini " + getName() + " sedang menduduki kelas 1 SMA.");
        } else if (umurnya == 16) {
            System.out.println("Saat ini " + getName() + " sedang menduduki kelas 2 SMA.");
        } else if (umurnya == 17) {
            System.out.println("Saat ini " + getName() + " sedang menduduki kelas 3 SMA.");
        } else if (umurnya == 18) {
            System.out.println("Saat ini " + getName() + " sedang Kuliah semester 1.");
        } else if (umurnya == 19) {
            System.out.println("Saat ini " + getName() + " sedang Kuliah semester 2.");
        } else if (umurnya == 20) {
            System.out.println("Saat ini " + getName() + " sedang Kuliah semester 3.");
        } else if (umurnya == 21) {
            System.out.println("Saat ini " + getName() + " sedang Kuliah semester 4.");
        } else if (umurnya == 22) {
            System.out.println("Saat ini " + getName() + " sedang Kuliah semester 5.");
        } else {
            System.out.println("Saat ini " + getName() + " sedang bekerja dan/atau menikmati hidup.");
        }
    }
    
    //Method untuk mendapatkan histori usia hingga tahun 2020
    public void historyAge(int tahunnya) {
        int count = tahunnya; //masukkin nilai tahun dari method getTahun() ke count biar bisa loop
        int usia = 0; //inisialisasi usia biar bisa dihitung di loop
        for (int i = count; i <= 2020; i++) {
            System.out.println("Usia " + getName() + " pada tahun " + count + " adalah: " + usia + " tahun.");
            count++; //tahunnya bertambah sampai 2020 (soalnya di for-nya diset sampai 2020 aja)
            usia++; //umurnya bertambah sampai tahun 2020 (soalnya di for-nya diset sampai 2020 aja)
        }
    }

    //Method untuk nge-print nama dan gender siswa
    public void printData() {
        System.out.println(getName() + " adalah "+ getGender() + " yang memiliki nilai " + getNilai() + "/100");
    }

}
