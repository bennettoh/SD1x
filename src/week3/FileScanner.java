package week3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileScanner {
    
    public static void main(String[] args) {
	
	//BufferedReader
	try(BufferedReader in = new BufferedReader(new FileReader("movies.txt"))) {
	    String str;
	    while ((str = in.readLine()) != null) {
	        System.out.println(str);
	    }
	}
	catch (IOException e) {
	    System.out.println("File Read Error");
	}
	
	//Scanner
	try(Scanner sc = new Scanner(new File("movies.txt"))) {
	    while (sc.hasNextLine()) {
		System.out.println(sc.nextLine());
	    }
	}
	catch (IOException e) {
	    System.out.println("File Read Error");
	}
	
    }

}
