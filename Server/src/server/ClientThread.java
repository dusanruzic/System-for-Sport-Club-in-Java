/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.IGeneralEntity;
import domen.Igrac;
import domen.Menadzer;
import domen.Pozicija;
import domen.Profil;
import domen.Sport;
import domen.StatistikaIgracaSaUtakmice;
import domen.Tim;
import domen.Trener;
import domen.Utakmica;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.Kontroler;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Milena
 */
public class ClientThread extends Thread {

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            communication();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void communication() throws IOException, ClassNotFoundException {
        while (!isInterrupted()) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            Object object = inSocket.readObject();
            if (object instanceof Request) {
                Request request = (Request) object;
                Response response = handleRequest(request);
                sendResponse(response);
            }

        }
    }

    private Response handleRequest(Request request) {
        int operation = request.getOperation();
        Response response = new Response();
        System.out.println("Operation: " + operation);
        switch (operation) {
//            case Operation.OPERATION_LOGIN_MANAGER:
//                Menadzer m = (Menadzer) request.getData();
//
//                 {
//                    try {
//                        Menadzer menadzer = Kontroler.getInstanca().proveriMenadzera(m.getProfil().getKorisnickoIme(), m.getProfil().getKorisnickaLozinka());
//                        response.setStatus(ResponseStatus.OK);
//                        response.setData(menadzer);
//
//                    } catch (Exception ex) {
//                        response.setStatus(ResponseStatus.ERROR);
//                        response.setError(ex);
//                    }
//
//                }
//                break;
//            case Operation.OPERATION_LOGIN_TRAINER:
//                Trener t = (Trener) request.getData();
//
//                 {
//                    try {
//                        Trener trener = Kontroler.getInstanca().proveriTrenera(t.getProfil().getKorisnickoIme(), t.getProfil().getKorisnickaLozinka());
//                        response.setStatus(ResponseStatus.OK);
//                        response.setData(trener);
//
//                    } catch (Exception ex) {
//                        response.setStatus(ResponseStatus.ERROR);
//                        response.setError(ex);
//                    }
//
//                }
//                break;
            case Operation.OPERATION_PRIJAVI_SE:
                if (request.getData() instanceof Trener) {
                    Trener tr = (Trener) request.getData();

                    {
                        try {
                            Trener trener = Kontroler.getInstanca().proveriTrenera(tr.getProfil().getKorisnickoIme(), tr.getProfil().getKorisnickaLozinka());
                            response.setStatus(ResponseStatus.OK);
                            response.setData(trener);

                        } catch (Exception ex) {
                            response.setStatus(ResponseStatus.ERROR);
                            response.setError(ex);
                        }

                    }
                } else if (request.getData() instanceof Menadzer) {
                    Menadzer mn = (Menadzer) request.getData();

                    {
                        try {
                            Menadzer menadzer = Kontroler.getInstanca().proveriMenadzera(mn.getProfil().getKorisnickoIme(), mn.getProfil().getKorisnickaLozinka());
                            response.setStatus(ResponseStatus.OK);
                            response.setData(menadzer);

                        } catch (Exception ex) {
                            response.setStatus(ResponseStatus.ERROR);
                            response.setError(ex);
                        }

                    }
                }
                break;
            case Operation.OPERATION_VRATI_LISTU_TIMOVA:
                try {
                    Tim tim = new Tim();
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiListuTimova(tim);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_VRATI_LISTU_SPORTOVA:
                try {
                    Sport sport = new Sport();
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiListuSportova(sport);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_VRATI_LISTU_TRENERA_DATOG_SPORTA:
                try {
                    Sport sport = (Sport) request.getData();
                    Trener trener = new Trener();
                    trener.setSport(sport);
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiListuTreneraOdredjenogSporta(trener);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_VRATI_LISTU_POZICIJA_DATOG_SPORTA:
                try {
                    Sport sport = (Sport) request.getData();
                    Pozicija pozicija = new Pozicija();
                    pozicija.setSport(sport);
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiListuPozicijaOdredjenogSporta(pozicija);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_PRONADJI_IGRACE:
                try {
                    Igrac igrac = (Igrac) request.getData();
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiIgracaPodUslovom(igrac);
                    System.out.println("Velicina povratne liste igraca: " + list.size());
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    System.out.println("Baca exception kod vracanja igraca pod uslovom");
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_ZAPAMTI_TIM:
                try {
                    IGeneralEntity entity = (Tim) request.getData();
                    Kontroler.getInstanca().zapamtiTim(entity);
                    response.setData(entity);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_ZAPAMTI_PROFIL:
                try {
                    Profil profil = (Profil) request.getData();
                    Kontroler.getInstanca().zapamtiProfil(profil);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_ZAPAMTI_TRENERA:
                try {
                    Trener trener = (Trener) request.getData();
                    Kontroler.getInstanca().zapamtiTrenera(trener);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_ZAPAMTI_IGRACA:
                try {
                    Igrac igrac = (Igrac) request.getData();
                    Kontroler.getInstanca().zapamtiIgraca(igrac);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_ZAPAMTI_STATISTIKE:
                try {
                    ArrayList<StatistikaIgracaSaUtakmice> statistike = (ArrayList<StatistikaIgracaSaUtakmice>) request.getData();
                    
                    System.out.println("Duzina liste: " + statistike.size());
                    
//                    for (StatistikaIgracaSaUtakmice statistikaIgracaSaUtakmice : statistike) {
//                        Kontroler.getInstanca().zapamtiStatistiku((IGeneralEntity) statistikaIgracaSaUtakmice);
//
//                    }
                    Kontroler.getInstanca().zapamtiStatistike(statistike);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_VRATI_TIMOVE_DATOG_TRENERA:
                try {
                    Trener trener = (Trener) request.getData();
                    Tim tim = new Tim();
                    tim.setTrener(trener);
                    List<IGeneralEntity> list = Kontroler.getInstanca().vratiListuTimovaOdredjenogTrenera(tim);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_VRATI_UTAKMICE_DATOG_TIMA:
                try {
                    Tim tim = (Tim) request.getData();
                    Utakmica utakmica = new Utakmica();
                    utakmica.setTim(tim);
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiListuUtakmicaOdredjenogTima(utakmica);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_AZURIRAJ_TIM:
                try {
                    Tim tim = (Tim) request.getData();
                    Kontroler.getInstanca().azurirajTim(tim);
                    response.setStatus(ResponseStatus.OK);
                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);

                }
                break;
            case Operation.OPERATION_AZURIRAJ_TRENERA:
                try {
                    Trener trener = (Trener) request.getData();
                    Kontroler.getInstanca().azurirajTrenera(trener);
                    response.setStatus(ResponseStatus.OK);
                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);

                }
                break;
            case Operation.OPERATION_AZURIRAJ_IGRACA:
                try {
                    Igrac igrac = (Igrac) request.getData();
                    Kontroler.getInstanca().azurirajIgraca(igrac);
                    response.setStatus(ResponseStatus.OK);
                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);

                }
                break;
            case Operation.OPERATION_PRONADJI_STATISTIKE:
                try {
                    StatistikaIgracaSaUtakmice stat = (StatistikaIgracaSaUtakmice) request.getData();
                    List<IGeneralEntity> list = Kontroler.getInstanca().vratiStatistikeIgraca(stat);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_POSLEDNI_TIM:
                try {
                    Object rb = Kontroler.getInstanca().poslednjiRBTima();
                    response.setData(rb);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                
            case Operation.OPERATION_KREIRAJ_TIM:
                try {
                    IGeneralEntity entity = Kontroler.getInstanca().kreirajTim((Tim) request.getData());
                    
                    response.setData(entity);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
//            case Operation.OPERATION_PRONADJI_TIM:
//                try {
//                    IGeneralEntity entity = Kontroler.getInstanca().pronadjiTim((int) request.getData());
//                    
//                    response.setData(entity);
//                    response.setStatus(ResponseStatus.OK);
//
//                } catch (Exception ex) {
//                    response.setStatus(ResponseStatus.ERROR);
//                    response.setError(ex);
//                }
//                break;
            case Operation.OPERATION_OBRISI_TIM:
                try {
                    
                    System.out.println("Pre brisanja");
                    Kontroler.getInstanca().obrisiTim((Tim) request.getData());
                    
                    System.out.println("Pre slanja odgovora");
                    
                    response.setStatus(ResponseStatus.OK);
                    
                    System.out.println("Posle slanja odgovora");

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
             case Operation.OPERATION_VRATI_LISTU_TRENERA:
                try {
                    Trener trener = new Trener();
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiSve(trener);
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_POSLEDNJI_TRENER:
                try {
                    Object rb = Kontroler.getInstanca().poslednjiRBTrenera();
                    response.setData(rb);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                
            case Operation.OPERATION_KREIRAJ_TRENERA:
                try {
                    IGeneralEntity entity = Kontroler.getInstanca().kreirajTrenera((Trener) request.getData());
                    
                    response.setData(entity);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_OBRISI_TRENERA:
                try {
                    
                    System.out.println("Pre brisanja");
                    Kontroler.getInstanca().obrisiTrenera((Trener) request.getData());
                    
                    System.out.println("Pre slanja odgovora");
                    
                    response.setStatus(ResponseStatus.OK);
                    
                    System.out.println("Posle slanja odgovora");

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_POSLEDNJI_IGRAC:
                try {
                    Object rb = Kontroler.getInstanca().poslednjiRBIgraca();
                    response.setData(rb);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
                
            case Operation.OPERATION_KREIRAJ_IGRACA:
                try {
                    IGeneralEntity entity = Kontroler.getInstanca().kreirajIgraca((Igrac) request.getData());
                    
                    response.setData(entity);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_OBRISI_IGRACA:
                try {
                    
                    System.out.println("Pre brisanja");
                    Kontroler.getInstanca().obrisiIgraca((Igrac) request.getData());
                    
                    System.out.println("Pre slanja odgovora");
                    
                    response.setStatus(ResponseStatus.OK);
                    
                    System.out.println("Posle slanja odgovora");

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_VRATI_UTAKMICE_DATOG_TRENERA:
                try {
                    
                    Trener trener = (Trener) request.getData();
                    
                    System.out.println("Prihvatio trenera...TRENER JE : " + trener);
                    Utakmica utakmica = new Utakmica();
                    utakmica.setTim(new Tim());
                    utakmica.getTim().setTrener(trener);
                    System.out.println("Na serveru pre akcije");
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiListuUtakmicaOdredjenogTrenera(utakmica);
                    
                    System.out.println("Na serveru posle akcije");
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_VRATI_ODABRANE_UTAKMICE_DATOG_TRENERA:
                try {
                    
                    Utakmica utakmica = (Utakmica) request.getData();
                    
                    System.out.println("Prihvatio utakmicu...UTAKMICA JE : " + utakmica);
                    
                    System.out.println("Na serveru pre akcije");
                    ArrayList<IGeneralEntity> list = Kontroler.getInstanca().vratiListuUtakmicaOdredjenogTrenera(utakmica);
                    
                    System.out.println("Na serveru posle akcije");
                    response.setData(list);
                    response.setStatus(ResponseStatus.OK);

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            case Operation.OPERATION_LOGOUT:
                try {
                    
                    response.setStatus(ResponseStatus.OK);
                    response.setData(true);
                    this.interrupt();

                } catch (Exception ex) {
                    response.setStatus(ResponseStatus.ERROR);
                    response.setError(ex);
                }
                break;
            
                

//            case Operation.OPERATION_OBRADI_PREGLED:
//                try{
//                    Controler.vratiInstancu().obradiPregled((Pregled) request.getData());
//                    response.setStatus(ResponseStatus.OK);
//                
//                }catch(Exception ex){
//                response.setStatus(ResponseStatus.ERROR);
//                response.setError(ex);
//                }
//                break;
//            case Operation.OPERATION_ZAPAMTI_POR:
//                try{
//                    IGeneralEntity entity= Controler.vratiInstancu().zapamtiPor((Porudzbenica) request.getData());
//                    response.setData(entity);
//                    response.setStatus(ResponseStatus.OK);
//                    
//                }catch(Exception ex){
//                 response.setStatus(ResponseStatus.ERROR);
//                response.setError(ex);
//                }
//                break;
//            case Operation.OPERATION_OBRADI_POR:
//                try{
//                    Controler.vratiInstancu().zapamtiPor((Porudzbenica) request.getData());
//                    response.setStatus(ResponseStatus.OK);
//                
//                }catch(Exception ex){
//                response.setStatus(ResponseStatus.ERROR);
//                response.setError(ex);
//                }
//                break;
//            case Operation.OPERATION_POSLEDNJI_RB_PORUDZBENICE:
//                try{
//                int rb=Controler.vratiInstancu().poslednjiRBPorudzbenice((TipPorudzbenice) request.getData());
//                    response.setData(rb);
//                    response.setStatus(ResponseStatus.OK);
//                }catch(Exception ex){
//                response.setStatus(ResponseStatus.ERROR);
//                response.setError(ex);
//                }
//                break;
//            case Operation.OPERATION_PRONADJI_POR:
//                try{
//                IGeneralEntity entity= Controler.vratiInstancu().pronadjiPor((Long) request.getData());
//                response.setData(entity);
//                response.setStatus(ResponseStatus.OK);
//                }catch(Exception ex){
//                response.setStatus(ResponseStatus.ERROR);
//                response.setError(ex);
//                }
//                break;
        }
        return response;
    }

    private void sendResponse(Response response) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(response);
    }
    
    public Socket getSocket() {
        return socket;
    }

}
