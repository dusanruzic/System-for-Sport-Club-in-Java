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
public class StatistikaIgracaSaUtakmice implements IGeneralEntity {

    private Utakmica utakmica;
    private Igrac igrac;
    private int brojSuteva;
    private int brojGolova;
    private int brojZutihKartona;
    private double ocena;

    public StatistikaIgracaSaUtakmice() {
    }

    public StatistikaIgracaSaUtakmice(Utakmica utakmica, Igrac igrac, int brojSuteva, int brojGolova, int brojZutihKartona, int ocena) {
        this.utakmica = utakmica;
        this.igrac = igrac;
        this.brojSuteva = brojSuteva;
        this.brojGolova = brojGolova;
        this.brojZutihKartona = brojZutihKartona;
        this.ocena = ocena;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Utakmica getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(Utakmica utakmica) {
        this.utakmica = utakmica;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    public int getBrojSuteva() {
        return brojSuteva;
    }

    public void setBrojSuteva(int brojSuteva) {
        this.brojSuteva = brojSuteva;
    }

    public int getBrojGolova() {
        return brojGolova;
    }

    public void setBrojGolova(int brojGolova) {
        this.brojGolova = brojGolova;
    }

    public int getBrojZutihKartona() {
        return brojZutihKartona;
    }

    public void setBrojZutihKartona(int brojZutihKartona) {
        this.brojZutihKartona = brojZutihKartona;
    }

    @Override
    public String toString() {
        return igrac.toString() + " sa utakmice: " + utakmica.toString();
    }

    @Override
    public String vratiImeTabele() {
        return "statistikaigracasautakmice";
    }

    @Override
    public String vratiImenaKolona() {
        return "sifraUtakmice, sifraIgraca, brojSuteva, brojGolova, brojZutihKartona, ocena";
    }

    @Override
    public String vratiUslovPretrage() {
        
        return "ig.sifraIgraca = " + getIgrac().getSifraIgraca();
        //return " ti.sifraTima = "  + getIgrac().getTim().getSifraTima() +  " GROUP BY jmbgIgraca ORDER BY AVG(ocena) DESC;";
    }

    @Override
    public String poveziTabele() {
        return "imeIgraca, prezimeIgraca, jmbgIgraca, plataIgraca, ti.sifraTima,  ocena, nazivProtivnika, brojDatihGolova, brojPrimljenihGolova, nazivTima, brojSuteva, brojGolova, brojZutihKartona FROM statistikaigracasautakmice si JOIN igrac ig ON si.`sifraIgraca` = ig.`sifraIgraca` JOIN tim ti ON ig.`sifraTima`=ti.`sifraTima` JOIN trener tr ON ti.`sifraTrenera`=tr.`sifraTrenera` JOIN profil pr ON tr.`korisnickoIme`=pr.`korisnickoIme` JOIN pozicija po ON ig.`sifraPozicije`=po.`sifraPozicije` JOIN sport sp ON po.`sifraSporta`=sp.`sifraSporta` JOIN utakmica ut ON si.`sifraUtakmice` = ut.`sifraUtakmice`";
    }

    @Override
    public IGeneralEntity vratiObjekat(ResultSet rs) throws Exception {
        
        String imeIgraca = rs.getString("imeIgraca");
        String prezimeIgraca = rs.getString("prezimeIgraca");
        String JMBGIgraca = rs.getString("jmbgIgraca");
        double plataIgraca = rs.getDouble("plataIgraca");
        double ocena = rs.getDouble("ocena");
        int sifraTima = rs.getInt("ti.sifraTima");
        String protivnik = rs.getString("nazivProtivnika");
        int brojDatihGolova = rs.getInt("brojDatihGolova");
        int brojPrimljenihGolova = rs.getInt("brojPrimljenihGolova");
        String nazivTima = rs.getString("nazivTima");
        int brojSuteva = rs.getInt("brojSuteva");
        int brojGolova = rs.getInt("brojGolova");
        int brojZutihKartona = rs.getInt("brojZutihKartona");


        Tim tim = new Tim();
        tim.setNazivTima(nazivTima);

        Igrac igrac = new Igrac();
        igrac.setIme(imeIgraca);
        
        igrac.setPrezime(prezimeIgraca);
        igrac.setPlata(plataIgraca);
        igrac.setJmbg(JMBGIgraca);
        igrac.setTim(tim);
        igrac.getTim().setSifraTima(sifraTima);
        System.out.println(igrac);
        StatistikaIgracaSaUtakmice statistika = new StatistikaIgracaSaUtakmice();
        statistika.setIgrac(igrac);
        
        Utakmica ut = new Utakmica();
        ut.setNazivProtivnika(protivnik);
        ut.setBrojDatihGolova(brojDatihGolova);
        ut.setBrojPrimljenihGolova(brojPrimljenihGolova);
        ut.setTim(tim);
        statistika.setUtakmica(ut);
        
        statistika.setBrojGolova(brojGolova);
        statistika.setBrojSuteva(brojSuteva);
        statistika.setBrojZutihKartona(brojZutihKartona);
        statistika.setOcena(ocena);
        return statistika;
    }

    @Override
    public String vratiVrednostiKolona() {
        return "'" + utakmica.getSifraUtakmice() + "','" + igrac.getSifraIgraca() + "','" + brojSuteva + "','" + brojGolova + "','" + brojZutihKartona + "','" + ocena + "'";
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
        return "'" + utakmica.getSifraUtakmice() + "','" + igrac.getSifraIgraca() + "','" + brojSuteva + "','" + brojGolova + "','" + brojZutihKartona + "','" + ocena + "'";
    }

    @Override
    public String vratiImenaKolonaZaCreate() {
        return "sifraUtakmice, sifraIgraca, brojSuteva, brojGolova, brojZutihKartona, ocena";

    }

    @Override
    public IGeneralEntity vratiObjekatPriOdustani(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
