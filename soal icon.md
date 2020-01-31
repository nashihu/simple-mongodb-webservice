#SOAL TEST PEMOGRAMMER ICON+

##SOAL AWAL
1.Aplikasi harus berupa web app, tidak diperbolehkan berupa desktop app
2.Aplikasi minimal terdiri dari 4 form, pertama berupa form login selainnya sesuai table yang dibuat
3.Untuk setiap form yang dibuat masih-masing menggunakan 1 tabel dan dapat melakukan proses CRUD (Create, Read Update Delete) atau sebagai tabel master
4.Menjadi nilai tambah apabila terdapat proses join tabel untuk melakukan transaksi dari tabel master yang dibuat.
5.Bisa manampilkan data di dalam table/grid dengan disertai fitur pencarian data mendapatkan nilai plus apabila bisa memakai konsep pagination table
6.Terdapat report/print preview minimal dengan format pdf
7.Data Base yang dipergunakan minimal mysql dengan ketentuan minimal 4 table dan minimal terdapat relasi table one to many 
8.Menjadi nilai tambah jika aplikasi dibuat dengan framework spring dan thymeleaf sebagai template engine nya. 
9.Project yang dikirimkan harus menggunakan salah satu version control baik github, gitlab atau bitbucket

##SOAL LANJUTAN
1.Buat REST API menggunakan spring boot
2.Dengan kasus sebagai berikat
a.Terdapat 3 tabel master yaitu
i.Master Mata Kuliah
ii.Master Jurusan
iii.Master Fakultas
b.Buat tabel mahasiswa untuk menampung data mahasiswa
c.Data mahasiswa mempunyai ketentuan sebagai berikut
i.1 mahasiwa mempunyai 1 jurusan
ii.1 mahasiwa mempunyai 1 fakultas
iii.1 mahasiswa mempunyai banyak mata kuliah
d.Ada action CRUD pada tabel mahasiswa
e.Ada action CRUD untuk matakuliah bagi setiap mahasiswa
f.Untuk output yang diharapkan selain CRUD di atas yaitu
i.Menampilkan mahasiswa beserta mata kuliah yang diambil
ii.Menampilkan banyak mahasiswa yang mengambil mata kuliah
iii.Menampilkan banyak mahaswa yang berada dalam jurusan tertentu
g.Akan menjadi nilai tambah jika menerapkan DAO design pattern
