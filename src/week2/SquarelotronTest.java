package week2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquarelotronTest {
    Squarelotron squarelotron2x2 = new Squarelotron(2);
    Squarelotron squarelotron3x3 = new Squarelotron(3);
    Squarelotron squarelotron5x5 = new Squarelotron(5);
    Squarelotron testSquare = new Squarelotron(0);

    @BeforeEach
    void setUp() throws Exception {
    }

    //Initialization test for 2x2 squarelotron
    @Test
    void testSquarelotron2x2() {
	assertEquals(1, squarelotron2x2.grid[0][0]);
	assertEquals(2, squarelotron2x2.grid[0][1]);
	assertEquals(3, squarelotron2x2.grid[1][0]);
	assertEquals(4, squarelotron2x2.grid[1][1]);
    }

    //Initialization test for 3x3 squarelotron
    @Test
    void testSquarelotron3x3() {
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 3; j++) {
		assertEquals((i * 3) + j + 1, squarelotron3x3.grid[i][j]);
	    }
	}
    }

    //Initialization test for 5x5 squarelotron
    @Test
    void testSquarelotron5x5() {
	for (int i = 0; i < 5; i++) {
	    for (int j = 0; j < 5; j++) {
		assertEquals((i * 5) + j + 1, squarelotron5x5.grid[i][j]);
	    }
	}
    }

    //Testing various transformations on squarelotron instances with a 2x2 grid layout
    @Test
    void testUpsideDownFlip2x2() {
	testSquare = squarelotron2x2.upsideDownFlip(1); 
	assertEquals(3, testSquare.grid[0][0]);
	assertEquals(1, testSquare.grid[1][0]);
    }

    @Test
    void testMainDiagonalFlip2x2() {
	testSquare = squarelotron2x2.mainDiagonalFlip(1);
	assertEquals(3, testSquare.grid[0][1]);
    }

    @Test
    void testRotateRight2x2() {
	squarelotron2x2.rotateRight(1);
	assertEquals(1, squarelotron2x2.grid[0][1]);
    }
    
    
  //Testing various transformations on squarelotron instances with a 3x3 grid layout
    @Test
    void testUpsideDownFlip3x3() {
	testSquare = squarelotron3x3.upsideDownFlip(1);
	assertEquals(7, testSquare.grid[0][0]);
	assertEquals(1, testSquare.grid[2][0]);
    }

    @Test
    void testMainDiagonalFlip3x3() {
	testSquare = squarelotron3x3.mainDiagonalFlip(1);
	assertEquals(7, testSquare.grid[0][2]);
    }

    @Test
    void testRotateRight3x3() {
	squarelotron3x3.rotateRight(1);
	assertEquals(1, squarelotron3x3.grid[0][2]);
    }
    
  //Testing various transformations on squarelotron instances with a 5x5 grid layout
    @Test
    void testUpsideDownFlip5x5() {
	testSquare = squarelotron5x5.upsideDownFlip(1);
	assertEquals(21, testSquare.grid[0][0]);
	assertEquals(1, testSquare.grid[4][0]);
    }

    @Test
    void testMainDiagonalFlip5x5() {
	testSquare = squarelotron5x5.mainDiagonalFlip(1);
	assertEquals(21, testSquare.grid[0][4]);
	testSquare = squarelotron5x5.mainDiagonalFlip(2);
	assertEquals(17, testSquare.grid[1][3]);
    }

    @Test
    void testRotateRight5x5() {
	squarelotron5x5.rotateRight(1);
	assertEquals(1, squarelotron5x5.grid[0][4]);
    }
}
