/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import form.ServerskaForma;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ClientThread;
import transfer.Response;
import transfer.util.Operation;
import static transfer.util.Operation.OPERATION_SERVER_UGASEN;
import transfer.util.ResponseStatus;

/**
 *
 * @author Milena
 */
public class PokretanjeServera extends Thread {

    ServerskaForma sf;
    ServerSocket ss;
    private List<ClientThread> listaKlijenata;

    public PokretanjeServera(ServerskaForma sf) {
        this.sf = sf;
        listaKlijenata = new LinkedList<>();
    }

    @Override
    public void run() {

        try {
            ss = new ServerSocket(9000);

            ZaustavljanjeServera zs = new ZaustavljanjeServera(this);
           zs.start();
            while (!isInterrupted()) {
                Socket soket = ss.accept();
                System.out.println("Klijent se povezao");
                ClientThread client = new ClientThread(soket);

                client.start();
                listaKlijenata.add(client);
            }
        } catch (IOException ex) {

            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ServerSocket getSs() {
        return ss;
    }

    public List<ClientThread> getListaKlijenata() {
        return listaKlijenata;
    }

    public void kaziImDaJeServerZaustavljen() throws IOException {
        Response r = new Response();
        r.setOperation(OPERATION_SERVER_UGASEN);
        r.setStatus(ResponseStatus.OK);
        r.setData("Server je ugasen");
        for (ClientThread clientThread : listaKlijenata) {
            ObjectOutputStream out = new ObjectOutputStream(clientThread.getSocket().getOutputStream());

            out.writeObject(r);

        }

    }

}
