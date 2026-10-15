package model;
public class Printer extends Perangkat implements Koneksi {
    private String jenisTinta;
    private int jumlahHalaman;
    private boolean terhubung;
    public Printer(String nama, double harga, int daya, String jenisTinta, int jumlahHalaman) {
        super(nama, harga, daya);
        if (jenisTinta == null || jenisTinta.trim().isEmpty()) throw new IllegalArgumentException("Jenis tinta tidak boleh kosong.");
        if (jumlahHalaman < 0) throw new IllegalArgumentException("Jumlah halaman tidak boleh negatif.");
        this.jenisTinta = jenisTinta; this.jumlahHalaman = jumlahHalaman;
    }
    @Override public String getDetail() {
        return getInfo("=== PRINTER ===") + "\nJenis tinta: " + jenisTinta
            + "\nJumlah halaman: " + jumlahHalaman
            + "\nKoneksi: " + (terhubung ? "Terhubung" : "Tidak terhubung");
    }
    @Override public void hubungkan() {
        if (terhubung) { System.out.println("Printer sudah terhubung."); return; }
        terhubung = true; System.out.println("Printer berhasil dihubungkan.");
    }
    @Override public void putuskan() {
        if (!terhubung) { System.out.println("Printer belum terhubung."); return; }
        terhubung = false; System.out.println("Koneksi printer berhasil diputus.");
    }
}
