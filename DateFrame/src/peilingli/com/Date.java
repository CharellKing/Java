package peilingli.com;

public class Date {
	
	Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date NextDate() {
		int year = this.year, month = this.month, day = this.day;
		
		++ day;
		if (day > GetMonthDay(year, month)) {
			day = 1;
			++ month;
			if (month > 12) {
				month = 1;
				++ year;
			} 
		} 
		
		return new Date(year, month, day);
	}
	
	private boolean IsLeap(int year) {
		return 0 == year % 400 || (0 == year % 4 && 0 != year % 100);
	}
	
	private int GetMonthDay(int year, int month) {
		final int [] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int ret = days[month];
		if (2 == month && IsLeap(year)) {
			++ ret;
		}
		return ret;
	}
	
	private String IsInRanger() {
		if (month < 1 || month > 12) {
			return "month";
		}
		
		if (day < 1 || day > GetMonthDay(year, month)) {
			return "day";
		}
		
		if (year < 1920 || year > 2050) {
			return "year";
		}
		
		return "";
	}
	
	private String dateToStr(){
		return year + "年" + month + "月" + day + "日";
	}
	
	public String getResult() {
		String rangeRet = IsInRanger();
		if (false == rangeRet.isEmpty()) {
			return rangeRet + "的取值不在允许范围之内";
		}
		
		Date nextDate = NextDate();
		return "明天的日期是" + nextDate.dateToStr();
		
	}
	
	private int year = 1;
	private int month = 1;
	private int day = 1;
}
