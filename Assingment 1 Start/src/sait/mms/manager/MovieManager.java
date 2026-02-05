package sait.mms.manager;

import java.util.*;
import java.io.*;

import sait.mms.problemdomain.Movie;

public class MovieManager {
	
	//attributes
	private ArrayList<Movie> movies = new ArrayList<>();
	private Scanner keyboard = new Scanner(System.in);
	private int option;
	
	
	public MovieManager() {
		loadMovieList();
		//System.out.println(movies.get(1).toString()); // this is just a test
		
		displayMenu();
	}

	private void displayMenu() {
		System.out.println("Movie Management system");
		System.out.println("1    Add New Movie and Save");
		System.out.println("2    Generate List of Movies Released in a Year");
		System.out.println("3    Generate list of random Movies");
		System.out.println("4    Exit");
		
		System.out.print("Enter an option: ");
		int option = Integer.parseInt(keyboard.nextLine());
		
		if (option == 1) {
			addMovie();
		}
		else if (option == 2) {			
			generateMovieListInYear();
		}
		else if (option == 3) {
			generateRandomMovieList();			
		}
		else if (option == 4) {
			saveMovieListToFile();			
		}
	}
	
	//Lin
	private void addMovie() {
		int duration = 0;
		int year = 0;
		String title = "";

		System.out.print("\nEnter duration: ");
		if (keyboard.hasNextInt()) {
			duration = keyboard.nextInt();
		}
		keyboard.nextLine();

		if (duration <= 0) {
			System.out.println("Invalid duration!");
			return;
		}

		System.out.print("Enter movie title: ");
		title = keyboard.nextLine().trim();

		if (title.isEmpty()) {
			System.out.println("Invalid title!");
			return;
		}

		System.out.print("Enter year: ");
		if (keyboard.hasNextInt()) {
			year = keyboard.nextInt();
		}
		keyboard.nextLine();

		if (year <= 0) {
			System.out.println("Invalid year!");
			return;
		}

		movies.add(new Movie(duration, title, year));

		System.out.println("\nSaving movies...");
		saveMovieListToFile();
		System.out.println("Added movie to the data file.\n");
	}
	
	//Lin
	private void generateMovieListInYear() {
		int inputYear = 0;

		System.out.print("\nEnter in year: ");
		if (keyboard.hasNextInt()) {
			inputYear = keyboard.nextInt();
		}
		keyboard.nextLine();

		if (inputYear <= 0) {
			System.out.println("Invalid year!");
			return;
		}

		System.out.println("\n\nMovie List\n");
		System.out.println("Duration\tYear\tTitle");

		int totalDuration = 0;

		for (Movie m : movies) {
			if (m.getYear() == inputYear) {
				totalDuration += m.getDuration();
				System.out.println(
					m.getDuration() + "\t\t" + m.getYear() + "\t" + m.getTitle()
				);
			}
		}

		System.out.println("\nTotal duration: " + totalDuration + " minutes\n");
	}
	

	private void generateRandomMovieList() {
		
	}
	

	private void saveMovieListToFile() {
		
	}

	private void loadMovieList() {
		File movieFile = new File("res/movies.txt");
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(movieFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int duration;
		String title = null;
		int year;
		
		while (fileScanner.hasNextLine()) {
			String movieText = fileScanner.nextLine();
			
			String[] text = movieText.split(",");
			duration = Integer.parseInt(text[0]);
			title = text[1];
			year = Integer.parseInt(text[2]);
			
			Movie movie = new Movie(duration,title,year);
			movies.add(movie);
		}
	}
}
