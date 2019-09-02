package week3;

public class Garage {
    private Car[] stalls;
    private int spots;
    
    public Garage(int spots, Car car) {
	this.spots = spots;
	stalls = new Car[spots];
    }
    
    public boolean park(Car tobeparked) {
	int i = 0;
	while(stalls[i] != null) {
	    i++;
	    if(i == stalls.length) return false;
	}
	
	stalls[i] = tobeparked;
	tobeparked.setLocation(i);
	return true;
    }
    
    
    
    public static void main(String[] args) {
	
    }

}
