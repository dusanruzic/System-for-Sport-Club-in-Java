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
public class Trener implements IGeneralEntity {

    private int sifraTrenera;
    private String ime;
    private String prezime;
    private String jmbg;
    private double plata;
    private boolean daLiJeAktivanTrener;
    private Profil profil;
    private Sport sport;

    public Trener() {
    }

    public Trener(int sifraTrenera, String ime, String prezime, String jmbg, double plata, boolean daLiJeAktivanTrener, Profil profil, Sport sport) {
        this.sifraTrenera = sifraTrenera;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.plata = plata;
        this.daLiJeAktivanTrener = daLiJeAktivanTrener;
        this.profil = profil;
        this.sport = sport;
    }

    public Trener(int sifra) {
        this.sifraTrenera = sifra;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getSifraTrenera() {
        return sifraTrenera;
    }

    public void setSifraTrenera(int sifraTrenera) {
        this.sifraTrenera = sifraTrenera;
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

    public boolean getDaLiJeAktivanTrener() {
        return daLiJeAktivanTrener;
    }

    public void setDaLiJeAktivanTrener(boolean daLiJeAktivanTrener) {
        this.daLiJeAktivanTrener = daLiJeAktivanTrener;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
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
        final Trener other = (Trener) obj;
        if (this.sifraTrenera != other.sifraTrenera) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiImeTabele() {
        return "trener";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraTrenera, imeTrenera, prezimeTrenera, jmbgTrenera, plataTrenera, daLiJeAktivanTrener, korisnickoIme, sifraSporta";
    }

    @Override
    public String vratiUslovPretrage() {
        return "sp.sifraSporta = " + getSport().getSifraSporta();
    }

    @Override
    public String poveziTabele() {
        return " * from trener tr join profil pr on tr.korisnickoIme = pr.korisnickoIme join sport sp on tr.sifraSporta = sp.sifraSporta";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {
        int sifra = rs.getInt("sifraTrenera");
        String ime = rs.getString("imeTrenera");
        String prezime = rs.getString("prezimeTrenera");
        String jmbg = rs.getString("jmbgTrenera");
        double plata = rs.getDouble("plataTrenera");
        boolean daLiJeAktivanTrener = rs.getBoolean("daLiJeAktivanTrener");
        int sifraSporta = rs.getInt("sifraSporta");
        String nazivSporta = rs.getString("nazivSporta");

        String korisnickoIme = rs.getString("korisnickoIme");
        String korisnickaLozinka = rs.getString("korisnickaLozinka");

        Profil profil = new Profil(korisnickoIme, korisnickaLozinka);
        Sport sport = new Sport(sifraSporta, nazivSporta);

        Trener trener = new Trener(sifra, ime, prezime, jmbg, plata, daLiJeAktivanTrener, profil, sport);
        return trener;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + sifraTrenera + "','" + ime + "','" + prezime + "','" + jmbg + "','" + plata + "','" + (daLiJeAktivanTrener ? 1 : 0) + "','" + profil.getKorisnickoIme() + "','" + sport.getSifraSporta() + "'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "sifraTrenera= '" + sifraTrenera + "'";
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return "sifraTrenera = " + sifraTrenera;
    }

    @Override
    public ArrayList<IGeneralEntity> vratiListu(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiKolonaZaUpdate() {
        return "imeTrenera= '" + ime + "', prezimeTrenera= '" + prezime +  "', jmbgTrenera= '" + jmbg + "', plataTrenera= " + plata + ", daLiJeAktivanTrener= '" + (daLiJeAktivanTrener ? 1 : 0) + "', korisnickoIme= '" + profil.getKorisnickoIme() + "', sifraSporta=" + sport.getSifraSporta() ;
    }

    @Override
    public String vratiAtributZaPoslednji() {
        return "sifraTrenera";
    }

    @Override
    public Object vratiPoslednji(ResultSet rs) throws Exception {
        int broj = 0;
        while (rs.next()){
            broj = rs.getInt(1);
        }
        return broj;
    }

    @Override
    public String vratiVrednostiKolonaZaCreate() {
        return " " + sifraTrenera;
    }

    @Override
    public String vratiImenaKolonaZaCreate() {
        return "sifraTrenera";
    }

    @Override
    public IGeneralEntity vratiObjekatPriOdustani(ResultSet rs) throws Exception {
        System.out.println("pri odustani pocetak");

        //int sifra = rs.getInt("sifraTima");
        
        //String nazivTima = rs.getString("nazivTima");
               
        System.out.println("pri odustani pred kraj");
        
        Trener trener = new Trener();
        return trener;
    }

}
