package pack;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ziozas Georgios icsd15058 Chalagiannis Xristos icsd15xxx
 */
public class DatabaseHomeServer {

    ServerSocket serverSocket ;
    
    public static void main(String args[]) throws Exception {
        ServerSocket serverSocket = null;
        int port = 25000;
        serverSocket = new ServerSocket(port);
        System.out.println("Server Started and listening to the port 25000");
        while(true){
            Socket clientSocket = serverSocket.accept();
            
            DatabaseHomeServerThread t = new DatabaseHomeServerThread(clientSocket); //thread creation
            t.start();
            
            
        }
        
        
    }
    
}
