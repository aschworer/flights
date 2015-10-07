package javaflights.model.flight.travelclass;

import java.util.List;
import java.util.ArrayList;

/**
 * Class representing travel class codes usually used when booking tickets of econom, first and business travel classes.
 * Class contains all these codes represented as class static constants which are objects of a class.
 * Here is list for them from <a href=www.wikipedia.org>Wikipedia</a>:
 * <p/>
 * A = First Class Discounted,
 * F = First Class,
 * P = First Class Premium,
 * R = Supersonic (concorde), //unused
 * Z = Business Class Discounted
 * (a lowercase "n" after any class code indicates Night Service)
 * C = Business Class,
 * D = Business Class Discounted,
 * J = Business Class Premium
 * (a lowercase "n" after any class code indicates Night Service)
 * B = Economy/Coach Discounted
 * E = Shuttle Service (No reservation allowed), or Economy/Coach Discounted
 * G = Conditional Reservation
 * H = Economy/Coach Discounted
 * K = Economy/Coach Discounted
 * L = Economy/Coach Discounted
 * M = Economy/Coach Discounted
 * N = Economy/Coach Discounted
 * Q = Economy/Coach Discounted
 * R = Economy/Coach Heavily discounted
 * S = Economy/Coach
 * T = Economy/Coach Discounted, or Premium
 * U = Shuttle Service (No res. needed/Seat guaranteed)
 * V = Economy/Coach Discounted
 * W = Economy/Coach Discounted
 * Y = Economy/Coach
 * (a lowercase "n" after any class code indicates Night Service)
 *
 * @see javaflights.model.flight.ticket.Ticket
 * @author Aigul Zainillina
 */
public class ClassCode {
    private String name;
    private String travelClass;
    private boolean returnForbidden;
    private boolean discounted;
    private String specialNote;
    private double salePriceCoef = 1; //for each Class Code coef must be different

    private static final String FIRST = "First Class";
    private static final String BUSINESS = "Business Class";
    private static final String ECONOM = "Econom/Coach Class";

    public static final ClassCode A = new ClassCode("A", ClassCode.FIRST, true);
    public static final ClassCode F = new ClassCode("F", ClassCode.FIRST);
    public static final ClassCode P = new ClassCode("P", ClassCode.FIRST, "Premium");
    public static final ClassCode Z = new ClassCode("Z", ClassCode.BUSINESS, true);
    public static final ClassCode C = new ClassCode("C", ClassCode.BUSINESS);
    public static final ClassCode D = new ClassCode("D", ClassCode.BUSINESS, true);
    public static final ClassCode J = new ClassCode("J", ClassCode.BUSINESS, "Premium");
    public static final ClassCode B = new ClassCode("B", ClassCode.ECONOM, true);
    public static final ClassCode E = new ClassCode("E", ClassCode.ECONOM, true, true, "Shuttle Service");
    public static final ClassCode G = new ClassCode("G", ClassCode.ECONOM, false, true, "Conditional Reservation");
    public static final ClassCode H = new ClassCode("H", ClassCode.ECONOM, true);
    public static final ClassCode K = new ClassCode("K", ClassCode.ECONOM, true);
    public static final ClassCode L = new ClassCode("L", ClassCode.ECONOM, true);
    public static final ClassCode M = new ClassCode("M", ClassCode.ECONOM, true);
    public static final ClassCode N = new ClassCode("N", ClassCode.ECONOM, true);
    public static final ClassCode Q = new ClassCode("Q", ClassCode.ECONOM, true);
    public static final ClassCode R = new ClassCode("R", ClassCode.ECONOM, true, false, "Heavily Discounted");
    public static final ClassCode S = new ClassCode("S", ClassCode.ECONOM);
    public static final ClassCode T = new ClassCode("T", ClassCode.ECONOM, "Premium");
    public static final ClassCode U = new ClassCode("U", ClassCode.ECONOM, false, true, "Shuttle Service");
    public static final ClassCode V = new ClassCode("V", ClassCode.ECONOM, true);
    public static final ClassCode W = new ClassCode("W", ClassCode.ECONOM, true);
    public static final ClassCode Y = new ClassCode("Y", ClassCode.ECONOM);

    private static List codes = setDefaultCodes();

    /**
     * Method creates List of used default codes
     *
     * @return List of default codes
     */

    public static List setDefaultCodes() {
        List defaultCodes = new ArrayList();
        defaultCodes.add(ClassCode.A);
        defaultCodes.add(ClassCode.F);
        defaultCodes.add(ClassCode.P);
        defaultCodes.add(ClassCode.Z);
        defaultCodes.add(ClassCode.C);
        defaultCodes.add(ClassCode.D);
        defaultCodes.add(ClassCode.J);
        defaultCodes.add(ClassCode.B);
        defaultCodes.add(ClassCode.E);
        defaultCodes.add(ClassCode.G);
        defaultCodes.add(ClassCode.H);
        defaultCodes.add(ClassCode.K);
        defaultCodes.add(ClassCode.L);
        defaultCodes.add(ClassCode.M);
        defaultCodes.add(ClassCode.N);
        defaultCodes.add(ClassCode.Q);
        defaultCodes.add(ClassCode.R);
        defaultCodes.add(ClassCode.S);
        defaultCodes.add(ClassCode.T);
        defaultCodes.add(ClassCode.U);
        defaultCodes.add(ClassCode.V);
        defaultCodes.add(ClassCode.W);
        defaultCodes.add(ClassCode.Y);
        return defaultCodes;
    }

    /**
     * @return coefficient used while calculating price of a ticket with current travel class code
     * @see javaflights.model.flight.TicketReservator
     */
    public double getSalePriceCoef() {
        return salePriceCoef;
    }

    /**
     * @return List of travel class codes existing
     */
    public static List getCodes() {
        return codes;
    }

    /**
     * Overrided toString() method.
     * Representing name of current class code, its travel class, such features as discounted,
     * Is return forbidden and Special Note for this class code
     *
     * @return String object summing property fields
     */
    public String toString() {
        return getName() + ": " + getTravelClass() + "; Discouned: " + isDiscounted() + "; Is return forbidden: "
                + isreturnForbidden() + "; Special Note: " + getSpecialNote();
    }

    /**
     * Initialize object with set fields
     *
     * @param name
     * @param travelClass
     * @param returnForbidden
     * @param discounted
     * @param specialNote
     */
    public ClassCode(String name, String travelClass, boolean returnForbidden, boolean discounted,
                     String specialNote) {
        this.travelClass = travelClass;
        this.specialNote = specialNote;
        this.discounted = discounted;
        this.returnForbidden = returnForbidden;
        this.name = name;
    }

    /**
     * Initialize object with set fields
     *
     * @param name
     * @param travelClass
     */
    public ClassCode(String name, String travelClass) {
        this.travelClass = travelClass;
        this.name = name;
    }

    /**
     * Initialize object with set fields
     *
     * @param name
     * @param travelClass
     * @param specialNote
     */
    public ClassCode(String name, String travelClass, String specialNote) {
        this.travelClass = travelClass;
        this.specialNote = specialNote;
        this.name = name;
    }

    /**
     * Initialize object with set fields
     *
     * @param name
     * @param travelClass
     * @param discounted
     */
    public ClassCode(String name, String travelClass, boolean discounted) {
        this.travelClass = travelClass;
        this.discounted = discounted;
        this.name = name;
    }

    /**
     * @return String object representing travel class of current code
     */
    public String getTravelClass() {
        return travelClass;
    }

    /**
     * @return true if ticket returning is forbidden
     */
    public boolean isreturnForbidden() {
        return returnForbidden;
    }

    /**
     * @return true if customer bought ticket with some discount
     */
    public boolean isDiscounted() {
        return discounted;
    }

    /**
     * @return String object representing special notes for current code
     */
    public String getSpecialNote() {
        return specialNote;
    }

    /**
     * @return name of current class code
     */
    public String getName() {
        return name;
    }
}
