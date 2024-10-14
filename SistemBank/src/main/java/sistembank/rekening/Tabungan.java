/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistembank.rekening;

public class Tabungan extends Rekening {
    private final double bunga;

    public Tabungan(String nomorRekening, String namaNasabah, double setoranAwal, double bunga) {
        super(nomorRekening, namaNasabah, setoranAwal);
        this.bunga = bunga;
    }

    public void tambahBunga() {
        double jumlahBunga = lihatSaldo() * (bunga / 100);
        deposit(jumlahBunga);
        System.out.println("Bunga sebesar " + jumlahBunga + " berhasil ditambahkan ke saldo.");
    }
}