package week4;

public class Destroyer extends Ship {
    
    Destroyer(){
	super();
	super.setLength(4);
	super.setHit(new boolean[4]);
    }

    @Override
    public String getShipType() {
	return "Destroyer";
    }
}
