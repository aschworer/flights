package javaflights.model.flight.flightvisitor;

import javaflights.model.flight.Flight;

/**
 * Interface for FlightVisitor
 * Represents Visitor Design Pattern
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.model.flight.travelclass.ClassCodeRepository
 */
public interface FlightVisitor {
    /**
     * Single method of interface <code>accept</code> allows to check if <code>ClassCode</code> object confirm
     * requirements represented in <code>accept</code> method
     *
     * @param fl is <code>ClassCode</code> object which has to be checked
     * @return true if t is proper or false if it is not
     */
    public abstract boolean accept(Flight fl);
}
