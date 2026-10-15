Program Daftar Kendaraan - Java MVC

Struktur:
src/Main.java
src/model/
src/view/
src/controller/

Cara menjalankan dari folder project:
1. Buka terminal di folder SmartFitnessCenter.
2. Compile:
   javac -d out src/Main.java src/model/*.java src/view/*.java src/controller/*.java
3. Jalankan:
   java -cp out Main

Menu:
1. Tambah kendaraan
2. Tampilkan semua kendaraan
3. Urutkan berdasarkan kapasitas
0. Keluar

Catatan:
- Mobil dapat memilih bahan bakar.
- Truk selalu diesel dan kapasitas orang selalu 3.
- Helikopter dan Pesawat selalu avtur.
- Operasi kargo tersedia di class Truk, Helikopter, dan Pesawat.
