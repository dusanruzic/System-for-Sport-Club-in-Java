/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.utakmica;

import domen.IGeneralEntity;
import domen.Utakmica;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOVratiListuUtakmica extends OpstaSistemskaOperacija {

    private ArrayList<IGeneralEntity> lista;

    public ArrayList<IGeneralEntity> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Utakmica)){
            throw new Exception("Sistem ne moze da vrati utakmice");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        lista = db.DBBroker.getInstance().vratiPodUslovom((IGeneralEntity) odo);

    }

}
