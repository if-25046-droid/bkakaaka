package model;

public class Helikopter extends Kendaraan implements Kargoable {
    private final int jumlahBalingBaling;
    private boolean kargoTerisi;

    public Helikopter(String nama, int kapasitasOrang, int jumlahBalingBaling) {
        super(nama, kapasitasOrang, BahanBakar.AVTUR);
        if (jumlahBalingBaling <= 0) {
            throw new IllegalArgumentException("Jumlah baling-baling harus lebih dari 0.");
        }
        this.jumlahBalingBaling = jumlahBalingBaling;
    }

    public Helikopter(String nama, int kapasitasOrang) {
        this(nama, kapasitasOrang, 2);
    }

    public int getJumlahBalingBaling() {
        return jumlahBalingBaling;
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
        return "Helikopter " + getNama()
                + ", kapasitas orang: " + getKapasitasOrang()
                + ", Jumlah Baling-Baling: " + jumlahBalingBaling;
    }
}
