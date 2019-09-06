/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sport;

import domen.IGeneralEntity;
import domen.Sport;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOVratiListuSportova extends OpstaSistemskaOperacija{
    private ArrayList<IGeneralEntity> lista;

    public ArrayList<IGeneralEntity> getLista() {
        return lista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        lista = db.DBBroker.getInstance().vratiSve((IGeneralEntity) odo);
    }

    

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Sport)){
            throw new Exception("Sistem ne moze da vrati sportove");
        }
    }
}
