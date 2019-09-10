package week4;

public class Cruiser extends Ship {
    
    Cruiser(){
	super();
	super.setLength(6);
	super.setHit(new boolean[6]);
    }

    @Override
    public String getShipType() {
	return "Cruiser";
    }
}
