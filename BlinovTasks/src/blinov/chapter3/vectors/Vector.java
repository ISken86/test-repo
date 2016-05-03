package blinov.chapter3.vectors;

public class Vector {
	private int[] arr;
	private final int LENGTH;
	public Vector(int n) {
		assert n > 0;
		LENGTH = n;
		arr = new int[LENGTH];
	}

	public int getValue(int index) {
		assert 0 <= index && index < LENGTH;
		return arr[index];
	}

	public void setValue(int value, int index) {
		assert 0 <= index && index < arr.length;
		arr[index] = value;
	}

	public int[] getSubVector(int start, int end) {
		assert 0 <= start && start < arr.length;
		assert 0 <= end && end < arr.length;
		assert end > start;
		int[] tmp = new int[end - start];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[i + start];
		}
		return tmp;
	}

	public void setSubVector(int start, int[] vector) {
		assert 0 <= start && start < arr.length;
		assert (start + vector.length) <= arr.length;
		for (int i = start; i < (start + vector.length); i++) {
			arr[i] = vector[i - start];
		}
	}

	public int getSize() {
		return arr.length;
	}

	public void multiply(int multiplier) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] *= multiplier;
		}
	}

	public boolean addVector(Vector v) {
		if (v.getSize() != arr.length) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] += v.getValue(i);
		}
		return true;
	}

	public boolean deductVector(Vector v) {
		if (v.getSize() != arr.length) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] -= v.getValue(i);
		}
		return true;
	}

	public void increment() {
		for (int i = 0; i < arr.length; i++) {
			arr[i]++;
		}
	}

	public void decrement() {
		for (int i = 0; i < arr.length; i++) {
			arr[i]--;
		}
	}

	public int calcModule() {
		int module = 0;
		for (int i = 0; i < arr.length; i++) {
			module += arr[i] * arr[i];

		}

		return (int) Math.pow((double) module, 0.5);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		for (int i = 0; i < arr.length; i++) {
			sb.append(" " + arr[i] + ",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(')');
		return sb.toString();
	}
}
