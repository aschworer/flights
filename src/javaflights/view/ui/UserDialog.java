package javaflights.view.ui;

import javaflights.model.SingletonData;
import javaflights.model.FlightRepository;
import javaflights.model.TicketRepository;
import javaflights.model.flight.TicketReservator;
import javaflights.model.flight.FlightNotFoundException;
import javaflights.model.flight.city.CityNotFoundException;
import javaflights.model.flight.ticket.Ticket;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.Iterator;

/**
 * Class representing console dialog with user for searching needed flights and booking tickets for particular flights.
 *
 * @author Aigul Zainullina
 * @see UserInputCheck
 */
public class UserDialog {
    /**
     * Method launches dialog with user.
     * Method provides all user input checks by {@link javaflights.view.ui.UserInputCheck UserInputCheck} class.
     */
    public static void start() {
        try {
            while (true) {
                System.out.print("\nChoose what arguments for searching flight do you want to use:\n");
                System.out.print("1 - Departure city/Destination city\n");
                System.out.print("2 - Departure city/Destination city/Date\n");
                System.out.print("3 - Departure city/Destination city/Date Range\n");
                System.out.print("4 - Print all flight existing (Hint)\n");
                System.out.print("5 - Book ticket\n");
                System.out.print("6 - Exit\n");

                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                String choice = br.readLine();
                UserInputCheck.checkChoice(Integer.parseInt(choice));
                switch (Integer.parseInt(choice)) {
                    case 1:
                        System.out.print("Input Departure City: ");
                        String depCity = br.readLine();
                        System.out.print("Input Destination City: ");
                        String destCity = br.readLine();
                        try {
                            printList(FlightRepository.findFlightsByFromTo(depCity, destCity));
                        } catch (CityNotFoundException e) {
                            System.err.println("Illegal city");
                        }
                        break;
                    case 2:
                        System.out.print("Input Departure City: ");
                        String depCity0 = br.readLine();
                        System.out.print("Input Destination City: ");
                        String destCity0 = br.readLine();
                        System.out.print("Input Departure Year: ");
                        int year = Integer.parseInt(br.readLine());
                        UserInputCheck.checkYear(year);
                        System.out.print("Input Departure Month (number): ");
                        int month = Integer.parseInt(br.readLine());
                        UserInputCheck.checkMonth(month);
                        System.out.print("Input Departure Day: ");
                        int day = Integer.parseInt(br.readLine());
                        UserInputCheck.checkDay(day, month);
                        try {
                            printList(FlightRepository.findFlightsByFromToDate(depCity0, destCity0,
                                    year, month, day));
                        } catch (CityNotFoundException e) {
                            System.err.println("Illegal city");
                        }

                        break;
                    case 3:
                        System.out.print("Input Departure City: ");
                        String depCity1 = br.readLine();
                        System.out.print("Input Destination City: ");
                        String destCity1 = br.readLine();
                        System.out.print("Input Year_from: ");
                        int year0 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkYear(year0);
                        System.out.print("Input Month_from (number): ");
                        int month0 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkMonth(month0);
                        System.out.print("Input Day_from: ");
                        int day0 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkDay(day0, month0);
                        System.out.print("Input Year_to: ");
                        int year1 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkYear(year1);
                        System.out.print("Input Month_to (number): ");
                        int month1 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkMonth(month1);
                        System.out.print("Input Day_to: ");
                        int day1 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkDay(day1, month1);
                        try {
                            printList(FlightRepository.findFlightsByRangeDate(depCity1, destCity1,
                                    year0, month0, day0, year1, month1, day1));
                        } catch (CityNotFoundException e) {
                            System.err.println("Illegal city");
                        }

                        break;
                    case 5:
                        System.out.print("Input Flight No: ");
                        String flightNo = br.readLine();
                        System.out.print("Input Departure Year: ");
                        int year2 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkYear(year2);
                        System.out.print("Input Departure Month (number): ");
                        int month2 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkMonth(month2);
                        System.out.print("Input Departure Day: ");
                        int day2 = Integer.parseInt(br.readLine());
                        UserInputCheck.checkDay(day2, month2);
                        System.out.print("Input Travel Class (Business Class/Econom/Coach Class/First Class): ");
                        String cl = br.readLine();
                        UserInputCheck.checkClass(cl);
                        List found = null;
                        try {
                            found = TicketRepository.findTicketsByAll(flightNo, year2, month2, day2, true, cl);
                        } catch (FlightNotFoundException e) {
                            System.err.println("Illegal city");
                        }
                        if (found.isEmpty()) {
                            System.out.println("\nDesired Tickets not found");
                            System.exit(0);
                        } else {
                            System.out.println("\nInput booking information:");
                        }
                        System.out.print("Discounted - Yes/No (1/0): ");
                        int d = Integer.parseInt(br.readLine());

                        boolean discounted;
                        if (d == 1) {
                            discounted = true;
                        } else if (d == 0) {
                            discounted = false;
                        } else {
                            System.out.println("Input error");
                            break;
                        }
                        System.out.print("Return Allowed - Yes/No (1/0): ");
                        int r = Integer.parseInt(br.readLine());
                        boolean returnable = false;
                        if (r == 1) {
                            returnable = true;
                        } else if (r == 0) {
                            returnable = false;
                        } else {
                            System.out.println("Input error");
                            System.exit(0);
                        }
                        System.out.print("Customer Info: ");
                        String ci = br.readLine();
                        Ticket bookedTicket = (Ticket) found.get(0);
                        TicketReservator.reserve(bookedTicket, discounted, returnable, ci, cl);
                        System.out.println("Your ticket:");
                        System.out.println(bookedTicket.toString());
                    case 6:
                        stop();
                        break;
                    case 4:
                        printList(SingletonData.getFlights());
                        break;
                }
            }
        } catch (java.io.IOException ioe) {
            System.err.println("Input error");
            start();
        } catch (NumberFormatException e) {
            System.err.println("Incorrect number");
            start();
        }

    }

    /**
     * Stops dialog with user by finishing process with exit code 0
     */

    public static void stop() {
        System.out.println("\nThanks for using Java Flights.");
        System.exit(0);

    }

    private static void printList(List list) {
        if (list.isEmpty()) {
            System.out.println("\nList is empty");
            System.exit(0);
        }
        try {
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                System.out.println(iterator.next());
            }
        } catch (NullPointerException e) {
            System.out.println("No flights found");
        }
    }

}

