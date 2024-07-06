package PBO;

import java.util.Scanner;

public class PerpustakaanApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perpustakaan perpustakaan = new Perpustakaan(100); // Perpustakaan dengan kapasitas 100 buku

        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\nSistem Manajemen Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Semua Buku");
            System.out.println("3. Cari Buku Berdasarkan Judul");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                continue;
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
        }

        scanner.close();
    }
}