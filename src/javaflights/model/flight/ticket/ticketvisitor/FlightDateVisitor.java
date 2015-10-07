package javaflights.model.flight.ticket.ticketvisitor;

import javaflights.model.flight.ticket.Ticket;

/**
 * Class implements interface <code>TicketVisitor</code> for searching by Default property
 *
 * @author Aigul Zainullina
 * @see TicketVisitor
 * @see javaflights.model.flight.ticket
 */

public class FlightDateVisitor implements TicketVisitor {
    private int year;
    private int month;
    private int day;

    /**
     * Initializes values of specific "filter" fields which is used for searching for <code>ClassCode</code>
     * objects by <code>accept</code> method
     *
     * @param year
     * @param month
     * @param day
     */
    public FlightDateVisitor(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Method implements abstract method of <code>TicketVisitor</code> class
     *
     * @param t is an object being cjecked
     * @return true if cc is proper or false if it is not
     * @see TicketVisitor
     */

    public boolean accept(Ticket t) {
        if (t.getFlightDate().getYear() == year &&
                t.getFlightDate().getMonth() + 1 == month &&
                t.getFlightDate().getDay() == day) {
            return true;
        }
        return false;
    }


}
