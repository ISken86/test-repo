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

	public static int doScalarMult(Vector a, Vector b) {
		if (a == null || b == null || (a.getSize() != b.getSize())) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		for (int i = 0; i < a.getSize(); i++) {
			result += a.getValue(i) * b.getValue(i);
		}
		return result;
	}

	public static int calcAngle(Vector a, Vector b) {
		if (a == null || b == null || (a.getSize() != b.getSize())) {
			throw new IllegalArgumentException();
		}
		int angle = 0;
		double cosA = (double)doScalarMult(a, b) / (a.calcModule() * b.calcModule());
		System.out.println("CosA = " + cosA);
		angle = (int) Math.toDegrees(Math.acos(cosA));
		return angle;
	}

	public static void initRandom(Vector v) {
		if (v == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < v.getSize(); i++) {
			v.setValue(i, (int) Math.round(Math.random() * 20.0) - 10);
		}
	}

}
