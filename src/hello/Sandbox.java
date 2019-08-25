package hello;

import java.util.*;

public class Sandbox {

    public static void main(String[] args) {
	char[][] moleGrid = new char[10][10];
	for(int i = 0; i < moleGrid.length; i++) {
	    for(int j = 0; j < moleGrid[i].length; j++) {
		moleGrid[i][j] = 'x';
	    }
	}
	
	
	//System.out.println(Arrays.deepToString(moleGrid));
	System.out.println(Arrays.deepToString(moleGrid).replace("], ", "]\n"));
	
	
	
	
	Random rand = new Random();
	//int n = rand.nextInt(10);
	//System.out.println(n);
    }

}
