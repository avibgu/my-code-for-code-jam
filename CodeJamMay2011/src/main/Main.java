package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import exception.GiveUpException;

public class Main {

	public static void main(String[] args){

		String inputFilename = "in.txt";
		String outputFilename = "out.txt";
		
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

		output = Practice( inputVector );
		
//		output = QualificationRound_A( inputVector );
//		output = QualificationRound_B( inputVector );
//		output = QualificationRound_C( inputVector );
		
//		output = Round1_A( inputVector );
//		output = Round1_B( inputVector );
//		output = Round1_C( inputVector );

		
//-----------------| End of Code |---------------------------	
		
		try {
			
			filesHandler.writeToFile(outputFilename, output);
			System.out.println("\n----------------------------------\n");
			System.out.println( output );
		}
		catch (GiveUpException e) { System.out.println("error while writing.."); }
	}
	

	private static String Practice(Vector<String> inputVector) {
		
		String output = "";
		
		int T = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= T; i++){
			
			String[] NandK = inputVector.get(i).split(" ");
			
			double N = Double.valueOf( NandK[0] );
			double K = Double.valueOf( NandK[1] );

			double firstOn = Math.pow( 2, N) - 1;
			double nextOn = firstOn + 1;
			
			if (K == firstOn){
				
				output = output + "Case #" + i + ": ON\n";
			}
			else if ( (K > firstOn) && ( (K-firstOn) % nextOn) == 0){
				
				output = output + "Case #" + i + ": ON\n";
			} 
			else{
				
				output = output + "Case #" + i + ": OFF\n";
			}
		}
		
		return output;
	}
}
