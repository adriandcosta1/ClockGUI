import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;


public class DateForClock {
	int day, month, year;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public DateForClock(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public DateForClock(){
		
	}
	public void computeDate()
	{
		
		TimeZone est = TimeZone.getTimeZone("EST");
		
		 
		
		GregorianCalendar gc = new GregorianCalendar(est);
		
		 this.setDay(gc.get(Calendar.DAY_OF_MONTH));
		 this.setMonth(gc.get(Calendar.MONTH));
		 this.setYear(gc.get(Calendar.YEAR));
	}
}
