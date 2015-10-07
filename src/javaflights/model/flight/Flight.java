package javaflights.model.flight;

import javaflights.model.flight.city.City;
import javaflights.model.flight.airport.Airport;

/**
 * The instance of <code>Flight</code> class represents some particular flight.
 * Flight has no, departure (<code>Aiprort</code> object), destination (<code>Aiprort</code> object),
 * domestic/international flag (determinded in constructor from fields of departure and destination),
 * shedule (<code>Shedule</code> object), aircraft used for flight (<code>Aircraft</code> object),
 * air company (<code>AirCompany</code> object).
 *
 * @author Aigul Zainullina
 * @see javaflights.flight
 * @see javaflights.model.flight.airport
 */
public class Flight {
    private String no;
    private Airport from;
    private Airport to;
    private boolean domestic;

    private Shedule shedule;
    private AirCraft aircraft;
    private AirCompany aircompany;

    /**
     * Constructor assumes only proper values according to required types
     *
     * @param from
     * @param to
     * @param shedule
     * @param aircraft
     * @param aircompany
     */
    public Flight(Airport from, Airport to, Shedule shedule,
                  AirCraft aircraft, AirCompany aircompany) {
        no = Integer.toString(this.hashCode());
        this.from = from;
        this.to = to;
        if (from.getCity().getCountry().equals(to.getCity().getCountry())) {
            domestic = true;
        }
        this.shedule = shedule;
        this.aircraft = aircraft;
        this.aircompany = aircompany;
    }

    /**
     * Overrided <code>to String</code> method
     *
     * @return String object with information about current flight
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\nno: ").append(getNo())
                .append("; From: ").append(from.getCode()).append(", ").append(from.getCity().toString())
                .append(", To: ").append(to.getCode()).append(", ").append(to.getCity().toString())
                .append("; Type: ").append(getType())
                .append("\n").append("Total Seats: ")
                .append("First Class: ").append(getAircraft().getNumberOfSeatsFirstClass())
                .append("; Business Class: ").append(getAircraft().getNumberOfSeatsBusinessClass())
                .append("; Econom Class: ").append(getAircraft().getNumberOfSeatsEconomClass())
                .append("\nAircraft model: ").append(getAircraft().getModel())
                .append("; Aircompany: ").append(getAircompany().getName())
                .append("\nNearest Flight: ").append(getShedule().getNearestFlight().toString());
        return out.toString();
    }

    public String getType() {
        if (domestic) {
            return "Domestic Flight";
        } else {
            return "International Flight";
        }
    }

    public City getFromCity() {
        return from.getCity();
    }

    public City getToCity() {
        return to.getCity();
    }

    public Shedule getShedule() {
        return shedule;
    }

    public AirCraft getAircraft() {
        return aircraft;
    }

    public AirCompany getAircompany() {
        return aircompany;
    }

    public String getNo() {
        return no;
    }

}
    

