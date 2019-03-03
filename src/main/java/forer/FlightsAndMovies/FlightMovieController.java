package forer.FlightsAndMovies;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightMovieController {

    private MovieService movieService;
    private FlightService flightService;
    private Provider<FlightMovieView> viewProvider;
    private Disposable movieDisposable;
    private Disposable movieInfoDisposable;
    private Disposable flightDisposable;
    private Flight randomFlight;
    private List<Movie> movieInfos = new ArrayList<>();
    private int flightDur;

    @Inject
    public FlightMovieController(FlightService flightService, MovieService movieService, Provider<FlightMovieView> viewProvider) {
        this.viewProvider = viewProvider;
        this.flightService = flightService;
        this.movieService = movieService;

    }

    void getFlightInformation() {
        flightDisposable = flightService.getAllFlights()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(this::setFlightInformation, Throwable::printStackTrace);
    }

    private void setFlightInformation(Flight[] flightFeed) {
        Random rand = new Random();
        randomFlight = flightFeed[rand.nextInt(flightFeed.length)];
        viewProvider.get().setTop(randomFlight);
        getMovies(randomFlight.getFlightDuration());
    }

    private void getMovies(int duration) {
        flightDur = duration;
        movieDisposable = movieService.getAllMovies(duration - 15)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(this::setMovies, Throwable::printStackTrace);
    }

    private void setMovies(MovieFeed movieFeed) {
        MovieID[] movies = movieFeed.getResults();


        for (int i = 0; i < movies.length; i++) {
            movieInfoDisposable = movieService
                        .getMovieInfo(movies[i].getId())
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.single())
                        .subscribe(this::addMovie, Throwable::printStackTrace);

            }

        }


    private void addMovie(Movie movie) {
        viewProvider.get().addMovies(movie);
    }


    public void stop() {
        flightDisposable.dispose();
        movieDisposable.dispose();
        movieInfoDisposable.dispose();
    }
}
