package lesson_24;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Cinema cinema = new Cinema();
		/*int min = 80 % 60 ;
		int hour = 0;
		System.out.println(min);
		if(min > 0) {
			hour++;
		}
		
		System.out.println("Hour: " + hour + "\nMin: " + min);
		*/
		
		while(true) {
			menu();
			Scanner scan = new Scanner(System.in);
			int scanMenu = scan.nextInt();
			
			switch (scanMenu) {
			case 0: 
				cinema.showWorkingHours();
				break;
				
			case 1: 
				cinema.addMovie();
				break;
				
			case 2: 
				cinema.showMoviesLibrary();
				break;
				
			case 3: 
				cinema.removeMovieByName();
				break;
				
			case 4: 
				cinema.addSession();
				break;
				
			case 5: 
				cinema.showSessions();
				break;
				
			case 6: 
				cinema.addSessionToSchedule();
				break;
				
			case 7: 
				cinema.removeSession();
				break;
			
			case 8: 
				cinema.printScheduleInfo();
				break;
				
			case 9: 
				cinema.clearSchedules();
				break;
				
			case 10: 
				System.exit(0);
				break;
				
			default: System.out.println("Invalid input.");
				break;
			}
		}
	}
	
	static void menu() {
		System.out.println("Enter 0 to show working hours.");
		System.out.println("Enter 1 to add Movie.");
		System.out.println("Enter 2 to show Movies.");
		System.out.println("Enter 3 to remove a Movie.");
		System.out.println("Enter 4 to add Session.");
		System.out.println("Enter 5 to show Sessions.");
		System.out.println("Enter 6 to add Session to Schedule.");
		System.out.println("Enter 7 to remove Session from Schedule.");
		System.out.println("Enter 8 to show Schedule.");
		System.out.println("Enter 9 to clear ALL Schedule");
		System.out.println("Enter 10 to Exit.");
	}
}
