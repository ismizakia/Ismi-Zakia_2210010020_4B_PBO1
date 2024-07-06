package PBO;

public class Buku {
    // Atribut (Enkapsulasi dengan modifier akses private)
    private String judul;
    private String penulis;
    private int tahun;

    // Konstruktor
    public Buku(String judul, String penulis, int tahun) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    // Aksesors (Getters)
    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahun() {
        return tahun;
    }

    // Mutators (Setters)
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    // Metode untuk menampilkan informasi buku
    public void tampilkanInfoBuku() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis + ", Tahun: " + tahun);
    }
}