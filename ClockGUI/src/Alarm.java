
public class Alarm {
	int alarmHour, alarmMin;
	public int getAlarmHour() {
		return alarmHour;
	}
	public void setAlarmHour(int alarmHour) {
		this.alarmHour = alarmHour;
	}
	public int getAlarmMin() {
		return alarmMin;
	}
	public void setAlarmMin(int alarmMin) {
		this.alarmMin = alarmMin;
	}
	public Alarm(int alarmHour, int alarmMin)
	{
		this.alarmHour = alarmHour;
		this.alarmMin = alarmMin;
	}
}
