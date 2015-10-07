package javaflights.model.flight.flightvisitor;

import javaflights.model.flight.Flight;
import javaflights.model.flight.FlightDate;

import java.util.List;
import java.util.Iterator;

/**
 * Class implements interface <code>FlightVisitor</code> for searching by Default property
 *
 * @author Aigul Zainullina
 * @see FlightVisitor
 * @see javaflights.model.flight.flightvisitor
 */
public class DateVisitor implements FlightVisitor {
    private int year;
    private int month;
    private int day;

    /**
     * Initializes value of specific "filter" field which is used for searching for <code>ClassCode</code>
     * objects by method <code>accept</code>
     *
     * @param year, month, day are "filters"
     */
    public DateVisitor(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Method implements abstract method of <code>FlightVisitor</code> class
     *
     * @param fl is an object being cjecked
     * @return true if cc is proper or false if it is not
     * @see javaflights.model.flight.flightvisitor
     */
    public boolean accept(Flight fl) {
        List dates = fl.getShedule().getDates();
        for (Iterator iterator = dates.iterator(); iterator.hasNext();) {
            FlightDate found = (FlightDate) iterator.next();
            if (found.getYear() == year && found.getMonth() == month && found.getDay() == day) {
                return true;
            }
        }
        return false;
    }
}