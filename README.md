# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data mahasiswa menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa nama dan NPM mahasiswa, dan memberikan output berupa informasi detail dari NPM tersebut seperti tahun masuk, fakultas, program studi, dan nomor registrasi.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Buku`, `EBook`, `Perpustakaan` dan `PerpustakaanApp` adalah contoh dari class.

```bash
public class Buku {
    ...
}

public class EBook extends Buku {
    ...
}

public class Perpustakaan {
    ...
}

public class PerpustakaanApp {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `Buku bukuBaru = new Buku(judul, penulis, tahun);` adalah contoh pembuatan object.

```bash
Buku bukuBaru = new Buku(judul, penulis, tahun);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `Judul`, `Penulis`, dan `Tahun` adalah contoh atribut.

```bash
String Judul;
String Penulis;
Int Tahun;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Buku` dan `EBook`.

```bash
public Buku(String judul, String penulis, int tahun) {
    this.judul = judul;
    this.penulis = penulis;
    this.tahun = tahun;
}

public EBook(String judul, String penulis, int tahun, String formatFile) {
    super(judul, penulis, tahun); // Memanggil konstruktor dari kelas induk (superclass)
    this.formatFile = formatFile;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setJudul`, `setPenulis` dan `setTahun` adalah contoh method mutator.

```bash
public void setJudul(String judul) {
    this.judul = judul;
}

public void setPenulis(String penulis) {
    this.penulis = penulis;
}

public void setTahun(int tahun) {
    this.tahun = tahun;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getJudul`, `getPenulis`, dan `getTahun` adalah contoh method accessor.

```bash
public String getJudul() {
    return judul;
}

public String getPenulis() {
    return penulis;
}

public int getTahun() {
    return tahun;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `judul`, `penulis`, dan `tahun` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String judul;
private String penulis;
private String tahun;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `Ebook` mewarisi `Buku` dengan sintaks `extends`.

```bash
public class EBook extends Buku {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `tampilkanInfoBuku()` di `Buku` merupakan overloading method `tampilkanInfoBuku` dan `tampilkanInfoBuku` di `EBook` merupakan override dari method `tampilkanInfoBuku()` di `Buku`.

```bash
class Buku {
    public void tampilkanInfoBuku() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis + ", Tahun: " + tahun);
    }
}

class EBook extends Buku {
    private String formatFile;

    @Override
    public void tampilkanInfoBuku() {
        super.tampilkanInfoBuku(); // Memanggil metode dari kelas induk
        System.out.println("Format File: " + formatFile);
    }
}

// Dalam aplikasi utama, ketika menggunakan kelas PerpustakaanApp
// Pada bagian pilihan 1 untuk menambah buku, kita membuat objek EBook:
Buku bukuBaru = new EBook(judul, penulis, tahun, formatFile); // Polimorfisme terjadi di sini

```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `cariBukuBerdasarkanJudul` dan seleksi `switch` dalam kelas `PerpustakaanApp`.

```bash
public Buku cariBukuBerdasarkanJudul(String judul) {
    for (int i = 0; i < jumlahBuku; i++) {
        if (bukuBuku[i].getJudul().equalsIgnoreCase(judul)) {
            return bukuBuku[i];
        }
    }
    return null;
}

switch (pilihan) {
    case 1:
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = scanner.nextLine();
        int tahun = 0;
        while (true) {
            System.out.print("Masukkan tahun terbit: ");
            try {
                tahun = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tahun tidak valid. Harap masukkan angka yang benar.");
            }
        }
        Buku bukuBaru = new Buku(judul, penulis, tahun);
        perpustakaan.tambahkanBuku(bukuBaru);
        break;

    case 2:
        perpustakaan.tampilkanSemuaBuku();
        break;

    case 3:
        System.out.print("Masukkan judul buku yang dicari: ");
        String judulCari = scanner.nextLine();
        Buku bukuDitemukan = perpustakaan.cariBukuBerdasarkanJudul(judulCari);
        if (bukuDitemukan != null) {
            bukuDitemukan.tampilkanInfoBuku();
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
        break;

    case 4:
        berjalan = false;
        System.out.println("Keluar dari sistem...");
        break;

    default:
        System.out.println("Pilihan tidak valid. Harap pilih opsi yang benar.");
        break;
}

```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk meminta input dan menampilkan data.

```bash
for (int i = 0; i < jumlahBuku; i++) {
        if (bukuBuku[i].getJudul().equalsIgnoreCase(judul)) {
            return bukuBuku[i];
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
System.out.print("Masukkan judul buku: ");
String judul = scanner.nextLine();
System.out.print("Masukkan penulis buku: ");
String penulis = scanner.nextLine();

System.out.println("\nSistem Manajemen Perpustakaan:");
System.out.println("1. Tambah Buku");
System.out.println("2. Lihat Semua Buku");
System.out.println("3. Cari Buku Berdasarkan Judul");
System.out.println("4. Keluar");
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `bukuBuku = new Buku[kapasitas];` adalah contoh penggunaan array.

```bash
bukuBuku = new Buku[kapasitas];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
int pilihan = 0;
try {
    pilihan = Integer.parseInt(scanner.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Input tidak valid. Harap masukkan angka.");
    continue;
}

```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Ismi Zakia
NPM: 2210010020
