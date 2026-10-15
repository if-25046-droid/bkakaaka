SISTEM TURNAMEN ESPORTS - JAVA OOP

File:
- Main.java: seluruh source code dalam satu file agar mudah dijalankan.

Materi OOP:
- enum StatusPertandingan
- interface DapatBertanding
- abstract class Peserta
- inheritance: Pemain dan Tim
- polymorphism: ArrayList<Peserta>
- encapsulation: atribut private dan getter
- overriding: hitungPoin(), hitungHadiah(), getDetail()
- custom exception: PertandinganBelumDimulaiException dan PertandinganBelumSelesaiException
- perhitungan poin dan hadiah

Aturan perhitungan:
- Pemain: poin = skor pertandingan + jumlah kill; hadiah = total poin x Rp10.000.
- Tim: poin = skor pertandingan + (jumlah anggota x 5); hadiah = total poin x Rp25.000.
- Tim mendapatkan tambahan satu kemenangan jika skor pertandingan minimal 100.

Cara menjalankan:
1. Pastikan JDK terpasang.
2. Buka terminal di folder yang berisi Main.java.
3. Jalankan: javac Main.java
4. Jalankan: java Main
