/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistembank.rekening;

public class Giro extends Rekening {
    private final double limitTransaksi;

    public Giro(String nomorRekening, String namaNasabah, double setoranAwal, double limitTransaksi) {
        super(nomorRekening, namaNasabah, setoranAwal);
        this.limitTransaksi = limitTransaksi;
    }

    @Override
    public void deposit(double jumlah) {
        if (jumlah > limitTransaksi) {
            System.out.println("Setoran gagal, jumlah melebihi limit transaksi: " + limitTransaksi);
        } else {
            super.deposit(jumlah);
        }
    }

    public double lihatLimitTransaksi() {
        return limitTransaksi;
    }
}