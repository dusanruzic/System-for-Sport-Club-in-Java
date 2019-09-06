/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author duler
 */
public class Pozicija implements IGeneralEntity {

    private int sifraPozicije;
    private String nazivPozicije;
    private Sport sport;

    public Pozicija() {
    }

    public Pozicija(int sifraPozicije, String nazivPozicije, Sport sport) {
        this.sifraPozicije = sifraPozicije;
        this.nazivPozicije = nazivPozicije;
        this.sport = sport;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getSifraPozicije() {
        return sifraPozicije;
    }

    public void setSifraPozicije(int sifraPozicije) {
        this.sifraPozicije = sifraPozicije;
    }

    public String getNazivPozicije() {
        return nazivPozicije;
    }

    public void setNazivPozicije(String nazivPozicije) {
        this.nazivPozicije = nazivPozicije;
    }

    @Override
    public String toString() {
        return nazivPozicije + " (" + sport.getNazivSporta() + ")";
    }

    @Override
    public String vratiImeTabele() {
        return "pozicija";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraPozicije, nazivPozicije, sifraSporta";
    }

    @Override
    public String vratiUslovPretrage() {
        return "sp.sifraSporta = " + getSport().getSifraSporta();
    }

    @Override
    public String poveziTabele() {
        return " * from sport sp join pozicija po on sp.sifraSporta = po.sifraSporta";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {
        int sifraPozicije = rs.getInt("sifraPozicije");
        String nazivPozicije = rs.getString("nazivPozicije");
        Pozicija pozicija = new Pozicija(sifraPozicije, nazivPozicije, sport);
        return pozicija;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + sifraPozicije + "','" + nazivPozicije + "'," + sport.getSifraSporta() + "'" ;
    }

    @Override
    public String vratiUslovZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaBrisanje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<IGeneralEntity> vratiListu(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiKolonaZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiAtributZaPoslednji() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object vratiPoslednji(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiKolonaZaCreate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImenaKolonaZaCreate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IGeneralEntity vratiObjekatPriOdustani(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
