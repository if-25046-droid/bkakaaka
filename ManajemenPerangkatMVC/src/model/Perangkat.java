package model;
public abstract class Perangkat {
    private String nama;
    private double harga;
    private int daya;
    private StatusPerangkat status = StatusPerangkat.NONAKTIF;

    public Perangkat(String nama, double harga, int daya) {
        setNama(nama);
        setHarga(harga);
        setDaya(daya);
    }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getDaya() { return daya; }
    public StatusPerangkat getStatus() { return status; }
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) throw new IllegalArgumentException("Nama tidak boleh kosong.");
        this.nama = nama;
    }
    public void setHarga(double harga) {
        if (harga < 0) throw new IllegalArgumentException("Harga tidak boleh negatif.");
        this.harga = harga;
    }
    public void setDaya(int daya) {
        if (daya < 0) throw new IllegalArgumentException("Daya tidak boleh negatif.");
        this.daya = daya;
    }
    public void setStatus(StatusPerangkat status) {
        if (status == null) throw new IllegalArgumentException("Status tidak boleh kosong.");
        this.status = status;
    }
    public abstract String getDetail();
    public String getInfo() {
        return "Nama: " + nama + "\nHarga: Rp" + String.format("%.0f", harga)
            + "\nDaya: " + daya + " Watt\nStatus: " + status;
    }
    public String getInfo(String label) { return label + "\n" + getInfo(); }
}
