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
public class Menadzer implements IGeneralEntity {

    private int sifraMenadzera;
    private String ime;
    private String prezime;
    private String jmbg;
    private double plata;
    private Profil profil;

    public Menadzer() {
    }

    public Menadzer(int sifraTrenera, String ime, String prezime, String jmbg, double plata, Profil profil) {
        this.sifraMenadzera = sifraTrenera;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.plata = plata;
        this.profil = profil;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public int getSifraMenadzera() {
        return sifraMenadzera;
    }

    public void setSifraMenadzera(int sifraTrenera) {
        this.sifraMenadzera = sifraTrenera;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Menadzer other = (Menadzer) obj;
        if (this.sifraMenadzera != other.sifraMenadzera) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiImeTabele() {
        return "menadzer";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraMenadzera, ime, prezime, jmbg, plata, korisnickoIme";
    }

    @Override
    public String vratiUslovPretrage() {
        return "korisnickoIme = " + getProfil().getKorisnickoIme() + " && korisnickaLozinka = " + getProfil().getKorisnickaLozinka();
    }

    @Override
    public String poveziTabele() {
        return " * from menadzer me join profil pr on me.korisnickoIme = pr.korisnickoIme";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {
        int sifra = rs.getInt("sifraMenadzera");
        String ime = rs.getString("ime");
        String prezime = rs.getString("prezime");
        String jmbg = rs.getString("jmbg");
        double plata = rs.getDouble("plata");
        String korisnickoIme = rs.getString("korisnickoIme");
        String korisnickaLozinka = rs.getString("korisnickaLozinka");

        Profil profil = new Profil(korisnickoIme, korisnickaLozinka);

        Menadzer menadzer = new Menadzer(sifra, ime, prezime, jmbg, plata, profil);
        
        return menadzer;
    }

    @Override
    public String vratiVrednostiKolona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
