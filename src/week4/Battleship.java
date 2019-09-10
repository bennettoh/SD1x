package week4;

public class Battleship extends Ship {
    
    Battleship(){
	super();
	super.setLength(8);
	super.setHit(new boolean[8]);
    }

    @Override
    public String getShipType() {
	return "Battleship";
    }
}
