package hello;

import java.util.*;

public class HelloWorld {
    public static class WhackAMole {
	int score = 0;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;
	Random rand = new Random();

	WhackAMole (int numAttempts, int gridDimension){
	    this.attemptsLeft = 50;
	    this.molesLeft = 0;
	    this.moleGrid = new char[gridDimension][gridDimension];

	    //initialize the grid
	    for(int i = 0; i < moleGrid.length; i++) {
		for(int j = 0; j < moleGrid[0].length; j++) {
		    moleGrid[i][j] = 'O';
		}
	    }

	    //place moles
	    while(molesLeft < 10) {
		int x = rand.nextInt(10);
		int y = rand.nextInt(10);
		place(x, y);
	    }
	}

	boolean place(int x, int y) {
	    if(moleGrid[x][y] != 'M') {
		moleGrid[x][y] = 'M';
		molesLeft++;
		return true;
	    }
	    else {
		return false;
	    }
	}

	void whack(int x, int y) {
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

	void printGridToUser() {
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

	void printGrid() {
	    for(int i = 0; i < moleGrid.length; i++) {
		for(int j = 0; j < moleGrid[0].length; j++) {
		    System.out.print(moleGrid[i][j]);
		}
		System.out.println();
	    }
	}
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	WhackAMole game = new WhackAMole(10, 10);

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

	    game.whack(xCoordinate - 1, yCoordinate - 1);
	}
    }
}