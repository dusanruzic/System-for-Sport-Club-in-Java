/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author duler
 */
public class Igrac implements IGeneralEntity {

    private int sifraIgraca;
    private String ime;
    private String prezime;
    private String jmbg;
    private double plata;
    private boolean daLiJeKapiten;
    private Date datumRodjenja;
    private boolean daLiJeAktivanIgrac;
    private Tim tim;
    private Pozicija pozicija;

    public Igrac() {
    }

    public Igrac(int sifraIgraca, String ime, String prezime, String jmbg, double plata, boolean daLiJeKapiten, Date datumRodjenja, boolean daLiJeAktivanIgrac, Tim tim, Pozicija pozicija) {
        this.sifraIgraca = sifraIgraca;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.plata = plata;
        this.daLiJeKapiten = daLiJeKapiten;
        this.datumRodjenja = datumRodjenja;
        this.daLiJeAktivanIgrac = daLiJeAktivanIgrac;
        this.tim = tim;
        this.pozicija = pozicija;
    }

    public Igrac(int sifra) {
        this.sifraIgraca = sifra;
    }

    public Pozicija getPozicija() {
        return pozicija;
    }

    public void setPozicija(Pozicija pozicija) {
        this.pozicija = pozicija;
    }

    public int getSifraIgraca() {
        return sifraIgraca;
    }

    public void setSifraIgraca(int sifraIgraca) {
        this.sifraIgraca = sifraIgraca;
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

    public boolean getDaLiJeKapiten() {
        return daLiJeKapiten;
    }

    public void setDaLiJeKapiten(boolean daLiJeKapiten) {
        this.daLiJeKapiten = daLiJeKapiten;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public boolean getDaLiJeAktivanIgrac() {
        return daLiJeAktivanIgrac;
    }

    public void setDaLiJeAktivanIgrac(boolean daLiJeAktivanIgrac) {
        this.daLiJeAktivanIgrac = daLiJeAktivanIgrac;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiImeTabele() {
        return "igrac";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraIgraca, imeIgraca, prezimeIgraca, jmbgIgraca, plataIgraca, daLiJeKapiten, datumRodjenja, daLiJeAktivanIgrac, sifraTima, sifraPozicije";
    }

    @Override
    public String vratiUslovPretrage() {
        if (getPozicija() != null) {
            return "sp.sifraSporta = " + getPozicija().getSport().getSifraSporta() + " && ig.prezimeIgraca like '" + getPrezime() + "%'" + " && daLiJeAktivanIgrac = " + true;

        } 
        else {
            return "ti.sifraTima = " + getTim().getSifraTima() + " && daLiJeAktivanIgrac = " + true;
        }
    }
    


    @Override
    public String poveziTabele() {
        return " * from igrac ig JOIN tim ti ON ig.`sifraTima`=ti.`sifraTima` JOIN trener tr ON ti.`sifraTrenera`=tr.`sifraTrenera` JOIN profil pr ON tr.`korisnickoIme`=pr.`korisnickoIme` JOIN pozicija po ON ig.`sifraPozicije`=po.`sifraPozicije` JOIN sport sp ON po.`sifraSporta`=sp.`sifraSporta`";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {
        int sifraIgraca = rs.getInt("sifraIgraca");
        String imeIgraca = rs.getString("imeIgraca");
        String prezimeIgraca = rs.getString("prezimeIgraca");
        String JMBGIgraca = rs.getString("jmbgIgraca");
        double plataIgraca = rs.getDouble("plataIgraca");
        boolean daLiJeKapiten = rs.getBoolean("daLiJeKapiten");
        java.sql.Date datumRodjenja = rs.getDate("datumRodjenja");
        boolean daLiJeAktivanIgrac = rs.getBoolean("daLiJeAktivanIgrac");

        int sifraTima = rs.getInt("sifraTima");
        String nazivTima = rs.getString("nazivTima");
        int brojDobijenihUtakmica = rs.getInt("brojDobijenihUtakmica");
        int brojIzgubljenihUtakmica = rs.getInt("brojIzgubljenihUtakmica");
        int brojNeresenihUtakmica = rs.getInt("brojNeresenihUtakmica");
        boolean daLiJeAktivanTim = rs.getBoolean("daLiJeAktivanTim");

        int sifraTrenera = rs.getInt("sifraTrenera");
        String imeTrenera = rs.getString("imeTrenera");
        String prezimeTrenera = rs.getString("prezimeTrenera");
        String JMBGTrenera = rs.getString("jmbgTrenera");
        double plataTrenera = rs.getDouble("plataTrenera");
        String korisnickoIme = rs.getString("korisnickoIme");
        boolean daLiJeAktivanTrener = rs.getBoolean("daLiJeAktivanTrener");
        String korisnickaLozinka = rs.getString("korisnickaLozinka");
        Profil profil = new Profil(korisnickoIme, korisnickaLozinka);

        int sifraSporta = rs.getInt("sifraSporta");
        String nazivSporta = rs.getString("nazivSporta");
        Sport sport = new Sport(sifraSporta, nazivSporta);

        int sifraPozicije = rs.getInt("sifraPozicije");
        String nazivPozicije = rs.getString("nazivPozicije");
        Pozicija pozicija = new Pozicija(sifraPozicije, nazivPozicije, sport);
        Trener trener = new Trener(sifraTrenera, imeTrenera, prezimeTrenera, JMBGTrenera, plataTrenera, daLiJeAktivanTrener, profil, sport);
        Tim tim = new Tim(sifraTima, nazivTima, brojDobijenihUtakmica, brojIzgubljenihUtakmica, brojNeresenihUtakmica, this.daLiJeAktivanIgrac, trener);

        Igrac igrac = new Igrac(sifraIgraca, imeIgraca, prezimeIgraca, JMBGIgraca, plataIgraca, daLiJeKapiten, new Date(datumRodjenja.getTime()), daLiJeAktivanIgrac, tim, pozicija);
        return igrac;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + sifraIgraca + "','" + ime + "','" + prezime + "','" + jmbg + "','" + plata + "','" + (daLiJeKapiten ? 1 : 0) + "','" + new java.sql.Date(datumRodjenja.getTime()) +  "','" + (daLiJeAktivanIgrac ? 1 : 0) + "','" + tim.getSifraTima() + "','" + pozicija.getSifraPozicije() + "'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "sifraIgraca= '" + sifraIgraca + "'";
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return " sifraIgraca= " + sifraIgraca;
    }

    @Override
    public ArrayList<IGeneralEntity> vratiListu(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiKolonaZaUpdate() {
        return "imeIgraca= '" + ime + "', prezimeIgraca= '" + prezime + "', jmbgIgraca= '" + jmbg + "', plataIgraca= '" + plata + "', daLiJeKapiten= '" + (daLiJeKapiten ? 1 : 0) + "', datumRodjenja= '" + new java.sql.Date(datumRodjenja.getTime()) + "', daLiJeAktivanIgrac= '" + (daLiJeAktivanIgrac ? 1 : 0) + "', sifraTima= '" + tim.getSifraTima() + "', sifraPozicije= '" + pozicija.getSifraPozicije() + "'";                
    } 

    @Override
    public String vratiAtributZaPoslednji() {
        return "sifraIgraca";
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
        
        return " " + sifraIgraca;
    }
    

    @Override
    public String vratiImenaKolonaZaCreate() {
        return "sifraIgraca";
    }

    @Override
    public IGeneralEntity vratiObjekatPriOdustani(ResultSet rs) throws Exception {
        System.out.println("pri odustani pocetak");

               
        System.out.println("pri odustani pred kraj");
        
        Igrac igrac = new Igrac();
        return igrac;
    }

}
