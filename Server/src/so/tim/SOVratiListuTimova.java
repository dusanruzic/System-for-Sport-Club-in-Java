/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tim;

import db.DBBroker;
import domen.IGeneralEntity;
import domen.Tim;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOVratiListuTimova extends OpstaSistemskaOperacija{
    private ArrayList<IGeneralEntity> lista;

    public ArrayList<IGeneralEntity> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Tim)){
            throw new Exception("Sistem ne moze da vrati trenere");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        lista = DBBroker.getInstance().vratiSve((IGeneralEntity) odo);
    }
    
}
