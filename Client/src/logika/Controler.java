/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import communication.Communication;
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
import java.io.IOException;
import javax.swing.JOptionPane;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author duler
 */
public class Controler {

    private static Controler instanca;
    private Trener trener;
    private Menadzer menadzer;

    private Controler() {

    }

    public static Controler getInstanca() {
        if (instanca == null) {
            instanca = new Controler();
        }
        return instanca;

    }

//    public ArrayList<Menadzer> vratiListuMenadzera() throws Exception {
//        Request request = new Request();
//        request.setOperation(Operation.OPERATION_VRATI_LISTU_MENADZERA);
//        Communication.getInstance().sendRequest(request);
//        Response response = Communication.getInstance().readResponse();
//        if (response.getStatus() == ResponseStatus.OK) {
//            return (ArrayList<Menadzer>) response.getData();
//        } else {
//            throw (Exception) response.getError();
//        }
//
//    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }
    
    
    public int poslednjiRBTima() throws Exception{
        
        Request request = new Request();
        request.setOperation(Operation.OPERATION_POSLEDNI_TIM);
        
        Communication.getInstance().sendRequest(request);
        
        
        Response response = Communication.getInstance().readResponse();
        
        System.out.println(response.getStatus());
        if(response.getStatus() == ResponseStatus.OK){
            return (int) response.getData();
        }
        throw new Exception(response.getError().toString());
        
    }
    
    public int poslednjiRBTrenera() throws Exception{
        
        Request request = new Request();
        request.setOperation(Operation.OPERATION_POSLEDNJI_TRENER);
        
        Communication.getInstance().sendRequest(request);
        
        
        Response response = Communication.getInstance().readResponse();
        System.out.println("Data: " + response.getData());
        System.out.println(response.getStatus());
        if(response.getStatus() == ResponseStatus.OK){
            return (int) response.getData();
        }
        throw new Exception(response.getError().toString());
        
    }
    
    public Menadzer loginMenadzera(String username, String password) throws Exception {
        Request request = new Request();
        Menadzer m = new Menadzer();
        m.setProfil(new Profil(username, password));
        request.setOperation(Operation.OPERATION_PRIJAVI_SE);
        request.setData(m);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            setMenadzer((Menadzer) response.getData());
            return (Menadzer) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public Trener loginTrenera(String username, String password) throws Exception {
        Request request = new Request();
        Trener t = new Trener();
        t.setProfil(new Profil(username, password));
        request.setOperation(Operation.OPERATION_PRIJAVI_SE);
        request.setData(t);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            setTrener((Trener) response.getData());
            return (Trener) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public boolean izbrisiIgraca(Igrac igrac) {
        return false;
    }

//        public Menadzer proveriMenadzera(String username, String password) {
//        for (IGeneralEntity menadzer : listaMenadzera) {
//            Menadzer m = (Menadzer) menadzer;
//            if (m.getProfil().getKorisnickoIme().equals(username) && m.getProfil().getKorisnickaLozinka().equals(password)) {
//                return m;
//            }
//        }
//        return null;
//
//    }
//    DBBroker db;
//    private static Kontroler instanca;
//    ArrayList<IGeneralEntity> listaMenadzera;
//    ArrayList<IGeneralEntity> listaTrenera;
//
//    private Kontroler() {
//        db = DBBroker.getInstance();
//        napuniListuMenadzera();
//        napuniListuTrenera();
//    }
//
//    public static Kontroler getInstanca() {
//        if (instanca == null) {
//            instanca = new Kontroler();
//        }
//        return instanca;
//    }
//
//    public ArrayList<IGeneralEntity> getListaMenadzera() {
//        return listaMenadzera;
//    }
//
//    public ArrayList<IGeneralEntity> getListaTrenera() {
//        return listaTrenera;
//    }
//
//    private void napuniListuMenadzera() {
//        db.otvoriKonekciju();
//        Menadzer menadzer = new Menadzer();
//        listaMenadzera = db.vratiSve(menadzer);
//        db.zatvoriKonekciju();
//
//    }
//
//    private void napuniListuTrenera() {
//        db.otvoriKonekciju();
//        Trener trener = new Trener();
//        listaTrenera = db.vratiSve(trener);
//        db.zatvoriKonekciju();
//    }
//
//
//
//    public Trener proveriTrenera(String username, String password) {
//        for (IGeneralEntity trener : listaTrenera) {
//            Trener t = (Trener) trener;
//            if (t.getProfil().getKorisnickoIme().equals(username) && t.getProfil().getKorisnickaLozinka().equals(password)) {
//                return t;
//            }
//        }
//        return null;
//    }
//
    public ArrayList<Tim> vratiSveTimove() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_LISTU_TIMOVA);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Tim>) response.getData();
        }
        throw new Exception(response.getError().toString());

    }

    public ArrayList<Sport> vratiSveSportove() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_LISTU_SPORTOVA);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Sport>) response.getData();
        }
        throw new Exception(response.getError().toString());

    }

    public ArrayList<Igrac> pronadjiIgrace(Igrac igrac) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_PRONADJI_IGRACE);
        request.setData(igrac);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Igrac>) response.getData();
        }
        System.out.println("Primio errorcode od servera");
        throw new Exception(response.getError().toString());
    }
    
        public ArrayList<StatistikaIgracaSaUtakmice> pronadjiStatistike(StatistikaIgracaSaUtakmice stat) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_PRONADJI_STATISTIKE);
        request.setData(stat);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<StatistikaIgracaSaUtakmice>) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

//
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
        return null;
    }
//
//    public ArrayList<IGeneralEntity> getAllTeams() throws Exception {
//        AbstractGenericOperation op = new GetAllTeamsSO();
//        op.templateExecute(new Tim());
//        return ((GetAllTeamsSO) op).getList();
//    }
//
//    public boolean izbrisiIgraca(Igrac igrac) {
//        boolean izbrisano = false;
//        db.otvoriKonekciju();
//        try {
//            db.izbrisi(igrac);
//            db.commitTransaction();
//            izbrisano = true;
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//            db.rollbackTransaction();
//        }
//        db.zatvoriKonekciju();
//        return izbrisano;
//    }
//

    public ArrayList<Trener> vratiTrenereSporta(Sport sport) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_LISTU_TRENERA_DATOG_SPORTA);
        request.setData(sport);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();

        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Trener>) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public ArrayList<Pozicija> vratiPozicijeSporta(Sport sport) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_LISTU_POZICIJA_DATOG_SPORTA);
        request.setData(sport);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Pozicija>) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public ArrayList<Tim> vratiTimoveTrenera(Trener trener) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_TIMOVE_DATOG_TRENERA);
        request.setData(trener);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Tim>) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public ArrayList<Utakmica> vratiUtakmiceTima(Tim tim) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_UTAKMICE_DATOG_TIMA);
        request.setData(tim);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Utakmica>) response.getData();
        }
        throw new Exception(response.getError().toString());
        
    }
    
//    public Tim pronadjiTim(int sifra) throws Exception {
//        Request request = new Request();
//        request.setOperation(Operation.OPERATION_PRONADJI_TIM);
//        request.setData(sifra);
//        Communication.getInstance().sendRequest(request);
//        
//        Response response = Communication.getInstance().readResponse();
//        if(response.getStatus() == ResponseStatus.ERROR){
//            throw (Exception) response.getError();
//        }
//        return (Tim) response.getData();
//    }
    
    public void obrisiTim(int sifra) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_OBRISI_TIM);
        request.setData(sifra);
        Communication.getInstance().sendRequest(request);
        
        Response response = Communication.getInstance().readResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw (Exception) response.getError();
        }
    }
    

    public Tim zapamtiTim(Tim tim) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_ZAPAMTI_TIM);
        request.setData(tim);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            throw (Exception) response.getError();
        }
        return (Tim) response.getData();
    }

    public Igrac zapamtiIgraca(Igrac igrac) throws Exception {
        boolean sacuvano = false;
        Request request = new Request();
        request.setOperation(Operation.OPERATION_ZAPAMTI_IGRACA);
        request.setData(igrac);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return igrac;
        }
        throw (Exception) response.getError();

    }

    public boolean zapamtiStatistike(ArrayList<StatistikaIgracaSaUtakmice> statistike) throws Exception {
        boolean sacuvano = false;
        Request request = new Request();
        request.setOperation(Operation.OPERATION_ZAPAMTI_STATISTIKE);
        request.setData(statistike);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return true;
        }
        throw (Exception) response.getError();
    }
//

    public Trener zapamtiTrenera(Trener trener) throws Exception {
        boolean sacuvano = false;
        Request request = new Request();
        request.setOperation(Operation.OPERATION_ZAPAMTI_TRENERA);
        request.setData(trener);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return trener;
        }
        throw (Exception) response.getError();
    }

    public boolean zapamtiProfil(Profil profil) throws Exception {
        boolean sacuvano = false;
        Request request = new Request();
        request.setOperation(Operation.OPERATION_ZAPAMTI_PROFIL);
        request.setData(profil);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return true;
        }
        throw (Exception) response.getError();
    }

    public boolean izbrisiIgraca() {
        return false;
    }
//        

    public ArrayList<IGeneralEntity> vratiPodUslovom(IGeneralEntity entity) {
        return new ArrayList<>();
    }

    public boolean azurirajTim(Tim tim) throws Exception {
        boolean sacuvano = false;
        Request request = new Request();
        request.setOperation(Operation.OPERATION_AZURIRAJ_TIM);
        request.setData(tim);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return true;
        }
        throw (Exception) response.getError();
    }

    public boolean azurirajIgraca(Igrac igrac) throws Exception {
        boolean sacuvano = false;
        Request request = new Request();
        request.setOperation(Operation.OPERATION_AZURIRAJ_IGRACA);
        request.setData(igrac);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return true;
        }
        throw (Exception) response.getError();
    }

    public ArrayList<Trener> vratiSveTrenere() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_LISTU_TRENERA);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize zahtev");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Trener>) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public boolean azurirajTrenera(Trener trener) throws Exception {
        boolean sacuvano = false;
        Request request = new Request();
        request.setOperation(Operation.OPERATION_AZURIRAJ_TRENERA);
        request.setData(trener);
        try {
            Communication.getInstance().sendRequest(request);
        } catch (IOException ex) {
            Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
        }
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.OK) {
            return true;
        }
        throw (Exception) response.getError();
    }

    public Tim kreirajTim(Tim novi) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_KREIRAJ_TIM);
        request.setData(novi);
        
        Communication.getInstance().sendRequest(request);
        
        Response response = Communication.getInstance().readResponse();
        
        System.out.println("ODGOVOOOR" + response.getStatus());
        if(response.getStatus() == ResponseStatus.ERROR){
            throw (Exception) response.getError();
        }
        return (Tim) response.getData();
    }

    public void obrisiTim(Tim t) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_OBRISI_TIM);
        request.setData(t);
        
        System.out.println("Pre prijema odgovora.. Nikad ne stize odg...");
        Communication.getInstance().sendRequest(request);
        
        Response response = Communication.getInstance().readResponse();
        
        System.out.println("Posle prijema odgovora");
        if(response.getStatus() == ResponseStatus.ERROR){
            throw (Exception) response.getError();
        }
    }

    public Trener kreirajTrenera(Trener novi) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_KREIRAJ_TRENERA);
        request.setData(novi);
        
        Communication.getInstance().sendRequest(request);
        
        Response response = Communication.getInstance().readResponse();
        
        System.out.println("ODGOVOOOR" + response.getStatus());
        if(response.getStatus() == ResponseStatus.ERROR){
            throw (Exception) response.getError();
        }
        return (Trener) response.getData();
    }

    public void obrisiTrenera(Trener t) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_OBRISI_TRENERA);
        request.setData(t);
        Communication.getInstance().sendRequest(request);
        
        Response response = Communication.getInstance().readResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw (Exception) response.getError();
        }
    }

    public int poslednjiRBIgraca() throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_POSLEDNJI_IGRAC);
        
        Communication.getInstance().sendRequest(request);
        
        
        Response response = Communication.getInstance().readResponse();
        System.out.println("Data: " + response.getData());
        System.out.println(response.getStatus());
        if(response.getStatus() == ResponseStatus.OK){
            return (int) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public Igrac kreirajIgraca(Igrac novi) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_KREIRAJ_IGRACA);
        request.setData(novi);
        
        Communication.getInstance().sendRequest(request);
        
        Response response = Communication.getInstance().readResponse();
        
        System.out.println("ODGOVOOOR" + response.getStatus());
        if(response.getStatus() == ResponseStatus.ERROR){
            throw (Exception) response.getError();
        }
        return (Igrac) response.getData();
    }

    public void obrisiIgraca(Igrac igrac) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_OBRISI_IGRACA);
        request.setData(igrac);
        Communication.getInstance().sendRequest(request);
        
        Response response = Communication.getInstance().readResponse();
        if(response.getStatus() == ResponseStatus.ERROR){
            throw (Exception) response.getError();
        }
    }

    

    public ArrayList<Utakmica> vratiUtakmiceTrenera(Trener trener) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_UTAKMICE_DATOG_TRENERA);
        request.setData(trener);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        
        System.out.println("Ceka se odgovor....");
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize odgovor");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Utakmica>) response.getData();
        }
        throw new Exception(response.getError().toString());
        
    }



    public ArrayList<Utakmica> vratiOdabraneUtakmiceTrenera(Utakmica utakmica) throws Exception {
        Request request = new Request();
        request.setOperation(Operation.OPERATION_VRATI_ODABRANE_UTAKMICE_DATOG_TRENERA);
        request.setData(utakmica);
        System.out.println("Poslat zahtev");
        Communication.getInstance().sendRequest(request);
        
        System.out.println("Ceka se odgovor....");
        Response response = Communication.getInstance().readResponse();
        System.out.println("Stize odgovor");
        if (response.getStatus() == ResponseStatus.OK) {
            return (ArrayList<Utakmica>) response.getData();
        }
        throw new Exception(response.getError().toString());
    }

    public boolean logout() throws Exception {
        Request request = new Request();
      
        request.setOperation(Operation.OPERATION_LOGOUT);
       
        Communication.getInstance().sendRequest(request);
       
        Response response = Communication.getInstance().readResponse();
        if (response.getStatus() == ResponseStatus.ERROR) {
            throw (Exception) response.getError();
        }
       return (boolean) response.getData();
    }

    
}
