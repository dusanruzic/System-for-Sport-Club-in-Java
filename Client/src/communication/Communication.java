/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Milena
 */
public class Communication {
    private static Communication instance;
    private static Socket socket;

    
    private Communication(Socket socket) throws IOException {
        this.socket = socket;
    }
    public static Communication getInstance() throws IOException{
    if(instance==null){
    instance= new Communication(socket);
    }
    return instance;
    }
    public void sendRequest(Request request) throws IOException{
        ObjectOutputStream outStream= new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject(request);
    }
    public Response readResponse() throws IOException, ClassNotFoundException{
        ObjectInputStream inSocket= new ObjectInputStream(socket.getInputStream());
        return (Response) inSocket.readObject();
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
    
    
}
