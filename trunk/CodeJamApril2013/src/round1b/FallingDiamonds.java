package round1b;

public class FallingDiamonds {

	private int N;
	private int X;
	private int Y;

	public FallingDiamonds(int pN, int pX, int pY) {
		N = pN;
		X = pX;
		Y = pY;
	}

	public double calc() {

		double b = X + Y;

		double A1 = ((b * (b + 1)) / 2) + Y;
		double A2 = ((b * (b - 1)) / 2) + Y;

		if (N > A1)
			return 1;

		else if (N < A2)
			return 0;

		double a = N - (b * (b - 1)) / 2;
		double twoPowerA = Math.pow(2, a);

		double Z = 0.0;

		for (int i = 0; i <= Y + 1; i++)
			Z += azeret(a) / (azeret(i) * azeret(a - i));

		return (twoPowerA - Z) / twoPowerA;
	}

	private double azeret(double n) {
		return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
	}

	@Override
	public String toString() {
		return "{N=" + N + ", X=" + X + ", Y=" + Y + "}";
	}

	public double calc2() {

		double b = X + Y;

		double A1 = ((b * (b + 1)) / 2) + Y;
		double A2 = ((b * (b - 1)) / 2) + Y;

		if (N > A1)
			return 1;

		else if (N < A2)
			return 0;

		return calc3(N, 0, 0, 0);
	}

	public double calc3(int n, int centerHeight, int leftHeight, int rightHeight) {

		if (0 == n)
			return 1;

		if (leftHeight > centerHeight && rightHeight > centerHeight)
			return calc3(n - 1, centerHeight + 1, leftHeight, rightHeight);

		else if (leftHeight > centerHeight)
			return calc3(n - 1, centerHeight, leftHeight, rightHeight + 1);

		else if (rightHeight > centerHeight)
			return calc3(n - 1, centerHeight, leftHeight + 1, rightHeight);

		else
			return calc3(n - 1, centerHeight, leftHeight + 1,
					rightHeight + 1);
	}
}
