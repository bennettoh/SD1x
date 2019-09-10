package week4;

public class Battlecruiser extends Ship {
    
    public Battlecruiser(){
	super();
	super.setLength(7);
	super.setHit(new boolean[7]);
    }

    @Override
    public String getShipType() {
	return "Battlecruiser";
    }
}
