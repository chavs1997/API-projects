package forer.earthquake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class EarthquakeReader {
	public static void main(String args[]) throws FileNotFoundException {
		Gson gson = new Gson();
		BufferedReader in = new BufferedReader(new FileReader(new File("src/main/java/forer/earthquake/all_month.geojson")));
		EarthquakeFeed feed = gson.fromJson(in, EarthquakeFeed.class);
		int count = 0;
		for(int i = 0; i < feed.getFeatures().size(); i++) {
			if(feed.getFeatures().get(i).getProperties().getMag() >= 5) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println(feed.getFeatures().stream().filter(e -> e.getProperties().getMag() >= 5).count());
		// same result as lines 16-21
	}
}
