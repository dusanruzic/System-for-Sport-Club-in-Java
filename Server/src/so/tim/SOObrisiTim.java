/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tim;

import db.DBBroker;
import domen.IGeneralEntity;
import domen.Tim;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOObrisiTim extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        DBBroker.getInstance().izbrisi((Tim) odo);
    }
    
}
