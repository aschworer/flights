package javaflights.model.flight;

import javaflights.model.flight.airport.Airport;
import javaflights.model.flight.airport.AirportNotFoundException;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The FlightsFactory class implements methods that create List of {@link Flight Flight} class objects.
 * It can be performed as a class implementing interface <code>AbstractFlightsFactory</code>
 * if we had an apportunity to change way of factoring objects of {@link Flight Flight} class.
 * for example if we had another way of storaging and receiving data (not a constant structure)
 * Represents WidgetFactory Design Pattern
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.flight
 */
public class FlightsFactory {
    private static Shedule sh[] = new Shedule[5];

    /**
     * Method creates 5 flights (instances of <code>Flight</code> class).
     * At first method creates 4 instances of <code>AirCompany</code> class,
     * 4 instances of <code>AirCraft</code> clas and 5 instances of <code>Shedule</code> class for
     * using them in constructor of <code>Flight</code> class
     *
     * @return List of <code>Flight</code> objects.
     */
    public static List createFlightsDefaults(List airports) {
        List flights = new ArrayList();

        AirCompany acn1 = new AirCompany("Pulkovo");
        AirCompany acn2 = new AirCompany("Aeroflot");
        AirCompany acn3 = new AirCompany("British Airways");
        AirCompany acn4 = new AirCompany("American Airlines");

        AirCraft ac1 = new AirCraft("Tu-154", "Tupolev", 20, 100, 100, 100);
        AirCraft ac2 = new AirCraft("Tu-134", "Tupolev", 10, 20, 30, 100);
        AirCraft ac3 = new AirCraft("An-24", "Antonov", 5, 40, 10, 20);
        AirCraft ac4 = new AirCraft("Boeing-747", "Boeing", 30, 30, 20, 200);

        sh[0] = new Shedule(2006, 11, 20, 13, 30, 2006, 12, 30, 1);
        sh[1] = new Shedule(2006, 11, 1, 0, 50, 2007, 5, 1, 5);
        sh[2] = new Shedule(2006, 12, 2, 15, 20, 2007, 12, 4, 14);
        //Shedule sh3 = new Shedule(2006,12,12,20,30, 2007,02,20, 30);
        sh[3] = new Shedule(2007, 1, 30, 15, 50, 2007, 7, 20, 50);
        sh[4] = new Shedule(2008, 1, 1, 0, 0);

        setValidFlight(flights, airports, "Domodedovo", "Moscow", "Pulkovo-I", "Saint_Petersburg", sh[0], ac1, acn1);
        setValidFlight(flights, airports, "Sheremetievo", "Moscow", "Pulkovo-I", "Saint_Petersburg", sh[1], ac2, acn2);
        setValidFlight(flights, airports, "A1", "Madrid", "Pulkovo-II", "Saint_Petersburg", sh[2], ac3, acn3);
        setValidFlight(flights, airports, "Pulkovo-II", "Saint_Petersburg", "A1", "Stockholm", sh[3], ac4, acn4);
        setValidFlight(flights, airports, "Sheremetievo", "Moscow", "A1", "London", sh[4], ac1, acn4);

        return flights;
    }

    private static void setValidFlight(List flights, List airports, String fromAirportName, String fromCity,
                                       String toAirportName, String toCity, Shedule shedule,
                                       AirCraft act, AirCompany acn) {
        try {
            Airport from = returnAirport(airports, fromAirportName, fromCity);
            Airport to = returnAirport(airports, toAirportName, toCity);
            flights.add(new Flight(from, to, shedule, act, acn));
        } catch (AirportNotFoundException ee) {
            System.err.println("Airport is incorrect");
        }
    }

    /**
     * Private method for returning Airport object with required name and city fields from List of <code>Airport</code> objects.
     * Usially used while creating {@link javaflights.model.flight.Flight Flight} objects.
     *
     * @param airports is a List where required airport will be searched
     * @param airport  is a name of required airport
     * @param city     is a location of required airport
     * @return required object of <code>Airport</code> class
     * @throws AirportNotFoundException if required airport wasn't found
     */
    private static Airport returnAirport(List airports, String airport, String city) throws AirportNotFoundException {
        for (Iterator iterator = airports.iterator(); iterator.hasNext();) {
            Airport o = (Airport) iterator.next();
            if (airport.equals(o.getCode()) && (o.getCity().getName().equals(city))) {
                return o;
            }
        }
        throw new AirportNotFoundException();
    }

}
