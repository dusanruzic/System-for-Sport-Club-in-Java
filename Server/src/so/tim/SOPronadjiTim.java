///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package so.tim;
//
//import domen.IGeneralEntity;
//import so.OpstaSistemskaOperacija;
//
///**
// *
// * @author duler
// */
//public class SOPronadjiTim extends OpstaSistemskaOperacija{
//    
//    private IGeneralEntity e;
//
//    @Override
//    protected void proveriPreduslov(IGeneralEntity odo) throws Exception {
//    }
//
//    @Override
//    protected void izvrsiKonkretnuOperaciju(IGeneralEntity odo) throws Exception {
//        e = db.DBBroker.getInstance().vratiJednog(odo);
//    }
//
//    public IGeneralEntity getEntity() {
//        return e;
//    }
//    
//}
