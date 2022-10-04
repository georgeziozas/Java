package pack;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Ziozas Georgios icsd15058 Chalagiannis Xristos icsd15xxx
 */
public class Booking_server extends UnicastRemoteObject implements Booking_interface {

    private List<Booking_implementation> retrieve;
    private boolean response_from_final_booking;
    private String host;
    private int port;
    private InetAddress address;
    private static Socket socket;

    public Booking_server() throws RemoteException {
        super();
    }

    @Override
//Sending the client's booking request to the main server for further check and returning the results of this query.
    public synchronized List<Booking_implementation> bookingAvailability(Booking_implementation cl) throws RemoteException {
        try {

            BookingAvailabilityRequestToMainServer(cl);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Booking_server.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retrieve;
    }

    @Override
    public synchronized boolean confirmBooking(Booking_implementation cl) throws RemoteException {
        try {
            BookingConfirmationRequestToMainServer(cl);
        } catch (IOException ex) {
            Logger.getLogger(Booking_server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response_from_final_booking;
    }

    public void BookingAvailabilityRequestToMainServer(Booking_implementation flight_order) throws IOException, ClassNotFoundException {

        this.host = "localhost";
        this.port = 25000;
        address = InetAddress.getByName(host);
        socket = new Socket(address, port);

        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());

//send first to the server the specific part of code you want from him to excecute.
        outToServer.writeUTF("search");
        outToServer.flush();

//Send the Message Object to the server 
        outToServer.writeObject(flight_order);
        outToServer.flush();
        //-testSystem.out.println("Message sent to the server : " + flight_order);

//Retrive the Message Object from server
        ByteArrayInputStream bis = new ByteArrayInputStream(new byte[1024]);
        ObjectInputStream inFromServer = new ObjectInputStream(bis);
        retrieve = (List<Booking_implementation>) inFromServer.readObject();
        System.out.println("Message response sent from the server : " + retrieve);

        socket.close();
    }

    ;
  public void BookingConfirmationRequestToMainServer(Booking_implementation flight_order) throws IOException {
        this.host = "localhost";
        this.port = 25000;
        address = InetAddress.getByName(host);
        socket = new Socket(address, port);

        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

//send first to the server the specific part of code you want from him to excecute.
        outToServer.writeUTF("book");
        outToServer.flush();

        //Send the Message Object to the server 
        outToServer.writeObject(flight_order);
        outToServer.flush();
        //-testSystem.out.println("Message sent to the server : " + flight_order);

//Get the response from the server.
        response_from_final_booking = inFromServer.readBoolean();
        System.out.println("Message response sent from the server : " + response_from_final_booking);
    }

    public static void main(String[] args) throws AlreadyBoundException, MalformedURLException {

           //RMISecurityManager security = new RMISecurityManager();
        //System.setSecurityManager(security);
        try {
            Booking_server look = new Booking_server();
            // Booking_implementation stub = (Booking_implementation) UnicastRemoteObject.exportObject(look, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("giozio", look);
            System.out.println("Server is ready for remote invocations by client");

        } catch (RemoteException ex) {
            ex.printStackTrace();
        }

    }

}
