package week4;

public class EmptySea extends Ship{
    public EmptySea() {
	super();
	super.setLength(1);
    }

    //This method overrides shootAt(int row, int column) that is inherited from Ship, and always returns false to indicate that nothing was hit.
    @Override
    public boolean shootAt(int row, int column) {
	return false;
    }

    //This method overrides isSunk() that is inherited from Ship, and always returns false to indicate that you didn’t sink anything.
    @Override 
    public boolean isSunk() {
	return false;
    }
    
    @Override
    public String toString() {
	return " . ";
    }

    @Override
    public String getShipType() {
	return "Empty";
    }

}
