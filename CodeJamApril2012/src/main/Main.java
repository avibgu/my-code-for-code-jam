package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import qualificationRound.BotTrust;

import exception.GiveUpException;

public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String inputFilename = "B-small-attempt1.in";
		String outputFilename = "B-small-attempt1.out";

		String output = "";

		FileHandling filesHandler = new FileHandling();

		FileReader file = null;

		Vector<String> inputVector = null;

		try {

			file = filesHandler.openFileForReading(inputFilename);
			inputVector = filesHandler.readLinesFromFile(file);
		} catch (GiveUpException e) {
			System.err.println("exiting..");
		} catch (IOException e) {
			System.err.println("error while reading..");
		}

		// ---------------| Place Code Here |-------------------------

		// output = Practice( inputVector );

		output = QualificationRound_A(inputVector);

		// -----------------| End of Code |---------------------------

		try {

			filesHandler.writeToFile(outputFilename, output);
			System.out.println("\n----------------------------------\n");
			System.out.println(output);
		} catch (GiveUpException e) {
			System.err.println("error while writing..");
		}
	}

	/**
	 * 
	 * @param pInputVector
	 * @return
	 */
	private static String QualificationRound_A(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String[] sLine = pInputVector.get(i).split(" ");

			int N = Integer.parseInt(sLine[0]);

			int seconds = BotTrust.calcSeconds(N, sLine);

			output = output + "Case #" + i + ": " + seconds + "\n";
		}

		return output;
	}
}
