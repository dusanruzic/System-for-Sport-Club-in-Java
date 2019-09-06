/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Igrac;
import domen.Menadzer;
import domen.Pozicija;
import domen.Profil;
import domen.Sport;
import domen.StatistikaIgracaSaUtakmice;
import domen.Tim;
import domen.Trener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import domen.IGeneralEntity;
import domen.Utakmica;
import java.util.List;
import javax.swing.JOptionPane;
import so.OpstaSistemskaOperacija;
import so.igrac.SOAzurirajIgraca;
import so.igrac.SOKreirajIgraca;
import so.igrac.SOObrisiIgraca;
import so.igrac.SOPoslednjiRBIgraca;
import so.igrac.SOVratiListuIgraca;
import so.igrac.SOZapamtiIgraca;
import so.pozicija.SOVratiListuPozicija;
import so.sport.SOVratiListuSportova;
import so.statistika.SOVratiListuStatistikaIgraca;
import so.statistika.SOZapamtiStatistike;
import so.tim.SOAzurirajTim;
import so.tim.SOKreirajTim;
import so.tim.SOObrisiTim;
import so.tim.SOPoslednjiRBTima;
//import so.tim.SOPronadjiTim;
import so.tim.SOVratiListuTimova;
import so.tim.SOVratiListuTimovaTrenera;
import so.tim.SOZapamtiTim;
import so.trener.SOAzurirajTrenera;
import so.trener.SOKreirajTrenera;
import so.trener.SOObrisiTrenera;
import so.trener.SOPoslednjiRBTrenera;
import so.trener.SOVratiListuTrenera;
import so.trener.SOZapamtiTrenera;
import so.utakmica.SOVratiListuUtakmica;

/**
 *
 * @author duler
 */
public class Kontroler {

    DBBroker db;
    private static Kontroler instanca;
    ArrayList<IGeneralEntity> listaMenadzera;
    ArrayList<IGeneralEntity> listaTrenera;

    private Kontroler() {
        db = DBBroker.getInstance();
        napuniListuMenadzera();
        napuniListuTrenera();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public ArrayList<IGeneralEntity> getListaMenadzera() {
        return listaMenadzera;
    }

    public ArrayList<IGeneralEntity> getListaTrenera() {
        return listaTrenera;
    }

    private void napuniListuMenadzera() {
        db.otvoriKonekciju();
        Menadzer menadzer = new Menadzer();
        listaMenadzera = db.vratiSve(menadzer);
        db.zatvoriKonekciju();

    }

    private void napuniListuTrenera() {
        db.otvoriKonekciju();
        Trener trener = new Trener();
        listaTrenera = db.vratiSve(trener);
        db.zatvoriKonekciju();
    }

    public Menadzer proveriMenadzera(String username, String password) {
        for (IGeneralEntity menadzer : listaMenadzera) {
            Menadzer m = (Menadzer) menadzer;
            if (m.getProfil().getKorisnickoIme().equals(username) && m.getProfil().getKorisnickaLozinka().equals(password)) {
                return m;
            }
        }
        return null;

    }

    public Trener proveriTrenera(String username, String password) {
        for (IGeneralEntity trener : listaTrenera) {
            Trener t = (Trener) trener;
            if (t.getProfil().getKorisnickoIme().equals(username) && t.getProfil().getKorisnickaLozinka().equals(password)) {
                return t;
            }
        }
        return null;
    }

//    public ArrayList<Tim> vratiSveTimove() {
//        ArrayList<Tim> listaTimova = new ArrayList<>();
//
//        db.otvoriKonekciju();
//        listaTimova = db.vratiSveTimove();
//        db.zatvoriKonekciju();
//
//        return listaTimova;
//    }
    public ArrayList<IGeneralEntity> vratiPodUslovom(IGeneralEntity odo) {

        ArrayList<IGeneralEntity> lista = new ArrayList<>();

        db.otvoriKonekciju();
        lista = db.vratiPodUslovom(odo);
        db.zatvoriKonekciju();

        return lista;
    }

//    public boolean zapamtiIgraca(Igrac igrac) {
//        boolean sacuvano = false;
//
//        db.otvoriKonekciju();
//
//        try {
//            db.sacuvaj(igrac);
//            sacuvano = true;
//            db.commitTransaction();
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//        } finally {
//
//            db.zatvoriKonekciju();
//            return sacuvano;
//        }
//
//    }
//    public ArrayList<Igrac> vratiSveIgrace(Sport sport, String prezime) {
//        ArrayList<Igrac> listaIgraca = new ArrayList<>();
//
//        db.otvoriKonekciju();
//        listaIgraca = db.vratiSveIgrace(sport, prezime);
//        db.zatvoriKonekciju();
//
//        return listaIgraca;
//    }
    public ArrayList<IGeneralEntity> vratiSve(IGeneralEntity odo) {
        ArrayList<IGeneralEntity> lista = new ArrayList<>();

        db.otvoriKonekciju();
        lista = db.vratiSve(odo);
        db.zatvoriKonekciju();

        return lista;
    }

//    public ArrayList<IGeneralEntity> getAllTeams() throws Exception {
//        AbstractGenericOperation op = new GetAllTeamsSO();
//        op.templateExecute(new Tim());
//        return ((GetAllTeamsSO) op).getList();
//    }
    public boolean izbrisiIgraca(Igrac igrac) {
        boolean izbrisano = false;
        db.otvoriKonekciju();
        try {
            db.izbrisi(igrac);
            db.commitTransaction();
            izbrisano = true;
        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            db.rollbackTransaction();
        }
        db.zatvoriKonekciju();
        return izbrisano;
    }

//    public ArrayList<Trener> vratiTrenereSporta(Sport sport) {
//        ArrayList<Trener> listaTrenera = new ArrayList<>();
//
//        db.otvoriKonekciju();
//        listaTrenera = db.vratiSveTrenereSporta(sport);
//        db.zatvoriKonekciju();
//
//        return listaTrenera;
//    }
//    public boolean zapamtiTim(Tim tim) {
//        boolean sacuvano = false;
//        try {
//
//            db.otvoriKonekciju();
//            db.sacuvaj(tim);
//            sacuvano = true;
//            db.commitTransaction();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//        } finally {
//            db.zatvoriKonekciju();
//            return sacuvano;
//        }
//    }
//    public boolean azurirajTim(Tim tim){
//        boolean sacuvano = false;
//        try {
//
//            db.otvoriKonekciju();
//            db.update(tim);
//            sacuvano = true;
//            db.commitTransaction();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//        } finally {
//            db.zatvoriKonekciju();
//            return sacuvano;
//        }
//    }
    
    
//    public boolean azurirajIgraca(Igrac igrac) {
//        boolean sacuvano = false;
//        try {
//
//            db.otvoriKonekciju();
//            db.update(igrac);
//            sacuvano = true;
//            db.commitTransaction();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//        } finally {
//            db.zatvoriKonekciju();
//            return sacuvano;
//        }
//    }

//    public boolean zapamtiStatistike(ArrayList<StatistikaIgracaSaUtakmice> statistike) {
//        boolean sacuvano = false;
//        try {
//
//            db.otvoriKonekciju();
//            for (StatistikaIgracaSaUtakmice statistikaIgracaSaUtakmice : statistike) {
//                db.kreiraj(statistikaIgracaSaUtakmice);
//            }
//
//            sacuvano = true;
//            db.commitTransaction();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//            throw new Exception();
//        } finally {
//            db.zatvoriKonekciju();
//            return sacuvano;
//        }
//    }

//    public boolean zapamtiTrenera(Trener trener) {
//        boolean sacuvano = false;
//        try {
//
//            db.otvoriKonekciju();
//            db.sacuvaj(trener);
//            sacuvano = true;
//            db.commitTransaction();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//        } finally {
//            db.zatvoriKonekciju();
//            return sacuvano;
//        }
//    }
    public boolean zapamtiProfil(Profil profil) {
        boolean sacuvano = false;
        try {

            db.otvoriKonekciju();
            db.kreiraj(profil);
            sacuvano = true;
            db.commitTransaction();

        } catch (SQLException ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            db.rollbackTransaction();
        } finally {
            db.zatvoriKonekciju();
            return sacuvano;
        }
    }

//    public List<Igrac> pronadjiIgrace(Igrac igrac) {
//        ArrayList<IGeneralEntity> lista = new ArrayList<>();
//
//        db.otvoriKonekciju();
//        lista = db.vratiPodUslovom(odo);
//        db.zatvoriKonekciju();
//
//        return lista;
//    }
//    public boolean azurirajTrenera(Trener trener) {
//       boolean sacuvano = false;
//        try {
//
//            db.otvoriKonekciju();
//            db.update(trener);
//            sacuvano = true;
//            db.commitTransaction();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//        } finally {
//            db.zatvoriKonekciju();
//            return sacuvano;
//        }
//    }
    //-------------------------------------------------------------- sistemske operacije
    public ArrayList<IGeneralEntity> vratiListuSportova(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuSportova();
        oso.izvrsi(odo);
        return ((SOVratiListuSportova) oso).getLista();
    }

    public ArrayList<IGeneralEntity> vratiListuTimova(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuTimova();
        oso.izvrsi(odo);
        return ((SOVratiListuTimova) oso).getLista();
    }

    public ArrayList<IGeneralEntity> vratiListuPozicijaOdredjenogSporta(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuPozicija();
        oso.izvrsi(odo);
        return ((SOVratiListuPozicija) oso).getLista();
    }

    public ArrayList<IGeneralEntity> vratiListuTreneraOdredjenogSporta(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuTrenera();
        oso.izvrsi(odo);
        return ((SOVratiListuTrenera) oso).getLista();
    }

    public ArrayList<IGeneralEntity> vratiListuUtakmicaOdredjenogTima(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuUtakmica();
        oso.izvrsi(odo);
        return ((SOVratiListuUtakmica) oso).getLista();
    }

    public ArrayList<IGeneralEntity> vratiIgracaPodUslovom(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuIgraca();
        oso.izvrsi(odo);
        return ((SOVratiListuIgraca) oso).getLista();
    }

    public ArrayList<IGeneralEntity> vratiListuTimovaOdredjenogTrenera(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuTimovaTrenera();
        oso.izvrsi(odo);
        return ((SOVratiListuTimovaTrenera) oso).getLista();
    }

    public void azurirajTim(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOAzurirajTim();
        oso.izvrsi(odo);
    }

    public void azurirajTrenera(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOAzurirajTrenera();
        oso.izvrsi(odo);
    }

    public void zapamtiStatistike(ArrayList<StatistikaIgracaSaUtakmice> odo) throws Exception {

        OpstaSistemskaOperacija oso = new SOZapamtiStatistike();
        oso.izvrsi(odo);
    }

    public IGeneralEntity zapamtiTim(IGeneralEntity odo) throws Exception {

        OpstaSistemskaOperacija oso = new SOZapamtiTim();
        oso.izvrsi((IGeneralEntity) odo);
        return ((SOZapamtiTim)oso).getEntity();
    }

    public void zapamtiTrenera(IGeneralEntity odo) throws Exception {

        OpstaSistemskaOperacija oso = new SOZapamtiTrenera();
        oso.izvrsi((IGeneralEntity) odo);
    }

    public void zapamtiIgraca(IGeneralEntity odo) throws Exception {

        OpstaSistemskaOperacija oso = new SOZapamtiIgraca();
        oso.izvrsi((IGeneralEntity) odo);
    }
    
    public void azurirajIgraca(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOAzurirajIgraca();
        oso.izvrsi(odo);
    }

    public IGeneralEntity kreirajTim(Tim tim) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajTim();
        oso.izvrsi(tim);
        return ((SOKreirajTim)oso).getE();
    }

    public Object poslednjiRBTima() throws Exception {
        OpstaSistemskaOperacija so = new SOPoslednjiRBTima();
        so.izvrsi(new Tim());
        System.out.println("REDNI BROJ TIMA IZ SISTEMSKEOPERACIJE: " + ((SOPoslednjiRBTima)so).getRb());
        return ((SOPoslednjiRBTima)so).getRb();
    }

//    public IGeneralEntity pronadjiTim(int sifraTima) throws Exception {
//        OpstaSistemskaOperacija so = new SOPronadjiTim();
//        so.izvrsi(new Tim(sifraTima));
//        return((SOPronadjiTim)so).getEntity();
//    }

    public void obrisiTim(Tim tim) throws Exception {
        OpstaSistemskaOperacija so = new SOObrisiTim();
        so.izvrsi(tim);
    }

    public ArrayList<IGeneralEntity> vratiListuTrenera(IGeneralEntity odo) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuTrenera();
        oso.izvrsi(odo);
        return ((SOVratiListuTimova) oso).getLista();
    }

    public Object poslednjiRBTrenera() throws Exception {
        OpstaSistemskaOperacija so = new SOPoslednjiRBTrenera();
        so.izvrsi(new Trener());
        System.out.println("REDNI BROJ TRENERA IZ SISTEMSKEOPERACIJE: " + ((SOPoslednjiRBTrenera)so).getRb());
        return ((SOPoslednjiRBTrenera)so).getRb();
    }

    public IGeneralEntity kreirajTrenera(Trener trener) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajTrenera();
        oso.izvrsi(trener);
        return ((SOKreirajTrenera)oso).getE();
    }

    public void obrisiTrenera(Trener trener) throws Exception {
        OpstaSistemskaOperacija so = new SOObrisiTrenera();
        so.izvrsi(trener);
    }

    public Object poslednjiRBIgraca() throws Exception {
        OpstaSistemskaOperacija so = new SOPoslednjiRBIgraca();
        so.izvrsi(new Igrac());
        System.out.println("REDNI BROJ IGRACA IZ SISTEMSKEOPERACIJE: " + ((SOPoslednjiRBIgraca)so).getRb());
        return ((SOPoslednjiRBIgraca)so).getRb();
        
    }

    public IGeneralEntity kreirajIgraca(Igrac igrac) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajIgraca();
        oso.izvrsi(igrac);
        return ((SOKreirajIgraca)oso).getE();
    }

    public void obrisiIgraca(Igrac igrac) throws Exception {
        OpstaSistemskaOperacija so = new SOObrisiIgraca();
        so.izvrsi(igrac);
    }

    public ArrayList<IGeneralEntity> vratiListuUtakmicaOdredjenogTrenera(Utakmica utakmica) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuUtakmica();
        oso.izvrsi(utakmica);
        return ((SOVratiListuUtakmica) oso).getLista();
    }

    public List<IGeneralEntity> vratiStatistikeIgraca(StatistikaIgracaSaUtakmice stat) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuStatistikaIgraca();
        oso.izvrsi(stat);
        return ((SOVratiListuStatistikaIgraca) oso).getLista();
    }
    
}
