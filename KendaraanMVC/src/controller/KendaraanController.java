package controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.*;
import view.KendaraanView;
import view.InputUtil;

public class KendaraanController {
    private final List<Kendaraan> daftarKendaraan = new ArrayList<>();
    private final KendaraanView view;

    public KendaraanController(KendaraanView view) {
        this.view = view;
    }

    public void run() {
        int pilihan;
        do {
            view.showMenu();
            pilihan = InputUtil.readInt();

            switch (pilihan) {
                case 1:
                    tambahKendaraan();
                    break;
                case 2:
                    tampilkanKendaraan();
                    break;
                case 3:
                    urutkanKendaraan();
                    break;
                case 0:
                    view.showMessage("Program selesai.");
                    break;
                default:
                    view.showMessage("Menu tidak valid.");
            }
        } while (pilihan != 0);
    }

    private void tambahKendaraan() {
        try {
            view.showJenisKendaraan();
            int jenis = InputUtil.readInt();

            if (jenis < 1 || jenis > 4) {
                throw new IllegalArgumentException("Jenis kendaraan tidak valid.");
            }

            System.out.print("Nama kendaraan: ");
            String nama = InputUtil.readLine();

            Kendaraan kendaraan;
            switch (jenis) {
                case 1:
                    kendaraan = buatMobil(nama);
                    break;
                case 2:
                    kendaraan = buatTruk(nama);
                    break;
                case 3:
                    kendaraan = buatHelikopter(nama);
                    break;
                default:
                    kendaraan = buatPesawat(nama);
                    break;
            }

            daftarKendaraan.add(kendaraan);
            view.showMessage("Kendaraan berhasil ditambahkan.");
        } catch (IllegalArgumentException e) {
            view.showMessage("Input tidak valid: " + e.getMessage());
        }
    }

    private Mobil buatMobil(String nama) {
        System.out.print("Kapasitas orang: ");
        int kapasitas = InputUtil.readInt();
        view.showBahanBakar();
        int pilihan = InputUtil.readInt();

        BahanBakar bahanBakar;
        switch (pilihan) {
            case 1:
                bahanBakar = BahanBakar.BENSIN;
                break;
            case 2:
                bahanBakar = BahanBakar.DIESEL;
                break;
            case 3:
                bahanBakar = BahanBakar.AVTUR;
                break;
            default:
                throw new IllegalArgumentException("Pilihan bahan bakar tidak tersedia.");
        }

        return new Mobil(nama, kapasitas, bahanBakar);
    }

    private Truk buatTruk(String nama) {
        System.out.print("Jumlah roda: ");
        int roda = InputUtil.readInt();
        return new Truk(nama, roda);
    }

    private Helikopter buatHelikopter(String nama) {
        System.out.print("Kapasitas orang: ");
        int kapasitas = InputUtil.readInt();
        System.out.print("Jumlah baling-baling: ");
        int balingBaling = InputUtil.readInt();
        return new Helikopter(nama, kapasitas, balingBaling);
    }

    private Pesawat buatPesawat(String nama) {
        System.out.print("Kapasitas orang: ");
        int kapasitas = InputUtil.readInt();
        System.out.print("Pesawat tempur? (1 = Ya, 0 = Tidak): ");
        int tempur = InputUtil.readInt();

        if (tempur != 0 && tempur != 1) {
            throw new IllegalArgumentException("Pilihan harus 0 atau 1.");
        }

        System.out.print("Jumlah roda: ");
        int roda = InputUtil.readInt();
        return new Pesawat(nama, kapasitas, tempur == 1, roda);
    }

    private void tampilkanKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            view.showMessage("Belum ada kendaraan.");
            return;
        }

        for (Kendaraan kendaraan : daftarKendaraan) {
            view.showKendaraan(kendaraan.getDetails());
        }
    }

    private void urutkanKendaraan() {
        daftarKendaraan.sort(
                Comparator.comparingInt(Kendaraan::getKapasitasOrang)
        );
        view.showKapasitasSorted();
        tampilkanKendaraan();
    }
}
