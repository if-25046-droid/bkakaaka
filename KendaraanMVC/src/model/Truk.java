package model;

public class Truk extends Kendaraan implements Kargoable {
    private final int jumlahRoda;
    private boolean kargoTerisi;

    public Truk(String nama, int jumlahRoda) {
        super(nama, 3, BahanBakar.DIESEL);
        if (jumlahRoda <= 0) {
            throw new IllegalArgumentException("Jumlah roda harus lebih dari 0.");
        }
        this.jumlahRoda = jumlahRoda;
    }

    public Truk(String nama) {
        this(nama, 6);
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }

    public boolean isKargoTerisi() {
        return kargoTerisi;
    }

    @Override
    public void loadKargo() {
        kargoTerisi = true;
    }

    public void loadKargo(String namaKargo) {
        kargoTerisi = true;
        System.out.println("Kargo " + namaKargo + " berhasil dimuat.");
    }

    @Override
    public void unloadKargo() {
        kargoTerisi = false;
    }

    @Override
    public String getDetails() {
        return "Truk " + getNama()
                + ", kapasitas orang: " + getKapasitasOrang()
                + ", Jumlah Roda: " + jumlahRoda;
    }
}
