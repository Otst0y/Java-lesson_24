package lesson_24;

public class Session implements Comparable<Session> {
	Movie movie;
	Time startTime;
	Time endTime;
	Days day;

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public Days getDay() {
		return day;
	}

	public Session(Movie movie, Days day, Time startTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.day = day;
		
		int endHours = startTime.getHour() + movie.getHour();
		int endMin = startTime.getMin() + movie.getMin();
		int minRemainder = endMin % 60;
		if(minRemainder % 60 > 0) {
			endHours++;
		}
		endTime = new Time(endHours, minRemainder);
	}

	@Override
	public String toString() {
		return "Session: \n" + movie + "\nDay: " + day + "\nStart: " + startTime + " End: " + endTime;
	}

	@Override
	public int compareTo(Session s) {
		return this.movie.title.compareTo(s.movie.title);
	}
}
