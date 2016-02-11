package hig;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

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

		for (Entry<String,List<MatchedDataPair>> res1 : resultData.entrySet()) {
			//	System.out.println("Res.size() = " + res2.size());
				Double tempX = 0d;
				Double tempY = 0d;
				for (int i = 0; i < res1.getValue().size(); i++) {
					tempX += res1.getValue().get(i).getXValue();
					tempY += res1.getValue().get(i).getYValue();

				//	System.out.println("tempX & Y " +tempX + " " + tempY);

				}

				finalResult.put(res1.getKey(), new MatchedDataPair(tempX/res1.getValue().size(),tempY/res1.getValue().size()));
			}
			//		return new DataCollection(xData.getUnit(), yData.getUnit(), title, finalResult);
		
	}

	private void doAthing() {
		List<MatchedDataPair> list;

		for(Entry<LocalDate, Double> xLoop : xData.getData().entrySet()) {
			boolean match = false;
			list = new ArrayList<>();
			String date1 = resolution.setDate(xLoop.getKey());

			for (Entry<LocalDate, Double> yLoop : yData.getData().entrySet()) {


				String date2 = resolution.setDate(yLoop.getKey());

				if(date1.equals(date2)) {
					list.add(new MatchedDataPair(xLoop.getValue(), yLoop.getValue()));
					match = true;
				}


			}
			if(match)
				resultData.put(xLoop.getKey()+"", list);






		}

		System.out.println(resultData);



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
