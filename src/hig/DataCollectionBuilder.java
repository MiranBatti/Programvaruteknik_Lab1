package hig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataCollectionBuilder {
	private DataSource xData;
	private DataSource yData;
	private Resolution resolution;
	private Map<String, List <MatchedDataPair>> resultData; 
	private Map<String, MatchedDataPair> finalResult;
	
	public DataCollectionBuilder(DataSource xData, DataSource yData, Resolution resolution) {
		this.xData = xData;
		this.yData = yData;
		this.resolution = resolution;
		finalResult = new HashMap<String, MatchedDataPair>();
	}

	public String getTitle() {
		return "Title: " + xData.getName() + ", " + yData.getName();
	}
	
	public DataCollection getResult() {
//		return new DataCollection(xData.getUnit(), yData.getUnit(), title, finalResult);
		return null;
	}
	
	private void doathing() {
		
	}
}
