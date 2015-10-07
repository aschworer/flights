package javaflights.view.ui;

/**
 * Class representing checking of user input. It checks if all inputs propers values needed by application.
 *
 * @author Aigul Zainullina
 * @see UserDialog
 */
public class UserInputCheck {
    /**
     * Checks if String is a proper travel class value
     *
     * @param c
     */
    public static void checkClass(String c) {
        if (!(c.equals("Business Class") || c.equals("Econom/Coach Class") || c.equals("First Class"))) {
            System.err.println("Illegal Class");
            UserDialog.start();
        }
    }

    /**
     * Checks if integer is a proper menu choice value
     *
     * @param choice
     */
    public static void checkChoice(int choice) {
        if (!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6)) {
            System.err.println("Illegal Choice");
            UserDialog.start();
        }
    }

    /**
     * Checks if integer is a proper year value (from 2006, befor 2010)
     *
     * @param year
     */
    public static void checkYear(int year) {
        if (!(year >= 2006 && year < 2010)) {
            System.out.println("Illegal Year");
            UserDialog.start();
        }
    }

    /**
     * Checks if integer is a proper month value
     *
     * @param month
     */
    public static void checkMonth(int month) {
        if (!(month >= 1 && month <= 12)) {
            System.out.println("Illegal month");
            UserDialog.start();
        }
    }

    /**
     * Checks if integer is a proper day value
     *
     * @param day
     * @param month used for checking about 30 and 31 of february
     */
    public static void checkDay(int day, int month) {
        if (month == 2) {
            if (!(day >= 1 && day <= 29)) {
                System.out.println("Illegal day");
                UserDialog.start();
            }
        } else if (!(day >= 1 && day <= 31)) {
            System.out.println("Illegal day");
            UserDialog.start();
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
