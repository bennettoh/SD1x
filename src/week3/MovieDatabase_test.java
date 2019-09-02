package week3;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MovieDatabase_test {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;
    
    public MovieDatabase_test() {
	movieList = new ArrayList<Movie>(); //instantiation of arrays with unknown number of Movie objects
	actorList = new ArrayList<Actor>(); //instantiation of arrays with unknown number of Actor objects
    }
    
    
    /**
     * This method takes in the name of a movie that is not currently in the database along with a list of actors for that movie.
     * If the movie is already in the database, your code ignores this request (this specification is an oversimplification).
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     * @param name
     * @param actors
     */
    public void addMovie(String actor, String[] movies) {
	for(int i = 1; i < movies.length; i++) {
	    Movie newMovie = new Movie(movies[i]);
	    Actor newActor = new Actor(actor);
	    
	    //if newMovie's actor array doesn't contain newActor, add newActor
	    if(!newMovie.getActors().contains(newActor)) {
		newMovie.setActors(newActor);
		newActor.setMovies(newMovie);
	    }
	    	    
	    //if newMovie doesn't exist in movieList, add newMovie to the ArrayList
	    //if newActor doesn't exist in actorList, add newActor to the actorList
	    if(!movieList.contains(newMovie)) {
		movieList.add(newMovie);
	    }
	    if(!actorList.contains(newActor)) {
		actorList.add(newActor);
	    }
	    
	}

    }
    
    public ArrayList<Movie> getMovies(){
	return movieList;
    }

    public static void main(String[] args) {
	MovieDatabase_test md = new MovieDatabase_test();
	
	try(Scanner sc = new Scanner(new File("movies.txt"))) {
	    while (sc.hasNextLine()) {
		String str = sc.nextLine(); //read line by line
		String[] tokens = str.split(", "); //split line into array
		String actorName = tokens[0]; //first item in tokens is name of actor
		md.addMovie(actorName, tokens);
		
		System.out.println(md.getMovies());
		}
		

	    }
	catch (IOException e) {
	    System.out.println("File Read Error");
	}

	}
	
    }
