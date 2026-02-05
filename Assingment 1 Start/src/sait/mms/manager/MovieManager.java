package sait.mms.manager;

import java.util.*;

import sait.mms.problemdomain.Movie;

public class MovieManager {
	
	//attributes
	private ArrayList<Movie> movies = new ArrayList<>();
	private Scanner keyboard = new Scanner(System.in);
	private int option;
	
	public MovieManager() {
		loadMovieList();
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
	
	//Camille
	private void generateRandomMovieList() {
		
	}
	
	//Camille
	private void saveMovieListToFile() {
		
	}

	private void loadMovieList() {
		
		
	}
}
