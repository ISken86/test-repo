package blinov.chapter3.vectors;

import java.lang.reflect.Array;

public class Vector {
	private double[] arr;
	private final int LENGTH;

	public Vector(int n) {
		assert n > 0;
		LENGTH = n;
		arr = new double[LENGTH];
	}

	public double getValue(int index) {
		assert 0 <= index && index < LENGTH;
		return arr[index];
	}

	public void setValue(double value, int index) {
		assert 0 <= index && index < LENGTH;
		arr[index] = value;
	}

	public double[] getSubVector(int start, int end) {
		assert 0 <= start && start < LENGTH;
		assert 0 <= end && end < LENGTH;
		assert end > start;
		double[] tmp = new double[end - start];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[i + start];
		}
		return tmp;
	}

	public void setSubVector(int start, double[] vector) {
		assert 0 <= start && start < LENGTH;
		assert (start + vector.length) <= LENGTH;
		for (int i = start; i < (start + vector.length); i++) {
			arr[i] = vector[i - start];
		}
	}

	public int length() {
		return LENGTH;
	}

	public void multiply(int multiplier) {
		for (int i = 0; i < LENGTH; i++) {
			arr[i] *= multiplier;
		}
	}

	public boolean addVector(Vector v) {
		if (v.length() != LENGTH) {
			return false;
		}
		for (int i = 0; i < LENGTH; i++) {
			arr[i] += v.getValue(i);
		}
		return true;
	}

	public boolean deductVector(Vector v) {
		if (v.length() != LENGTH) {
			return false;
		}
		for (int i = 0; i < LENGTH; i++) {
			arr[i] -= v.getValue(i);
		}
		return true;
	}

	public void increment() {
		for (int i = 0; i < LENGTH; i++) {
			arr[i]++;
		}
	}

	public void decrement() {
		for (int i = 0; i < LENGTH; i++) {
			arr[i]--;
		}
	}

	public double calcModule() {
		double module = 0;
		for (int i = 0; i < LENGTH; i++) {
			module += arr[i] * arr[i];

		}

		return Math.pow(module, 0.5);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		for (int i = 0; i < LENGTH; i++) {
			sb.append(" " + arr[i] + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(')');
		return sb.toString();
	}
}
