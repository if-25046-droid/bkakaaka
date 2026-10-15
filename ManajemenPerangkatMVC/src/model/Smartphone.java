package model;
public class Smartphone extends Perangkat {
    private int kapasitasBaterai;
    private boolean mendukung5G;
    public Smartphone(String nama, double harga, int daya, int kapasitasBaterai, boolean mendukung5G) {
        super(nama, harga, daya);
        if (kapasitasBaterai <= 0) throw new IllegalArgumentException("Kapasitas baterai harus lebih dari 0.");
        this.kapasitasBaterai = kapasitasBaterai; this.mendukung5G = mendukung5G;
    }
    public int getKapasitasBaterai() { return kapasitasBaterai; }
    public boolean isMendukung5G() { return mendukung5G; }
    @Override public String getDetail() {
        return getInfo("=== SMARTPHONE ===") + "\nBaterai: " + kapasitasBaterai + " mAh"
            + "\nMendukung 5G: " + (mendukung5G ? "Ya" : "Tidak");
    }
}
