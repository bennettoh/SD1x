package week4;

public class Submarine extends Ship {
    
    Submarine(){
	super();
	super.setLength(3);
	super.setHit(new boolean[3]);
    }

    @Override
    public String getShipType() {
	return "Submarine";
    }
}
