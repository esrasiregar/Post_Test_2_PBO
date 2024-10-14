/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistembank.layanan;

import sistembank.rekening.Rekening;

public abstract class Layanan {
    public abstract void tambahNasabah(Rekening rekening);
    
    public abstract Rekening temukanRekening(String nomorRekening);

    public abstract void lihatRekening();
    
    public abstract void setoranRekening(String nomorRekening, double jumlah);

    public abstract void hapusNasabah(String nomorRekening);
}
