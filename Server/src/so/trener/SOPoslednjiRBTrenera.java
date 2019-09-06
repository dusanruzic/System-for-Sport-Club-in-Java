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
public class SOPoslednjiRBTrenera extends OpstaSistemskaOperacija{

    private Object rb;
   
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        rb = db.DBBroker.getInstance().poslednji((Trener)odo);
    }
    
    public Object getRb(){
        return rb;
    }
    
}
