package com.greatlearning.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import com.greatlearning.search.LinearSearch;
import com.greatlearning.sort.MergeSortAscending;
import com.greatlearning.sort.MergeSortDescending;

public class Stock {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the number of companies");
		int noOfCompanies = scan.nextInt();
		double[] arr = new double[noOfCompanies];
		int riseCount = 0;
		int decreaseCount = 0;
		for (int i = 0; i < noOfCompanies; i++) {
			System.out.println("Enter current stock price of the company "+ (i + 1));
			BigDecimal bigdecimal = new BigDecimal(scan.nextDouble()).setScale(2, RoundingMode.HALF_UP);
			arr[i] = bigdecimal.doubleValue();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			Boolean isStockRise = scan.nextBoolean();
			if (isStockRise) {
				riseCount++;
			} else {
				decreaseCount++;
			}
		}

		boolean doExit = true;
		while (doExit) {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. press 0 to exit");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				double[] ascending = MergeSortAscending.sort(arr, 0, arr.length - 1);
				System.out.println("Stock prices in ascending order are :");
				for (int i = 0; i < ascending.length; i++) {
					System.out.print(ascending[i] + " ");
				}
				System.out.print("\n");
				break;
			case 2:
				double[] descending = MergeSortDescending.sort(arr, 0, arr.length - 1);
				System.out.println("Stock prices in descending order are :");
				for (int i = 0; i < descending.length; i++) {
					System.out.print(descending[i] + " ");
				}
				System.out.print("\n");
				break;
			case 3:
				System.out.println("Total no of companies whose stock price rose today :" + riseCount);
				break;
			case 4:
				System.out.println("Total no of companies whose stock price declined today :" + decreaseCount);
				break;
			case 5:
				System.out.println("Enter the key value");
				double key = scan.nextDouble();
				boolean isFound = LinearSearch.search(arr, key);
				if (isFound)
					System.out.println("Stock of value " + key + " is present");
				else
					System.out.println("Stock of value " + key + " is not present");
				break;
			case 6:
				doExit = false;
				System.out.println("Exited successfully!!");
				break;
			default:
				System.out.println("Invalid Option. Please select correct option");
				break;
			}
		}

	}

}
