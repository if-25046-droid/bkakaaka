public abstract class MenuItem {
    protected String id;
    protected String nama;
    protected double hargaBase;
    protected int stok;

    public abstract double hitungHargaTotal();
    public abstract String getOrderDetail();

    // 1. Berdasarkan jumlah
    public double hitungHargaTotal(int jumlah) {
        return hitungHargaTotal() * jumlah;
    }

    // 2. Berdasarkan jumlah dan promo
    public double hitungHargaTotal(
            int jumlah, String kodePromo) {

        double total = hitungHargaTotal(jumlah);

        if ("HEMAT10".equalsIgnoreCase(kodePromo)) {
            total *= 0.9;
        }

        return total;
    }

    // 3. Berdasarkan jumlah dan ukuran
    public double hitungHargaTotal(
            int jumlah, EnumUkuran ukuran) {

        double harga = hitungHargaTotal();

        switch (ukuran) {
            case SMALL:
                break;
            case MEDIUM:
                harga += 3000;
                break;
            case LARGE:
                harga += 5000;
                break;
        }

        return harga * jumlah;
    }
}
