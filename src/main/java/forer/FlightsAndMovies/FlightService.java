package forer.FlightsAndMovies;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface FlightService {
    @GET("/v2/public/routes?key=551297-e13789&airlineIata=B6")
    Observable<Flight[]> getAllFlights();
}
