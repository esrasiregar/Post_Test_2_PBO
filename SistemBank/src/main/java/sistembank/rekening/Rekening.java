/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistembank.rekening;

public class Rekening {
    private final String nomorRekening;
    private String namaNasabah;
    private double totalSaldo;
    
    public static int totalRekening = 0;

    public Rekening(String nomorRekening, String namaNasabah, double setoranAwal) {
        this.nomorRekening = nomorRekening;
        this.namaNasabah = namaNasabah;
        this.totalSaldo = setoranAwal;
        totalRekening++;
    }

    public void deposit(double jumlah) {
        if (jumlah > 0) {
            this.totalSaldo += jumlah;
            System.out.println("Setoran berhasil. Saldo Baru: " + this.totalSaldo);
        } else {
            System.out.println("Jumlah setoran tidak valid.");
        }
        System.out.println("====================================");
    }

    public String lihatNomorRekening() {
        return nomorRekening;
    }

    public String lihatNamaNasabah() {
        return namaNasabah;
    }

    public double lihatSaldo() {
        return totalSaldo;
    }
    
    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }
}