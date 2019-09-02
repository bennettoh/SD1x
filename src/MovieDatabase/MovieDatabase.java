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
	this.actorList.add(toBeAdded);
    }

    public static void main(String[] args) {
	MovieDatabase md = new MovieDatabase();

	try(Scanner sc = new Scanner(new File("movies.txt"))) {
	    while (sc.hasNextLine()) {
		String str = sc.nextLine(); //read line by line
		String[] tokens = str.split(", "); //split line into array
		String actorName = tokens[0]; //first item in tokens is name of actor
		
		Actor newActor = new Actor(actorName);
		md.addActor(newActor);

		for(int i = 1; i < tokens.length; i++) {
		    Movie newMovie = new Movie(tokens[i]);
		    md.addMovie(newMovie);
		    newActor.addMovie(newMovie);
		}
	    }

	    for(Actor actor : md.actorList) {
		System.out.println(actor.getName());
		for(Movie movie : actor.getMovie()) {
		    System.out.println(movie.getName());
		}
	    }
	}
	catch (IOException e) {
	    System.out.println("File Read Error");
	}

    }

}
