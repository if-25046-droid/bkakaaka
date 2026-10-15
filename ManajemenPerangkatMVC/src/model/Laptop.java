package model;
public class Laptop extends Perangkat {
    private int ram;
    private String jenisProsesor;
    public Laptop(String nama, double harga, int daya, int ram, String jenisProsesor) {
        super(nama, harga, daya);
        if (ram <= 0) throw new IllegalArgumentException("RAM harus lebih dari 0.");
        if (jenisProsesor == null || jenisProsesor.trim().isEmpty()) throw new IllegalArgumentException("Prosesor tidak boleh kosong.");
        this.ram = ram; this.jenisProsesor = jenisProsesor;
    }
    public int getRam() { return ram; }
    public String getJenisProsesor() { return jenisProsesor; }
    @Override public String getDetail() {
        return getInfo("=== LAPTOP ===") + "\nRAM: " + ram + " GB\nProsesor: " + jenisProsesor;
    }
}
