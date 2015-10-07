package javaflights.model.flight.ticket.ticketvisitor;

import javaflights.model.flight.ticket.Ticket;

/**
 * Class implements interface <code>TicketVisitor</code> for searching by Default property
 *
 * @author Aigul Zainullina
 * @see TicketVisitor
 * @see javaflights.model.flight.ticket
 */

public class TravelClass implements TicketVisitor {
    private String travelClass;

    /**
     * Initializes values of specific "filter" fields which is used for searching for <code>ClassCode</code>
     * objects by <code>accept</code> method
     *
     * @param travelClass
     */
    public TravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    /**
     * Method implements abstract method of <code>TicketVisitor</code> class
     *
     * @param t is an object being cjecked
     * @return true if cc is proper or false if it is not
     * @see TicketVisitor
     */

    public boolean accept(Ticket t) {
        if (t.getTravelClass().equals(travelClass)) {
            return true;
        }
        return false;
    }

}
