package blinov.chapter1;

import java.io.*;

public class Hello {

	public static void main(String[] args) {
		//Hello.sayHello(); // 1.1
		//Hello.reverseArgsOrder(args);// 1.2
		//Hello.analizeArrayOfNumbers();
		System.out.println((-5) % 3);
	}
	private static void sayHello() {
		try(BufferedReader br = new BufferedReader(new 
				InputStreamReader(System.in))) {
			System.out.print("Enter your name: ");
			String name = br.readLine();
			System.out.println();
			System.out.println("Hello " + name);
		} catch (IOException ex) {
			System.out.println("IOException ocured.");
		}

	}
	private static void reverseArgsOrder(String[] args) {
		for(int i = args.length - 1; i >= 0; i--) {
			System.out.print(args[i] + " ");
		}
		System.out.println();
	}
	private static void analizeArrayOfNumbers() {
		String str = "";
		try(BufferedReader br = new BufferedReader(new 
				InputStreamReader(System.in))) {
			System.out.println("Enter numbers separated with space...");
			str = br.readLine();
		} catch (IOException ex) {
			System.out.println("IOException ocured.");
		}
		String[] subStrings = str.split(" ");
		int[] numbers = new int[subStrings.length];
		for(int i = 0; i < subStrings.length; i++) {
			numbers[i] = new Integer(subStrings[i]);
		}
	
		System.out.print("You entered : ");
		for(int n : numbers) {
			System.out.print(n + " ");
		}
		System.out.println();
		
		//Even numbers
		System.out.println("Even numbers : ");
		for(int n : numbers) {
			if(n % 2 == 0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		//Odd numbers
		System.out.println("Odd numbers : ");
		for(int n : numbers) {
			if(n % 2 != 0) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		//The largest and the smallest numbers
		int largest = 0, smallest = 0;
		largest = smallest = numbers[0];
		for(int n : numbers) {
			if(n > largest) {
				largest = n;
				continue;
			}
			if(n < smallest) {
				smallest = n;
				continue;
			}
		}
		System.out.println("The largets  number is " + largest);
		System.out.println("The smallest  number is " + smallest);
		System.out.println();
		
		//Numbers that divided by 3 or 9 
		System.out.println("Numbers that divided by 3 or 9 :");
		for(int n : numbers) {
			if((n % 9 == 0) || (n % 3 == 0)) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
		
		//Numbers that divided by 5 and 7 
		System.out.println("Numbers that divided by 5 and 7 :");
		for(int n : numbers) {
			if((n % 5 == 0) && (n % 7 == 0)) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}
	
}
