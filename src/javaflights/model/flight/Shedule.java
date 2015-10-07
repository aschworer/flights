package javaflights.model.flight;

import java.util.*;

/**
 * The instance of <code>Shedule</code> class represents some particular shedule that is, virtually, list
 * of <code>FlightDate></code> objects.
 *
 * @author Aigul Zainullina
 * @see javaflights.flight
 */
public class Shedule {
    private List dates = new ArrayList();
    private FlightDate nearestFlight;

    /**
     * Creates shedule class instance with single flight date
     *
     * @param year    year of flights date
     * @param month   month of flights date
     * @param day     day of flights date
     * @param hours   hour of flights date
     * @param minutes minutes of flights date
     */
    public Shedule(int year, int month, int day, int hours, int minutes) {
        this.dates.add(new FlightDate(year, month, day, hours, minutes));
        nearestFlight = (FlightDate) dates.get(0);
    }

    /**
     * Creates shedule class instance with list of flight dates with particular period of time (number of days)
     * from particular beginning date and time to particular <i>before</i> date
     *
     * @param fromYear         year of beginning date
     * @param fromMonth        month of beginning date
     * @param fromDay          day of beginning date
     * @param flightHour       hour of beginning date
     * @param flightMinutes    year of beginning date
     * @param befYear          year of <before> date
     * @param befMonth         month  of <before> date
     * @param befDay           day of <before> date
     * @param eachNumberOfDays is an interval between flight dates
     */
    public Shedule(int fromYear, int fromMonth, int fromDay, int flightHour, int flightMinutes,
                   int befYear, int befMonth, int befDay, int eachNumberOfDays) {
        GregorianCalendar end = new GregorianCalendar(befYear, befMonth - 1, befDay);
        GregorianCalendar temp = new GregorianCalendar(fromYear, fromMonth - 1, fromDay, flightHour, flightMinutes);
        while (temp.before(end)) {
            dates.add(new FlightDate(temp));
            temp.add(GregorianCalendar.DATE, eachNumberOfDays);
        }
        nearestFlight = (FlightDate) dates.get(0);
    }

    /**
     * Adding a sigle date to date list.
     *
     * @param year
     * @param month
     * @param day
     * @param hours
     * @param minutes
     */
    public void insertDate(int year, int month, int day, int hours, int minutes) {
        dates.add(new FlightDate(year, month, day, hours, minutes));
    }

    public List getDates() {
        return dates;
    }

    /**
     * Gets value of nearest flight availible in List of dates, the first value of it.
     *
     * @return <code>FlightDate</code> object
     */
    public FlightDate getNearestFlight() {
        return nearestFlight;
    }
}
