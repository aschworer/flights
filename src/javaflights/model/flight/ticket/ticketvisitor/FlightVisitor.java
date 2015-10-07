package javaflights.model.flight.ticket.ticketvisitor;

import javaflights.model.flight.Flight;
import javaflights.model.flight.ticket.Ticket;

/**
 * Class implements interface <code>TicketVisitor</code> for searching by Default property
 *
 * @author Aigul Zainullina
 * @see TicketVisitor
 * @see javaflights.model.flight.ticket
 */

public class FlightVisitor implements TicketVisitor {
    private Flight flight;

    /**
     * Initializes values of specific "filter" fields which is used for searching for <code>ClassCode</code>
     * objects by <code>accept</code> method
     *
     * @param flight
     */
    public FlightVisitor(Flight flight) {
        this.flight = flight;
    }

    /**
     * Method implements abstract method of <code>TicketVisitor</code> class
     *
     * @param t is an object being cjecked
     * @return true if cc is proper or false if it is not
     * @see TicketVisitor
     */

    public boolean accept(Ticket t) {
        if (t.getParent().equals(flight)) {
            return true;
        }
        return false;
    }
}
