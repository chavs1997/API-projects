package forer.earthquake.net;

import javax.swing.JLabel;

import com.google.inject.Inject;

import forer.earthquake.*;
import retrofit2.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EarthquakeController {

	private EarthquakeView view;
	private USGSEarthquakeService service;

	@Inject
	public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
		this.view = view;
		this.service = service;
	}

/*	public void refreshData() {
		requestMonth();
		requestWeek();
		requestDay();
		requestHour();
	}*/

	public void refreshData() {
		requestEarthquakeFeed(service.getAllHour(), view.getHourMagLabel(), view.getHourLocLabel());
	}

	/*public void requestDay() {
		requestEarthquakeFeed(service.getAllDay(), view.getDayMagLabel(), view.getDayLocLabel());
	}

	public void requestWeek() {
		requestEarthquakeFeed(service.getAllWeek(), view.getWeekMagLabel(), view.getWeekLocLabel());
	}

	public void requestMonth() {

		requestEarthquakeFeed(service.getAllMonth(), view.getMonthMagLabel(), view.getMonthLocLabel());
	}*/

	public void requestEarthquakeFeed(Call<EarthquakeFeed> call, JLabel [] mag, JLabel [] loc) {
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				List<Earthquake> earthquakes = feed.getFeatures()
						.stream()
						.filter(earthquake -> earthquake.getProperties().getMag() >= 0.25)
						.sorted(Comparator.comparing(Earthquake :: getMagnitude).reversed())
						.limit(5)
						.collect(Collectors.toList());
				showTopFive(earthquakes, mag, loc);
			}

		});
	}

	public void showTopFive(List<Earthquake> earthquakes, JLabel [] mag, JLabel [] loc) {
		for(int i = 0; i < earthquakes.size(); i ++)
		{
			String magn = String.valueOf(earthquakes.get(i).getMagnitude());
			mag[i].setText(magn);
			loc[i].setText(earthquakes.get(i).getProperties().getPlace());
		}
	}
}
