package com.epam.trjava.arraysort.logic;

/**
 * Class implements four method of array sorting for numeric elements: Selection
 * sort; Insertion sort; Bubble sort; QuickSort
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */
public final class SortMethods {
	
	private SortMethods(){}

	/**
	 * Method implements <b>Selection Sort</b>. The algorithm divides the input
	 * list into two parts: the sublist of items already sorted, which is built
	 * up from left to right at the front (left) of the list, and the sublist of
	 * items remaining to be sorted that occupy the rest of the list. Initially,
	 * the sorted sublist is empty and the unsorted sublist is the entire input
	 * list. The algorithm proceeds by finding the smallest (or largest,
	 * depending on sorting order) element in the unsorted sublist, exchanging
	 * (swapping) it with the leftmost unsorted element (putting it in sorted
	 * order), and moving the sublist boundaries one element to the right.
	 * 
	 * @see https://en.wikipedia.org/wiki/Selection_sort
	 * @param array
	 *            of double to sort, if they are numbers
	 * @return sorted array of double
	 */
	public static double[] selectionSort(double[] array) {
		if (isNotEmptyArray(array)) {
			int min;
			double temp;

			for (int index = 0; index < array.length - 1; index++) {
				min = index;
				for (int scan = index + 1; scan < array.length; scan++) {
					if (array[scan] < array[min]) {
						min = scan;
					}
				}
				if (min != index) {
					temp = array[min];
					array[min] = array[index];
					array[index] = temp;
				}
			}
			return array;
		}
		return array;
	}

	/**
	 * Method implements <b>Insertion Sort</b>. Insertion sort iterates,
	 * consuming one input element each repetition, and growing a sorted output
	 * list. Each iteration, insertion sort removes one element from the input
	 * data, finds the location it belongs within the sorted list, and inserts
	 * it there. It repeats until no input elements remain.
	 * 
	 * @see https://en.wikipedia.org/wiki/Insertion_sort
	 * @param array
	 *            of double to sort, if they are numbers
	 * @return sorted array of double
	 */
	public static double[] insertionSort(double[] array) {
		if (isNotEmptyArray(array)) {
			double temp;
			int scan = 0;
			for (int index = 1; index < array.length; index++) {
				temp = array[index];
				scan = index - 1;

				while (scan >= 0 && array[scan] > temp) {
					array[scan + 1] = array[scan];
					array[scan] = temp;
					scan--;
				}
			}
			return array;
		}
		return array;
	}

	/**
	 * Method implements <b>Bubble Sort</b>. A simple sorting algorithm that
	 * repeatedly steps through the list to be sorted, compares each pair of
	 * adjacent items and swaps them if they are in the wrong order. The pass
	 * through the list is repeated until no swaps are needed, which indicates
	 * that the list is sorted.
	 * 
	 * @see https://en.wikipedia.org/wiki/Bubble_sort
	 * @param array
	 *            of double to sort, if they are numbers
	 * @return sorted array of double
	 */
	public static double[] bubbleSort(double[] array) {
		if (isNotEmptyArray(array)) {
			double temp;

			for (int index = array.length - 1; index >= 0; index--) {
				for (int scan = 0; scan < index; scan++) {
					if (array[scan] > array[scan + 1]) {
						temp = array[scan];
						array[scan] = array[scan + 1];
						array[scan + 1] = temp;
					}
				}
			}
			return array;
		}
		return array;
	}

	/**
	 * Method implements <b>QuickSort</b>. Quicksort is a divide and conquer
	 * algorithm. Quicksort first divides a large array into two smaller
	 * sub-arrays: the low elements and the high elements. Quicksort can then
	 * recursively sort the sub-arrays.
	 * 
	 * The steps are: 1 Pick an element, called a pivot, from the array. 2
	 * Partitioning: reorder the array so that all elements with values less
	 * than the pivot come before the pivot, while all elements with values
	 * greater than the pivot come after it (equal values can go either way).
	 * After this partitioning, the pivot is in its final position. This is
	 * called the partition operation. 3 Recursively apply the above steps to
	 * the sub-array of elements with smaller values and separately to the
	 * sub-array of elements with greater values. The base case of the recursion
	 * is arrays of size zero or one, which never need to be sorted.
	 * 
	 * @see https://en.wikipedia.org/wiki/Quicksort
	 * @param array
	 *            of double to sort, if they are numbers
	 * @return sorted array of double
	 */
	public static double[] quickSort(double[] array) {
		if (isNotEmptyArray(array)) {

			array = quickSortPartition(array, 0, array.length - 1);

			return array;
		}
		return array;
	}

	/**
	 * Auxiliary method for the method quickSort(Object[] array). Mission: sort
	 * array according quickSort algorithm and provide recursion.
	 * 
	 * @param array
	 *            of double to sort
	 * @param lowIndex
	 *            is the first index of array
	 * @param highIndex
	 *            is the last index of array
	 * @return sorted array of Objects
	 */
	private static double[] quickSortPartition(double[] array, int lowIndex, int highIndex) {
		if (isNotEmptyArray(array)) {
			double temp;
			double pivot = array[lowIndex + (highIndex - lowIndex) / 2];

			int i = lowIndex;
			int j = highIndex;
			while (i <= j) {
				while (array[i] < pivot) {
					i++;
				}
				while (array[j] > pivot) {
					j--;
				}
				if (i <= j) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					i++;
					j--;
				}
			}

			// recursion
			if (lowIndex < j) {
				quickSortPartition(array, lowIndex, j);
			}
			if (highIndex > i) {
				quickSortPartition(array, i, highIndex);
			}
			return array;
		}
		return array;

	}

	/**
	 * Auxiliary method to check if array of double is empty
	 * 
	 * @param array
	 *            of double to check
	 * @return true if array is not empty
	 */
	private static boolean isNotEmptyArray(double[] array) {
		if (null == array || array.length == 0) {
			System.err.println("Array is empty");
			return false;
		}
		return true;
	}
}
