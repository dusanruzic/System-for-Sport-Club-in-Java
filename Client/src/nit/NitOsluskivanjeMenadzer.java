/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import communication.Communication;
import forme.GlavnaFormaMenadzer;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Response;
import transfer.util.Operation;

/**
 *
 * @author Milena
 */
public class NitOsluskivanjeMenadzer extends Thread{
    GlavnaFormaMenadzer gfm;
    Socket soket;

    public NitOsluskivanjeMenadzer(GlavnaFormaMenadzer gfm, Socket soket) {
        this.gfm = gfm;
        this.soket = soket;
    }

    @Override
    public void run() {
       while(!isInterrupted()){
           try {
               //ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
               
               Response response = Communication.getInstance().readResponse();
               
               System.out.println("Lepo prosao");
               if(response.getOperation()==Operation.OPERATION_SERVER_UGASEN){
               gfm.ugasiGlavnuFormu();
               }
               
           } catch (Exception ex) {
               Logger.getLogger(NitOsluskivanjeMenadzer.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
    }

    
    
    
}
