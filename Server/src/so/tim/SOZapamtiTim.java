/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tim;

import domen.IGeneralEntity;
import domen.Tim;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOZapamtiTim extends OpstaSistemskaOperacija{

    private IGeneralEntity e;
    
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Tim)){
            throw new Exception("Sistem ne moze da kreira tim");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        db.DBBroker.getInstance().update((IGeneralEntity) odo);
    }

    public IGeneralEntity getEntity() {
        return e;
    }

}