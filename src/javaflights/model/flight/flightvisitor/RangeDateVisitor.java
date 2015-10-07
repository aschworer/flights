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
 */
public class RangeDateVisitor implements FlightVisitor {
    private int fromYear;
    private int fromMonth;
    private int fromDay;
    private int beforeYear;
    private int beforeMonth;
    private int beforeDay;

    /**
     * Initializes values of specific "filters" fields which is used for searching for <code>ClassCode</code>
     * objects by method <code>accept</code>
     *
     * @param fromYear
     * @param fromMonth
     * @param fromDay
     * @param beforeYear
     * @param beforeMonth
     * @param beforeDay
     */
    public RangeDateVisitor(int fromYear, int fromMonth, int fromDay,
                            int beforeYear, int beforeMonth, int beforeDay) {
        this.fromYear = fromYear;
        this.fromMonth = fromMonth;
        this.fromDay = fromDay;
        this.beforeYear = beforeYear;
        this.beforeMonth = beforeMonth;
        this.beforeDay = beforeDay;
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
        FlightDate dateLower = new FlightDate(fromYear, fromMonth, fromDay);
        FlightDate dateHigher = new FlightDate(beforeYear, beforeMonth, beforeDay);
        for (Iterator iterator = dates.iterator(); iterator.hasNext();) {
            FlightDate found = (FlightDate) iterator.next();
            if ((dateLower.compareTo(found) == -1) && (dateHigher.compareTo(found) == 1)) {
                return true;
            }
        }
        return false;
    }

}
