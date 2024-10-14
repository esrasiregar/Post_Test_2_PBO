/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistembank.layanan;

import sistembank.rekening.Rekening;
import java.util.List;

public interface NasabahCRUD {
    
    void createNasabah(Rekening rekening);
    
    List<Rekening> readAllNasabah();

    Rekening readNasabah(String nomorRekening);
    
    void updateNasabah(String nomorRekening, String namaNasabah);
    
    void deleteNasabah(String nomorRekening);
}