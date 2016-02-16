package hig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Resolution {
	YEAR {
		@Override
		public String setDate(LocalDate ld) {
			return String.valueOf(DateTimeFormatter.ofPattern("yyyy"));
//			return String.valueOf(ld.getYear());
		}
	}, MONTH{
		@Override
		public String setDate(LocalDate ld) {
			return String.valueOf(DateTimeFormatter.ofPattern("yyyy-MM"));
//			return  String.valueOf(ld.getYear()) + "-" + String.valueOf(ld.getMonthValue());
		}

	}, QUARTER {
		@Override
		public String setDate(LocalDate ld) {
			return String.valueOf(DateTimeFormatter.ofPattern("yyyy-Q"));
		}

	}, WEEK {
		@Override
		public String setDate(LocalDate ld) {
			return String.valueOf(DateTimeFormatter.ofPattern("yyyy-w"));
		}

	}, DAY {
		@Override
		public String setDate(LocalDate ld) { 
			return String.valueOf(DateTimeFormatter.ISO_DATE);
//			return String.valueOf(ld.getYear()) +"-"+ String.valueOf(ld.getMonthValue()) +"-"+ String.valueOf(ld.getDayOfMonth());		
		}

	};
	
	public abstract String setDate(LocalDate ld);
	
}
