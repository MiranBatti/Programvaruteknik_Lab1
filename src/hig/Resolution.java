package hig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Resolution{
	YEAR{
		@Override
		public String setDate(LocalDate ld){

			return String.valueOf(ld.getYear());
		}
	}, 
	MONTH{
		@Override
		public String setDate(LocalDate ld){
			return  String.valueOf(ld.getYear()) + "-" + String.valueOf(ld.getMonthValue());
		}

	}, 
	QUARTER{
		@Override
		public String setDate(LocalDate ld){
			return String.valueOf(ld.getYear() + "-Q" + String.valueOf((ld.getMonthValue()+2)/3));

		}

	}, 
	WEEK{
		@Override
		public String setDate(LocalDate ld){
			
			return ld.format(DateTimeFormatter.ofPattern("YYYY-'W'w")); 
		}

	}, DAY{
		@Override
		public String setDate(LocalDate ld){
			return String.valueOf(ld.getYear()) +"-"+ String.valueOf(ld.getMonthValue()) +"-"+ String.valueOf(ld.getDayOfMonth());
		}

	};
	public abstract String setDate(LocalDate ld);
}
