package week2;

/*
 * A Squarelotron consists basically of a matrix of numbers. 
 * This matrix can be decomposed as square rings which can flip independently in two different ways: 
 * Upside-Down and through the Main Diagonal.
 */
public class Squarelotron {
    int[][] grid;
    int size;

    /*
     * Constructor creates a 2D array with a given number of cells on each side.
     * It then populates the cells in ascending order starting from 1.
     * Sets the size variable to n.
     */
    public Squarelotron(int n) {
	this.size = n;
	int value = 1;
	this.grid = new int[n][n];
	for (int i= 0; i < n; i++) {
	    for (int j = 0; j < n; j++){
		this.grid[i][j] = value;
		value++;
	    }
	}
    }

    /*
     * This method performs the Upside-Down Flip of the squarelotron, as described above, and returns the new squarelotron.
     * The original squarelotron should not be modified (we will check for this).
     */
    public Squarelotron upsideDownFlip(int ring) {
	int offset = ring - 1;
	Squarelotron newSquarelotron = new Squarelotron(size);

	for (int i = offset; i < size; i++) {
	    if (i == offset || i == size - offset - 1) {
		newSquarelotron.grid[i] = this.grid[size - i - 1];
	    }
	    else {
		newSquarelotron.grid[i][offset] = this.grid[size - i - 1][offset];
		newSquarelotron.grid[i][size - 1 - offset] = this.grid[size - i][size - offset -1];
	    }
	}
	return newSquarelotron;
    }

    /*
     * This method performs the Main Diagonal Flip of the squarelotron, as described above, and returns the new squarelotron.
     * The original squarelotron should not be modified (we will check for this).
     */
    public Squarelotron mainDiagonalFlip (int ring) {
	int offset = ring - 1;
	Squarelotron newSquarelotron = new Squarelotron (size);
	
	for (int i = offset; i < size; i++) {
	    for (int j = offset; j < size; j++) {
		if (i == offset || i == size - 1 || j == offset || j == size - 1) {
		    newSquarelotron.grid[i][j] = this.grid[j][i];
		}
	    }
	}
	return newSquarelotron;
    }

    /*
     * The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise. 
     * Any integer, including zero and negative integers, is allowable as the argument. A value of -1 indicates a 90° counterclockwise rotation. 
     * This method modifies the internal representation of the squarelotron; 
     * it does not create a new squarelotron.
     */
    public void rotateRight(int numberOfTurns) {
	numberOfTurns = ((numberOfTurns % 4) + 4) % 4;

	for (int t = 0; t < numberOfTurns; t++) {
	    Squarelotron newSquarelotron = new Squarelotron (size);
	    for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
		    newSquarelotron.grid[i][j] = this.grid[size - 1 - j][i];
		}
	    }
	    System.out.println("Loop: " + (t + 1));
	    newSquarelotron.printGrid();
	    this.grid = newSquarelotron.grid;
	}
	
    }


    public void printGrid() {
	for(int i = 0; i < size; i++) {
	    for(int j = 0; j < grid[0].length; j++) {
		System.out.print(grid[i][j] + ", ");
	    }
	    System.out.println(); 
	}
	System.out.println();
    }



    public static void main(String[] args) {
	int size = 5;
	Squarelotron game = new Squarelotron(size);

	game.printGrid();
	game.rotateRight(3);
    }
}
