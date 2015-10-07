package javaflights.model.flight.flightvisitor;

import javaflights.model.flight.city.City;
import javaflights.model.flight.Flight;

/**
 * Class implements interface <code>FlightVisitor</code> for searching by Default property
 *
 * @author Aigul Zainullina
 * @see FlightVisitor
 */
public class FromToVisitor implements FlightVisitor {
    private City fromCity;
    private City toCity;

    /**
     * Initializes value of specific "filter" field which is used for searching for <code>ClassCode</code>
     * objects by method <code>accept</code>
     *
     * @param cityObjFrom is a "filter"
     * @param cityObjTo   is a "filter"
     * @see FlightVisitor
     */
    public FromToVisitor(City cityObjFrom, City cityObjTo) {
        this.fromCity = cityObjFrom;
        this.toCity = cityObjTo;
    }

    /**
     * Method implements abstract method of <code>FlightVisitor</code> class
     *
     * @param fl is an object being cjecked
     * @return true if cc is proper or false if it is not
     * @see FlightVisitor
     */
    public boolean accept(Flight fl) {
        if (fl.getFromCity().equals(fromCity) && toCity.equals(fl.getToCity())) {
            return true;
        }
        return false;
    }
}