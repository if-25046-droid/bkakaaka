package view;
import java.util.Scanner;
import model.Perangkat;
import model.StatusPerangkat;
public class PerangkatView {
    private final Scanner sc = new Scanner(System.in);
    public int menu() {
        System.out.println("\n===== MANAJEMEN PERANGKAT =====");
        System.out.println("1. Tambah Laptop\n2. Tambah Smartphone\n3. Tambah Printer");
        System.out.println("4. Tampilkan Semua Perangkat\n5. Urutkan Berdasarkan Harga");
        System.out.println("6. Ubah Status Perangkat\n7. Hubungkan Printer\n0. Keluar");
        return bacaInt("Pilihan: ");
    }
    public String bacaString(String p) { System.out.print(p); return sc.nextLine().trim(); }
    public int bacaInt(String p) {
        while (true) { System.out.print(p); try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Input harus bilangan bulat."); } }
    }
    public double bacaDouble(String p) {
        while (true) { System.out.print(p); try { return Double.parseDouble(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Input harus angka."); } }
    }
    public boolean bacaBoolean(String p) {
        while (true) { String s = bacaString(p);
            if (s.equalsIgnoreCase("true")) return true;
            if (s.equalsIgnoreCase("false")) return false;
            System.out.println("Masukkan true atau false."); }
    }
    public StatusPerangkat pilihStatus() {
        while (true) { System.out.println("1. AKTIF\n2. NONAKTIF\n3. RUSAK");
            int x = bacaInt("Pilih status: ");
            if (x == 1) return StatusPerangkat.AKTIF;
            if (x == 2) return StatusPerangkat.NONAKTIF;
            if (x == 3) return StatusPerangkat.RUSAK;
            System.out.println("Pilihan tidak valid."); }
    }
    public void tampil(Perangkat p) { System.out.println(p.getDetail()); System.out.println("--------------------"); }
    public void pesan(String s) { System.out.println(s); }
    public void tutup() { sc.close(); }
}
