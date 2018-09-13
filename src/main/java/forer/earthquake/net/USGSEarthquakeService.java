package forer.earthquake.net;

import forer.earthquake.EarthquakeFeed;
import retrofit2.http.GET;
import io.reactivex.Observable;

public interface USGSEarthquakeService {

	@GET("/earthquakes/feed/v1.0/summary/all_month.geojson")
	 Observable<EarthquakeFeed> getAllMonth();

	@GET("/earthquakes/feed/v1.0/summary/all_week.geojson")
	Observable<EarthquakeFeed> getAllWeek();
	
	@GET("/earthquakes/feed/v1.0/summary/all_day.geojson")
	Observable<EarthquakeFeed> getAllDay();
	
	@GET("/earthquakes/feed/v1.0/summary/all_hour.geojson")
	Observable<EarthquakeFeed> getAllHour();
}
