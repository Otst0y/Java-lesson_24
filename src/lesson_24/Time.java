package lesson_24;

public class Time {
	int hour;
	int min;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (!(hour < 0 && hour > 24)) {
			this.hour = hour;
		} else {
			throw new IllegalAccessError("Invalid time.");
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (!(min < 0 && min > 60)) {
			this.min = min;
		} else {
			throw new IllegalAccessError("Invalid time.");
		}
	}

	public Time(int hour, int min) {
		if (!(hour < 0 && hour > 24)) {
			this.hour = hour;
		} else {
			throw new IllegalAccessError("Invalid time.");
		}
		if (!(min < 0 && min > 60)) {
			this.min = min;
		} else {
			throw new IllegalAccessError("Invalid time.");
		}
	}

	@Override
	public String toString() {
		return hour + ":" + min;
	}
}
