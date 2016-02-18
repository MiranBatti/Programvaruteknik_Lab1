package hig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Resolution {

	YEAR("yyyy"),

	MONTH("yyyy-MM"),

	QUARTER("yyyy-'Q'q"),

	WEEK("YYYY-'W'w"),

	DAY("yyyy-MM-dd");

	final DateTimeFormatter dtf;

	public String setDate(LocalDate ld) {
		return ld.format(dtf);
	}

	private Resolution(String pattern) {

		dtf = DateTimeFormatter.ofPattern(pattern);
	}

}
