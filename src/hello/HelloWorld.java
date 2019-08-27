package hello;

import java.util.*;

public class HelloWorld {
    public static class WhackAMole {
	int score = 0;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;


	/**
	 * Given a location, place a mole at that location. 
	 * Update number of moles left.
	 * Return whether it is possible to place. 
	 */
	public WhackAMole (int numAttempts, int gridDimension){
	    this.attemptsLeft = 50;
	    this.molesLeft = 0;
	    this.moleGrid = new char[gridDimension][gridDimension];

	    //initialize the 2D array grid with 'O' in all spaces
	    for(int i = 0; i < moleGrid.length; i++) {
		for(int j = 0; j < moleGrid[0].length; j++) {
		    moleGrid[i][j] = 'O';
		}
	    }
	}

	/**
	 * Given a location, place a mole at that location. 
	 * Update number of moles left.
	 * Return whether it is possible to place. 
	 */
	public boolean place(int x, int y) {
	    if(moleGrid[x][y] != 'M') {
		moleGrid[x][y] = 'M';
		molesLeft++;
		return true;
	    }
	    else {
		return false;
	    }
	}

	/**
	 * Given a location, take a whack at that location. 
	 * If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated. 
	 * If that location does not contain a mole, only attemptsLeft is updated.
	 */
	public void whack(int x, int y) {
	    if(moleGrid[x][y] == 'M') {
		score++;
		molesLeft--;
		attemptsLeft--;
		moleGrid[x][y] = 'W';
	    }
	    else {
		attemptsLeft--;
		moleGrid[x][y] = 'X';
	    }
	}

	/**
	 * Print the grid without showing where the moles are. 
	 * For every spot that has recorded a “whacked mole” print out a 'W', 
	 * or 'X' otherwise.
	 */
	public void printGridToUser() {
	    for(int i = 0; i < moleGrid.length; i++) {
		for(int j = 0; j < moleGrid[0].length; j++) {
		    if(moleGrid[i][j] == 'M') {
			System.out.print('O');
		    }
		    else {
			System.out.print(moleGrid[i][j]);
		    }
		}
		System.out.println();
	    }
	}

	/**
	 * Print the grid completely. 
	 * This is effectively dumping the 2d array on the screen. 
	 * The places where the moles are should be printed as an ‘M’. 
	 * The places where the moles have been whacked should be printed as a ‘W’. 
	 * The places that don’t have a mole should be printed as 'O'.
	 */
	public void printGrid() {
	    for(int i = 0; i < moleGrid.length; i++) {
		for(int j = 0; j < moleGrid[0].length; j++) {
		    System.out.print(moleGrid[i][j]);
		}
		System.out.println();
	    }
	}
    }

    /**
     * Begin by creating a 10 by 10 grid where you randomly place the moles. 
     * Place a total of 10 moles.
     * Now allow the user  to enter the x and y coordinates of where they would like to take a whack. 
     * Tell them they have a maximum of 50 attempts to get all the moles. 
     * At any point in the game, they can input coordinates of -1, -1 in order to indicate that they are giving up. 
     * If the user gives up they get to see the entire grid.  
     * The game ends if the user is able to uncover all the moles or if the user runs out of attempts. 
     */
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	WhackAMole game = new WhackAMole(10, 10);
	Random rand = new Random();

	//populates grid with moles represented by 'X'
	while(game.molesLeft < 10) {
	    int x = rand.nextInt(10);
	    int y = rand.nextInt(10);
	    game.place(x, y);
	}

	while(game.attemptsLeft > -1) {
	    game.printGridToUser();	    
	    System.out.println("Attempts left:" + game.attemptsLeft);
	    System.out.println("Moles left:" + game.molesLeft);

	    if(game.molesLeft == 0) {
		System.out.println("You won the game!");
		break;
	    }
	    if(game.attemptsLeft == 0) {
		System.out.println("You lost the game!");
		break;
	    }	    

	    System.out.print("Enter a x-coordinate between 1~10: ");
	    int xCoordinate = scanner.nextInt();
	    System.out.print("Enter a y-coordinate between 1~10: ");
	    int yCoordinate = scanner.nextInt();

	    if(xCoordinate == -1 && yCoordinate == -1) {
		game.printGrid();
		break;
	    }

	    game.whack(xCoordinate - 1, yCoordinate - 1);
	}
    }
}