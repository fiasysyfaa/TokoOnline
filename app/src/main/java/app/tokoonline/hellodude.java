package app.tokoonline;

public class hellodude {
    private String nama_barang;
    private String harga;
    private String stok;
    private String kategori;
    private String deskripsi;


    public hellodude(String Namabarang,String Hargabarang,String jumlahbarang,String Kategoribarang, String Deskripsi) {
        this.nama_barang = Namabarang;
        this.harga = Hargabarang;
        this.stok = jumlahbarang;
        this.kategori = Kategoribarang;
        this.deskripsi = Deskripsi;
    }

    public String getNamabarang() {
        return nama_barang;
    }
    public String getHargabarang() {
        return harga;
    }
    public String getjumlahbarang() {
        return stok;
    }
    public String getKategoribarang() {
        return kategori;
    }
    public String getDeskripsi() {
        return deskripsi;
    }

}
