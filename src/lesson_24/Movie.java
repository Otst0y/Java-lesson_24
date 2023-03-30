package lesson_24;

public class Movie extends Time {
	String title;
	Time duration;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public Movie(String title, int hour, int min) {
		super(hour, min);
		this.title = title;
	}

	@Override
	public String toString() {
		return "Movie: " + title + "\nDuration: " + hour + ":" + min;
	}
}
