/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import form.ServerskaForma;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import server.Server;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Milena
 */
public class Start {
   
   
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
//        Server server= new Server();
//        server.start();
        ServerskaForma sf = new ServerskaForma();
        sf.setVisible(true);
    }
}
