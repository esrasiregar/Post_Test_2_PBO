/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistembank;

import sistembank.nasabah.Nasabah;
import sistembank.rekening.Tabungan;
import sistembank.rekening.Giro;
import java.util.Scanner;

public class SistemBank { 
    public static void main(String[] args) {
        Nasabah nasabah = new Nasabah();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Selamat Datang di Dashboard Bank ---");
            System.out.println("1. Tambah Nasabah");
            System.out.println("2. Lihat Rekening");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Hapus Nasabah");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1 -> {
                    System.out.print("Masukkan Nomor Rekening: ");
                    String nomorRekening = scanner.next();
                    System.out.print("Masukkan Nama Nasabah: ");
                    String namaNasabah = scanner.next();
                    System.out.print("Masukkan Setoran Awal: ");
                    double setoranAwal = scanner.nextDouble();

                    // Tambahkan opsi untuk memilih jenis rekening
                    System.out.println("Pilih Jenis Rekening:");
                    System.out.println("1. Tabungan");
                    System.out.println("2. Giro");
                    int pilihanRekening = scanner.nextInt();

                    if (pilihanRekening == 1) {
                        System.out.print("Masukkan Bunga (%): ");
                        double bunga = scanner.nextDouble();
                        nasabah.tambahNasabah(new Tabungan(nomorRekening, namaNasabah, setoranAwal, bunga));
                    } else if (pilihanRekening == 2) {
                        System.out.print("Masukkan Limit Transaksi: ");
                        double limitTransaksi = scanner.nextDouble();
                        nasabah.tambahNasabah(new Giro(nomorRekening, namaNasabah, setoranAwal, limitTransaksi));
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }
                case 2 -> nasabah.lihatRekening();
                case 3 -> {
                    System.out.print("Masukkan Nomor Rekening: ");
                    String nomorRekSetor = scanner.next();
                    System.out.print("Masukkan Jumlah Setoran: ");
                    double jumlahSetoran = scanner.nextDouble();
                    nasabah.setoranRekening(nomorRekSetor, jumlahSetoran);
                }
                case 4 -> {
                    System.out.print("Masukkan Nomor Rekening yang Ingin Dihapus: ");
                    String nomorRekeningHapus = scanner.next();
                    nasabah.hapusNasabah(nomorRekeningHapus);
                }
                case 5 -> {
                    System.out.println("Sampai Jumpa...");
                    exit = true;
                }
                default -> System.out.println("Pilihan Tidak Valid. Silahkan Coba Lagi.");
            }
        }
    }
}