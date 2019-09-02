package week3;

import java.util.*;

public class Actor {
    private String name;
    private ArrayList<Movie> movies;
    
    public Actor(String name) {
	this.name = name;
	this.movies = new ArrayList<>();
    }
    
    public void setMovies(Movie newMovie) {
	this.movies.add(newMovie);
    }

}
