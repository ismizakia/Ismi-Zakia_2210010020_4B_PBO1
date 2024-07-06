package PBO;

class Perpustakaan extends Buku {
    private Buku[] bukuBuku;
    private int jumlahBuku;

    // Konstruktor
    public Perpustakaan(int kapasitas) {
        super("", "", 0);  // Memanggil konstruktor kelas induk
        bukuBuku = new Buku[kapasitas];
        jumlahBuku = 0;
    }

    // Metode untuk menambahkan buku
    public void tambahkanBuku(Buku buku) {
        if (jumlahBuku < bukuBuku.length) {
            bukuBuku[jumlahBuku] = buku;
            jumlahBuku++;
        } else {
            System.out.println("Perpustakaan penuh, tidak bisa menambahkan buku lagi.");
        }
    }

    // Metode untuk menampilkan semua buku
    public void tampilkanSemuaBuku() {
        for (int i = 0; i < jumlahBuku; i++) {
            bukuBuku[i].tampilkanInfoBuku();
        }
    }

    // Metode untuk mencari buku berdasarkan judul
    public Buku cariBukuBerdasarkanJudul(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (bukuBuku[i].getJudul().equalsIgnoreCase(judul)) {
                return bukuBuku[i];
            }
        }
        return null;
    }
}