package model;

public class Mobil extends Kendaraan {
    private final int jumlahRoda = 4;

    public Mobil(String nama, int kapasitasOrang, BahanBakar bahanBakar) {
        super(nama, kapasitasOrang, bahanBakar);
    }

    public Mobil(String nama, int kapasitasOrang) {
        super(nama, kapasitasOrang);
    }

    public int getJumlahRoda() {
        return jumlahRoda;
    }

    @Override
    public String getDetails() {
        return "Mobil " + getNama()
                + ", kapasitas orang: " + getKapasitasOrang()
                + ", Jumlah Roda: " + jumlahRoda;
    }
}
