/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Milena
 */
public class Server {
    private boolean active=true;
    
    public void start() throws IOException{
        ServerSocket ss= new ServerSocket(9000);
        System.out.println("Ceka na konekcije....");
        while(active){
            Socket socket= ss.accept();
            System.out.println("Novi klijent");
            
            ClientThread clientThread= new ClientThread(socket);
            clientThread.start();
        }
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
