package com.vicnesh.dynamicarray;

public class DynamicArray {
	
	
	//variables
	private static final int DEFAULT_ARRAY_SIZE = 8;
	private int[] dynamicArray;
	private int arraySize;
	private int arrayPointer;
	private int arrayCounter;
	
	
	//methods
	//constructor
	public DynamicArray() {
		System.out.println("create new dynamic array");
	}
	
	//initialize array
	public void initializeArray() {
		this.arraySize = this.DEFAULT_ARRAY_SIZE;
		this.arrayPointer = 0;
		this.dynamicArray = new int[this.arraySize];
	}

	public void resetArrayPointer() {
		this.arraySize = 0;
	}
	
	
	//get current number of items in array
	public int getSize() {
		/*
		this.arrayCounter = 0;
		try {
			while (this.dynamicArray[arrayCounter] == 0) {
				this.arrayCounter++;
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return this.arrayCounter;
		}	
		return this.arrayCounter;
		*/
		
		
		
		return this.arrayCounter;
	}
	
	
	//capacity - max number of items can hold
	public int getCapacity() {
		return this.arraySize;
	}

	//is empty
	
	//at(index)
	public int getElementAtIndex(int index) { 
		try {
			return this.dynamicArray[index];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}
	
	
	//push(item)
	public void pushElement(int element) {
		
		
	}
	
	//insert(index, item)
	//prepend(item)
	//pop
	//delete(index)
	
	//remove(item)
	public void removeElement(int element) {
		for (int i = 0; i != this.arraySize; i++) {
			if (this.dynamicArray[i] == element) {
				this.dynamicArray[i] = 0;
			}
		}
	}
	
	//find(item)
	//resize(new capacity)
	
}
