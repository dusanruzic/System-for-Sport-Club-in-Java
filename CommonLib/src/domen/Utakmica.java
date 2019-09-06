/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author duler
 */
public class Utakmica implements IGeneralEntity {

    private int sifraUtakmice;
    private Date datumUtakmice;
    private String nazivProtivnika;
    private int brojDatihGolova;
    private int brojPrimljenihGolova;
    private Tim tim;

    public Utakmica() {
    }

    public Utakmica(int sifraUtakmice, Date datumUtakmice, String nazivProtivnika, int brojDatihGolova, int brojPrimljenihGolova, Tim tim) {
        this.sifraUtakmice = sifraUtakmice;
        this.datumUtakmice = datumUtakmice;
        this.nazivProtivnika = nazivProtivnika;
        this.brojDatihGolova = brojDatihGolova;
        this.brojPrimljenihGolova = brojPrimljenihGolova;
        this.tim = tim;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public int getSifraUtakmice() {
        return sifraUtakmice;
    }

    public void setSifraUtakmice(int sifraUtakmice) {
        this.sifraUtakmice = sifraUtakmice;
    }

    public Date getDatumUtakmice() {
        return datumUtakmice;
    }

    public void setDatumUtakmice(Date datumUtakmice) {
        this.datumUtakmice = datumUtakmice;
    }

    public String getNazivProtivnika() {
        return nazivProtivnika;
    }

    public void setNazivProtivnika(String nazivProtivnika) {
        this.nazivProtivnika = nazivProtivnika;
    }

    public int getBrojDatihGolova() {
        return brojDatihGolova;
    }

    public void setBrojDatihGolova(int brojDatihGolova) {
        this.brojDatihGolova = brojDatihGolova;
    }

    public int getBrojPrimljenihGolova() {
        return brojPrimljenihGolova;
    }

    public void setBrojPrimljenihGolova(int brojPrimljenihGolova) {
        this.brojPrimljenihGolova = brojPrimljenihGolova;
    }

    @Override
    public String toString() {
        
        return tim.getNazivTima() + " vs. " + nazivProtivnika;
    }

    @Override
    public String vratiImeTabele() {
        return "utakmica";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraUtakmice, datumUtakmice, nazivProtivnika, brojDatihGolva, brojPrimljenihGolova, sifraTima";
    }

    @Override
    public String vratiUslovPretrage() {
        
        System.out.println("Protivnik: " + getNazivProtivnika());
        System.out.println("Trener: " + getTim().getTrener().getSifraTrenera());
        System.out.println("Tim: " + getTim().getSifraTima());
        
        if(getTim().getSifraTima() != 0){
            return "ti.sifraTima = " + getTim().getSifraTima();


        }
        
        if(getNazivProtivnika() != null && getTim().getTrener().getSifraTrenera() != 0){
            return "ti.sifraTrenera = " + getTim().getTrener().getSifraTrenera() + " and nazivProtivnika like '%" + getNazivProtivnika() + "%'";
        }
        
        return "ti.sifraTrenera = " + getTim().getTrener().getSifraTrenera();

    }

    @Override
    public String poveziTabele() {
        return " * from utakmica ut join tim ti ON ut.sifraTima = ti.sifraTima JOIN trener tr ON ti.sifraTrenera=tr.sifraTrenera JOIN profil pr ON tr.korisnickoIme = pr.korisnickoIme JOIN sport sp ON tr.sifraSporta = sp.sifraSporta";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {

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
        boolean daLiJeAktivanTrener = rs.getBoolean("daLiJeAktivanTrener");
        String korisnickoIme = rs.getString("korisnickoIme");
        String korisnickaLozinka = rs.getString("korisnickaLozinka");
        Profil profil = new Profil(korisnickoIme, korisnickaLozinka);

        int sifraSporta = rs.getInt("sifraSporta");
        String nazivSporta = rs.getString("nazivSporta");
        Sport sport = new Sport(sifraSporta, nazivSporta);

        Trener trener = new Trener(sifraTrenera, imeTrenera, prezimeTrenera, JMBGTrenera, plataTrenera, daLiJeAktivanTrener, profil, sport);
        Tim tim = new Tim(sifraTima, nazivTima, brojDobijenihUtakmica, brojIzgubljenihUtakmica, brojNeresenihUtakmica, daLiJeAktivanTim, trener);

        int sifraUtakmice = rs.getInt("sifraUtakmice");
        Date datumUtakmice = rs.getDate("datumUtakmice");
        String nazivProtivnika = rs.getString("nazivProtivnika");
        int brojDatihGolova = rs.getInt("brojDatihGolova");
        int brojPrimljenihGolova = rs.getInt("brojPrimljenihGolova");

        Utakmica utakmica = new Utakmica(sifraUtakmice, datumUtakmice, nazivProtivnika, brojDatihGolova, brojPrimljenihGolova, tim);
        return utakmica;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + sifraUtakmice + "','" + datumUtakmice + "','" + nazivProtivnika + "','" + brojDatihGolova + "','" + brojPrimljenihGolova + "','" + tim.getSifraTima() + "'";
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
    public Object vratiPoslednji(ResultSet rs) throws Exception {
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
