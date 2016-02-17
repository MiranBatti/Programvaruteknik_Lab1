package hig;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DataSourceImpl implements DataSource{
	
	String name;
	String unit;
	
	Map<LocalDate, Double> data;
	
	public DataSourceImpl(String name, String unit) {
		data = new HashMap<LocalDate, Double>();
		this.name = name;
		this.unit = unit;
	}
	

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getUnit() {
		return unit;
	}

	@Override
	public Map<LocalDate, Double> getData() {
		return data;
	}

	public void setValue(LocalDate ld, Double d){
		data.put(ld, d);
	}

}
