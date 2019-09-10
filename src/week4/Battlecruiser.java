package week4;

public class Battlecruiser extends Ship {
    
    Battlecruiser(){
	super();
	super.setLength(7);
	super.setHit(new boolean[7]);
    }

    @Override
    public String getShipType() {
	return "Battlecruiser";
    }
}
