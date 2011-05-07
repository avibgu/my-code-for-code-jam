package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import qualificationRound.BotTrust;
import qualificationRound.Magicka;

import exception.GiveUpException;

public class Main {

	/**
	 * 
	 * @param args
	 */
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
		catch (GiveUpException e) { System.err.println("exiting.."); }
		catch (IOException e) { System.err.println("error while reading.."); }
		
//---------------| Place Code Here |-------------------------		

//		output = Practice( inputVector );
		
//		output = QualificationRound_A( inputVector );
		output = QualificationRound_B( inputVector );
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
		catch (GiveUpException e) { System.err.println("error while writing.."); }
	}
	
	/**
	 * 
	 * @param inputVector
	 * @return
	 */
	private static String Practice(Vector<String> inputVector) {
		
		return "";
	}
	
	/**
	 * 
	 * @param inputVector
	 * @return
	 */
	private static String QualificationRound_A(Vector<String> inputVector) {
		
		String output = "";
		
		int T = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= T; i++){
			
			String[] sLine = inputVector.get(i).split(" ");
			
			int N = Integer.parseInt( sLine[0] );

			int seconds = BotTrust.calcSeconds(N, sLine);
			
			output = output + "Case #" + i + ": " + seconds + "\n";
		}
		
		return output;
	}
	
	/**
	 * 
	 * @param inputVector
	 * @return
	 */
	private static String QualificationRound_B(Vector<String> inputVector) {
		
		String output = "";
		
		int T = Integer.valueOf( inputVector.get(0) );
		
		for (int i=1; i <= T; i++){
			
			String[] sLine = inputVector.get(i).split(" ");
			
			int C = Integer.parseInt( sLine[0] );
			
			String[] Cs = new String[C];
			
			for (int j=0; j < C; j++)
				Cs[j] = sLine[j+1];
			
			int D = Integer.parseInt( sLine[C+1] );

			String[] Ds = new String[D];
			
			for (int j=0; j < D; j++)
				Ds[j] = sLine[j+C+2];
			
			int N = Integer.parseInt( sLine[C+D+2] );
			
			String series = sLine[sLine.length-1];
			
			String[] ans = Magicka.calc();
			
			String out = "[";
			
			for (String s: ans)
				out += s + ", ";
			
			out = out.substring(0, out.length()-3) + "]";
			
			output = output + "Case #" + i + ": " + out + "\n";
		}
		
		return output;
	}
}
