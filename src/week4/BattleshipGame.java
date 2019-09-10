package week4;

import java.util.Scanner;
import java.util.Random;

public class BattleshipGame {

    public static void main(String[] args) {
	Ocean playingField = new Ocean();
	Random rand = new Random();
	
	Ship[] ships = new Ship[13];
	for (int i = 0; i < 13; i++) {
		if (i == 0) {
			ships[i] = new Battleship();
		} else if (i == 1) {
			ships[i] = new Battlecruiser();
		} else if (i < 4) {
			ships[i] = new Cruiser();
		} else if (i < 6) {
			ships[i] = new LightCruiser();
		} else if (i < 9) {
			ships[i] = new Destroyer();
		} else if (i < 13) {
			ships[i] = new Submarine();
		}
	}
	

	//Place all ships randomly
	for(Ship ship : ships) {
	    while(true) {
		int bowRow = rand.nextInt(20);
		int bowColumn = rand.nextInt(20);
		boolean horizontal = rand.nextBoolean();
		if(ship.okToPlaceShip(bowRow, bowColumn, horizontal, playingField)) {
		    ship.placeShipAt(bowRow, bowColumn, horizontal, playingField);
		    break;
		}
		
	    }
	    
	}
	
	while(!playingField.isGameOver()) {
	playingField.print();
	System.out.println("Shots fired: " + playingField.getShotsFired());
	System.out.println("Hit count: " + playingField.getHitCount());
	System.out.print("Enter coordinates (format as y,x): ");
	Scanner sc = new Scanner(System.in);
	String token[] = sc.next().split(",");
	int inputRow = Integer.parseInt(token[0]);
	int inputCol = Integer.parseInt(token[1]);
	playingField.shootAt(inputRow, inputCol);
	}
    }
}