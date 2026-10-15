enum StatusPertandingan {
    BELUM_DIMULAI,
    BERLANGSUNG,
    SELESAI
}

interface DapatBertanding {
    void mulaiPertandingan();
    void selesaikanPertandingan(int skor) throws PertandinganBelumDimulaiException;
}

class PertandinganBelumDimulaiException extends Exception {
    public PertandinganBelumDimulaiException(String pesan) {
        super(pesan);
    }
}

class PertandinganBelumSelesaiException extends Exception {
    public PertandinganBelumSelesaiException(String pesan) {
        super(pesan);
    }
}

abstract class Peserta implements DapatBertanding {
    private String id;
    private String nama;
    private int jumlahPertandingan;
    private int totalPoin;
    private StatusPertandingan status;

    public Peserta(String id, String nama) {
        this.id = id;
        this.nama = nama;
        this.jumlahPertandingan = 0;
        this.totalPoin = 0;
        this.status = StatusPertandingan.BELUM_DIMULAI;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlahPertandingan() {
        return jumlahPertandingan;
    }

    public int getTotalPoin() {
        return totalPoin;
    }

    public StatusPertandingan getStatus() {
        return status;
    }

    public void setStatus(StatusPertandingan status) {
        this.status = status;
    }

    @Override
    public void mulaiPertandingan() {
        status = StatusPertandingan.BERLANGSUNG;
    }

    @Override
    public void selesaikanPertandingan(int skor)
            throws PertandinganBelumDimulaiException {
        if (status != StatusPertandingan.BERLANGSUNG) {
            throw new PertandinganBelumDimulaiException(
                "Pertandingan harus dimulai terlebih dahulu!"
            );
        }

        if (skor < 0) {
            throw new IllegalArgumentException("Skor tidak boleh negatif!");
        }

        totalPoin += hitungPoin(skor);
        jumlahPertandingan++;
        status = StatusPertandingan.SELESAI;
    }

    public abstract int hitungPoin(int skor);
    public abstract double hitungHadiah() throws PertandinganBelumSelesaiException;
    public abstract String getDetail();
}

class Pemain extends Peserta {
    private String nickname;
    private int jumlahKill;

    public Pemain(String id, String nama, String nickname, int jumlahKill) {
        super(id, nama);
        this.nickname = nickname;
        this.jumlahKill = jumlahKill;
    }

    public String getNickname() {
        return nickname;
    }

    public int getJumlahKill() {
        return jumlahKill;
    }

    public void setJumlahKill(int jumlahKill) {
        this.jumlahKill = jumlahKill;
    }

    @Override
    public int hitungPoin(int skor) {
        return skor + jumlahKill;
    }

    @Override
    public double hitungHadiah() throws PertandinganBelumSelesaiException {
        if (getStatus() != StatusPertandingan.SELESAI) {
            throw new PertandinganBelumSelesaiException(
                "Hadiah belum bisa dihitung karena pertandingan belum selesai!"
            );
        }
        return getTotalPoin() * 10000.0;
    }

    @Override
    public String getDetail() {
        return "=== PEMAIN ==="
            + "\nID: " + getId()
            + "\nNama: " + getNama()
            + "\nNickname: " + nickname
            + "\nJumlah Kill: " + jumlahKill
            + "\nTotal Poin: " + getTotalPoin()
            + "\nJumlah Pertandingan: " + getJumlahPertandingan()
            + "\nStatus: " + getStatus();
    }
}

class Tim extends Peserta {
    private int jumlahAnggota;
    private int jumlahKemenangan;

    public Tim(String id, String nama, int jumlahAnggota) {
        super(id, nama);
        this.jumlahAnggota = jumlahAnggota;
        this.jumlahKemenangan = 0;
    }

    public int getJumlahAnggota() {
        return jumlahAnggota;
    }

    public int getJumlahKemenangan() {
        return jumlahKemenangan;
    }

    @Override
    public int hitungPoin(int skor) {
        if (skor >= 100) {
            jumlahKemenangan++;
        }
        return skor + (jumlahAnggota * 5);
    }

    @Override
    public double hitungHadiah() throws PertandinganBelumSelesaiException {
        if (getStatus() != StatusPertandingan.SELESAI) {
            throw new PertandinganBelumSelesaiException(
                "Hadiah belum bisa dihitung karena pertandingan belum selesai!"
            );
        }
        return getTotalPoin() * 25000.0;
    }

    @Override
    public String getDetail() {
        return "=== TIM ==="
            + "\nID: " + getId()
            + "\nNama Tim: " + getNama()
            + "\nJumlah Anggota: " + jumlahAnggota
            + "\nJumlah Kemenangan: " + jumlahKemenangan
            + "\nTotal Poin: " + getTotalPoin()
            + "\nJumlah Pertandingan: " + getJumlahPertandingan()
            + "\nStatus: " + getStatus();
    }
}

public class Main {
    public static void main(String[] args) {
        java.util.List<Peserta> daftarPeserta = new java.util.ArrayList<>();

        Pemain pemain1 = new Pemain("P01", "Andi", "Shadow", 10);
        Pemain pemain2 = new Pemain("P02", "Budi", "Blaze", 7);
        Tim tim1 = new Tim("T01", "Garuda Esports", 5);
        Tim tim2 = new Tim("T02", "Phoenix Squad", 4);

        daftarPeserta.add(pemain1);
        daftarPeserta.add(pemain2);
        daftarPeserta.add(tim1);
        daftarPeserta.add(tim2);

        System.out.println("=== DAFTAR PESERTA ===");
        for (Peserta peserta : daftarPeserta) {
            System.out.println(peserta.getDetail());
            System.out.println();
        }

        System.out.println("=== SIMULASI PERTANDINGAN ===");
        try {
            pemain1.mulaiPertandingan();
            pemain1.selesaikanPertandingan(50);
            System.out.println(pemain1.getNama() + " memperoleh " + pemain1.getTotalPoin() + " poin.");

            pemain2.mulaiPertandingan();
            pemain2.selesaikanPertandingan(40);
            System.out.println(pemain2.getNama() + " memperoleh " + pemain2.getTotalPoin() + " poin.");

            tim1.mulaiPertandingan();
            tim1.selesaikanPertandingan(100);
            System.out.println(tim1.getNama() + " memperoleh " + tim1.getTotalPoin() + " poin.");

            tim2.mulaiPertandingan();
            tim2.selesaikanPertandingan(80);
            System.out.println(tim2.getNama() + " memperoleh " + tim2.getTotalPoin() + " poin.");
        } catch (PertandinganBelumDimulaiException e) {
            System.out.println("Pertandingan gagal: " + e.getMessage());
        }

        System.out.println("\n=== PERHITUNGAN HADIAH ===");
        for (Peserta peserta : daftarPeserta) {
            try {
                System.out.println(peserta.getNama() + " mendapat hadiah: Rp"
                    + String.format("%.0f", peserta.hitungHadiah()));
            } catch (PertandinganBelumSelesaiException e) {
                System.out.println("Hadiah gagal dihitung: " + e.getMessage());
            }
        }

        System.out.println("\n=== UJI CUSTOM EXCEPTION ===");
        Pemain pemainBaru = new Pemain("P03", "Citra", "Nova", 5);
        try {
            pemainBaru.selesaikanPertandingan(30);
        } catch (PertandinganBelumDimulaiException e) {
            System.out.println("Berhasil menangani exception: " + e.getMessage());
        }

        try {
            pemainBaru.hitungHadiah();
        } catch (PertandinganBelumSelesaiException e) {
            System.out.println("Berhasil menangani exception: " + e.getMessage());
        }

        System.out.println("\n=== STATUS AKHIR PESERTA ===");
        for (Peserta peserta : daftarPeserta) {
            System.out.println(peserta.getDetail());
            System.out.println();
        }
    }
}
