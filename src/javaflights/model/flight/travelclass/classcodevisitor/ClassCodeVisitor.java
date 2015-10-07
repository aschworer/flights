package javaflights.model.flight.travelclass.classcodevisitor;

import javaflights.model.flight.travelclass.ClassCode;

/**
 * Interface for ClassCodeVisitor
 * Represents Visitor Design Pattern
 *
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 * @see javaflights.model.flight.travelclass.ClassCodeRepository
 */
public interface ClassCodeVisitor {
    /**
     * Single method of interface <code>accept</code> allows to check if <code>ClassCode</code> object confirm
     * represented in <code>accept</code> requirements
     *
     * @param t is <code>ClassCode</code> object which has to be checked
     * @return true if t is proper or false if it is not
     */
    public abstract boolean accept(ClassCode t);
}
