package javaflights.model.flight.city;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The CitiesFactory class implements methods that create List of {@link City City} class objects.
 * It can be performed as a class implementing interface <code>AbstractCitiesFactory</code>
 * if we had an apportunity to change way of factoring objects of City class.
 * for example if we had another way of storaging and receiving data (not a constant structure)
 * <p/>
 * Represents WidgetFactory Design Pattern
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.flight
 */

public class CitiesFactory {
    /**
     * Method creates 6 objects of {@link City City} class
     *
     * @return List of 6 Airport objects
     */
    public static List createCitiesDefaults() {
        List cities = new ArrayList();
        cities.add(new City("Saint_Petersburg", "Russia"));
        cities.add(new City("London", "England"));
        cities.add(new City("Madrid", "Spain"));
        cities.add(new City("New York", "United States Of America"));
        cities.add(new City("Stockholm", "Sweden"));
        cities.add(new City("Moscow", "Russia"));
        return cities;
    }

    /**
     * Method for returning City object with required name and city fields from List of <code>City</code> objects.
     * Usially used while creating {@link javaflights.model.flight.Flight Flight} objects.
     *
     * @param cities is a List where required airport will be searched
     * @param city   is a name of required airport
     * @return required object of <code>City</code> class or throws exception
     * @throws CityNotFoundException if required city wasn't found in List
     */
    public static City returnCity(List cities, String city) throws CityNotFoundException {
        for (Iterator iterator = cities.iterator(); iterator.hasNext();) {
            City o = (City) iterator.next();
            if (city.equals(o.getName())) {
                return o;
            }
        }
        throw new CityNotFoundException();
    }


}
