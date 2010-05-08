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

//		output = QualificationRound_A( inputVector );
		output = QualificationRound_B( inputVector );
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

		String output ="";
		
		int T = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= T; i++){
			
			String[] NandK = inputVector.get(i).split(" ");
			
			int N = Integer.valueOf( NandK[0] );
			int K = Integer.valueOf( NandK[1] );

			int onAt = 2*N - 1;
			
			if (K < onAt){
				
				output = output + "Case #" + i + ": OFF\n";
			}
			
			else if ( ( (K - onAt) % 2) == 0){
				
				output = output + "Case #" + i + ": ON\n";
			}
			else{
				
				output = output + "Case #" + i + ": OFF\n";
			}
		}
		
		return output.substring(0, output.length() - 1);
	}
	
	
	private static String QualificationRound_B( Vector<String> inputVector ) {

		String output ="";
		
		int C = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= C; i++){
			
			String[] splitted = inputVector.get(i).split(" ");
			
			int N = Integer.valueOf( splitted[0] );
			
			long originalMin = Long.valueOf( splitted[1] );
			
			for (int j=2; j <= N; j++){
				
				long temp = Long.valueOf( splitted[j] );
				
				if ( originalMin > temp )
					originalMin = temp;
			}
			
			long hefreshMin = Long.MAX_VALUE;
			
			for (int j=1; j <= N-1; j++){
				
				for (int k=j+1; k <= N; k++){
					
					long x = Long.valueOf( splitted[j] );
					long y = Long.valueOf( splitted[k] );
					
					long temp = Math.abs( x-y );
					
					if ( hefreshMin > temp )
						hefreshMin = temp;
				}
			}
			
			long x = hefreshMin;
			
			while ( hefreshMin < originalMin ){
				
				hefreshMin += x;
			}
			
			output += "Case #" + i + ": " + (hefreshMin-originalMin)+ "\n";
		}
		
		return output;
	}
	
	
	private static String QualificationRound_C( Vector<String> inputVector ) {

		return "";
	}

}
