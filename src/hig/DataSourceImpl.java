package hig;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DataSourceImpl implements DataSource{
	
	String name;
	String unit;
	
	Map<LocalDate, Double> data;
	
	
	public DataSourceImpl(LocalDate ld, Double d) {
		
		data = new HashMap<LocalDate, Double>();
		
		data.put(ld, d);
		
		
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getUnit() {
		// TODO Auto-generated method stub
		return unit;
	}

	@Override
	public Map<LocalDate, Double> getData() {
		// TODO Auto-generated method stub
		return data;
	}

	public void setValue(LocalDate ld, Double d){
		
		
		data.put(ld, d);
	}
	
	

}
