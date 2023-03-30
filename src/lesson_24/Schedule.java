package lesson_24;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Schedule {
	Set<Session> sessions = new TreeSet<>();

	public Set<Session> getSessions() {
		return sessions;
	}

	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}

	Session addSession() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter movie title:");
		String title = scan.next();
		System.out.print("Enter movie hour duration:");
		int hourDuration = scan.nextInt();
		System.out.print("Enter movie min duration:");
		int minDuration = scan.nextInt();
		Movie movie = new Movie(title, hourDuration, minDuration);
		System.out.println("Enter day of the session:");
		String day = scan.next().toUpperCase();
		Days dayEnum = null;
		dayEnum = Days.valueOf(day);
		System.out.print("Enter movie hour start time:");
		int hourStart = scan.nextInt();
		System.out.print("Enter movie min start time:");
		int minStart = scan.nextInt();
		Time startTime = new Time(hourStart, minStart);
		Session session = new Session(movie, dayEnum, startTime);
		sessions.add(session);
		System.out.println("Session was successfully added.");
		return session;
	}

	void showSessions() {
		for (Session session : sessions) {
			System.out.println(session);
			System.out.println();
		}
	}

	void clearSessions() {
		sessions.clear();
	}

	void removeSessionByMovieName() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter title of a movie:");
		String scanMovieName = scan.next();
		Set<Session> s = sessions.stream().filter(movie -> movie.getMovie().getTitle().equalsIgnoreCase(scanMovieName))
				.collect(Collectors.toSet());
		sessions.removeAll(s);
		System.out.println("Session was removed.");
	}

	@Override
	public String toString() {
		return sessions.toString();
	}
}
