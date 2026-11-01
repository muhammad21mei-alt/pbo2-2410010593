<h1 style="font-size: 50px;">PERTEMUAN 5</h1>

EKSPERIMEN PRAKTIKUM 3
1. Pesan "item berubah" akan tercetak 2 kali setiap pilihan diganti, karena itemStateChanged dipanggil dua kali, yaitu ketika pilihan lama mengalami DESELECTED dan pilihan baru mengalami SELECTED

2. Hasil terlambat satu karakter karena event keyPressed dijalankan ketika tombol keyboard ditekan, sebelum karakter baru dimasukkan ke dalam JTextField. Akibatnya, metode konversi() membaca teks sebelum karakter terbaru ditambahkan

3. Ketika huruf dimasukkan ke dalam kolom suhu, program akan menghasilkan pesan kesalahan NumberFormatException pada jendela Output karena teks yang dimasukkan tidak dapat dikonversi menjadi angka oleh Double.parseDouble()

EKSPERIMEN PRAKTIKUM 4
1. Pesan "kali" akan tercetak sebanyak dua kali setiap tombol kali diklik karena terdapat dua event handler yang terhubung ke tombol yang sama, yaitu event handler actionPerformed yang dibuat melalui GUI Builder dan lambda yang ditulis di konstruktor. Satu tombol sebaiknya hanya menggunakan satu cara untuk menangani event agar aksi tidak dijalankan dua kali

2. Pada tab Design, tambahkan JButton baru dengan teks "%" dan nama variabel modulusButton. Ubah jumlah kolom pada operatorPanel dari 4 menjadi 5 agar tombol modulus dapat ditampilkan.
   Pada tab Source, tambahkan penanganan event untuk tombol modulus, lalu tambahkan operator '%' pada method hitung(). Gunakan operator modulus (%) untuk menghitung sisa pembagian dua bilangan. Tambahkan kondisi operator '%' pada switch, misalnya case '%' -> a % b;.

3. Kursor langsung berada di isian pertama karena method hapus() memanggil angka1Field.requestFocusInWindow(). Method tersebut meminta agar fokus keyboard kembali ke kolom angka pertama setelah kedua kolom dikosongkan. Dengan demikian, pengguna dapat langsung memasukkan angka baru tanpa perlu mengeklik kolom tersebut terlebih dahulu.

<img width="500" height="362" alt="image" src="https://github.com/user-attachments/assets/2c24ae7a-4c8b-45de-bc70-3c74a9158c19" />





BAGIAN BUTTON DAFTAR PROPERTIES DAN EVENT


<img width="430" height="500" alt="image" src="https://github.com/user-attachments/assets/f8d9a6b2-53d4-4d2d-b0d4-3bcfd9abbc72" /> 


<img width="439" height="500" alt="image" src="https://github.com/user-attachments/assets/7ee456b8-9209-4b21-8a3d-def9ab7f8c0d" />



TANGKAPAN LAYAR DIALOG RINGKASAN


<img width="502" height="547" alt="image" src="https://github.com/user-attachments/assets/85eef29c-2f79-427f-95a2-bf6315d8c86a" />



TANGKAPAN LAYAR DIALOG KONFIRMASI KELUAR


<img width="501" height="544" alt="image" src="https://github.com/user-attachments/assets/7874baa3-1e58-47db-97c2-e0881b57f55c" />



Penggunaan AI menggunakan ChatGPT. AI digunakan untuk mencari tau code perhitungan modulus dan mencari tau permasalahan error yang terjadi





<h1 style="font-size: 50px;">PERTEMUAN 6</h1>

<h4 style="font-size: 50px;">A. Foto atau pindaian dari Teman</h4>


<img width="600" height="500" alt="Screenshot 2026-10-31 155210" src="https://github.com/user-attachments/assets/1a3152b5-656e-4a23-a692-526d50e1c82b" />




<h4 style="font-size: 50px;">B. Tabel singkat berisi temuan dari teman, perbaikan yang Anda lakukan, dan commit yang memuat perbaikan
tersebut</h4>


<img width="507" height="494" alt="Screenshot 2026-10-31 160839" src="https://github.com/user-attachments/assets/fbe9e12d-fd0c-456b-b080-46ae6928f209" />


<h4 style="font-size: 50px;">C. Tangkapan layar form dengan pesan kesalahan, tangkapan layar jendela Navigator yang memperlihatkan
label pesan, dan jawaban eksperimen Praktikum 4.</h4>

<img width="600" height="600" alt="image" src="https://github.com/user-attachments/assets/fcc0f602-86f3-4689-85fa-2bee35588c36" />
<img width="1153" height="1261" alt="image" src="https://github.com/user-attachments/assets/e9ff3123-c749-4e35-a0e5-fbab1bc334be" />

1. Ketika mengetik huruf pada isian NPM, karakter tersebut tidak akan masuk ke dalam kolom. Hal ini terjadi karena terdapat pemeriksaan !Character.isDigit(evt.getKeyChar()). Jika karakter yang dimasukkan bukan angka, maka perintah evt.consume() akan membatalkan input tersebut. Selain itu, NPM juga dibatasi maksimal 10 digit melalui variabel penuh.
2. Pesan kesalahan muncul ketika fokus berpindah dari isian email ke komponen berikutnya setelah tombol Tab ditekan. Hal ini terjadi karena event focusLost memanggil method periksaEmail() ketika isian email tidak kosong. Karena format siti@ belum valid, pesan kesalahan akan ditampilkan di bawah isian email.		
3.	Tidak ada pesan kesalahan karena event focusLost pada nama memiliki pemeriksaan !namaField.getText().isBlank(). Artinya, validasi hanya dilakukan apabila isian Nama sudah berisi teks. Isian kosong baru diperiksa ketika tombol Daftar diklik.
4.	Isian NPM akan mendapatkan fokus terlebih dahulu. Hal ini karena method daftar() memeriksa seluruh isian secara berurutan, dimulai dari NPM. Ketika ditemukan kesalahan, komponen pertama dalam daftar kesalahan akan menerima fokus melalui perintah salah.get(0).requestFocusInWindow().
5.	Isian Nama akan mendapatkan fokus karena label Nama menggunakan mnemonic huruf N dan terhubung dengan komponen namaField melalui properti labelFor. Properti displayedMnemonic pada label digunakan untuk menentukan huruf pintasan tersebut.
6.	Ya, data yang sudah dimasukkan tetap ada. Hal ini karena ketika pengguna memilih No pada dialog konfirmasi, program menjalankan perintah return sehingga proses pengosongan data dibatalkan. Data hanya akan dihapus apabila pengguna memilih Yes.	


<h4 style="font-size: 50px;">D. Deklarasi penggunaan AI: alat yang dipakai dan untuk keperluan apa, atau pernyataan tidak memakai AI</h4>

AI Yang digunakan adalah ChatGPT, keperluannya mencari tau apa itu mneomonic, Mencari tau kode Aturan baru tidak memperbolehkan Nomor digit digunakan pada Field nama, dan terakhir mencari tau maksud dari B. Tabel singkat berisi temuan dari teman, perbaikan yang Anda lakukan, dan commit yang memuat perbaikan
tersebut


<h1 style="font-size: 50px;">PERTEMUAN 7</h1>

<h4 style="font-size: 50px;">A. Jawaban Experimen</h4>
1. Tabel tidak langsung menampilkan kontak baru karena fireTableRowsInserted() berfungsi memberi tahu JTable bahwa ada baris baru. Tanpa pemberitahuan tersebut, tabel tidak otomatis diperbarui	

2. Budi Santoso	

3. Kontak yang ditambahkan tetap dapat disimpan dan ditampilkan pada tabel meskipun dialog masih terbuka	

4. Ctrl+E dan Ctrl+D tidak berfungsi karena fitur Ubah dan Hapus hanya dapat digunakan ketika terdapat baris kontak yang dipilih	

5. baris hapusItem.setAccelerator yang berubah menjadi Delete yang awalnya adalah Ctrl + D	

6. Terjadi error karena variabel model belum diinisialisasi saat initComponents() dijalankan. Akibatnya, tabel menerima nilai null sebagai model	


<h4 style="font-size: 50px;">B. Tautan link video demo mini proyek</h4>

Maaf pa ukuran Videonya 28mb sedangkan maksimal uploud disini 10mb, kalau saya compress takudnya buram dan tidak jelas nanti gambarnya, jadi saya masukkan google drive saja dan taruh linknya disini
https://drive.google.com/file/d/1hS58lQ_bPkZyvj1BqOnZIwQBoP8fh8yU/view?usp=sharing


<h4 style="font-size: 50px;">C. Deklarasi penggunaan AI: alat yang dipakai dan untuk keperluan apa, atau pernyataan tidak memakai AI</h4>

Saya menggunakan Chat GPT, Ai digunakan sebagai alat pencari error dan langkah-langkah yang sekiranya tidak dimengerti pada modul serta membantu dalam mengoding pada bagian Mini Proyek.
