/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.trener;

import domen.IGeneralEntity;
import domen.Trener;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOVratiListuTrenera extends OpstaSistemskaOperacija {

    private ArrayList<IGeneralEntity> lista;

    public ArrayList<IGeneralEntity> getLista() {
        return lista;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        lista = db.DBBroker.getInstance().vratiPodUslovom((IGeneralEntity) odo);

    }

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(!(odo instanceof Trener)){
            throw new Exception("Sistem ne moze da vrati trenere");
        }
    }
}
