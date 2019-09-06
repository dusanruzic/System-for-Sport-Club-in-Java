/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

/**
 *
 * @author Milena
 */
public class ZaustavljanjeServera extends Thread{
   PokretanjeServera ps;
    boolean kraj = false;

    public ZaustavljanjeServera(PokretanjeServera ps) {
        this.ps = ps;
    }

   

    

    
    

    @Override
    public void run() {
      while(!kraj){
      if(ps.isInterrupted()){
          try {
             ps.getSs().close();
              kraj=true;
          } catch (IOException ex) {
              Logger.getLogger(ZaustavljanjeServera.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              sleep(1000);
          } catch (InterruptedException ex) {
              Logger.getLogger(ZaustavljanjeServera.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      }
    }
    
    
}
