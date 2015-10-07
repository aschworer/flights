package javaflights.model.flight.travelclass.classcodevisitor;

import javaflights.model.flight.travelclass.ClassCode;

/**
 * Class implements interface <code>ClassCodeVisitor</code> for searching by Default property
 *
 * @see ClassCodeVisitor
 * @see javaflights.model.flight.travelclass.ClassCodeRepository
 */
public class DiscountVisitor implements ClassCodeVisitor {
    private boolean discount;

    /**
     * Initialize value of specific "filter" field which is used for searching for <code>ClassCode</code>
     * objects by method <code>accept</code>
     *
     * @param dicount is a "filter"
     * @see ClassCodeVisitor
     */
    public DiscountVisitor(boolean dicount) {
        this.discount = dicount;
    }

    /**
     * Method implements abstract method of <code>ClassCodeVisitor</code> class
     *
     * @param cc is an object being cjecked
     * @return true if cc is proper or false if it is not
     * @see ClassCodeVisitor
     */

    public boolean accept(ClassCode cc) {
        if (cc.isDiscounted() == discount) {
            return true;
        }
        return false;
    }
}
