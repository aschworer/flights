package javaflights.model.flight;

import java.util.Calendar;

/**
 * The instance of <code>FlightDate</code> class represents some particular date that consists of
 * year, month, day, hours and minutes.
 * The class implements Comparable interface and its method {@link #compareTo compareTo}
 *
 * @author Aigul Zainullina
 * @see javaflights.flight
 */
public class FlightDate implements Comparable {
    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;

    /**
     * Full parameter constructor
     * Constructor assumes only proper values according to required types
     *
     * @param year
     * @param month
     * @param day
     * @param hours
     * @param minutes
     */
    public FlightDate(int year, int month, int day, int hours, int minutes) {
        String a = "x" + "y" + "z";
        String b = new StringBuffer("x").append("y").append("z").toString();
        
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
    }

    /**
     * Year-month-day constructor
     *
     * @param year
     * @param month
     * @param day
     */
    public FlightDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = 0;
        this.minutes = 0;
    }

    /**
     * Constructor uses <code>Calendar</code> object as a parameter
     *
     * @param date - <code>Calendar</code>
     * @see Calendar
     */
    public FlightDate(Calendar date) {
        year = date.get(Calendar.YEAR);
        month = date.get(Calendar.MONTH);
        day = date.get(Calendar.DATE);
        hours = date.get(Calendar.HOUR_OF_DAY);
        minutes = date.get(Calendar.MINUTE);
    }

    /**
     * Implements {@link Comparable#compareTo(Object) compareTo} method of <code>Comparable</code> interface
     *
     * @param flightDateObject Object parameter must be instance of <code>FlightDate</code> class
     * @return a -1, 0, or 1 as this object is less than, equal to, or greater than the specified object.
     */
    public int compareTo(Object flightDateObject) {
        FlightDate date = (FlightDate) flightDateObject;
        if (this.year < date.year) {
            return -1;
        } else if (this.year > date.year) {
            return 1;
        } else if (this.month < date.month) {
            return -1;
        } else if (this.month > date.month) {
            return 1;
        } else if (this.day < date.day) {
            return -1;
        } else if (this.day > date.day) {
            return 1;
        } else if (this.hours < date.hours) {
            return -1;
        } else if (this.hours > date.hours) {
            return 1;
        } else if (this.minutes < date.minutes) {
            return -1;
        } else if (this.minutes > date.minutes) {
            return 1;
        }
//        return (this.year - date.year) * 12 * 31
//        + (this.month - date.month) * 31
//        + (this.day - date.day)
//        } else if (this.hours < date.hours) {
//            return -1;
//        } else if (this.hours > date.hours) {
//            return 1;
//        } else if (this.minutes < date.minutes) {
//            return -1;
//        } else if (this.minutes > date.minutes) {
//            return 1;
//        }
        return 0;
    }

    /**
     * Overrided <code>toString</code> method.
     *
     * @return String object with value represented date in "dd-mm-yyyy; hh:mm" form
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append(Integer.toString(day)).append("-");
        if (month < 10) {
            out.append("0");
        }
        out.append(Integer.toString(month + 1)).append("-").append(Integer.toString(year)).append("; ").
                append(Integer.toString(hours)).append(":");
        if (minutes < 10) {
            out.append("0");
        }

        out.append(Integer.toString(minutes));
        return out.toString();
    }


    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

}
