/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pozicija;

import domen.IGeneralEntity;
import domen.Pozicija;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOVratiListuPozicija extends OpstaSistemskaOperacija{

    private ArrayList<IGeneralEntity> lista;

    public ArrayList<IGeneralEntity> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Pozicija)){
            throw new Exception("Sistem ne moze vrati pozicije");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        
         lista = db.DBBroker.getInstance().vratiPodUslovom((IGeneralEntity) odo);
    }
    
}
