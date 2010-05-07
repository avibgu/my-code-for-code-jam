package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import exception.GiveUpException;

public class Main {

	public static void main(String[] args){

		String inputFilename = "A-small.in";
		String outputFilename = "A-small.out";
		
		String output = "";
		
		FileHandling filesHandler = new FileHandling();
		
		FileReader file = null;
		
		Vector<String> inputVector = null;
		
		try {
			
			file = filesHandler.openFileForReading( inputFilename );
			inputVector = filesHandler.readLinesFromFile( file );
		}
		catch (GiveUpException e) { System.out.println("exiting.."); }
		catch (IOException e) { System.out.println("error while reading.."); }
		
//---------------| Place Code Here |-------------------------		

		output = QualificationRound_A( inputVector );
//		output = QualificationRound_B( inputVector );
//		output = QualificationRound_C( inputVector );
		
//-----------------| End of Code |---------------------------		
		
		try {
			
			filesHandler.writeToFile(outputFilename, output);
			System.out.println("\n----------------------------------\n");
			System.out.println( output );
		}
		catch (GiveUpException e) { System.out.println("error while writing.."); }
	}
	

	private static String QualificationRound_A( Vector<String> inputVector ) {

		return "";
	}
	
	
	private static String QualificationRound_B( Vector<String> inputVector ) {

		return "";
	}
	
	
	private static String QualificationRound_C( Vector<String> inputVector ) {

		return "";
	}

}
