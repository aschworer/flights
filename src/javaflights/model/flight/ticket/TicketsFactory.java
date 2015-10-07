package javaflights.model.flight.ticket;

import javaflights.model.flight.Flight;
import javaflights.model.flight.FlightDate;
import javaflights.model.SingletonData;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * The AirportsFactory class implements methods that create List of {@link Ticket Ticket} class objects.
 * It can be performed as a class implementing interface <code>AbstractTicketsFactory</code>
 * if we had an apportunity to change way of factoring objects of {@link Ticket Ticket} class.
 * for example if we had another way of storaging and receiving data (not a constant structure)
 *
 * @author Aigul Zainullina
 *         Represents WidgetFactory Design Pattern
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.flight
 */
public class TicketsFactory {
    private static int generalPrice;
    private static double coefFirst;
    private static double coefBusiness;
    private static double coefEconom;

    /**
     * Method creates tickets (an instances of <code>Ticket</code> class) for all flights existing which are got
     * through single object of {@link javaflights.model.SingletonData SingletonData} class
     * Tickets are created for all travel classes existing in each flight according to valid number of seats.
     * in current aircraft for approritate travel class.
     *
     * @return List of <code>Ticket</code> objects.
     */
    public static List createTicketsDefaults() {
        List tickets = new ArrayList();
        for (Iterator iterator = SingletonData.getFlights().iterator(); iterator.hasNext();) {
            Flight next = (Flight) iterator.next();
            for (Iterator iteratorIn = next.getShedule().getDates().iterator(); iteratorIn.hasNext();) {
                FlightDate nextIn = (FlightDate) iteratorIn.next();
                tickets.addAll(TicketsFactory.createTickets(next, nextIn));
            }
        }
        return tickets;
    }

    /**
     * Method sets value of <code>generalPrice</code> value which is general price for all tickets of particular flight
     * Then real price of ticket is calculated considering travel class coefficients and, if needed,
     * travel class code. General price is multiplied with these codes.
     *
     * @param generalPrice
     * @see SingletonData
     * @see javaflights.model.flight.travelclass.ClassCode
     */
    public static void setGeneralPrice(int generalPrice) {
        TicketsFactory.generalPrice = generalPrice;
    }

    /**
     * Method sets value of <code>coefFirst</code> value which is first travel class coefficients for calculating price
     * of ticket
     *
     * @param coefFirst
     * @see TicketsFactory#setGeneralPrice
     * @see javaflights.model.flight.travelclass.ClassCode
     */

    public static void setCoefFirst(double coefFirst) {
        TicketsFactory.coefFirst = coefFirst;
    }

    /**
     * Method sets value of <code>coefBusiness</code> value which is business travel class coefficients for calculating price
     * of ticket
     *
     * @param coefBusiness
     * @see TicketsFactory#setGeneralPrice
     * @see javaflights.model.flight.travelclass.ClassCode
     */

    public static void setCoefBusiness(double coefBusiness) {
        TicketsFactory.coefBusiness = coefBusiness;
    }

    /**
     * Method sets value of <code>coefEconom</code> value which is econom travel class coefficients for calculating price
     * of ticket
     *
     * @param coefEconom
     * @see TicketsFactory#setGeneralPrice
     * @see javaflights.model.flight.travelclass.ClassCode
     */
    public static void setCoefEconom(double coefEconom) {
        TicketsFactory.coefEconom = coefEconom;
    }

    private static List createTickets(Flight flight, FlightDate date) {
        List tickets = new ArrayList();
        for (int i = 0; i < flight.getAircraft().getNumberOfSeatsBusinessClass(); i++) {
            tickets.add(new Ticket(flight, "Business Class", date, generalPrice * coefBusiness));
        }
        for (int i = 0; i < flight.getAircraft().getNumberOfSeatsEconomClass(); i++) {
            tickets.add(new Ticket(flight, "Econom/Coach Class", date, generalPrice * coefEconom));
        }
        for (int i = 0; i < flight.getAircraft().getNumberOfSeatsFirstClass(); i++) {
            tickets.add(new Ticket(flight, "First Class", date, generalPrice * coefFirst));
        }
        return tickets;
    }
}
