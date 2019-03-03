package forer.FlightsAndMovies;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("/3/discover/movie?api_key=455081e48850a93745fb978afe2649af&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&vote_count.gte=1000&vote_average.gte=7")
    Observable<MovieFeed> getAllMovies(@Query("with_runtime.lte") int runtime);

    @GET("/3/movie/{id}?api_key=455081e48850a93745fb978afe2649af&language=en-US")
    Observable<Movie> getMovieInfo(@Path("id") int id);
}
