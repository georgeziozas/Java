package pack;
import java.io.Serializable;
/**
Ziozas Georgios icsd15058
Chalagiannis Xristos icsd15xxx
 */

public class Booking_implementation implements Serializable {

    private final String spotFrom;
    private final String spotTo;
    private final String dateTo;
    private final String dateFrom;
    private final String passengersNum;
    
    public Booking_implementation(String spotFrom,String spotTo,String dateTo,String dateFrom,String passengersNum){
        this.spotFrom = spotFrom;
        this.spotTo = spotTo;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
        this.passengersNum = passengersNum;
    }
    
    public String getSpotFrom() {
        return spotFrom;
    }

    public String getSpotTo() {
        return spotTo;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public String getPassengersNum() {
        return passengersNum;
    }
    
}
