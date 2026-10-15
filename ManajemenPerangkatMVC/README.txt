MANAJEMEN PERANGKAT ELEKTRONIK - MVC
Jalankan src/Main.java dari IDE Java.

Konsep: abstract class, inheritance, interface, enum, polymorphism, overloading,
encapsulation, exception handling, ArrayList, sorting, MVC.

SOAL BARU UNTUK LATIHAN (tanpa coding):
Sistem Manajemen Perpustakaan
- Abstract class Koleksi: judul (String), tahunTerbit (int), status (enum).
- Class Buku extends Koleksi: penulis (String), jumlahHalaman (int).
- Class Majalah extends Koleksi: nomorEdisi (int), kategori (String).
- Interface DapatDipinjam: pinjam() dan kembalikan().
- Enum StatusKoleksi: TERSEDIA, DIPINJAM, RUSAK.
- Menu: tambah buku, tambah majalah, tampilkan semua koleksi, cari judul,
  urutkan berdasarkan tahun terbit, pinjam/kembalikan koleksi, keluar.
- Gunakan ArrayList<Koleksi>, MVC, encapsulation, polymorphism, overloading,
  exception handling, dan file terpisah.
