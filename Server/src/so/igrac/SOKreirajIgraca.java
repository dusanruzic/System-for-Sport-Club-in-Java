/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.igrac;

import domen.IGeneralEntity;
import domen.Igrac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOKreirajIgraca extends OpstaSistemskaOperacija{

   IGeneralEntity e;
    
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Igrac)){
            throw new Exception("Sistem ne moze kreira igraca");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        e = db.DBBroker.getInstance().kreiraj((IGeneralEntity) odo);
    }

    public IGeneralEntity getE() {
        return e;
    }
    
}
