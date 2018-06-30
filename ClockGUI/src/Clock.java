
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


public class Clock{
	int hour, min, sec;
	
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		// TODO Auto-generated method stub
		this.sec = sec;
		
	}
	
	Clock()
	{
		
		
		
	}
/*	public static void main(String[] args) throws InterruptedException {
		//String answer = "n";
		Clock clock = new Clock();
		DateForClock dateForClock = new DateForClock();
		dateForClock.computeDate();
		while (true) {
            Calendar a = Calendar.getInstance();

            //The time I want
            String wTime = "21:6:0";

            String sec = Integer.toString(a.get(Calendar.SECOND));
            String min = Integer.toString(a.get(Calendar.MINUTE));
            String hour = Integer.toString(a.get(Calendar.HOUR_OF_DAY));
            String day = Integer.toString(a.get(Calendar.DAY_OF_MONTH));
            String year = Integer.toString(a.get(Calendar.YEAR));
            int month = Integer.parseInt(Integer.toString(a.get(Calendar.MONTH)));
            String strm = "January";
            switch(month)
            {
            case 0:
            	strm = "January"; break;
            case 1:
            	strm = "February"; break;
            case 2:
            	strm = "March"; break;
            case 3:
            	strm = "April"; break;
            case 4:
            	strm = "May"; break;
            case 5:
            	strm = "June"; break;
            case 6:
            	strm = "July"; break;
            case 7:
            	strm = "August"; break;
            case 8:
            	strm = "September"; break;
            case 9:
            	strm = "October"; break;
            case 10:
            	strm = "November"; break;
            case 11:
            	strm = "December"; break;
            default:
            	strm = "Unknown"; break;
            
            }
            clock.setHour(Integer.parseInt(hour));
            clock.setMin(Integer.parseInt(min));
            clock.setSec(Integer.parseInt(sec));
            String time = hour + ":" + min + ":" + sec + " "   + strm + " " + day + ", " + year;

            System.out.println(time);
            if (time.equals(wTime)) {
                // Tweet something
            	System.out.println("BEEP!!!" + "BEEP!!" + "BEEP!" + "BEEP");
            	System.exit(0);
                //Tweet something
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		
		
		
	}
	*/
	
	
}

