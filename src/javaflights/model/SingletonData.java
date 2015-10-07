package javaflights.model;

import javaflights.model.flight.FlightsFactory;
import javaflights.model.flight.ticket.TicketsFactory;
import javaflights.model.flight.city.CitiesFactory;
import javaflights.model.flight.airport.AirportsFactory;

import java.util.List;

/**
 * Class represents static values of data which application work with (flights, cities, airports and tickets)
 * represented by <code>List</code> objects.
 * <p/>
 * Represents Singleton Design Pattern.
 * Singleton pattern is used because there can be only single instance of existing flights, tickets, airports
 * and cities while application is being run once.
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.model.flight
 */
public class SingletonData {
    private static SingletonData instance;
    private static boolean instanceExists = false;
    private static List flights;
    private static List cities;
    private static List airports;
    private static List tickets;

    /**
     * Constructor assumes receiving proper values according to needed types
     *
     * @param flights_  List of <code>Fligth</code> instances
     * @param cities_   List of <code>City</code> instances
     * @param airports_ List of <code>Airport</code> instances
     * @see javaflights.model.flight.airport.Airport
     * @see javaflights.model.flight.city.City
     * @see javaflights.model.flight.Flight
     */
    public SingletonData(List flights_, List cities_, List airports_) {
        flights = flights_;
        cities = cities_;
        airports = airports_;
        instanceExists = true;
    }

    /**
     * @return Single instance of <code>SingletonData</code> class
     */
    public static SingletonData instanceOf() {
        return instance;
    }

    /**
     * Registers instance of <code>SingletonData</code> class. Checks if it is already exists.
     *
     * @throws SingletonInstanceExistsException
     *          throwed if instance of <code>SingletonData</code> class already exists.
     */
    public static void register() throws SingletonInstanceExistsException {
        if (!instanceExists) {
            cities = CitiesFactory.createCitiesDefaults();
            airports = AirportsFactory.createAirportsDefaults(cities);
            flights = FlightsFactory.createFlightsDefaults(airports);
            TicketsFactory.setGeneralPrice(200);
            TicketsFactory.setCoefBusiness(1.2);
            TicketsFactory.setCoefEconom(0.7);
            TicketsFactory.setCoefFirst(2);
            tickets = TicketsFactory.createTicketsDefaults();
            instance = new SingletonData(flights, cities, airports);
        } else {
            throw new SingletonInstanceExistsException();
        }
    }

    public static List getFlights() {
        return flights;
    }

    public static List getCities() {
        return cities;
    }

    public static List getTickets() {
        return tickets;
    }

    public static List getAirports() {
        return airports;
    }
}


