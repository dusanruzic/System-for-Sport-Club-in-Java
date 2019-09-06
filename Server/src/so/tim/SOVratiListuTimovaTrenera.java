/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tim;

import db.DBBroker;
import domen.IGeneralEntity;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOVratiListuTimovaTrenera extends OpstaSistemskaOperacija{
    
    private ArrayList<IGeneralEntity> lista;

    public ArrayList<IGeneralEntity> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        lista = DBBroker.getInstance().vratiPodUslovom((IGeneralEntity) odo);
    }
    
}
