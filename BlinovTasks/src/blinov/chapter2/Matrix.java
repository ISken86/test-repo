package blinov.chapter2;

import java.util.Random;

public class Matrix {
	private int[][] arr;
	private int width;
	private int height;

	private Matrix(int width, int height) {
		this.width = width;
		this.height = height;
		this.arr = new int[height][width];
	}

	public static Matrix getInstance(int width, int height) {
		if (width < 2 || height < 2) {
			throw new IllegalArgumentException("Arguments must be greater than 1");
			// return null;
		}
		return new Matrix(width, height);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean setValue(int w, int h, int value) {
		if (w >= width || w < 0 || h >= height || h < 0) {
			return false;
		}
		arr[h][w] = value;
		return true;
	}

	public int getValue(int w, int h) {
		if (w >= width || w < 0 || h >= height || h < 0) {
			throw new IllegalArgumentException("Out of bounds index(es)");
		}
		return arr[h][w];
	}

	public int[][] getArray() {
		return arr;
	}

	public void initRandom() {
		int n = (width > height) ? width : height;
		Random rnd = new Random(System.currentTimeMillis());
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				arr[i][j] = rnd.nextInt(2 * n + 1) - n;
			}
		}
	}

	public void shiftElemnts(int dir, int k) {
		if (dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Illegal argument dir (4 < dir < 1)");
		}
		if (k < 0) {
			throw new IllegalArgumentException("Illegal argument k (k < 0) ");
		}
		int tmp = 0;
		int border1, border2;
		border1 = border2 = 0;
		switch (dir) {
		case 1: // Up shift
			k %= height;
			k = height - k;
			border1 = width;
			border2 = height;
			break;
		case 2: // Right shift
			k %= width;
			border1 = height;
			border2 = width;
			break;
		case 3: // Down shift
			k %= height;
			border1 = width;
			border2 = height;
			break;
		case 4: // Left shift
			k %= width;
			k = width - k;
			border1 = height;
			border2 = width;
			break;
		}
		for (int i = 0; i < border1; i++) {
			for (int l = 0; l < k; l++) {
				switch (dir) {
				case 1: // Up shift
				case 3: // Right shift
					tmp = arr[border2 - 1][i];
					break;
				case 2: // Down shift
				case 4: // Left shift
					tmp = arr[i][border2 - 1];
					break;
				}
				for (int j = border2 - 1; j > 0; j--) {
					switch (dir) {
					case 1: // Up shift
					case 3: // Right shift
						arr[j][i] = arr[j - 1][i];
						break;
					case 2: // Down shift
					case 4: // Left shift
						arr[i][j] = arr[i][j - 1];
						break;
					}
				}
				switch (dir) {
				case 1: // Up shift
				case 3: // Right shift
					arr[0][i] = tmp;
					break;
				case 2: // Down shift
				case 4: // Left shift
					arr[i][0] = tmp;
					break;
				}
			}
		}

	}

	public boolean sortLines(int line, int index) {
		if (line < 0 || line > 2) {
			return false;
		}
		int size = 0;
		switch (line) {
		case 1: // Sort rows
			if (index < 0 || index >= width) {
				return false;
			}
			size = height;
			break;
		case 2: // Sort columns
			if (index < 0 || index >= height) {
				return false;
			}
			size = width;
			break;
		}
		boolean isSorted = true;
		int tmp = 0;
		do {
			isSorted = true;
			for (int i = 0; i < size - 1; i++) {
				switch (line) {
				case 1: // Sort rows
					if (arr[i][index] > arr[i + 1][index]) {
						for (int j = 0; j < width; j++) {
							tmp = arr[i][j];
							arr[i][j] = arr[i + 1][j];
							arr[i + 1][j] = tmp;
						}
						isSorted = false;
					}
					break;
				case 2: // Sort columns
					if (arr[index][i] > arr[index][i + 1]) {
						for (int j = 0; j < height; j++) {
							tmp = arr[j][i];
							arr[j][i] = arr[j][i + 1];
							arr[j][i + 1] = tmp;
						}
						isSorted = false;
					}
					break;
				}
			}
		} while (!isSorted);
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int n = (width > height) ? width : height;
		n = Integer.toString(n).length() + 2;
		for (int i = 0; i < height; i++) {
			sb.append('|');
			for (int j = 0; j < width; j++) {
				sb.append(String.format("%1$" + n + "d", arr[i][j]));
			}
			sb.append('|');
			sb.append(String.format("%n"));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Matrix m = Matrix.getInstance(5, 7);
		m.initRandom();
		System.out.println(m);
		m.sortLines(1, 3); // 1 - rows, 2 - cols
		System.out.println(m);
		m.sortLines(2, 2);
		System.out.println(m);
		m.shiftElemnts(1, 3); System.out.println(m); m.shiftElemnts(2, 9);
		System.out.println(m); m.shiftElemnts(3, 7); System.out.println(m);
		m.shiftElemnts(4, 11); System.out.println(m);
	}
}
