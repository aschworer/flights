package javaflights.model;

import javaflights.model.flight.flightvisitor.DateVisitor;
import javaflights.model.flight.flightvisitor.FromToVisitor;
import javaflights.model.flight.flightvisitor.FlightVisitor;
import javaflights.model.flight.flightvisitor.RangeDateVisitor;
import javaflights.model.flight.city.City;
import javaflights.model.flight.city.CityNotFoundException;
import javaflights.model.flight.city.CitiesFactory;
import javaflights.model.flight.Flight;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class implements methods for searching for Objects of {@link Flight Flight} class
 * by required constraints for <code>Flight</code> object fields.
 * Represents Repository Design Pattern
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 */

public class FlightRepository {
    /**
     * Finding <code>Flight</code> objects by values of departure and destination cities
     *
     * @param cityFrom
     * @param cityTo
     * @return List of <code>Flight</code>objects found
     * @throws CityNotFoundException
     */
    public static List findFlightsByFromTo(String cityFrom, String cityTo) throws CityNotFoundException {
            City cityObjFrom = CitiesFactory.returnCity(SingletonData.getCities(), cityFrom);
            City cityObjTo = CitiesFactory.returnCity(SingletonData.getCities(), cityTo);
            FlightVisitor fv = new FromToVisitor(cityObjFrom, cityObjTo);
            return find(SingletonData.getFlights(), fv);
    }

    /**
     * Finding <code>Flight</code> objects by values of departure, destination cities and date of flight
     * Method assumes receiving proper values according to needed types
     *
     * @param cityFrom
     * @param cityTo
     * @param year
     * @param month
     * @param day
     * @return List of <code>Flight</code>objects found
     */
    public static List findFlightsByFromToDate(String cityFrom, String cityTo, int year, int month, int day) throws CityNotFoundException {
        try {
            List result = findFlightsByFromTo(cityFrom, cityTo);
            FlightVisitor fv = new DateVisitor(year, month, day);
            return find(result, fv);
        } catch (CityNotFoundException e) {
            //incorrect statement - do not throw exception again
            throw new CityNotFoundException();
        }
    }

    /**
     * Finding <code>Flight</code> objects by values of departure, destination cities and range date of flight
     * Method assumes receiving proper values according to needed types
     *
     * @param cityFrom
     * @param cityTo
     * @param fromYear
     * @param fromMonth
     * @param fromDay
     * @param beforeYear
     * @param beforeMonth
     * @param beforeDay
     * @return List of <code>Flight</code>objects found
     */
    public static List findFlightsByRangeDate(String cityFrom, String cityTo, int fromYear, int fromMonth,
                                              int fromDay, int beforeYear, int beforeMonth, int beforeDay) throws CityNotFoundException{
        List result = findFlightsByFromTo(cityFrom, cityTo);
        FlightVisitor fv = new RangeDateVisitor(fromYear, fromMonth, fromDay, beforeYear, beforeMonth, beforeDay);
        return find(result, fv);
    }

    private static List find(List sourse, FlightVisitor fv) {
        List res = new ArrayList();
        for (Iterator iterator = sourse.iterator(); iterator.hasNext();) {
            Flight found = (Flight) iterator.next();
            if (fv.accept(found)) {
                res.add(found);
            }
        }
        return res;
    }

}
