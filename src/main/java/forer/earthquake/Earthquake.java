package forer.earthquake;

public class Earthquake {
	public Earthquake(double mag, String place, long time) {
		properties = new EarthquakeProperties(mag, place, time);
	}
	private String id;
	private EarthquakeProperties properties;
	
	
	public String getId() {
		return id;
	}
	public EarthquakeProperties getProperties() {
		return properties;
	}


	public double getMagnitude(){
		return getProperties().getMag();
	}
	
}
