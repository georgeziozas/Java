package pack;
import java.io.Serializable;
/**
Ziozas Georgios icsd15058
Chalagiannis Xristos icsd15xxx
 */

public class Booking_implementation implements Serializable {

    private String spotFrom;
    private String spotTo;
    private String dateTo;
    private String dateFrom;
    private String passengersNum;
    
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
