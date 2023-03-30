package lesson_24;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Cinema extends Schedule {
	TreeMap<Days, Session> schedules = new TreeMap<Days, Session>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();
	Time open = new Time(6, 30);
	Time close = new Time(23, 30);

	public TreeMap<Days, Session> getSchedules() {
		return schedules;
	}

	public void setSchedules(TreeMap<Days, Session> schedules) {
		this.schedules = schedules;
	}

	public ArrayList<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}

	public void setMoviesLibrary(ArrayList<Movie> moviesLibrary) {
		this.moviesLibrary = moviesLibrary;
	}

	public Time getOpen() {
		return open;
	}

	public void setOpen(Time open) {
		this.open = open;
	}

	public Time getClose() {
		return close;
	}

	public void setClose(Time close) {
		this.close = close;
	}

	void showMoviesLibrary() {
		for (Movie movie : moviesLibrary) {
			System.out.println(movie);
			System.out.println();
		}
	}

	void addMovie() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter movie title:");
		String title = scan.next();
		System.out.print("Enter movie hour duration:");
		int hourDuration = scan.nextInt();
		System.out.print("Enter movie min duration:");
		int minDuration = scan.nextInt();
		Movie movie = new Movie(title, hourDuration, minDuration);
		moviesLibrary.add(movie);
		System.out.println("Movie was successfully added to the collection.");
	}

	void removeMovieByName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter title of a movie:");
		String scanMovieName = scan.next();
		moviesLibrary.removeIf(m -> m.getTitle().equalsIgnoreCase(scanMovieName));
		System.out.println("Movie was successfully removed from the collection.");
	}

	void addSessionToSchedule() {
		Session session = addSession();
		Days day = session.getDay();
		LocalTime lt = LocalTime.now();
		if ((lt.getHour() >= open.getHour() || lt.getMinute() >= open.getMin())
				|| (lt.getHour() <= close.getHour() || lt.getMinute() <= close.getMin())) {
			schedules.put(day, session);
		}
		System.out.println("Session was added to Schedule.");
	}

	void removeSession() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter movie title to remove session from Schedule:");
		String scanTitle = scan.next();
		
		schedules.entrySet().removeIf(entry -> entry.getValue().getMovie().getTitle().equalsIgnoreCase(scanTitle));
		System.out.println("Session was removed.");
	}

	void showSchedule() {
		for (Map.Entry<Days, Session> schedule : schedules.entrySet()) {
			System.out.println(schedule.getKey().toString() + ": " + schedule.getValue().toString());
		}
	}
	
	void printScheduleInfo() {
	    if (schedules.isEmpty()) {
	        System.out.println("The schedule is empty.");
	    } else {
	        System.out.println("Schedule:");
	        for (Map.Entry<Days, Session> entry : schedules.entrySet()) {
	            Days day = entry.getKey();
	            Session session = entry.getValue();
	            System.out.println(day.toString() + ": " + session.toString());
	        }
	    }
	}

	void clearSchedules() {
		schedules.clear();
	}

	void showWorkingHours() {
		System.out.println("We're open from: " + open + "\n           " + "to: " + close);
		System.out.println();
	}

	@Override
	public String toString() {
		return "Cinema [schedules=" + schedules + ", moviesLibrary=" + moviesLibrary + ", open=" + open + ", close="
				+ close + "]";
	}
}
