package controller;
import java.util.ArrayList;
import java.util.Comparator;
import model.*;
import view.PerangkatView;
public class PerangkatController {
    private final ArrayList<Perangkat> data = new ArrayList<>();
    private final PerangkatView view;
    public PerangkatController(PerangkatView view) { this.view = view; }
    public void jalankan() {
        boolean jalan = true;
        while (jalan) {
            try {
                switch (view.menu()) {
                    case 1: tambahLaptop(); break;
                    case 2: tambahSmartphone(); break;
                    case 3: tambahPrinter(); break;
                    case 4: tampilkan(); break;
                    case 5: urutkan(); break;
                    case 6: ubahStatus(); break;
                    case 7: hubungkanPrinter(); break;
                    case 0: jalan = false; view.pesan("Program selesai."); break;
                    default: view.pesan("Pilihan menu tidak valid.");
                }
            } catch (IllegalArgumentException e) { view.pesan("Gagal: " + e.getMessage()); }
        }
        view.tutup();
    }
    private void tambahLaptop() {
        String n=view.bacaString("Nama Laptop: "); double h=view.bacaDouble("Harga: ");
        int d=view.bacaInt("Daya (Watt): "); int r=view.bacaInt("RAM (GB): ");
        String p=view.bacaString("Jenis Prosesor: ");
        data.add(new Laptop(n,h,d,r,p)); view.pesan("Laptop berhasil ditambahkan.");
    }
    private void tambahSmartphone() {
        String n=view.bacaString("Nama Smartphone: "); double h=view.bacaDouble("Harga: ");
        int d=view.bacaInt("Daya (Watt): "); int b=view.bacaInt("Baterai (mAh): ");
        boolean g=view.bacaBoolean("Mendukung 5G (true/false): ");
        data.add(new Smartphone(n,h,d,b,g)); view.pesan("Smartphone berhasil ditambahkan.");
    }
    private void tambahPrinter() {
        String n=view.bacaString("Nama Printer: "); double h=view.bacaDouble("Harga: ");
        int d=view.bacaInt("Daya (Watt): "); String t=view.bacaString("Jenis Tinta: ");
        int j=view.bacaInt("Jumlah Halaman: ");
        data.add(new Printer(n,h,d,t,j)); view.pesan("Printer berhasil ditambahkan.");
    }
    private void tampilkan() {
        if (data.isEmpty()) { view.pesan("Belum ada perangkat."); return; }
        for (int i=0;i<data.size();i++) { view.pesan("Perangkat "+(i+1)); view.tampil(data.get(i)); }
    }
    private void urutkan() {
        if (data.isEmpty()) { view.pesan("Belum ada perangkat."); return; }
        data.sort(Comparator.comparingDouble(Perangkat::getHarga));
        view.pesan("Berhasil diurutkan berdasarkan harga."); tampilkan();
    }
    private void ubahStatus() {
        if (data.isEmpty()) { view.pesan("Belum ada perangkat."); return; }
        for (int i=0;i<data.size();i++) view.pesan((i+1)+". "+data.get(i).getNama()+" - "+data.get(i).getStatus());
        int n=view.bacaInt("Pilih nomor perangkat: ");
        if (n<1 || n>data.size()) { view.pesan("Nomor tidak valid."); return; }
        data.get(n-1).setStatus(view.pilihStatus()); view.pesan("Status berhasil diubah.");
    }
    private void hubungkanPrinter() {
        ArrayList<Printer> printers=new ArrayList<>();
        for (Perangkat p:data) if (p instanceof Printer) printers.add((Printer)p);
        if (printers.isEmpty()) { view.pesan("Belum ada printer."); return; }
        for (int i=0;i<printers.size();i++) view.pesan((i+1)+". "+printers.get(i).getNama());
        int n=view.bacaInt("Pilih printer: ");
        if (n<1 || n>printers.size()) { view.pesan("Nomor tidak valid."); return; }
        printers.get(n-1).hubungkan();
    }
}
