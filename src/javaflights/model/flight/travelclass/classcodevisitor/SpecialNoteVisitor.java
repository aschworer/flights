package javaflights.model.flight.travelclass.classcodevisitor;

import javaflights.model.flight.travelclass.ClassCode;

/**
 * Class implements interface <code>ClassCodeVisitor</code> for searching by "special note" property
 *
 * @see ClassCodeVisitor
 * @see javaflights.model.flight.travelclass.ClassCodeRepository
 */
public class SpecialNoteVisitor implements ClassCodeVisitor {
    private String specialNote;

    /**
     * Initialize value of specific "filter" field which is used for searching for <code>ClassCode</code>
     * objects by method <code>accept</code>
     *
     * @param specialNote is a "filter"
     * @see ClassCodeVisitor
     */

    public SpecialNoteVisitor(String specialNote) {
        this.specialNote = specialNote;
    }

    /**
     * Method implements abstract method of <code>ClassCodeVisitor</code> class
     *
     * @param cc is an object being checked
     * @return true if cc is proper or false if it is not
     * @see ClassCodeVisitor
     */
    public boolean accept(ClassCode cc) {
        if (cc.getSpecialNote().equals(specialNote)) {
            return true;
        }
        return false;
    }
}
