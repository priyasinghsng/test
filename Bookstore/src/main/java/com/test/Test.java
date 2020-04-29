package com.test;

public class Test {

	public static void main(String[] args) {
		int arr[] = { 2, 6, 4, 4, 2, 6, 7, 2};
		int n = arr.length;

		System.out.println(identicalIn(arr, n));
	}

	public static int identicalIn(int arr[], int n) {
		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j])
					count++;
			}
		return count;
	}

}
