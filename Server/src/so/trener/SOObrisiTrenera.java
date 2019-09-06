/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.trener;

import db.DBBroker;
import domen.IGeneralEntity;
import domen.Trener;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOObrisiTrenera extends OpstaSistemskaOperacija{
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        DBBroker.getInstance().izbrisi((Trener) odo);
    }
}
