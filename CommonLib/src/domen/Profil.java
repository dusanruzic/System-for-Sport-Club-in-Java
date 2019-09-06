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
public class Profil implements IGeneralEntity {

    private String korisnickoIme;
    private String korisnickaLozinka;

    public Profil() {
    }

    public Profil(String korisnickoIme, String korisnickaLozinka) {
        this.korisnickoIme = korisnickoIme;
        this.korisnickaLozinka = korisnickaLozinka;
    }

    public String getKorisnickaLozinka() {
        return korisnickaLozinka;
    }

    public void setKorisnickaLozinka(String korisnickaLozinka) {
        this.korisnickaLozinka = korisnickaLozinka;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
        return korisnickoIme;
    }

    @Override
    public String vratiImeTabele() {
        return "profil";
    }

    @Override
    public String vratiImenaKolona() {
        return "korisnickoIme, korisnickaLozinka";
    }

    @Override
    public String vratiUslovPretrage() {
        return null;
    }

    @Override
    public String poveziTabele() {
        return " * from profil";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {
        String korisnickoIme = rs.getString("korisnickoIme");
        String korisnickaLozinka = rs.getString("korisnickaLozinka");

        Profil profil = new Profil(korisnickoIme, korisnickaLozinka);
        
        return profil;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + korisnickoIme + "','" + korisnickaLozinka + "'";
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
        return "'" + korisnickoIme + "','" + korisnickaLozinka + "'";
    }

    @Override
    public String vratiImenaKolonaZaCreate() {
        return "korisnickoIme, korisnickaLozinka";
    }

    @Override
    public IGeneralEntity vratiObjekatPriOdustani(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
