package MovieDatabase;

import java.util.ArrayList;

public class Actor {
    private String name;
    private ArrayList<Movie> movies;
    
    public Actor(String name) {
	this.name = name;
	this.movies = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Movie> getMovie() {
        return movies;
    }
    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }
    
    

}
