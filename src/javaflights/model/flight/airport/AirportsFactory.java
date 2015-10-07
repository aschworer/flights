package javaflights.model.flight.airport;

import javaflights.model.flight.city.City;
import javaflights.model.flight.city.CityNotFoundException;
import javaflights.model.flight.city.CitiesFactory;

import java.util.List;
import java.util.ArrayList;

/**
 * The AirportsFactory class implements methods that create List of {@link Airport Airport} class objects.
 * It can be performed as a class implementing interface <code>AbstractAirportsFactory</code>
 * if we had an apportunity to change way of factoring objects of {@link Airport Airport} class.
 * for example if we had another way of storaging and receiving data (not a constant structure)
 * Represents WidgetFactory Design Pattern
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.flight
 */
public class AirportsFactory {
    /**
     * Method creates 8 objects of {@link Airport Airport} class
     *
     * @param cities is used for checking if Airport location ({@link javaflights.model.flight.city.City City}) is valid (city exists)
     * @return List of Airport objects
     */
    public static List createAirportsDefaults(List cities) {
        List airports = new ArrayList();
        setValidAirport(airports, cities, "Saint_Petersburg", "Pulkovo-I");
        setValidAirport(airports, cities, "Madrid", "A1");
        setValidAirport(airports, cities, "Moscow", "Domodedovo");
        setValidAirport(airports, cities, "Moscow", "Sheremetievo");
        setValidAirport(airports, cities, "New York", "A1");
        setValidAirport(airports, cities, "Stockholm", "A1");
        setValidAirport(airports, cities, "Saint_Petersburg", "Pulkovo-II");
        setValidAirport(airports, cities, "London", "A1");
        return airports;
    }


    private static void setValidAirport(List airports, List cities, String city, String airport) {
        try {
            City cityObj = CitiesFactory.returnCity(cities, city);
            airports.add(new Airport(cityObj, airport));
        } catch (CityNotFoundException e) {
            System.err.println("Illegal City name");
            System.exit(0);
        }
    }

}
