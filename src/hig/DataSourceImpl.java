package hig;

import java.time.LocalDate;
import java.util.Map;

public interface DataSourceImpl {
	public String getName();
	public String getUnit();
	public Map<LocalDate, Double> getData();
}
