package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import qualificationRound.Dancing;
import qualificationRound.Googlerese;
import qualificationRound.Recycled;
import round1b.Safety;
import round1b.Tide;

import exception.GiveUpException;

public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String inputFilename = "B-large-practice.in";
		String outputFilename = "B-large-practice.out";

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

		// output = QualificationRound_A(inputVector);
		// output = QualificationRound_B(inputVector);
		// output = QualificationRound_C(inputVector);

		// output = Round1B_A(inputVector);
		output = Round1B_B(inputVector);

		// -----------------| End of Code |---------------------------

		try {

			filesHandler.writeToFile(outputFilename, output);
			System.out.println("\n----------------------------------\n");
			System.out.println(output);
		} catch (GiveUpException e) {
			System.err.println("error while writing..");
		}
	}

	private static String QualificationRound_A(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String result = Googlerese.translate(pInputVector.get(i));

			output = output + "Case #" + i + ": " + result + "\n";
		}

		return output;
	}

	private static String QualificationRound_B(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String line[] = pInputVector.get(i).split(" ");

			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int P = Integer.parseInt(line[2]);

			int[] Ti = new int[N];

			for (int j = 0; j < N; j++)
				Ti[j] = Integer.parseInt(line[j + 3]);

			int result = Dancing.howMany(N, S, P, Ti);

			output = output + "Case #" + i + ": " + result + "\n";
		}

		return output;
	}

	private static String QualificationRound_C(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String line[] = pInputVector.get(i).split(" ");

			int A = Integer.parseInt(line[0]);
			int B = Integer.parseInt(line[1]);

			int result = Recycled.howMany(A, B);

			output = output + "Case #" + i + ": " + result + "\n";
		}

		return output;
	}

	private static String Round1B_A(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String line[] = pInputVector.get(i).split(" ");

			int N = Integer.parseInt(line[0]);

			int[] Ti = new int[N];

			for (int j = 0; j < N; j++)
				Ti[j] = Integer.parseInt(line[j + 1]);

			double[] result = Safety.calc(Ti);

			output = output + "Case #" + i + ": ";

			for (int j = 0; j < N; j++)
				output = output + result[j] + " ";

			output = output.substring(0, output.length() - 2);

			output = output + "\n";
		}

		return output;
	}

	private static String Round1B_B(Vector<String> pInputVector) {
        
		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		int num = 1;

		for (int i = 1; num <= T; i++) {

			String[] line = pInputVector.get(i).split(" ");

			int H = Integer.parseInt(line[0]);
			int N = Integer.parseInt(line[1]);
			int M = Integer.parseInt(line[2]);

			int[][] ceil = new int[N][M];
			int[][] floor = new int[N][M];

			for (int j = 0; j < N; j++) {

				line = pInputVector.get(i + j + 1).split(" ");

				for (int k = 0; k < M; k++)
					ceil[j][k] = Integer.parseInt(line[k]);
			}

			for (int j = 0; j < N; j++) {

				line = pInputVector.get(i + j + N + 1).split(" ");

				for (int k = 0; k < M; k++)
					floor[j][k] = Integer.parseInt(line[k]);
			}

			double result = Tide.calc(H, N, M, ceil, floor);

			output = output + "Case #" + num++ + ": " + format(result, 6) + "\n";
			
			i += 2 * N;
		}

		return output;
	}

	private static double format(double num, int n) {
		
		for (int i = 0; i < n; i++)
			num *= 10;
		
		int x = (int)num;
		
		num = x;
		
		for (int i = 0; i < n; i++)
			num /= 10;
		
		return num;
	}
}
