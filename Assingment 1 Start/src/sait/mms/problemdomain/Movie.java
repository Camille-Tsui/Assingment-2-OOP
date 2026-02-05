package sait.mms.problemdomain;

public class Movie {
	
	// attributes
	private int duration;
	private String title;
	private int year;

	
	// non-default constructor
	public Movie(int duration, String title, int year) {
		super();
		this.duration = duration;
		this.title = title;
		this.year = year;
	}
	
	// public getter method (3)

	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	// public format to file method
	public String formatToFile() {
		String formatedString = new String(duration + "," + title + "," + year);
		return formatedString;
	}
	
	// Overridden toString
	@Override
	public String toString() {
		return "Movie [duration=" + duration + ", title=" + title + ", year=" + year + "]";
	}
	
}
