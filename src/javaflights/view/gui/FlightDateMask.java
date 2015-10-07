package javaflights.view.gui;

public class FlightDateMask{
    private int year;
    private int month;
    private int day;

    /**
     * Year-month-day constructor
     *
     * @param year
     * @param month
     * @param day
     */
    public FlightDateMask(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Overrided <code>toString</code> method.
     *
     * @return String object with value represented date in "dd-mm-yyyy; hh:mm" form
     */
    public String toString() {
        StringBuffer out = new StringBuffer();
        if (day < 10) {
            out.append("0");
        }
        out.append(Integer.toString(day)).append("-");
        if (month < 10) {
            out.append("0");
        }
        out.append(Integer.toString(month + 1)).append("-").append(Integer.toString(year));
        return out.toString();
    }
}