package com.vicnesh.dynamicarray;

import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		DynamicArray dynamicArray = new DynamicArray();
		dynamicArray.initializeArray();
		
		
		int[] testArray = new int[10];

		System.out.println("Number of items in array :" + dynamicArray.getSize());
		
	}

}
