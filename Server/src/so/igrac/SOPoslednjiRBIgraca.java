/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.igrac;

import domen.IGeneralEntity;
import domen.Igrac;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author duler
 */
public class SOPoslednjiRBIgraca extends OpstaSistemskaOperacija{

    private Object rb;
    
    @Override
    protected void proveriPreduslov(Object odo) throws Exception {

    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object odo) throws Exception {
        rb = db.DBBroker.getInstance().poslednji((Igrac)odo);

    }
    
    public Object getRb(){
        return rb;
    }
    
}
