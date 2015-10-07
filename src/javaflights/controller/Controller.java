package javaflights.controller;

import javaflights.view.gui.*;

import java.util.List;
import java.util.Iterator;

import javaflights.model.FlightRepository;
import javaflights.model.flight.city.CityNotFoundException;

public class Controller {
    public static String findFlightsByFromToDate(String fromCity, String toCity, String date) {
        try {
            int day = Integer.parseInt(date.substring(0, 2));
            int month = Integer.parseInt(date.substring(3, 5));
            int year = Integer.parseInt(date.substring(6, 10));

            FrameInputCheck.checkMonth(month);
            FrameInputCheck.checkDay(day, month);
            FrameInputCheck.checkYear(year);
            List found = FlightRepository.findFlightsByFromToDate(fromCity, toCity, year, month, day);
            return foundToString(found);
        } catch (IllegalDayException e) {
            return "Illegal day";
        } catch (IllegalMonthException e) {
            return "Illegal month";
        } catch (IllegalYearException e) {
            return "Illegal year";
        } catch (CityNotFoundException e) {
            return "City not found";
        } catch (NumberFormatException e) {
            return "Illegal number";
        }

    }

    private static String foundToString(List found) {
        if (found.isEmpty()) {
            return "Flights not found";
        }
        StringBuffer str = new StringBuffer();
        for (Iterator iterator = found.iterator(); iterator.hasNext();) {
            str.append(iterator.next().toString());
        }
        return str.toString();
    }
}
