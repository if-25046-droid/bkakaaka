package model;

public class Pesawat extends Kendaraan implements Kargoable {
    private final boolean pesawatTempur;
    private final int jumlahRoda;
    private boolean kargoTerisi;

    public Pesawat(String nama, int kapasitasOrang,
                   boolean pesawatTempur, int jumlahRoda) {
        super(nama, kapasitasOrang, BahanBakar.AVTUR);
        if (jumlahRoda <= 0) {
            throw new IllegalArgumentException("Jumlah roda harus lebih dari 0.");
        }
        this.pesawatTempur = pesawatTempur;
        this.jumlahRoda = jumlahRoda;
    }

    public Pesawat(String nama, int kapasitasOrang, int jumlahRoda) {
        this(nama, kapasitasOrang, false, jumlahRoda);
    }

    public boolean isPesawatTempur() {
        return pesawatTempur;
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

    @Override
    public void unloadKargo() {
        kargoTerisi = false;
    }

    @Override
    public String getDetails() {
        return "Pesawat " + getNama()
                + ", kapasitas orang: " + getKapasitasOrang()
                + ", Pesawat Tempur: " + (pesawatTempur ? "Ya" : "Tidak")
                + ", Jumlah Roda: " + jumlahRoda;
    }
}
