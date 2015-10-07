package javaflights.model.flight.city;

/**
 * The instance of <code>City</code> class represents some particular city in particular country.
 * City has name and country.
 *
 * @author Aigul Zainullina
 * @see javaflights.flight
 */
public class City {
    private String name;
    private String country;

    /**
     * Constructor requires String objects for initializing
     *
     * @param name    String object
     * @param country String object
     */
    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    /**
     * Overrided method toString()
     *
     * @return String object consisting of <code>name</code> and country <code>fields</code>.
     */
    public String toString() {
        return name + " (" + country + ")";
    }

    /**
     * Getting name of the city
     *
     * @return String field <code>name</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Used for determining is flight is domestic or international
     *
     * @return String value of country filed
     * @see javaflights.model.flight.Flight
     */

    public String getCountry() {
        return country;
    }

}
