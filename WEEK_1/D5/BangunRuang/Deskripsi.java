/**
 * === PENJELASAN PEMBUATAN PROGRAM ===
 * 
 * 1. Sebelum memulai pengerjaan, saya membaca Basmalah agar dilancarkan dalam membuat programnya.
 * 
 * 2. Buat file BangunRuang.java
 * 
 * 3. import class yang dibutuhkan ( java.io dan java.util )
 * 
 * 4. Deklarasikan trows di class main untuk memastikan program tetap berjalan walau ada hambatan
 * 
 * 5. Menginisialisasikan InputStreamReader dan BufferedReader untuk bisa mengambil parameter dari commandline
 * 
 * 6. Inisialisasi varibel:
 *      - string key --> sebagai parameter di while (menentukan program berjalan/berhenti)
 *      - string s, p, l, t, j --> sebagai parameter untuk menghitung volume, yang nantinya akan dirubah tipenya
 *        sebelum ke method hitung volume sesuai dengan parameter yang butuhkan (integer/double)
 *      - int vkub dan vlok, serta double vbol --> variabel untuk menyimpan hasil hitung volume
 *    Inisialisasi variabel di atas, dilakukan di class main
 * 
 * 7. Membuat method volumeBangun sebanyak tiga buah (untuk menghitung volume kubus, balok, dan bola):
 *      - Pembuatan method volmueBangun untuk masing-masing bangun ruang dibedakan berdasarkan tipe data dan parameter 
 *        (dan rumus):
 *          + Volume Kubus === integer dengan parameter sebanyak satu buah
 *          + Volume Balok === integer dengan parameter sebanyak tiga buah
 *          + Volume Bola  === double dengan parameter sebanyak satu buah
 *      - Masing-masing method menjalankan fungsi perhitungan sesuai dengan rumus bangun ruang.
 * 
 * 8. Sebelum membuat method average dan summary, dites apakah ketiga method di atas berjalan dengan semestinya:
 *      - Membuat while dengan parameter jika, key != "exit" (alias, key == "mulai"), maka program dijalankan
 *      - Jika key == "exit", program berhenti
 *      - Saat program berjalan, user diminta untuk memasukkan:
 *          + Sisi dari kubus (1 buah), yang nantinya dihitung menggunakan method volumeBangun untuk kubus
 *            dan dimasukkan ke variabel vkub. Yang selanjutnya hasilnya ditampilkan menggunakan sysout.
 *          + Panjang, lebar, dan tinggi balok (3 buah), yang nantinya dihitung menggunakan method volumeBangun untuk balok
 *            dan dimasukkan ke variabel vlok. Yang selanjutnya hasilnya ditampilkan menggunakan sysout.
 *          + Jari-jari bola (1 buah) yang nantinya dihitung menggunakan method volumeBangun untuk bola
 *            dan dimasukkan ke variabel vbol. Yang selanjutnya hasilnya ditampilkan menggunakan sysout.
 *      - vkub, vlok, dan vbol nantinya akan digunakan sebagai parameter method average dan summary.
 *      - Setelah semua fungsi berjalan, kembali fokus dalam pembuatan method average dan summary.
 * 
 * 9. Membuat method average:
 *      - Pada intinya, method ini melakukan perhitungan rata-rata dari ketiga volume bangun ruang.
 *      - Method ini bertipe double, karena akan ada pembagian.
 *      - Method ini pula memiliki tiga parameter, yaitu vkub, vlok, dan vbol.
 * 
 * 10. Membuat method summary:
 *      - Sama halnya dengan method average, yang membedakannya adalah
 *        method ini menjumlahkan ketiga volume yang telah dihitung sebelumnya.
 * 
 * 11. Pemanggilan method average dan summary otomatis dilakukan setelah poin 8 dilakukan dan di print menggunakan sysout.
 * 
 * 12. Selesai.
 */
