package javaflights.view.gui;

/**
 * Class representing checking of user input. It checks if all inputs propers values needed by application.
 *
 * @author Aigul Zainullina
 * @see javaflights.view.ui.UserDialog
 */
public class FrameInputCheck {
    /**
     * Checks if String is a proper travel class value
     *
     * @param c
     */
    public static void checkClass(String c) throws IllegalTravelClassException{
        if (!(c.equals("Business Class") || c.equals("Econom/Coach Class") || c.equals("First Class"))) {
            throw new IllegalTravelClassException();
        }
    }

    /**
     * Checks if integer is a proper year value (from 2006, befor 2010)
     *
     * @param year
     */
    public static void checkYear(int year) throws IllegalYearException{
        if (!(year >= 2006 && year < 2010)) {
            throw new IllegalYearException();
        }
    }

    /**
     * Checks if integer is a proper month value
     *
     * @param month
     */
    public static void checkMonth(int month) throws IllegalMonthException{
        if (!(month >= 1 && month <= 12)) {
            throw new IllegalMonthException();
        }
    }

    /**
     * Checks if integer is a proper day value
     *
     * @param day
     * @param month used for checking about 30 and 31 of february
     */
    public static void checkDay(int day, int month) throws IllegalDayException{
        if (month == 2) {
            if (!(day >= 1 && day <= 29)) {
                throw new IllegalDayException();
            }
        } else if (!(day >= 1 && day <= 31)) {
            throw new IllegalDayException();
        }
    }
    /*public static void checkHour(int hour) {
        if (!(hour >= 0 && hour < 23)) {
            System.out.println("Illegal hour");
            System.exit(0);
        }
    }
    public static void checkMinute(int minute) {
        if (!(minute >= 1 && minute < 12)) {
            System.out.println("Illegal minute");
            System.exit(0);
        }
    } */
}
