# TUGAS BESAR 1 IF 2123 ALJABAR LINIER DAN GEOMETRI
SISTEM PERSAMAAN LINIER, DETERMINAN, DAN APLIKASINYA
## Deskripsi (*Description*)
Projek ini berisi pengimplementasian Sistem Persamaan Linier, Determinan, dan Aplikasinya pada bahasa Java.
Projek ini dibuat dalam rangka penyelesaian Tugas Besar 1 IF 2123 Aljabar Linier dan Geometri
## Kontributor (*Contributor*)
Terdapat tiga orang kontributor dalam pengerjaan projek ini
|             NAMA             |    NIM   |
|------------------------------|----------|
|     Jordan Daniel Joshua     | 13519098 |
| Daffa Ananda Pratama Resyaly | 13519107 |
|    Naufal Yahya Kurnianto    | 13519141 |
## Cara pengoperasian (*How to use*)
1. Buka *command prompt* kemudian pindahkan direktori ke folder *bin*.
2. Jalani program menggunakan perintah `java Main`.
3. Pilih menu menggunakan angka dalam selang [1..6] sesuai dengan yang terdapat di list **MENU**.
  3.1. Untuk **MENU** *Sistem Persamaan Linier* terdapat empat buah *SubMenu*. Pilih *SubMenu* berdasarkan metode mencari solusi sistem persamaan linier yang ingin digunakan.
  3.2. Untuk **MENU** *Determinan* terdapat dua buah *SubMenu*. Pilih *SubMenu* berdasarkan metode menghitung determinan yang ingin digunakan.
  3.3. Untuk **MENU** *Matriks Balikan* terdapat dua buah *SubMenu*. Pilih *SubMenu* berdasarkan metode menghitung matriks balikan yang ingin digunakan.
4. Pilih cara program membaca input. Pilih angka 1 untuk membaca input langsung dari *keyboard*, pilih angka 2 untuk membaca input dari *file*.
5. Untuk setiap persoalan, masukkan dapat dilihat sesuai ketentuan berikut.
  5.1. Untuk **MENU** *Sistem Persamaan Linier* setelah memasukkan cara program membaca input, masukkan jumlah persamaan, masukkan jumlah variabel, kemudian masukkan koefisien persamaan (*ax1 + bx2 + ... = cy*).
  5.2. Untuk **MENU** *Determinan* dan *Matriks Balikan* setelah memasukkan cara program membaca input, masukkan *N*, kemudian masukkan elemen-elemen matriks.
  5.3. Untuk **MENU** *Interpolasi Polinom* setelah memasukkan cara program membaca input, masukkan *N*, kemudian masukkan data *x[0],y[0],x[1],y[1],...,x[n],y[n]*.
  5.4. Untuk **MENU** *Regresi Linier Berganda* setelah memasukkan cara program membaca input, masukkan jumlah variabel *x*, kemudian masukkan jumlah data yang ada, kemudian masukkan data yang ada (Nilai *y*/*f(x)* terlebih dahulu, diikuti nilai variabel *x*)
 6. Setelah menampilkan solusi, program akan otomatis kembali ke **MENU**.

***PENTING*** :
1. Sebelum dijalankan, pastikan file input (**INPUT SPL, INPUT REGRESI, INPUT INTERPOLASI, INPUT DETINV**) sudah terisi dengan benar.
2. Output melalui file akan ter-*overwrite* jika melakukan operasi yang sama. Maka dari itu, sebelum melakukan operasi yang sama dicek dahulu jawabannya di file hasil (directory hasil berada di **master**).
3. Untuk invers matriks, hasil matriks formatnya dua angka di belakang koma.
4. Untuk interpolasi polinom, hasil dari persamaan formatnya juga empat angka di belakang koma.
5. Jika masukkan tidak valid untuk setiap persoalan, program akan otomatis keluar dan harus dijalankan kembali dengan perintah `java Main`.
