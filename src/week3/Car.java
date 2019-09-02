package week3;

public class Car {
    private String ownerName;
    private int license;
    private int registration;
    private int location;
    
    public Car(String owner, int license, int registration) {
	this.ownerName = owner;
	this.license = license;
	this.registration = registration;
    }
    
    
    public int getLocation() {
        return location;
    }


    public void setLocation(int location) {
        this.location = location;
    }


    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public int getLicense() {
        return license;
    }
    public int getRegistration() {
        return registration;
    }

}
