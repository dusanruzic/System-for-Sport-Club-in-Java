/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.statistika;

import domen.IGeneralEntity;
import domen.StatistikaIgracaSaUtakmice;
import java.util.ArrayList;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOZapamtiStatistike extends OpstaSistemskaOperacija{

    @Override
    protected void proveriPreduslov(Object odo) throws Exception {
        if(odo == null){
            throw new Exception("Sistem ne moze da zapamti statistike");
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        ArrayList<StatistikaIgracaSaUtakmice> lista = (ArrayList<StatistikaIgracaSaUtakmice>) odo;
        for (StatistikaIgracaSaUtakmice statistika : lista) {
            db.DBBroker.getInstance().kreiraj((IGeneralEntity) statistika);
        }
        
    }

}