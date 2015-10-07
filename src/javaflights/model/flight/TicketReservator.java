package javaflights.model.flight;

import javaflights.model.flight.travelclass.ClassCode;
import javaflights.model.flight.travelclass.ClassCodeRepository;
import javaflights.model.flight.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents reservator of a particular ticket by particular customer with particular class code using.
 *
 * @author Aigul Zainullina
 * @see javaflights.flight
 */

public class TicketReservator {
    /**
     * Method do reservation of particular ticket by setting its <code>availible</code> filed in <code>false</code> value
     * an adding according information about reserving such as travel class code (after finding it),
     * customer info and price by which ticket was sold (its prime price * coefficient of class code)
     *
     * @param bookedTicket
     * @param discounted
     * @param returnable
     * @param ci
     * @param classCode
     * @see javaflights.model.flight.ticket.Ticket
     * @see javaflights.model.flight.travelclass.ClassCode
     * @see javaflights.model.flight.travelclass.ClassCodeRepository
     */
    public static void reserve(Ticket bookedTicket, boolean discounted, boolean returnable, String ci, String classCode) {
        bookedTicket.setAvailible(false);
        List list = ClassCodeRepository.findByAllConstraints(classCode, discounted, returnable);
        ClassCode cc = ClassCode.A;
        if (!list.isEmpty()){
            cc = (ClassCode) list.get(0);
        }
        bookedTicket.setSoldPrice(bookedTicket.getPrimePriceUSD() * cc.getSalePriceCoef());
        bookedTicket.setCustomerInfo(ci);
        bookedTicket.setClassCode(cc);
    }
}
