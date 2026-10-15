import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

enum StatusKoleksi {
    TERSEDIA, DIPINJAM, RUSAK
}

interface DapatDipinjam {
    void pinjam() throws KoleksiTidakTersediaException;
    void kembalikan() throws KoleksiBelumDipinjamException;
}

class KoleksiTidakTersediaException extends Exception {
    public KoleksiTidakTersediaException(String pesan) {
        super(pesan);
    }
}

class KoleksiBelumDipinjamException extends Exception {
    public KoleksiBelumDipinjamException(String pesan) {
        super(pesan);
    }
}

abstract class Koleksi implements DapatDipinjam {
    private String id;
    private String judul;
    private int tahunTerbit;
    private StatusKoleksi status;

    public Koleksi(String id, String judul, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.status = StatusKoleksi.TERSEDIA;
    }

    public String getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public StatusKoleksi getStatus() {
        return status;
    }

    public void setStatus(StatusKoleksi status) {
        this.status = status;
    }

    @Override
    public void pinjam() throws KoleksiTidakTersediaException {
        if (status != StatusKoleksi.TERSEDIA) {
            throw new KoleksiTidakTersediaException(
                "Koleksi '" + judul + "' tidak bisa dipinjam. Status: " + status
            );
        }
        status = StatusKoleksi.DIPINJAM;
    }

    @Override
    public void kembalikan() throws KoleksiBelumDipinjamException {
        if (status != StatusKoleksi.DIPINJAM) {
            throw new KoleksiBelumDipinjamException(
                "Koleksi '" + judul + "' tidak sedang dipinjam."
            );
        }
        status = StatusKoleksi.TERSEDIA;
    }

    public abstract String getDetail();
}

class Buku extends Koleksi {
    private String penulis;
    private int jumlahHalaman;

    public Buku(String id, String judul, int tahunTerbit,
                String penulis, int jumlahHalaman) {
        super(id, judul, tahunTerbit);
        this.penulis = penulis;
        this.jumlahHalaman = jumlahHalaman;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    @Override
    public String getDetail() {
        return "Buku | ID: " + getId()
            + " | Judul: " + getJudul()
            + " | Tahun: " + getTahunTerbit()
            + " | Penulis: " + penulis
            + " | Halaman: " + jumlahHalaman
            + " | Status: " + getStatus();
    }
}

class Majalah extends Koleksi {
    private int nomorEdisi;
    private String kategori;

    public Majalah(String id, String judul, int tahunTerbit,
                   int nomorEdisi, String kategori) {
        super(id, judul, tahunTerbit);
        this.nomorEdisi = nomorEdisi;
        this.kategori = kategori;
    }

    public int getNomorEdisi() {
        return nomorEdisi;
    }

    public String getKategori() {
        return kategori;
    }

    @Override
    public String getDetail() {
        return "Majalah | ID: " + getId()
            + " | Judul: " + getJudul()
            + " | Tahun: " + getTahunTerbit()
            + " | Edisi: " + nomorEdisi
            + " | Kategori: " + kategori
            + " | Status: " + getStatus();
    }
}

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final List<Koleksi> daftarKoleksi = new ArrayList<>();
    private static int nomorId = 1;

    public static void main(String[] args) {
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = bacaInt("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    tambahMajalah();
                    break;
                case 3:
                    tampilkanSemuaKoleksi();
                    break;
                case 4:
                    cariKoleksi();
                    break;
                case 5:
                    urutkanTahunTerbit();
                    break;
                case 6:
                    prosesPinjam();
                    break;
                case 7:
                    prosesPengembalian();
                    break;
                case 0:
                    System.out.println("Program perpustakaan selesai.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak tersedia.");
            }
            System.out.println();
        } while (pilihan != 0);
    }

    private static void tampilkanMenu() {
        System.out.println("===== SISTEM PERPUSTAKAAN =====");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tambah Majalah");
        System.out.println("3. Tampilkan Semua Koleksi");
        System.out.println("4. Cari Koleksi Berdasarkan Judul");
        System.out.println("5. Urutkan Berdasarkan Tahun Terbit");
        System.out.println("6. Pinjam Koleksi");
        System.out.println("7. Kembalikan Koleksi");
        System.out.println("0. Keluar");
    }

    private static void tambahBuku() {
        System.out.println("--- Tambah Buku ---");
        String judul = bacaTeks("Judul: ");
        int tahun = bacaInt("Tahun terbit: ");
        String penulis = bacaTeks("Penulis: ");
        int halaman = bacaInt("Jumlah halaman: ");

        if (tahun <= 0 || halaman <= 0) {
            System.out.println("Tahun dan jumlah halaman harus lebih dari 0.");
            return;
        }

        String id = buatId("BK");
        daftarKoleksi.add(new Buku(id, judul, tahun, penulis, halaman));
        System.out.println("Buku berhasil ditambahkan. ID: " + id);
    }

    private static void tambahMajalah() {
        System.out.println("--- Tambah Majalah ---");
        String judul = bacaTeks("Judul: ");
        int tahun = bacaInt("Tahun terbit: ");
        int edisi = bacaInt("Nomor edisi: ");
        String kategori = bacaTeks("Kategori: ");

        if (tahun <= 0 || edisi <= 0) {
            System.out.println("Tahun dan nomor edisi harus lebih dari 0.");
            return;
        }

        String id = buatId("MJ");
        daftarKoleksi.add(new Majalah(id, judul, tahun, edisi, kategori));
        System.out.println("Majalah berhasil ditambahkan. ID: " + id);
    }

    private static void tampilkanSemuaKoleksi() {
        System.out.println("--- Semua Koleksi ---");
        if (daftarKoleksi.isEmpty()) {
            System.out.println("Belum ada koleksi.");
            return;
        }

        for (Koleksi koleksi : daftarKoleksi) {
            System.out.println(koleksi.getDetail());
        }
    }

    private static void cariKoleksi() {
        String kataKunci = bacaTeks("Masukkan judul yang dicari: ").toLowerCase();
        boolean ditemukan = false;

        for (Koleksi koleksi : daftarKoleksi) {
            if (koleksi.getJudul().toLowerCase().contains(kataKunci)) {
                System.out.println(koleksi.getDetail());
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Koleksi dengan judul tersebut tidak ditemukan.");
        }
    }

    private static void urutkanTahunTerbit() {
        if (daftarKoleksi.isEmpty()) {
            System.out.println("Belum ada koleksi untuk diurutkan.");
            return;
        }

        daftarKoleksi.sort(Comparator.comparingInt(Koleksi::getTahunTerbit));
        System.out.println("Koleksi diurutkan dari tahun terbit paling lama:");
        tampilkanSemuaKoleksi();
    }

    private static void prosesPinjam() {
        String id = bacaTeks("Masukkan ID koleksi yang ingin dipinjam: ");
        Koleksi koleksi = cariById(id);

        if (koleksi == null) {
            System.out.println("ID koleksi tidak ditemukan.");
            return;
        }

        try {
            koleksi.pinjam();
            System.out.println("Berhasil meminjam: " + koleksi.getJudul());
        } catch (KoleksiTidakTersediaException e) {
            System.out.println("Peminjaman gagal: " + e.getMessage());
        }
    }

    private static void prosesPengembalian() {
        String id = bacaTeks("Masukkan ID koleksi yang dikembalikan: ");
        Koleksi koleksi = cariById(id);

        if (koleksi == null) {
            System.out.println("ID koleksi tidak ditemukan.");
            return;
        }

        try {
            koleksi.kembalikan();
            System.out.println("Berhasil mengembalikan: " + koleksi.getJudul());
        } catch (KoleksiBelumDipinjamException e) {
            System.out.println("Pengembalian gagal: " + e.getMessage());
        }
    }

    private static Koleksi cariById(String id) {
        for (Koleksi koleksi : daftarKoleksi) {
            if (koleksi.getId().equalsIgnoreCase(id)) {
                return koleksi;
            }
        }
        return null;
    }

    private static String buatId(String awalan) {
        return awalan + String.format("%03d", nomorId++);
    }

    private static String bacaTeks(String pesan) {
        System.out.print(pesan);
        return input.nextLine().trim();
    }

    private static int bacaInt(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine().trim();
            try {
                return Integer.parseInt(teks);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Coba lagi.");
            }
        }
    }
}
