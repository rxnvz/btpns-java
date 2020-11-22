/**
 * === PENJELASAN PEMBUATAN PROGRAM ===
 * 
 * 1. Sebelum memulai pengerjaan, saya membaca Basmalah agar dilancarkan dalam membuat programnya.
 * 
 * 2. Pertama, buat file Mobil.java dan MobilDemo.java
 * 
 * 3. Pada Mobil.java:
 *     a. Inisialisasi variabel tahun (int), merk mobil (str), dan kecepatan mobil (int) sesuai dengan soal yang diberikan.
 *         * Pemilihan penggunaan tipe data integer untuk tahun, tidak ada alasan khusus
 *           -- karena tahun hanya terdiri dari angka.
 *         * Pemilihan penggunaan tipe data string untuk merk mobil dikarenakan merk mobil biasanya menggunakan huruf.
 *         * Pemilihan penggunaan tipe data integer untuk kecepatan mobil karena 
 *           kecepatan akan diolah untuk menentukan kecepatan sebelum dan sesudah ditambah/dikurangi.
 *     b. Setelahnya, dibuat method constructor untuk mengisi variabel yang sebelumnya telah dibuat dengan data yang dimasukkan
 *     c. Kemudian, buat method get sesuai dengan tipe data dari masing-masing variabel
 *         * int untuk getTahun()
 *         * String untuk getMerk()
 *         * int untuk getSpeed() ---> kecepatan.
 *        Pembuatan method get ini dimasudkan untuk mengembalikan nilai ke variabel asal dengan menggunakan fungsi return
 *     d. Lalu, kita buat method Tambah_Kecepatan(), Kurangi_Kecepatan(), PrintData()
 *         * Method Tambah_Kecepatan:
 *            - Pada intinya, method ini menambahkan kecepatan awal dengan paramater yang diinput
 *            - Method ini dilengkapi dengan dua buah parameter bertipe data integer:
 *                + parameter pertama didapat dari getSpeed(),
 *                + paramater kedua merupakan tambahan kecepatan.
 *            - Hasil dari penjumlahan kedua paramater tersebut dimasukkan kembali ke this.kecepatan
 *            - Penyimpanan hasil ke this.kecepatan dikarenakan jika dimasukkan ke variabel baru/method getSpeed(), 
 *              saat perhitungan method Kurangi_Kecepatan, kecepatan yang dikurangi adalah kecepatan awal, bukan kecepatan
 *              setelah ditambahkan.
 *            - Print hasil perhitungan menggunakan System.out.println
 *         * Method Kurangi_Kecepatan:
 *            - Sama halnya dengan method Tambah_Kecepatan, hanya saja method ini digunakan untuk mengurangi kecepatan
 *              setelah kecepatan awal ditambah menggunakan method Tambah_Kecepatan.
 *         * Method PrintData:
 *            - Method ini hanya melakukan hasil print data dengan mengambil nilai dari method get.
 * 
 * 4. Pada MobilDemo.java:
 *     a. Inisialisasi dua buah objek mobil (merk, tahun, kecepatan).
 *     b. Lakukan printData pada dua objek untuk menampilkan merk, tahun, dan kecepatan awal.
 *     c. Memanggil method Tambah_Kecepatan dengan parameter getSpeed dan integer penambah.
 *     d. Memanggil method Tambah_Kecepatan dengan parameter getSpeed dan integer pengurang.
 *     e. (Tidak harus) panggil System.out.println untuk print enter
 * 
 * 5. Selesai.
 */