package javaflights.model.flight.airport;

import javaflights.model.flight.city.City;

/**
 * The instance of <code>Airport</code> class represents some particular airport in particular city
 * Airport has code and location (flied <code>city</code> which is an instance of City class)
 *
 * @author Aigul Zainullina
 * @see javaflights.model.flight
 * @see javaflights.model.flight.city.City
 */

public class Airport {
    City city;
    String code;

    /**
     * Constructor of Airport class. Initializes a newly created <code>Atrports</code> object.
     *
     * @param city is an instance of {@link javaflights.model.flight.city.City City} class
     *             Initializes field city of Airport object
     * @param code is for initialize field code of Airport object
     */

    public Airport(City city, String code) {
        this.city = city;
        this.code = code;

    }

    public City getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }
}
