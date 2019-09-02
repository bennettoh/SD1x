package week3;

import java.util.*;

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;
    
    public Movie(String name) {
	this.name = name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(Actor newActor) {
	this.actors.add(newActor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    


}
