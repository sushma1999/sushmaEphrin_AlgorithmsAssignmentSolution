package com.greatlearning.search;

public class LinearSearch {
	
	public static boolean search(double[] arr, double key) {
		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i])
				return true;
		}
		return false;
	}

}
