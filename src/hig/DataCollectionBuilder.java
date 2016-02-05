package hig;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		resultData = new HashMap<String, List<MatchedDataPair>>();
	}

	public String getTitle() {
		return "Title: " + xData.getName() + ", " + yData.getName();
	}

	private void setFinalResult(Map<String, List <MatchedDataPair>> resultData) {


		for (Entry<String, List<MatchedDataPair>> res : resultData.entrySet()) {

			Double tempX = 0d;
			Double tempY = 0d;
			for (int i = 0; i < res.getValue().size(); i++) {
				tempX += res.getValue().get(i).getXValue();
				tempY += res.getValue().get(i).getYValue();
				
				System.out.println("tempX o Y" +tempX + " " + tempY);
				
			}

			finalResult.put(res.getKey(), new MatchedDataPair(tempX/res.getValue().size(),tempY/res.getValue().size()));
		}
		//		return new DataCollection(xData.getUnit(), yData.getUnit(), title, finalResult);
	}

	private void doAthing() {
		ArrayList<MatchedDataPair> list;

		for(Entry<LocalDate, Double> xLoop : xData.getData().entrySet()) {
			list = new ArrayList<>();
			for (Entry<LocalDate, Double> yLoop : yData.getData().entrySet()) {

				if(xLoop.getKey().equals(yLoop.getKey())) {
					list.add(new MatchedDataPair(xLoop.getValue(), yLoop.getValue()));
				}

			}
			resultData.put(getLocalDate(xLoop.getKey()), list);
		}

	
	}

	public DataCollection getResult(){
		
		doAthing(); 
		setFinalResult(resultData);
		return new DataCollection(xData.getUnit(), yData.getUnit(), getTitle(),finalResult);
		
		
		
	}
	

	private String getLocalDate(LocalDate localDate){

		switch(resolution){

		case DAY:
		{
			return localDate.getYear() + "-" + localDate.getMonth() + "-" + localDate.getDayOfMonth();
		}
		case WEEK:
		{
			return localDate.getYear() + "-" ;
		}
		case MONTH:
		{
			return localDate.getYear() + "-" + localDate.getMonth();
		}
		case QUARTER:
		{
			return localDate.getYear()+"";
		}
		case YEAR:
		{
			return localDate.getYear()+"";
		}

		}


		return "";
	}



}
