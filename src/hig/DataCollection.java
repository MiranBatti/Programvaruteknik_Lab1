package hig;

import java.util.Map;

public class DataCollection {
	private Map<String, MatchedDataPair> data;
	private String title;
	private String xUnit, yUnit;
	
	public DataCollection(String xUnit, String yUnit, String title, Map data) {
		this.data = data;
		this.title = title;
		this.xUnit = xUnit;
		this.yUnit = yUnit;
	}
	
	public String getTitle() {
		return title;
	}

	public Map<String, MatchedDataPair> getData() {
		return data;
	}

	public String getxUnit() {
		return xUnit;
	}

	public String getyUnit() {
		return yUnit;
	}

	@Override
	public String toString() {
		return "DataCollection [title=" + title + ", xUnit=" + xUnit + ", yUnit=" + yUnit + "]";
	}
	
}
