package com.vicnesh.dynamicarray;


/*
 * Dynamic Array
 * Able to resize itself when the array is full.
 * 
 * 
 * 
 */


public class DynamicArray {
	private static final int DEFAULT_ARRAY_SIZE = 8;
	private int[] dynamicArray;
	private int arraySize;
	private int arrayPointer;
	private int arrayCounter;
	
	
	/*
	 * Constructor
	 * @parameter
	 * @return
	 */
	public DynamicArray() {
		System.out.println("create new dynamic array");
	}
	
	
	/*
	 * Initialize array
	 * Sets the array size to 8 when object is first instantiated
	 * @parameter
	 * @return
	 */
	public void initializeArray() {
		this.arraySize = this.DEFAULT_ARRAY_SIZE;
		this.arrayPointer = 0;
		this.dynamicArray = new int[this.arraySize];
	}

	
	/*
	 * Initialize array
	 * Sets the array size to 8 when object is first instantiated
	 * @parameter
	 * @return
	 */
	public void resetArrayPointer() {
		this.arraySize = 0;
	}
	
	
	/*
	 * Return size of array counter
	 * @parameter
	 * @return - size of array
	 */
	public int getSize() {
		return this.arrayCounter;
	}
	
	
	/*
	 * Return the capacity of array
	 * @parameter
	 * @return - max capacity of array
	 */
	public int getCapacity() {
		return this.arraySize;
	}

	
	/*
	 * Check if array is empty
	 * @parameter
	 * @return - boolean,  true if array is empty, false if not empty
	 */
	public boolean isEmpty() {
		if (this.arraySize == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	

	/*
	 * Return element at index
	 * @parameter - index of array 
	 * @return - element at index of array
	 */
	public int getElementAtIndex(int index) { 
		try {
			return this.dynamicArray[index];
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}
	
	
	/*
	 * Keep track of amount of elements in the array
	 * Increment array counter
	 * @parameter
	 * @return
	 */
	private void incrementArrayCounter() {
		this.arrayCounter++;
	}
	
	
	/*
	 * Keep track of amount of elements in the array
	 * Decrement array counter
	 * @parameter
	 * @return
	 */
	private void decrementArrayCounter() {
		this.arrayCounter--;
	}
	
	
	/*
	 * Keep track current index of array
	 * Increment array index pointer
	 * @parameter
	 * @return
	 */
	private void incrementArrayPointer() {
		this.arrayPointer++;
	}
	
	
	/*
	 * Keep track current index of array
	 * Decrement array index pointer
	 * @parameter
	 * @return
	 */
	private void decrementArrayPointer() {
		this.arrayPointer--;
		
	}
	
		
	/*
	 * Push Element into end of array
	 * Insert element into empty index at end of array
	 * @parameter
	 * @return
	 */
	public void pushElement(int element) {
		this.dynamicArray[this.arrayPointer] = element;
		this.incrementArrayPointer();
		this.incrementArrayCounter();
		
	}
	
	
	/*
	 * Delete element from last index of array
	 * @parameter
	 * @return - value deleted from last index of array
	 */
	public int pop() {
		int popValue = 0;
		this.dynamicArray[this.arraySize] = popValue;
		this.dynamicArray[this.arraySize] = 0;
		return popValue;
	}
	
	
	/*
	 * Delete element at index, shift all elements left
	 * @parameter - int index of element to delete
	 * @return
	 */
	public void delete(int index) {
		this.dynamicArray[index] = 0;
		int temp = 0;
		for (int i = index+1; i != this.arraySize; i++) {
			this.dynamicArray[i-1] = this.dynamicArray[i];
		}
	}
	
	
	/*
	 * Delete element at index, shift all elements left
	 * @parameter - element to be deleted from array
	 * @return
	 */
	public void removeElement(int element) {
		for (int i = 0; i != this.arraySize; i++) {
			if (this.dynamicArray[i] == element) {
				this.dynamicArray[i] = 0;
				
			}
		}
	}
	

	/*
	 * Find element in array, return first index with the element
	 * @parameter - int element to find in array
	 * @return - -1 if element is not found
	 */
	public int findItem(int element) {
		for (int i = 0; i != this.arraySize; i++) {
			if (element == this.dynamicArray[i]) {
				return i; 
			}
		}
		return -1;
	}
	
	
	/*
	 * Used for resizing array
	 * Increment current array size
	 * @parameter - int element to find in array
	 * @return - -1 if element is not found
	 */
	private void incrementArraySize() {
		this.arraySize = this.arraySize * 2;
	}
	
	
	/*
	 * Used for resizing array
	 * Decrement current array size
	 * @parameter - int element to find in array
	 * @return - -1 if element is not found
	 */
	private void decrementArraySize() {
		this.arraySize = this.arraySize/2;
	}
	
	
	/*
	 * Resize array
	 * If array is at max capacity, double the size, if array is at 1/4 of capacity resize to half
	 * Check if the current capacity is full, store all elements of current array into a temp array.
	 * @parameter
	 * @return
	 */
	public void resizeArray() {
		//check if array size is bigger than array capacity
		if (this.arrayCounter == this.arraySize) {
			int tempArraySize = this.arraySize;
			this.incrementArraySize();
			int[] tempArray = new int[this.arraySize];
			
			for (int i = 0; i != tempArraySize; i++) {
				tempArray[i] = this.dynamicArray[i];
			}
			
			//resize current array in class
			this.dynamicArray = new int[this.arraySize];
			
			//store everything from temp array into new array
			
			for (int k = 0; k != tempArraySize; k++) {
				this.dynamicArray[k] = tempArray[k];
			}
			
		}
		else if (this.arraySize > this.DEFAULT_ARRAY_SIZE && this.arrayCounter < this.arraySize/4) {
			int tempArraySize = this.arraySize;
			this.decrementArraySize();
			int[] tempArray = new int[this.arraySize];
			
			for (int i = 0; i != tempArraySize; i++) {
				tempArray[i] = this.dynamicArray[i];
			}
			
			//resize current array in class
			this.dynamicArray = new int[this.arraySize];
			
			//store everything from temp array into new array
			
			for (int k = 0; k != tempArraySize; k++) {
				this.dynamicArray[k] = tempArray[k];
			}
			
		}
	}
	
}
