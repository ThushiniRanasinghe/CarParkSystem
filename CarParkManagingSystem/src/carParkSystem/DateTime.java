//package name
package carParkSystem;

//setting and getting the entry date and time of the vehicles that are being currently parked
public class DateTime {
	// declare variables
	private int minute, hour, day, month, year;

	// Getters
	// getting the minute that a vehicle entered to the car park
	public int getMinute() {
		return minute;
	}

	// getting the hour that a vehicle entered to the car park
	public int getHour() {
		return hour;
	}

	// getting the day that a vehicle entered to the car park
	public int getDay() {
		return day;
	}

	// getting the month that a vehicle entered to the car park
	public int getMonth() {
		return month;
	}

	// getting the year that a vehicle entered to the car park
	public int getYear() {
		return year;
	}

	// Setters
	// setting the minute that a vehicle entered to the car park
	public void setMinute(int minute) {
		this.minute = minute;
	}

	// setting the hour that a vehicle entered to the car park
	public void setHour(int hour) {
		this.hour = hour;
	}

	// setting the day that a vehicle entered to the car park
	public void setDay(int day) {
		this.day = day;
	}

	// setting the month that a vehicle entered to the car park
	public void setMonth(int month) {
		this.month = month;
	}

	// setting the year that a vehicle entered to the car park
	public void setYear(int year) {
		this.year = year;
	}

}
