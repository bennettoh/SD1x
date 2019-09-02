package MovieDatabase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieDatabase {
    private ArrayList<Actor> actorList;
    private ArrayList<Movie> movieList;

    public MovieDatabase() {
	this.actorList = new ArrayList<Actor>();
	this.movieList = new ArrayList<Movie>();
    }

    public void addMovie(Movie toBeAdded) {
	boolean nameEquals = false;
	//check if duplicate movie already exists in the database
	for(Movie movie : this.movieList) {
	    if(toBeAdded.getName().equals(movie.getName())) {
		nameEquals = true;
	    }
	}
	if(!nameEquals) {
	    this.movieList.add(toBeAdded);
	}
    }

    public void addActor(Actor toBeAdded) {
	this.actorList.add(toBeAdded); //assume there is no actor duplication
    }
    
    public void addRating(String movieName, double rating) {
	for(Movie movie : movieList) {
	    if(movie.getName().equals(movieName)) {
		movie.setRating(rating);
	    }
	}
    }
    
    public String getBestActor() {
	String bestActor = null;
	double bestScore = 0;
	for(Actor actor : actorList) {
	    int count = 0;
	    double sum = 0;
	    
	    for(Movie movie : actor.getMovie()) {
		  sum = sum + movie.getRating();
		  count++;
	    }
	    
	    double average = sum / count;
	    if(average > bestScore) {
		bestActor = actor.getName();
		bestScore = average;
	    }
	    
	}
	return bestActor;
    }
    
    public String getBestMovie() {
	String bestMovie = null;
	double bestScore = 0;
	for(Movie movie : movieList) {
	    if(movie.getRating() > bestScore) {
		bestMovie = movie.getName();
		bestScore = movie.getRating();
	    }
	    
	}
	return bestMovie;
    }

    public static void main(String[] args) {
	MovieDatabase md = new MovieDatabase();

	//Scan from movies.txt and form primary database
	try(Scanner sc = new Scanner(new File("movies.txt"))) {
	    while (sc.hasNextLine()) {
		String str = sc.nextLine(); //read line by line
		String[] tokens = str.split(", "); //split line into array

		Actor newActor = new Actor(tokens[0]); //create actor object
		md.addActor(newActor); //add actor to database

		for(int i = 1; i < tokens.length; i++) {
		    Movie newMovie = new Movie(tokens[i]); //create movie object
		    md.addMovie(newMovie); //add movie to database
		    newActor.addMovie(newMovie); //add movies to actor object
		}
	    }
	}
	catch (IOException e) {
	    System.out.println("Movie.txt file Read Error");
	}
	
	//Scan from ratings.txt and apply ratings to movies in the database
	try(Scanner sc = new Scanner(new File("ratings.txt"))){
	    sc.nextLine(); //skip first line
	    while(sc.hasNextLine()) {
		String str = sc.nextLine();
		String[] tokens = str.split("\t");		
		String movieName = tokens[0];
		double rating = Double.parseDouble(tokens[1]);
		
		md.addRating(movieName, rating);
	    }
	    
	}
	catch (IOException e) {
	    System.out.println("Ratings.txt file Read Error");
	}
	
	System.out.println(md.getBestActor());
	System.out.println(md.getBestMovie());

	//checking if actors have movies
//	for(Actor actor : md.actorList) {
//	    System.out.println(actor.getName() + " performs in:");
//	    for(Movie movie : actor.getMovie()) {
//		System.out.println(" - " + movie.getName());
//	    }
//	}
	
	//checking if movies got their ratings
//	for(Movie movie : md.movieList) {
//	    System.out.println(movie.getName() + " has the rating: " + movie.getRating());
//	}

    }

}
