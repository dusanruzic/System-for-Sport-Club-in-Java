/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.IGeneralEntity;

/**
 *
 * @author duler
 */
public abstract class OpstaSistemskaOperacija {
    
    public void izvrsi(Object odo) throws Exception {
        try {
          
            proveriPreduslov(odo);
            System.out.println("Tik pre izvrsenja konkretne sistemske operacije");
            izvrsiKonkretnuOperaciju(odo);
            System.out.println("Prosla sistemska op");
            potvrdi();
            System.out.println("Prosla portvrda");
        } catch (Exception ex) {
            ponisti();
            throw new Exception("Greska kod izvrsenja SO: " + ex.getMessage());
        }
    }

    
    protected abstract void proveriPreduslov(Object odo) throws Exception;

    protected abstract void izvrsiKonkretnuOperaciju(Object odo) throws Exception;

    
     
    private void potvrdi() throws Exception {
        db.DBBroker.getInstance().commitTransaction();
    }

    private void ponisti() throws Exception {
        db.DBBroker.getInstance().rollbackTransaction();
    }

    
}