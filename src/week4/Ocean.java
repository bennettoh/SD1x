package week4;

public class Ocean {
    public Ship[][] grid;
    private int shotsFired;
    private int hitCount;
    private int shipSunk;
    
    public Ocean() {
	this.grid = new Ship[20][20];
	for(int i = 0; i < grid.length; i++) {
	    for(int j = 0; j < grid.length; j++) {
		this.grid[i][j] = new EmptySea();
	    }
	}
	this.shotsFired = 0;
	this.hitCount = 0;
	this.shipSunk = 0;
    }
    
    public Ship[][] getGrid() {
	return grid;
    }
    
    public void setGrid(Ship[][] grid) {
	this.grid = grid;
    }

    public int getShotsFired() {
	return shotsFired;
    }

    public void setShotsFired(int shotsFired) {
	this.shotsFired = shotsFired;
    }

    public int getHitCount() {
	return hitCount;
    }

    public void setHitCount(int hitCount) {
	this.hitCount = hitCount;
    }

    public int getShipSunk() {
	return shipSunk;
    }

    public void setShipSunk(int shipSunk) {
	this.shipSunk = shipSunk;
    }
    
    public boolean isOccupied(int row, int col) {
	if(grid[row][col].getShipType() == "Empty") {
	    return false;
	} else {
	    return true;
	}
    }

    public boolean shootAt(int row, int col) {
	setShotsFired(getShotsFired() + 1);
	if(isOccupied(row, col) && !grid[row][col].isSunk()){
	    boolean tempSink = grid[row][col].isSunk();
	    if(grid[row][col].getBowRow() == row) {
		grid[row][col].getHit()[col - grid[row][col].getBowColumn()] = true;
	    }
	    else {
		grid[row][col].getHit()[row - grid[row][col].getBowRow()] = true;
	    }
	    if(tempSink != grid[row][col].isSunk()) {
		setShipSunk(getShipSunk()+1);
	    }
	    setHitCount(getHitCount() + 1);
	    return true;
	}else {
	    boolean[] temp = new boolean[1];
	    temp[0] = true;
	    grid[row][col].setHit(temp);
	    return false;
	}
    }
    
    public boolean isGameOver() {
	if(getShipSunk() == 13) {
	    return true;
	}
	return false;
    }
    
    void print() {
	System.out.println("   | 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19");
	for(int i = 0; i < grid.length; i++) {
	    if(i < 10) {
		System.out.print(i + "  |");
	    }
	    else {
		System.out.print(i + " |");
	    }

	    for(int j = 0; j < grid.length; j++) {
		System.out.print(grid[i][j].string(i,j));
	    }
	    System.out.println();
	}
    }
}
