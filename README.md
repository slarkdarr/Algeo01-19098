# TUGAS BESAR 1 IF 2123 ALJABAR LINIER DAN GEOMETRI
SISTEM PERSAMAAN LINIER, DETERMINAN, DAN APLIKASINYA
## Deskripsi (*Description*)
Projek ini berisi pengimplementasian Sistem Persamaan Linier, Determinan, dan Aplikasinya pada bahasa Java.

Projek ini dibuat dalam rangka penyelesaian Tugas Besar 1 IF 2123 Aljabar Linier dan Geometri.
## Kontributor (*Contributor*)
Terdapat tiga orang kontributor dalam pengerjaan projek ini
|             NAMA             |    NIM   |
|------------------------------|----------|
|     Jordan Daniel Joshua     | 13519098 |
| Daffa Ananda Pratama Resyaly | 13519107 |
|    Naufal Yahya Kurnianto    | 13519141 |
## Cara pengoperasian (*How to use*)
1. Buka *command prompt* kemudian pindahkan *directory* ke folder *bin*.

2. Jalani program menggunakan perintah `java Main`.

3. Pilih menu menggunakan angka dalam selang [1..6] sesuai dengan yang terdapat di list **MENU**.

	3.1. Untuk persoalan *Sistem Persamaan Linier*, terdapat empat buah *SubMenu*. Pilih *SubMenu* berdasarkan metode mencari solusi sistem persamaan linier yang ingin digunakan.
	
	3.2. Untuk persoalan *Determinan*, terdapat dua buah *SubMenu*. Pilih *SubMenu* berdasarkan metode menghitung determinan yang ingin digunakan.
	
	3.3. Untuk persoalan *Matriks Balikan*, terdapat dua buah *SubMenu*. Pilih *SubMenu* berdasarkan metode menghitung matriks balikan yang ingin digunakan.
4. Pilih cara program membaca input. Ketik 1 untuk membaca input langsung dari *keyboard* atau ketik 2 untuk membaca input dari *file*.
5. Untuk setiap persoalan, masukkan dapat dilihat sesuai ketentuan berikut.

	5.1. Untuk persoalan *Sistem Persamaan Linier*, setelah memasukkan cara program membaca input, masukkan jumlah persamaan, masukkan jumlah variabel, kemudian masukkan koefisien persamaan (*ax1 + bx2 + ... = cy*).
	
	5.2. Untuk persoalan *Determinan* dan *Matriks Balikan*, setelah memasukkan cara program membaca input, masukkan *N*, kemudian masukkan elemen-elemen matriks.
	
	5.3. Untuk persoalan *Interpolasi Polinom*, setelah memasukkan cara program membaca input, masukkan *N*, kemudian masukkan data *x[0], y[0], x[1], y[1],..., x[n], y[n]*. Setelah ditunjukkan hasil persamaan, ketik 1 untuk menaksir titik (*x*, *y*) dengan memasukkan nilai *x* atau ketik 0 untuk kembali ke **MENU**.
	
	5.4. Untuk persoalan *Regresi Linier Berganda*, setelah memasukkan cara program membaca input, masukkan jumlah variabel *x*, kemudian masukkan jumlah data yang ada, kemudian masukkan data yang ada (Nilai *y* / *f(x)* terlebih dahulu, diikuti nilai variabel *x*). Setelah ditunjukkan hasil persamaan, ketik 1 untuk menaksir *y* / *f(x)* dengan memasukkan nilai-nilai variabel *x* atau ketik 0 untuk kembali ke **MENU**.
	
 6. Setelah menampilkan solusi, program akan otomatis kembali ke **MENU**.

***CATATAN*** :
1. Sebelum dijalankan, pastikan file input (**INPUT SPL, INPUT REGRESI, INPUT INTERPOLASI, INPUT DETINV**) sudah terisi dengan benar.
2. Output melalui file akan ter-*overwrite* jika melakukan operasi yang sama. Maka dari itu, sebelum melakukan operasi yang sama dicek dahulu jawabannya di file hasil (*directory* hasil berada di **master**).
3. Untuk persoalan *Matriks Balikan / Invers Matriks*, format elemen matriks hasil perhitungan adalah dua angka di belakang koma.
4. Untuk persoalan *Interpolasi Polinom*, format hasil dari persamaan adalah empat angka di belakang koma.
5. Jika masukkan tidak valid untuk setiap persoalan, program akan otomatis keluar dan harus dijalankan kembali dengan perintah `java Main`.
