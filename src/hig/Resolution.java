package hig;

import java.time.LocalDate;

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
return"";

		}

	}, 
	WEEK{
		@Override
		public String setDate(LocalDate ld){
return "";
		}

	}, DAY{
		@Override
		public String setDate(LocalDate ld){
return String.valueOf(ld.getYear()) +"-"+ String.valueOf(ld.getMonthValue()) +"-"+ String.valueOf(ld.getDayOfMonth());
		}

	};
	public abstract String setDate(LocalDate ld);
}
