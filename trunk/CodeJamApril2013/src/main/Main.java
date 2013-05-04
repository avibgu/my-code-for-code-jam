package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;

import qualificationRound.Chest;
import qualificationRound.FairAndSquare;
import qualificationRound.Lawnmower;
import qualificationRound.TicTacToeTomek;
import qualificationRound.Treasure;
import round1b.FallingDiamonds;
import round1b.GarbledEmail;
import round1b.Osmos;

public class Main {

	public static void main(String[] args) throws IOException {

		String inputFilename = "input.in";
		String outputFilename = "output.out";

		List<String> input = FileUtils.readLines(new File(inputFilename));
		System.out.println(new Date().toString() + ": " + input);

		List<String> output = null;

		output = QualificationRound_A(input);
		output = QualificationRound_B(input);
		output = QualificationRound_C(input);
		output = QualificationRound_D(input);

		output = Round1B_A(input);
		output = Round1B_B(input);
		output = Round1B_C(input);
		System.out.println(new Date().toString() + ": " + output);

		FileUtils.writeLines(new File(outputFilename), output);
	}

	private static List<String> QualificationRound_A(List<String> pInputVector) {

		List<String> result = new ArrayList<String>();

		int T = Integer.valueOf(pInputVector.get(0));
		int row = 1;

		for (int i = 1; i <= T; i++) {

			int[][] board = new int[4][];

			for (int j = 0; j < 4; j++) {

				int[] tmp = new int[4];
				char[] chars = pInputVector.get(row++).toCharArray();

				for (int k = 0; k < 4; k++) {

					if ('X' == chars[k])
						tmp[k] = TicTacToeTomek.X;

					else if ('O' == chars[k])
						tmp[k] = TicTacToeTomek.O;

					else if ('T' == chars[k])
						tmp[k] = TicTacToeTomek.T;

					else
						tmp[k] = TicTacToeTomek.EMPTY;
				}

				board[j] = tmp;
			}

			row++;

			result.add("Case #" + i + ": " + TicTacToeTomek.findWinner(board)
					+ "\n");
		}

		return result;
	}

	private static List<String> QualificationRound_B(List<String> input) {

		List<String> result = new ArrayList<String>();

		int T = Integer.valueOf(input.get(0));

		int row = 1;

		for (int t = 1; t <= T; t++) {

			String[] splitted = input.get(row++).split(" ");

			int n = Integer.valueOf(splitted[0]);
			int m = Integer.valueOf(splitted[1]);

			int[][] lown = new int[n][m];

			for (int i = 0; i < lown.length; i++) {

				splitted = input.get(row++).split(" ");

				for (int j = 0; j < lown[i].length; j++)
					lown[i][j] = Integer.valueOf(splitted[j]);
			}

			result.add("Case #" + t + ": "
					+ Lawnmower.isLegalPattern(n, m, lown) + "\n");
		}

		return result;
	}

	private static List<String> QualificationRound_C(List<String> input) {

		List<String> result = new ArrayList<String>();

		int T = Integer.valueOf(input.get(0));

		for (int i = 1; i <= T; i++) {

			String[] splitted = input.get(i).split(" ");

			result.add("Case #"
					+ i
					+ ": "
					+ FairAndSquare.count(Long.parseLong(splitted[0]),
							Long.parseLong(splitted[1])) + "\n");
		}

		return result;
	}

	private static List<String> QualificationRound_D(List<String> input) {

		List<String> result = new ArrayList<String>();

		int T = Integer.valueOf(input.get(0));

		int row = 1;

		for (int t = 1; t <= T; t++) {

			String[] splitted = input.get(row++).split(" ");

			int k = Integer.valueOf(splitted[0]);
			int n = Integer.valueOf(splitted[1]);

			splitted = input.get(row++).split(" ");

			int[] keys = new int[k];

			for (int i = 0; i < k; i++)
				keys[i] = Integer.valueOf(splitted[i]);

			Chest[] chests = new Chest[n];

			for (int i = 0; i < n; i++) {

				splitted = input.get(row++).split(" ");

				int ti = Integer.valueOf(splitted[0]);
				int ki = Integer.valueOf(splitted[1]);

				int[] ks = new int[ki];

				for (int j = 2; j < splitted.length; j++)
					ks[j - 2] = Integer.valueOf(splitted[j]);

				chests[i] = new Chest(ti, ki, ks);
			}

			result.add("Case #" + t + ": "
					+ Treasure.doSomething(k, keys, n, chests) + "\n");
		}

		return result;
	}

	private static List<String> Round1B_A(List<String> input) {

		List<String> result = new ArrayList<String>();

		int T = Integer.valueOf(input.get(0));

		int line = 1;

		for (int i = 1; i <= T; i++) {

			String[] ANstr = input.get(line++).split(" ");
			String[] Vstr = input.get(line++).split(" ");

			int A = Integer.parseInt(ANstr[0]);
			int N = Integer.parseInt(ANstr[1]);

			int[] V = new int[N];

			for (int j = 0; j < N; j++)
				V[j] = Integer.parseInt(Vstr[j]);

			result.add("Case #" + i + ": " + new Osmos(A, N, V).calc());
		}

		return result;
	}

	private static List<String> Round1B_B(List<String> input) {

		List<String> result = new ArrayList<String>();

		int T = Integer.valueOf(input.get(0));

		int line = 1;

		for (int i = 1; i <= T; i++) {

			String[] NXYstr = input.get(line++).split(" ");

			int N = Integer.parseInt(NXYstr[0]);
			int X = Integer.parseInt(NXYstr[1]);
			int Y = Integer.parseInt(NXYstr[2]);

			result.add("Case #" + i + ": "
					+ new FallingDiamonds(N, X, Y).calc2());
		}

		return result;
	}

	private static List<String> Round1B_C(List<String> input) {

		List<String> result = new ArrayList<String>();

		int T = Integer.valueOf(input.get(0));

		int line = 1;

		for (int i = 1; i <= T; i++) {

			String S = input.get(line++);

			result.add("Case #" + i + ": " + new GarbledEmail(S).calc());
		}

		return result;
	}
}