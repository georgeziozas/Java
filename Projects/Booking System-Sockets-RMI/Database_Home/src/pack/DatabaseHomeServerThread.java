/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DatabaseHomeServerThread extends Thread{
    private Socket socket;
    public static byte[] bytes;
    ObjectOutputStream outToServer;
    ObjectInputStream inFromServer;

//list with available flights
    private List<Booking_implementation> available_flights = new ArrayList<>();
//list with the booked flights 
    private List<Booking_implementation> bookings = new ArrayList<>();
//list with the booked flights 
    private List<Booking_implementation> results_to_user = new ArrayList<>();
    
    public DatabaseHomeServerThread(Socket socket) throws IOException{
        super("thread server");
        
        this.outToServer = new ObjectOutputStream(socket.getOutputStream());
        this.inFromServer = new ObjectInputStream(socket.getInputStream());
        this.socket = socket;
        available_flights_init();
        
    }
    
    public void run(){
        synchronized(this){
        try {
            communicate_with_middleman();
        } catch (IOException ex) {
            Logger.getLogger(DatabaseHomeServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHomeServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public void communicate_with_middleman() throws IOException, ClassNotFoundException {

        

//Server is running always. This is done using this while(true) loop
        while (true) {

            String action = inFromServer.readUTF();
            switch (action) {
                case "search":
//Reading the message from the client
                    
                    Booking_implementation received;
                    received = (Booking_implementation) inFromServer.readObject();
                    //test--System.out.println("Message (Booking Implementation) as received from middleman is " + received);

//Check with the arrays if the booking is possible 
                    for (Booking_implementation value : available_flights) {
                        if (value.getSpotFrom() == received.getSpotFrom()
                                && value.getSpotTo() == received.getSpotTo()
                                && value.getDateFrom() == received.getDateFrom()
                                && value.getDateTo() == received.getDateTo()) {

                            results_to_user.add(value);
                        }
                    }

//Sending the response back to the client.
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(results_to_user);
                    bytes = bos.toByteArray();
                    outToServer.write(bytes);
                    outToServer.flush();
                //test-- System.out.println("Message sent to the middleman is " + Arrays.toString(bytes));

                case "book":
//Reading the message from the client
                    
                    bookings.addAll(results_to_user);
//Sending the response back to the client.
                    outToServer.writeBoolean(true);
                    outToServer.flush();

            }

        }

    }

//array initilization
    public final void available_flights_init() {
        available_flights.add(01, new Booking_implementation("a", "b", "c", "d", "5"));
        available_flights.add(01, new Booking_implementation("A", "B", "C", "D", "6"));
    }

    ;
}
