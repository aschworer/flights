package javaflights.model;

import javaflights.model.flight.ticket.Ticket;
import javaflights.model.flight.ticket.ticketvisitor.*;
import javaflights.model.flight.FlightNotFoundException;
import javaflights.model.flight.Flight;
import javaflights.model.SingletonData;
import javaflights.view.ui.UserDialog;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class implements methods for searching for Objects of {@link Ticket Ticket} class
 * by required constraints for <code>Ticket</code> object fields.
 * Represents Repository Design Pattern
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 */

public class TicketRepository {
    /**
     * Finding <code>Ticket</code> objects by value of flight no for which ticket was created
     *
     * @param flightNo
     * @return List of <code>Ticket</code>objects found
     */
    public static List findTicketsByFlight(String flightNo) throws FlightNotFoundException {
        TicketVisitor tv = new FlightVisitor(returnFlight(SingletonData.getFlights(), flightNo));
        return find(SingletonData.getTickets(), tv);
    }

    /**
     * Finding <code>Ticket</code> objects by value of flight no and flight date for which ticket was created.
     * Method assumes receiving proper values according to needed types
     *
     * @param flightNo
     * @param year
     * @param month
     * @param day
     * @return List of <code>Ticket</code>objects found
     */
    public static List findTicketsByFlightDate(String flightNo, int year, int month, int day) throws FlightNotFoundException {
        List temp = findTicketsByFlight(flightNo);
        TicketVisitor fv = new FlightDateVisitor(year, month, day);
        return find(temp, fv);
    }

    /**
     * Finding <code>Ticket</code> objects by value of flight no for which ticket was created and required value
     * of <code>availible</code> field
     *
     * @param flightNo
     * @param availible
     * @return List of <code>Ticket</code>objects found
     */
    public static List findTicketsByFlightAvailible(String flightNo, boolean availible) throws FlightNotFoundException {
        List temp = findTicketsByFlight(flightNo);
        TicketVisitor fv = new FlightAvailibleVisitor(availible);
        return find(temp, fv);
    }

    /**
     * Finding <code>Ticket</code> objects by value of flight no and flight date for which ticket was created and required value
     * of <code>availible</code> field
     * Method assumes receiving proper values according to needed types
     *
     * @param flightNo
     * @param year
     * @param month
     * @param day
     * @param availible
     * @return List of <code>Ticket</code>objects found
     */
    public static List findTicketsByFlightDateAvailible(String flightNo, int year, int month, int day, boolean availible) throws FlightNotFoundException {
        List temp = findTicketsByFlightDate(flightNo, year, month, day);
        TicketVisitor fv = new FlightAvailibleVisitor(availible);
        return find(temp, fv);
    }

    /**
     * Finding <code>Ticket</code> objects by value of flight no, flight date for which ticket was created, required value
     * of <code>availible</code> field and travel class needed.
     *
     * @param flightNo
     * @param year
     * @param month
     * @param day
     * @param availible
     * @param travelClass
     * @return List of <code>Ticket</code>objects found
     */
    public static List findTicketsByAll(String flightNo, int year, int month, int day, boolean availible,
                                        String travelClass) throws FlightNotFoundException {
        List temp = findTicketsByFlightDateAvailible(flightNo, year, month, day, availible);
        TicketVisitor fv = new TravelClass(travelClass);
        return find(temp, fv);
    }


    /**
     * Private method for returning Flight objects with required properties
     * Analogue to {@link javaflights.model.flight.FlightsFactory#returnAirport returnAirport} method
     */
    private static Flight returnFlight(List flights, String flightNo) throws FlightNotFoundException {
        for (Iterator iterator = flights.iterator(); iterator.hasNext();) {
            Flight o = (Flight) iterator.next();
            if (flightNo.equals(o.getNo())) {
                return o;
            }
        }
        throw new FlightNotFoundException();
    }

    private static List find(List sourse, TicketVisitor fv) {
        List res = new ArrayList();
        for (Iterator iterator = sourse.iterator(); iterator.hasNext();) {
            Ticket found = (Ticket) iterator.next();
            if (fv.accept(found)) {
                res.add(found);
            }
        }
        return res;
    }


}

