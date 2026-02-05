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
		//printing out menu
		System.out.println("Movie Management system");
		System.out.println("1    Add New Movie and Save");
		System.out.println("2    Generate List of Movies Released in a Year");
		System.out.println("3    Generate list of random Movies");
		System.out.println("4    Exit");
		
		// getting input
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
		
	}
	
	//Lin
	private void generateMovieListInYear() {
		
	}
	

	private void generateRandomMovieList() {
		
	}
	

	private void saveMovieListToFile() {
		
	}

	private void loadMovieList() {
		//finding the text file
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
		
		//looping though each line and turning it into a Movie Object
		while (fileScanner.hasNextLine()) {
			String movieText = fileScanner.nextLine();
			//System.out.println(movieText);
			
			//splitting the text
			String[] text = movieText.split(",");
			duration = Integer.parseInt(text[0]);
			title = text[1];
			year = Integer.parseInt(text[2]);
			
			//creating and adding movie to the list
			Movie movie = new Movie(duration,title,year);
			movies.add(movie);
		}

	}
}
