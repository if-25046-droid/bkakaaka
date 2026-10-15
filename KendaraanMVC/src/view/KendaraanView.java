package view;

public class KendaraanView {
    public void showMenu() {
        System.out.println("\n===== DAFTAR KENDARAAN =====");
        System.out.println("1. Tambah kendaraan");
        System.out.println("2. Tampilkan semua kendaraan");
        System.out.println("3. Urutkan kendaraan berdasarkan kapasitas");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public void showJenisKendaraan() {
        System.out.println("\nJenis kendaraan:");
        System.out.println("1. Mobil");
        System.out.println("2. Truk");
        System.out.println("3. Helikopter");
        System.out.println("4. Pesawat");
        System.out.print("Pilih jenis: ");
    }

    public void showBahanBakar() {
        System.out.println("Pilihan bahan bakar:");
        System.out.println("1. Bensin");
        System.out.println("2. Diesel");
        System.out.println("3. Avtur");
        System.out.print("Pilih bahan bakar: ");
    }

    public void showKendaraan(String details) {
        System.out.println(details);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showKapasitasSorted() {
        System.out.println("\nDaftar kendaraan setelah diurutkan:");
    }
}
