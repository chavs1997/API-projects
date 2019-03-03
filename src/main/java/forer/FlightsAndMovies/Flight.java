package forer.FlightsAndMovies;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    String departureIata;
    String departureIcao;
    String departureTerminal;
    String departureTime;
    String arrivalIata;
    String arrivalIcao;
    String arrivalTerminal;
    String arrivalTime;
    String airlineIata;
    String airlineIcao;
    String flightNumber;
    String [] regNumber;

    public Flight(String departureIata, String departureIcao, String departureTerminal, String departureTime, String arrivalIata, String arrivalIcao, String arrivalTerminal, String arrivalTime, String airlineIata, String airlineIcao, String flightNumber, String[] regNumber) {
        this.departureIata = departureIata;
        this.departureIcao = departureIcao;
        this.departureTerminal = departureTerminal;
        this.departureTime = departureTime;
        this.arrivalIata = arrivalIata;
        this.arrivalIcao = arrivalIcao;
        this.arrivalTerminal = arrivalTerminal;
        this.arrivalTime = arrivalTime;
        this.airlineIata = airlineIata;
        this.airlineIcao = airlineIcao;
        this.flightNumber = flightNumber;
        this.regNumber = regNumber;
    }

    public String getDepartureIata() {
        return departureIata;
    }

    public String getDepartureIcao() {
        return departureIcao;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalIata() {
        return arrivalIata;
    }

    public String getArrivalIcao() {
        return arrivalIcao;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getAirlineIata() {
        return airlineIata;
    }

    public String getAirlineIcao() {
        return airlineIcao;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String[] getRegNumber() {
        return regNumber;
    }

    public int getFlightDuration(){
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        long difference = 100;
        try {
            Date start = formatter.parse(departureTime);
            Date end = formatter.parse(arrivalTime);
            difference = ((end.getTime() - start.getTime())/1000)/60;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return (int)difference;

    }
}
