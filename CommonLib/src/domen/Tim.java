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
public class Tim implements IGeneralEntity {

    private int sifraTima;
    private String nazivTima;
    private int brojDobijenihUtakmica;
    private int brojIzgubljenihUtakmica;
    private int brojNeresenihUtakmica;
    private boolean daLiJeAktivanTim;
    private Trener trener;

    public Tim() {
    }

    public Tim(int sifraTima, String nazivTima, int brojDobijenihUtakmica, int brojIzgubljenihUtakmica, int brojNeresenihUtakmica, boolean daLiJeAktivanTim, Trener trener) {
        this.sifraTima = sifraTima;
        this.nazivTima = nazivTima;
        this.brojDobijenihUtakmica = brojDobijenihUtakmica;
        this.brojIzgubljenihUtakmica = brojIzgubljenihUtakmica;
        this.brojNeresenihUtakmica = brojNeresenihUtakmica;
        this.daLiJeAktivanTim = daLiJeAktivanTim;
        this.trener = trener;
    }

    public Tim(int sifraTima) {
        this.sifraTima = sifraTima;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public int getSifraTima() {
        return sifraTima;
    }

    public void setSifraTima(int sifraTima) {
        this.sifraTima = sifraTima;
    }

    public String getNazivTima() {
        return nazivTima;
    }

    public void setNazivTima(String nazivTima) {
        this.nazivTima = nazivTima;
    }

    public int getBrojDobijenihUtakmica() {
        return brojDobijenihUtakmica;
    }

    public void setBrojDobijenihUtakmica(int brojDobijenihUtakmica) {
        this.brojDobijenihUtakmica = brojDobijenihUtakmica;
    }

    public int getBrojIzgubljenihUtakmica() {
        return brojIzgubljenihUtakmica;
    }

    public void setBrojIzgubljenihUtakmica(int brojIzgubljenihUtakmica) {
        this.brojIzgubljenihUtakmica = brojIzgubljenihUtakmica;
    }

    public int getBrojNeresenihUtakmica() {
        return brojNeresenihUtakmica;
    }

    public void setBrojNeresenihUtakmica(int brojNeresenihUtakmica) {
        this.brojNeresenihUtakmica = brojNeresenihUtakmica;
    }

    @Override
    public String toString() {
        return nazivTima + "  Trener: [" + trener.toString() + "]";
    }

    public boolean getDaLiJeAktivanTim() {
        return daLiJeAktivanTim;
    }

    public void setDaLiJeAktivanTim(boolean daLiJeAktivanTim) {
        this.daLiJeAktivanTim = daLiJeAktivanTim;
    }

    @Override
    public String vratiImeTabele() {
        return "tim";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraTima, nazivTima, brojDobijenihUtakmica, brojIzgubljenihUtakmica, brojNeresenihUtakmica, daLiJeAktivanTim, sifraTrenera";
    }

    @Override
    public String vratiUslovPretrage() {
        if (getTrener() != null) {
            return "tr.sifraTrenera = " + getTrener().getSifraTrenera();

        } else {
            return "sifraTima = " + getSifraTima();
        }
    }

    @Override
    public String poveziTabele() {
        return " * from tim ti JOIN trener tr ON ti.sifraTrenera=tr.sifraTrenera JOIN profil pr ON tr.korisnickoIme = pr.korisnickoIme JOIN sport sp ON tr.sifraSporta = sp.sifraSporta";
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
        String ime = rs.getString("imeTrenera");
        String prezime = rs.getString("prezimeTrenera");
        String JMBG = rs.getString("jmbgTrenera");
        double plata = rs.getDouble("plataTrenera");
        boolean daLiJeAktivanTrener = rs.getBoolean("daLiJeAktivanTrener");
        String korisnickoIme = rs.getString("korisnickoIme");
        String korisnickaLozinka = rs.getString("korisnickaLozinka");
        Profil profil = new Profil(korisnickoIme, korisnickaLozinka);
        int sifraSporta = rs.getInt("sifraSporta");
        String nazivSporta = rs.getString("nazivSporta");
        Sport sport = new Sport(sifraSporta, nazivSporta);

        Trener trener = new Trener(sifraTrenera, ime, prezime, JMBG, plata, daLiJeAktivanTrener, profil, sport);
        Tim tim = new Tim(sifraTima, nazivTima, brojDobijenihUtakmica, brojIzgubljenihUtakmica, brojNeresenihUtakmica, daLiJeAktivanTim, trener);

        return tim;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + sifraTima + "','" + nazivTima + "','" + brojDobijenihUtakmica + "','" + brojIzgubljenihUtakmica + "','" + brojNeresenihUtakmica + "','" + (daLiJeAktivanTim ? 1 : 0) + "','" + trener.getSifraTrenera() + "'";
    }

    @Override
    public String vratiUslovZaUpdate() {
        return "sifraTima= '" + sifraTima + "'";
    }

    @Override
    public String vratiUslovZaBrisanje() {
        return "sifraTima = " + sifraTima;
    }

    @Override
    public ArrayList<IGeneralEntity> vratiListu(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiKolonaZaUpdate() {
        return "nazivTima= '" + nazivTima + "', daLiJeAktivanTim= '" + (daLiJeAktivanTim ? 1 : 0) + "', sifraTrenera= '" + trener.getSifraTrenera() + "'";
    }

    @Override
    public String vratiAtributZaPoslednji() {
        return "sifraTima";
    }

    @Override
    public Object vratiPoslednji(ResultSet rs) throws Exception{
        int broj = 0;
        while (rs.next()){
            broj = rs.getInt(1);
        }
        return broj;
    }

    @Override
    public String vratiVrednostiKolonaZaCreate() {
        return " " + sifraTima;
    }

    @Override
    public String vratiImenaKolonaZaCreate() {
        return "sifraTima";
    }

    @Override
    public IGeneralEntity vratiObjekatPriOdustani(ResultSet rs) throws Exception {
        
                System.out.println("pri odustani pocetak");

        //int sifra = rs.getInt("sifraTima");
        
        //String nazivTima = rs.getString("nazivTima");
               
        System.out.println("pri odustani pred kraj");
        
        Tim tim = new Tim();
        return tim;
    }

}
