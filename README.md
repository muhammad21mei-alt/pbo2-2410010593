PERTEMUAN 5

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
