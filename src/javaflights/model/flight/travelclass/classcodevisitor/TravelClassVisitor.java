package javaflights.model.flight.travelclass.classcodevisitor;

import javaflights.model.flight.travelclass.ClassCode;

/**
 * Class implements interface <code>ClassCodeVisitor</code> for searching by "travel class" property
 *
 * @see ClassCodeVisitor
 * @see javaflights.model.flight.travelclass.ClassCodeRepository
 */
public class TravelClassVisitor implements ClassCodeVisitor {
    private String travelClass;

    /**
     * Initialize value of specific "filter" field which is used for searching for <code>ClassCode</code>
     * objects by method <code>accept</code>
     *
     * @param travelClass is a "filter"
     * @see ClassCodeVisitor
     */
    public TravelClassVisitor(String travelClass) {
        this.travelClass = travelClass;
    }

    /**
     * Method implements abstract method of <code>ClassCodeVisitor</code> class
     *
     * @param cc is an object being checked
     * @return true if cc is proper or false if it is not
     * @see ClassCodeVisitor
     */
    public boolean accept(ClassCode cc) {
        if (cc.getTravelClass().equals(travelClass)) {
            return true;
        }
        return false;
    }
}
