/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.LoginForma;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import sesija.Session;

/**
 *
 * @author Milena
 */
public class Start {
    public static void main(String[] args) throws IOException {
        Socket socket= new Socket("127.0.0.1",9000);
        Session.getInstance().setSocket(socket);
        communication.Communication.getInstance().setSocket(socket);
        
        JFrame lg = new LoginForma();
        lg.setVisible(true);
    }
}
