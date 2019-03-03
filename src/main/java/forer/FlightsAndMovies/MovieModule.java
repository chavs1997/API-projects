package forer.FlightsAndMovies;

import com.google.inject.AbstractModule;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieModule extends AbstractModule {
    @Override
    protected void configure() {
        super.configure();
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        MovieService service = retrofit.create(MovieService.class);
        bind(MovieService.class).toInstance(service);

        Retrofit retrofit2 = new Retrofit.Builder().
                baseUrl("https://aviation-edge.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        FlightService service2 = retrofit2.create(FlightService.class);
        bind(FlightService.class).toInstance(service2);
    }
}
