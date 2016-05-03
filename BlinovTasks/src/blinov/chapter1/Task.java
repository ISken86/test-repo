package blinov.chapter1;

import java.util.Calendar;

public class Task {
	private static String author = "Skrynnyk";
	private static String dateOfReceive = "26.04.2016 21:30";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar curDate = Calendar.getInstance();
		System.out.printf("Author : %1$s \n"
				+ "Receiving date : %2$s \n"
				+ "Finishing date : %3$te.%3$tm.%3$tY %3$tH:%3$tM \n", 
				Task.author, Task.dateOfReceive, curDate);
		//System.out.println("Receiving date : " + Task.dateOfReceive);
		//System.out.println("Finishing date : " + curDate.getTime());
	}

}
