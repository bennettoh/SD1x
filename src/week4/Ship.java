package week4;

public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    public Ship() {
    }

    public int getBowRow() {
	return bowRow;
    }

    public void setBowRow(int bowRow) {
	this.bowRow = bowRow;
    }

    public int getBowColumn() {
	return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
	this.bowColumn = bowColumn;
    }

    public int getLength() {
	return length;
    }

    public void setLength(int length) {
	this.length = length;
    }

    public boolean isHorizontal() {
	return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
	this.horizontal = horizontal;
    }

    public boolean[] getHit() {
	return hit;
    }

    public void setHit(boolean[] hit) {
	this.hit = hit;
    }

    public abstract String getShipType();

    /**
     * Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise. 
     * The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally), and it must not ”stick out” beyond the array. 
     * Do not actually change either the ship or the Ocean, just says whether it is legal to do so.
     */
    public boolean okToPlaceShip(int row, int column, boolean horizontal, Ocean ocean) {
	Ship[][] grid = ocean.getGrid();
	if (horizontal) {
	    if(column + getLength() > 20) {
		return false;
	    }
	    else {
		
		for(int i = column; i < column + length; i++) {
		    try{
			if(grid[row][i].getShipType() != "Empty") {
			    return false;
			}
		    } catch (Exception e) {
			continue;
		    }
		}
	    }
	}
	else {
	    if(row + getLength() > 20) {
		return false;
	    }
	    else {
		for(int i = row; i < row + length; i++) {
		    try {
			if(grid[i][column].getShipType() != "Empty") {
			    return false;
			}
		    } catch (Exception e) {
			continue;
		    }
		}
	    }
	}
	return true;
    }

    /**
     * ”Puts” the ship in the ocean. 
     * This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship, and it also involves putting a reference to the ship in each of 1 or more locations (up to 8) in the ships array in the Ocean object. 
     * (Note: This will be as many as eight identical references; you can’t refer to a ”part” of a ship, only to the whole ship.)
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	this.bowRow = row;
	this.bowColumn = column;
	this.horizontal = horizontal;

	if (horizontal) {
	    for (int j = column; j < column + getLength(); j++) {
		ocean.getGrid()[row][j] = this;
	    }
	} else {
	    for (int i = row; i < row + getLength(); i++) {
		ocean.getGrid()[i][column] = this;
	    }
	}

    }

    /**
     * Checks if a part of the ship occupies the given row and column.
     * If the ship hasn’t been sunk, mark that part of the ship as ”hit” (in the hit array, 0 indicates the bow) and return true, otherwise return false.
     * @param row
     * @param column
     * @return
     */
    public boolean shootAt(int row, int column) {
	if(row == bowRow && column == bowColumn) {
	    
	    return true;
	}
	else {
	    return false;
	}
	
    }

    /**
     * Return true if every part of the ship has been hit, false otherwise.
     * @return
     */
    public boolean isSunk() {
	int hp = 0;
	for(boolean bool : hit) {
	    if(bool == true) {
		hp++;
	    }
	}
	if(hp == length) {
	    return true;
	}
	else {
	    return false;
	}
	
    }

    /**
     * Returns a single-character String to use in the Ocean’s print method.
     * This method should return ”x” if the ship has been sunk, ”S” if it has not been sunk.
     * This method can be used to print out locations in the ocean that have been shot at; it should not be used to print locations that have not been shot at.
     */
    @Override
    public String toString() {
	if(isSunk()) {
	    return " X ";
	}
	return " S ";
    }

}
