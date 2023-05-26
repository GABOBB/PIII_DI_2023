/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class AirWars_S {
    
    public AirWars_S(){
        
    }
    
    private void on_server() throws IOException{
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        DataInputStream in;
        DataOutputStream out;
        final int PORT = 5000;
        final boolean FLAG = true;
        
        try{
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is On!");

            while (true) {
                
                clientSocket = serverSocket.accept();
                System.out.println("Client Connected");

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println("i recive:" + message);
                if(message.equals("hola server")){
                    out.writeUTF("Hola Cliente");
                }    
                
                clientSocket.close();
                System.out.println("Client [1] Disconnected");
            }
        } catch (IOException e) {
            Logger.getLogger(AirWars_S.class.getName()).log(Level.SEVERE, null, e);
        }
    }
        
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
