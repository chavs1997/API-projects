package forer.earthquake.net;

import javax.swing.JLabel;
import com.google.inject.Inject;
import forer.earthquake.*;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class EarthquakeController {

	private EarthquakeView view;
	private USGSEarthquakeService service;
    private Disposable disposable;
	@Inject
	public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
		this.view = view;
		this.service = service;
	}

	public void refreshData() {
<<<<<<< HEAD
		requestEarthquakeFeed(service.getAllDay(), view.getDayMagLabel(), view.getDayLocLabel());
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
						.filter(earthquake -> earthquake.getProperties().getMag() >= 3)
						.sorted(Comparator.comparing(Earthquake :: getMagnitude).reversed())
						.limit(5)
						.collect(Collectors.toList());
				showTopFive(earthquakes, mag, loc);
			}
=======
        disposable = Observable.interval(0,30, TimeUnit.SECONDS)
                .flatMap(aLong -> service.getAllDay())
                .map(EarthquakeFeed::getFeatures)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(this :: setEarthquakes,
                        throwable -> System.out.println("Error getting data"));
>>>>>>> master

	}

    private void setEarthquakes(List<Earthquake> list) {
        List<Earthquake> earthquakes = list
                .stream()
                .filter(earthquake -> earthquake.getProperties().getMag() >= 1.2)
                .sorted(Comparator.comparing(Earthquake :: getMagnitude).reversed())
                .limit(5)
                .collect(Collectors.toList());
        showTopFive(earthquakes, view.getHourMagLabel(), view.getHourLocLabel());
    }

    public void stop(){
	    disposable.dispose();
    }

    private void showTopFive(List<Earthquake> earthquakes, JLabel [] mag, JLabel [] loc) {
		for(int i = 0; i < earthquakes.size(); i ++)
		{
			String magn = String.valueOf(earthquakes.get(i).getMagnitude());
			mag[i].setText(magn);
			loc[i].setText(earthquakes.get(i).getProperties().getPlace());
		}
	}
}
