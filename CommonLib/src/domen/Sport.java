/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duler
 */
public class Sport implements IGeneralEntity {

    private int sifraSporta;
    private String nazivSporta;

    public Sport() {
    }

    public Sport(int sifraSporta, String nazivSporta) {
        this.sifraSporta = sifraSporta;
        this.nazivSporta = nazivSporta;
    }

    public String getNazivSporta() {
        return nazivSporta;
    }

    public void setNazivSporta(String nazivSporta) {
        this.nazivSporta = nazivSporta;
    }

    public int getSifraSporta() {
        return sifraSporta;
    }

    public void setSifraSporta(int sifraSporta) {
        this.sifraSporta = sifraSporta;
    }

    @Override
    public String toString() {
        return nazivSporta;
    }

    @Override
    public String vratiImeTabele() {
        return "sport";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraSporta, nazivSporta";
    }

    @Override
    public String vratiUslovPretrage() {
        return "sp.sifraSporta = " + getSifraSporta();
    }

    @Override
    public String poveziTabele() {
        return " * from sport";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {
        int sifraSporta = rs.getInt("sifraSporta");
        String nazivSporta = rs.getString("nazivSporta");
        Sport sport = new Sport(sifraSporta, nazivSporta);
        return sport;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + sifraSporta + "','" + nazivSporta + "'";
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sport other = (Sport) obj;
        if (this.sifraSporta != other.sifraSporta) {
            return false;
        }
        return true;
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
