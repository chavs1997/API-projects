package forer.earthquake.net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import forer.earthquake.EarthquakeFeed;

public class EarthquakeClient {

	public static void main(String[] args) throws IOException {

		URL url = new URL("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();
		EarthquakeFeed feed = gson.fromJson(reader, EarthquakeFeed.class);

		System.out.println(feed.getFeatures().stream().filter(e -> e.getProperties().getMag() >= 5).count());
	}

}