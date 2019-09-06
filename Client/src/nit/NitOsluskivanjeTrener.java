/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import forme.GlavnaFormaTrener;
import forme.GlavnaFormaTrener;
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
public class NitOsluskivanjeTrener extends Thread{
    GlavnaFormaTrener gft;
    Socket soket;

    public NitOsluskivanjeTrener(GlavnaFormaTrener gft, Socket soket) {
        this.gft = gft;
        this.soket = soket;
    }

    @Override
    public void run() {
       while(!isInterrupted()){
           try {
               ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
               Response r= (Response) in.readObject();
               if(r.getOperation()==Operation.OPERATION_SERVER_UGASEN){
               gft.ugasiGlavnuFormu();
               }
               
           } catch (Exception ex) {
               Logger.getLogger(NitOsluskivanjeTrener.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
    }

    
    
    
}
