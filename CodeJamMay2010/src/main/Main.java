package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
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
//		output = QualificationRound_B( inputVector );
//		output = QualificationRound_C( inputVector );
		
		output = Round1_A( inputVector );
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
	

	private static String Round1_A(Vector<String> inputVector) {

		String output = "";
		
		int T = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= T; i++){

			output = output + "Case #" + i + ": OFF\n";
		}
		
		return output;
	}
	

	private static String Round1_B(Vector<String> inputVector) {
		// TODO Auto-generated method stub
		return null;
	}


	private static String Round1_C(Vector<String> inputVector) {
		// TODO Auto-generated method stub
		return null;
	}


	private static String QualificationRound_A( Vector<String> inputVector ) {

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
	
	
	private static String QualificationRound_B( Vector<String> inputVector ) {

		String output = "";
		
		int C = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= C; i++){
			
			String[] splitted = inputVector.get(i).split(" ");
			
			int N = Integer.valueOf( splitted[0] );
			
			Num originalMin = new Num( splitted[1] );
			
			for (int j=2; j <= N; j++){
				
				Num temp = new Num( splitted[j] );
				
				if ( originalMin.biggerThan( temp ) )
					originalMin = temp;
			}
			
			Num hefreshMin = new Num( splitted[1] ).pahot( new Num( splitted[2] ) );
			
			for (int j=1; j <= N-1; j++){
				
				for (int k=j+1; k <= N; k++){
					
					Num x = new Num( splitted[j] );
					Num y = new Num( splitted[k] );
					
					Num temp = x.pahot( y );
					
					if ( hefreshMin.biggerThan(temp) )
						hefreshMin = temp;
				}
			}
			
			Num x = hefreshMin;
			
			while ( originalMin.biggerThan( hefreshMin ) ){
				
				hefreshMin.plus( x );
			}
			
			output += "Case #" + i + ": " + ( hefreshMin.pahot( originalMin ) )+ "\n";
		}
		
		return output;
	}
	
	
	private static String QualificationRound_C( Vector<String> inputVector ) {

		String output = "";
		
		int T = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= T*2; i=i+2){
			
			String[] RkN = inputVector.get(i).split(" ");

			int R = Integer.valueOf( RkN[0] );
			int k = Integer.valueOf( RkN[1] );
			int N = Integer.valueOf( RkN[2] );
			
			String[] G = inputVector.get( i+1 ).split(" ");
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			LinkedList<Integer> tempQueue = new LinkedList<Integer>();
			
			for(int j=0; j < N; j++) queue.add( Integer.valueOf( G[j] ) );
			
			int EURO = 0;
			
			for(int r=1; r <= R; r++){
				
				int howManyOnBorad = 0;
				
				while( !queue.isEmpty() && (howManyOnBorad < k) ){
					
					if( howManyOnBorad + queue.peek() > k ) break;
					
					else{
						
						howManyOnBorad += queue.peek();
						tempQueue.add( queue.remove() );
					}
				}
				
				while( !tempQueue.isEmpty() ) queue.add( tempQueue.remove() );
				
				EURO += howManyOnBorad;
			}
			
			output += "Case #" + ((int)i/2+1) + ": " + EURO + "\n";
		}
		
		return output;
	}

}
