package javaflights.model.flight.travelclass;

import javaflights.model.flight.travelclass.classcodevisitor.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class implements methods for searching for Objects of {@link ClassCode ClassCode} class
 * by required constraints for <code>ClassCode</code> object fields.
 * Represents Repository Design Pattern
 *
 * @author Aigul Zainullina
 * @see "Desighn Patterns" by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides.
 */

public class ClassCodeRepository {
    /**
     * Finding ClassCode object by values of <code>travelClass</code> and <code>discounted</code> fileds in ClassCode object
     *
     * @param travelClass
     * @param discounted
     * @return List of <code>ClassCode</code>objects found
     */
    public static List findByDiscounted(String travelClass, boolean discounted) {
        ClassCodeVisitor ccv = new TravelClassVisitor(travelClass);
        List tempCC = findCC(ClassCode.getCodes(), ccv);
        ccv = new DiscountVisitor(discounted);
        return findCC(tempCC, ccv);
    }

    /**
     * Finding ClassCode object by values of <code>travelClass</code> and <code>returnable</code> fileds in ClassCode object
     *
     * @param travelClass
     * @param returnable
     * @return List of <code>ClassCode</code>objects found
     */
    public static List findByReturnable(String travelClass, boolean returnable) {
        ClassCodeVisitor ccv = new TravelClassVisitor(travelClass);
        List tempCC = findCC(ClassCode.getCodes(), ccv);
        ccv = new ReturnableVisitor(returnable);
        return findCC(tempCC, ccv);
    }

    /**
     * Finding ClassCode object by values of <code>travelClass</code> and <code>specialNote</code> fileds in ClassCode object
     *
     * @param travelClass
     * @param specialNote
     * @return List of <code>ClassCode</code>objects found
     */
    public static List findBySpecialNote(String travelClass, String specialNote) {
        ClassCodeVisitor ccv = new TravelClassVisitor(travelClass);
        List tempCC = findCC(ClassCode.getCodes(), ccv);
        ccv = new SpecialNoteVisitor(specialNote);
        return findCC(tempCC, ccv);
    }

    /**
     * Finding ClassCode object by values of <code>travelClass</code>, <code>discounted</code> and <code>returnable</code> fileds in ClassCode object
     *
     * @param travelClass
     * @param discounted
     * @param returnable
     * @return List of <code>ClassCode</code>objects found
     */
    public static List findByAllConstraints(String travelClass, boolean discounted, boolean returnable) {
        ClassCodeVisitor ccv = new TravelClassVisitor(travelClass);
        List tempCC = findCC(ClassCode.getCodes(), ccv);
        ccv = new DiscountVisitor(discounted);
        tempCC = findCC(tempCC, ccv);
        ccv = new ReturnableVisitor(returnable);
        return findCC(tempCC, ccv);
    }

    private static List findCC(List sourse, ClassCodeVisitor ccv) {
        List res = new ArrayList();
        for (Iterator iterator = sourse.iterator(); iterator.hasNext();) {
            ClassCode found = (ClassCode) iterator.next();
            if (ccv.accept(found)) {
                res.add(found);
            }
        }
        return res;
    }

}
