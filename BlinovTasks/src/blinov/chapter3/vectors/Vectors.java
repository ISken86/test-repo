package blinov.chapter3.vectors;

public abstract class Vectors {

	public static void main(String[] args) {
		final int N = 5;
		final int M = 5;
		Vector[] vectors = new Vector[M];
		for (int i = 0; i < vectors.length; i++) {
			vectors[i] = new Vector(N);
			initRandom(vectors[i]);
		}
		for (int i = 0; i < vectors.length; i++) {
			System.out.println(vectors[i] + " has length = " + vectors[i].calcModule());
		}
		for (int i = 0; i < vectors.length; i++) {
			for (int j = i + 1; j < vectors.length; j++) {
				System.out.println(vectors[i] + " X " + vectors[j] + " = " + doScalarMult(vectors[i], vectors[j]));
				System.out.println("Angle between vectors = " + calcAngle(vectors[i], vectors[j]));
			}
		}
	}

	public static double doScalarMult(Vector a, Vector b) {
		assert (a != null && b != null);
		assert (a.length() == b.length());
		double result = 0;
		for (int i = 0; i < a.length(); i++) {
			result += a.getValue(i) * b.getValue(i);
		}
		return result;
	}

	public static double calcAngle(Vector a, Vector b) {
		assert (a != null && b != null);
		assert (a.length() == b.length());
		double angle = 0.0;
		double cosA = doScalarMult(a, b) / (a.calcModule() * b.calcModule());
		angle = Math.toDegrees(Math.acos(cosA));
		return angle;
	}

	public static void initRandom(Vector v) {
		assert v != null;
		for (int i = 0; i < v.length(); i++) {
			v.setValue(Math.round(Math.random() * 20.0) - 10.0, i);
		}
	}

}
