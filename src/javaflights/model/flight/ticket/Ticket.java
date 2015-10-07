package javaflights.model.flight.ticket;

import javaflights.model.flight.FlightDate;
import javaflights.model.flight.Flight;
import javaflights.model.flight.travelclass.ClassCode;

/**
 * The instance of <code>Ticket</code> class represents some particular ticket for particular flight.
 * Ticket has no, parent (<code>Flight</code> object), flight date (<code>FlightDate</code> object),
 * night flight flag (determinded in constructor from fields of flight date),
 * availible flag (default value is true, but if ticket is booked value=false),
 * travel class ("Business class/Econom/Coach Class/First Class"),
 * prime price of a ticket,
 * sold price and customer info when ticket is booked (unavailible)
 *
 * @author Aigul Zainullina
 *         Represents WidgetFactory Design Pattern
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.flight
 */
public class Ticket {
    private String no;
    private Flight parent;
    private FlightDate flightDate;
    private boolean nightFlight;
    private boolean availible = true;
    private ClassCode classCode;
    private String travelClass;
    private double primePriceUSD;
    private double soldPrice;
    private String customerInfo;

    /**
     * Constructor assumes only proper values according to required types
     *
     * @param parent
     * @param travelClass
     * @param flightDate
     * @param primePriceUSD
     */
    public Ticket(Flight parent, String travelClass, FlightDate flightDate, double primePriceUSD) {
        no = Integer.toString(this.hashCode());
        this.parent = parent;
        this.travelClass = travelClass;
        this.primePriceUSD = primePriceUSD;
        this.flightDate = flightDate;
        setIfNightFlight();
    }

    /**
     * Overrided <code>to String</code> method
     *
     * @return String object with <i>sold</i> information about ticket
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        out
                //.append("\nTicket No: ").append(no)
                .append("\nFlight No: ").append(getParent().getNo())
                .append("\nFrom: ").append(parent.getFromCity().toString())
                .append("\nTo: ").append(parent.getToCity().toString())
                .append("\nDate: ").append(flightDate.toString())
                .append("\nClass: ").append(travelClass)
                .append("\nNight Flight: ").append(nightFlight)
                .append("\nAircraft model: ").append(getParent().getAircraft().getModel())
                .append("\nMaximum baggage weight (kg): ").append(getParent().getAircraft().getBaggageMaxKG())
                .append("\nAircompany: ").append(getParent().getAircompany().getName())
                .append("\nClass Code: ").append(getClassCode().getName())
                .append("\nCustomer Info: ").append(customerInfo)
                .append("\nSold by price: ").append(soldPrice);
        //.append("Availible: ").append(availible).append("\n")
        //.append("Prime price (USD): ").append(primePriceUSD).append("\n");
        return out.toString();
    }

    /**
     * metho determinds if flight is night flight or not by checking hours of flight date
     */
    public void setIfNightFlight() {
        if ((flightDate.getHours() < 6) && (flightDate.getHours() > 0)) {
            this.nightFlight = true;
        }
    }

    public ClassCode getClassCode() {
        return classCode;
    }

    public void setClassCode(ClassCode classCode) {
        this.classCode = classCode;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public Flight getParent() {
        return parent;
    }

    public FlightDate getFlightDate() {
        return flightDate;
    }

    public boolean isAvailible() {
        return availible;
    }

    public void setAvailible(boolean availible) {
        this.availible = availible;
    }

    public double getPrimePriceUSD() {
        return primePriceUSD;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public String getNo() {
        return no;
    }

}
