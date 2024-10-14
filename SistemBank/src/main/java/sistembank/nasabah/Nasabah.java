/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package sistembank.nasabah;

import sistembank.rekening.Rekening;
import sistembank.rekening.Tabungan;
import sistembank.rekening.Giro;
import sistembank.layanan.Layanan;
import sistembank.layanan.NasabahCRUD;
import java.util.ArrayList;
import java.util.List;

public class Nasabah extends Layanan implements NasabahCRUD {
    private final ArrayList<Rekening> nasabahList = new ArrayList<>();

    @Override
    public void tambahNasabah(Rekening rekening) {
        createNasabah(rekening);
    }

    @Override
    public Rekening temukanRekening(String nomorRekening) {
        return readNasabah(nomorRekening);
    }

    @Override
    public void lihatRekening() {
        if (nasabahList.isEmpty()) {
            System.out.println("=================================");
            System.out.println("Tidak Ada Nasabah Yang Terdaftar.");
            System.out.println("=================================");
        } else {
            System.out.println("Daftar Rekening Yang Terdaftar:");
            System.out.println("-------------------------------------------------------");
            System.out.printf("| %-15s | %-20s | %-10s |\n", "Nomor Rekening", "Nama Nasabah", "Saldo");
            System.out.println("-------------------------------------------------------");
            for (Rekening rekening : nasabahList) {
                System.out.printf("| %-15s | %-20s | %-10.2f |\n", 
                                  rekening.lihatNomorRekening(), 
                                  rekening.lihatNamaNasabah(), 
                                  rekening.lihatSaldo());
                if (rekening instanceof Tabungan) {
                    System.out.println("  (Jenis Rekening: Tabungan)");
                } else if (rekening instanceof Giro) {
                    System.out.println("  (Jenis Rekening: Giro, Limit Transaksi: " + ((Giro) rekening).lihatLimitTransaksi() + ")");
                }
            }
            System.out.println("-------------------------------------------------------");
        }
    }

    @Override
    public void setoranRekening(String nomorRekening, double jumlah) {
        Rekening rekening = temukanRekening(nomorRekening);
        if (rekening != null) {
            rekening.deposit(jumlah);
        } else {
            System.out.println("Rekening Tidak Ditemukan.");
        }
    }

    @Override
    public void hapusNasabah(String nomorRekening) {
        deleteNasabah(nomorRekening);
    }

    @Override
    public void createNasabah(Rekening rekening) {
        nasabahList.add(rekening);
        System.out.println("Berhasil Menambah Nasabah!");
    }

    @Override
    public List<Rekening> readAllNasabah() {
        return nasabahList;
    }

    @Override
    public Rekening readNasabah(String nomorRekening) {
        for (Rekening rekening : nasabahList) {
            if (rekening.lihatNomorRekening().equals(nomorRekening)) {
                return rekening;
            }
        }
        return null;
    }

    @Override
    public void updateNasabah(String nomorRekening, String namaNasabah) {
        Rekening rekening = readNasabah(nomorRekening);
        if (rekening != null) {
            rekening.setNamaNasabah(namaNasabah);
            System.out.println("Nama Nasabah berhasil diperbarui.");
        } else {
            System.out.println("Rekening Tidak Ditemukan.");
        }
    }

    @Override
    public void deleteNasabah(String nomorRekening) {
        Rekening rekening = readNasabah(nomorRekening);
        if (rekening != null) {
            nasabahList.remove(rekening);
            System.out.println("Rekening dengan nomor " + nomorRekening + " berhasil dihapus.");
        } else {
            System.out.println("Rekening Tidak Ditemukan.");
        }
    }
}