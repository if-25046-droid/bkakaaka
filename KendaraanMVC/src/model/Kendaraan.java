package model;

public abstract class Kendaraan {
    private final BahanBakar bahanBakar;
    private final int kapasitasOrang;
    private final String nama;

    public Kendaraan(String nama, int kapasitasOrang, BahanBakar bahanBakar) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama kendaraan tidak boleh kosong.");
        }
        if (kapasitasOrang <= 0) {
            throw new IllegalArgumentException("Kapasitas harus lebih dari 0.");
        }
        if (bahanBakar == null) {
            throw new IllegalArgumentException("Bahan bakar harus dipilih.");
        }
        this.nama = nama;
        this.kapasitasOrang = kapasitasOrang;
        this.bahanBakar = bahanBakar;
    }

    public Kendaraan(String nama, int kapasitasOrang) {
        this(nama, kapasitasOrang, BahanBakar.BENSIN);
    }

    public String getNama() {
        return nama;
    }

    public int getKapasitasOrang() {
        return kapasitasOrang;
    }

    public BahanBakar getBahanBakar() {
        return bahanBakar;
    }

    protected String getBaseDetails() {
        return "Nama: " + nama
                + ", Bahan Bakar: " + bahanBakar
                + ", Kapasitas: " + kapasitasOrang + " orang";
    }

    public abstract String getDetails();
}
