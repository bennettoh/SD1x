package week4;

public class LightCruiser extends Ship {
    
    LightCruiser(){
	super();
	super.setLength(5);
	super.setHit(new boolean[5]);
    }

    @Override
    public String getShipType() {
	return "Light Cruiser";
    }
}
