/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.igrac;

import db.DBBroker;
import domen.IGeneralEntity;
import domen.Igrac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOObrisiIgraca extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        DBBroker.getInstance().izbrisi((Igrac) odo);
    }
    
}
