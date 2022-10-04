package pack;
import java.rmi.*;
import java.util.List;

/**
Ziozas Georgios icsd15058
Chalagiannis Xristos icsd15xxx
 */

public interface Booking_interface extends Remote
{
    public List<Booking_implementation> bookingAvailability(Booking_implementation cl) throws RemoteException;
   public boolean confirmBooking(Booking_implementation cl) throws RemoteException;
}
