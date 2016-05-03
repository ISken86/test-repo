package blinov.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Task {
	private static BufferedReader br;
	private static int matrix[][];
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		//showLongestShortestString();
		//printMonth();
		initMatrix();
		printMatrix();
		shiftMatrix();
		printMatrix();
	}
	// Task A.1 The longest and shortest Strings
 	private static void showLongestShortestString() throws IOException{
		System.out.println("Enter strings (to finish - empty string)...\n");
		String longestStr, shortestStr, tmpStr;
		System.out.print("> ");
		longestStr = shortestStr = tmpStr = br.readLine();
		System.out.println();
		do {
			System.out.print("> ");
			tmpStr = br.readLine();
			System.out.println();
			if(tmpStr.length() == 0) {
				break;
			}
			if(tmpStr.length() < shortestStr.length()) {
				shortestStr = tmpStr;
				continue;
			}
			if(tmpStr.length() > longestStr.length()) {
				longestStr = tmpStr;
				continue;
			}
			
		}while(true);
		System.out.printf("The longest string has %d symbols : %n%s%n", longestStr.length(), longestStr);
		System.out.printf("The shortest string has %d symbols : %n%s%n", shortestStr.length(), shortestStr);
	}

	// Task A.14 Print a month
 	private static void printMonth() throws IOException{
 		System.out.println("Enter a number of month (1 - 12, 0 - exit )...\n");
 		int month = 1;
 		EXIT: do {
 			System.out.print("> ");
 			try {
 				month = Integer.parseInt(br.readLine());
 			} catch (NumberFormatException ex) {
 				System.out.println("Wrong format! Try again");
 				continue;
 			}
 			switch(month) {
	 			case 0:
	 				break EXIT;
	 			case 1:
	 				System.out.println("1 - January");
	 				break;
	 			case 2:
	 				System.out.println("2 - February");
	 				break;
	 			case 3:
	 				System.out.println("3 - March");
	 				break;
	 			case 4:
	 				System.out.println("4 - April");
	 				break;
	 			case 5:
	 				System.out.println("5 - May");
	 				break;
	 			case 6:
	 				System.out.println("6 - June");
	 				break;
	 			case 7:
	 				System.out.println("7 - July");
	 				break;
	 			case 8:
	 				System.out.println("8 - August");
	 				break;
	 			case 9:
	 				System.out.println("9 - September");
	 				break;
	 			case 10:
	 				System.out.println("10 - October");
	 				break;
	 			case 11:
	 				System.out.println("11 - November");
	 				break;
	 			case 12:
	 				System.out.println("12 - December");
	 				break;
	 			default:
	 				System.out.println("Wrong number (1 - 12, 0 - exit)");
 			}
 		} while(true);
 	}

 	// Task B.2 Shift elements in matrix in various directions
 	private static void shiftMatrix() throws IOException{
 		if(matrix == null) {
 			System.out.println("Matrix is empty");
 			return;
 		}
 		int k = 0;
 		int dir = 0;
 		System.out.println("Enter k - number of shifts(0 - exit)...\n");
 		do {
			System.out.print("> ");
			try {
				k = Integer.parseInt(br.readLine());
			} catch (NumberFormatException ex) {
				System.out.println("Wrong format! Try again.");
				continue;
			}
			if(k == 0) {
				System.exit(0);
			}
			if(k < 0) {
				System.out.println("k must be greater than 0(k > 0)!");
				continue;
			} else {
				break;
			}
 		} while(true);
 		System.out.println("Enter direction (1 - up, 2 - right, 3 - down, 4 - left, 0 - exit)...\n");
 		do {
 			System.out.print("> ");
			try {
				dir = Integer.parseInt(br.readLine());
			} catch (NumberFormatException ex) {
				System.out.println("Wrong format! Try again.");
				continue;
			}
			if(dir == 0) {
				System.exit(0);
			}
			if(dir < 1 || dir > 4) {
				System.out.println("Direction must be 1 - 4!");
				continue;
			} else {
				break;
			}
 		} while(true);
 		int tmp = 0;
 		switch(dir) {
			case 1:
			case 3:
				k %= matrix.length;
				break;
			case 2:
			case 4:
				k %= matrix[0].length;
				break;
		}
 		for(int i = 0; i < matrix.length; i++) {
 			int curPos = 0;
 			for(int j = 0; j < matrix.length; j++) {
 				int newPos = curPos;
 				switch(k) {
	 				case 1:
	 					newPos = matrix.length + curPos - k;
	 					tmp = matrix[newPos][i];
	 					matrix[newPos][i] = matrix[curPos][i];
	 					curPos = newPos;
	 					break;
	 				case 2:
	 					newPos = curPos + k;
	 					tmp = matrix[i][newPos];
	 					matrix[i][newPos] = matrix[i][curPos];
	 					curPos = newPos;
	 					break;
	 				case 3:
	 					newPos = curPos + k;
	 					tmp = matrix[newPos][i];
	 					matrix[newPos][i] = matrix[curPos][i];
	 					curPos = newPos;
	 					break;
	 				case 4:
	 					newPos = matrix.length + curPos - k;
	 					tmp = matrix[i][newPos];
	 					matrix[i][newPos] = matrix[i][curPos];
	 					curPos = newPos;
	 					break;
 				}
 			}
 		}
 	}
 	
 	// Create and initialize Matrix[N][N] with numbers [-n; n]
 	private static void initMatrix() throws IOException{
 		int n = 2;
 		System.out.println("Enter n - size of matrix(n > 1, 0 - exit)...\n");
 		do {
			System.out.print("> ");
			try {
				n = Integer.parseInt(br.readLine());
			} catch (NumberFormatException ex) {
				System.out.println("Wrong format! Try again.");
				continue;
			}
			if(n == 0) {
				System.exit(0);
			}
			if(n <= 1) {
				System.out.println("N must be greater than 1 (n > 1)...\n");
				continue;
			} else {
				matrix = new int[n][n];
				Random rnd = new Random(System.currentTimeMillis());
				for(int i = 0; i < matrix.length; i++) {
					for(int j = 0; j < matrix[i].length; j++) {
						matrix[i][j] = rnd.nextInt(2 * n + 1) - n;
					}
				}
				System.out.println();
				break;
			}
 		} while(true);
 	}
 	
 	// Print matrix
 	private static void printMatrix() {
		if(matrix == null) {
			System.out.println("Matrix is empty");
			return;
		}
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
