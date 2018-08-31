package forer.earthquake;

import java.util.List;

public class EarthquakeFeed {

	public EarthquakeFeed(String type, List<Earthquake> features) {
		this.type = type;
		this.features = features;
	}

	private String type;
	private List<Earthquake> features;

	public List<Earthquake> getFeatures() {
		return features;
	}

	public String getType() {
		return type;
	}

	public Earthquake getLargest() {
		Earthquake currentMax = getFeatures().get(0);
		for (Earthquake quake : features) {
			if (currentMax.getProperties().getMag() < quake.getProperties().getMag()) {
				currentMax = quake;
			}
		}
		return currentMax;
	}

}
