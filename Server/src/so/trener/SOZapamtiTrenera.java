/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.trener;

import domen.IGeneralEntity;
import domen.Trener;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOZapamtiTrenera extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Trener)){
            throw new Exception("Sistem ne moze da zapamti trenera");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        db.DBBroker.getInstance().update((IGeneralEntity) odo);
    }

}
