package com.epam.trjava.arraysort.logic;

import com.epam.trjava.arraysort.logic.exception.NotANumberInArrayException;
import com.epam.trjava.arraysort.logic.exception.ZeroLengthArrayException;

/**
 * Class implements 4 method of array sorting
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */
public final class SortMethods {

	/** Number of iterations to compare perfomance */
	public static long numOfIterations = 0;

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
	 *            of Objects to sort, if they are numbers
	 * @return sorted array of Objects
	 */
	public static Object[] selectionSort(Object[] array) {
		numOfIterations = 0;
		double[] arrayToSort = getConvertedArray(array);

		if (null != arrayToSort) {
			int min;
			double temp;

			for (int index = 0; index < arrayToSort.length - 1; index++) {
				min = index;
				for (int scan = index + 1; scan < arrayToSort.length; scan++) {
					if (arrayToSort[scan] < arrayToSort[min]) {
						min = scan;
					}
				}
				if (min != index) {
					temp = arrayToSort[min];
					arrayToSort[min] = arrayToSort[index];
					arrayToSort[index] = temp;
					numOfIterations++;
				}
			}
			return convertArrayToObject(arrayToSort);
		}
		System.out.println("Selection Sort failed");
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
	 *            of Objects to sort, if they are numbers
	 * @return sorted array of Objects
	 */
	public static Object[] insertionSort(Object[] array) {
		numOfIterations = 0;
		double[] arrayToSort = getConvertedArray(array);

		if (null != arrayToSort) {
			double temp;
			int scan = 0;
			for (int index = 1; index < arrayToSort.length; index++) {
				temp = arrayToSort[index];
				scan = index - 1;

				while (scan >= 0 && arrayToSort[scan] > temp) {
					arrayToSort[scan + 1] = arrayToSort[scan];
					arrayToSort[scan] = temp;
					scan--;
					numOfIterations++;
				}
			}
			return convertArrayToObject(arrayToSort);
		}
		System.out.println("Insertion Sort failed");
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
	 *            of Objects to sort, if they are numbers
	 * @return sorted array of Objects
	 */
	public static Object[] bubbleSort(Object[] array) {
		numOfIterations = 0;
		double[] arrayToSort = getConvertedArray(array);

		if (null != arrayToSort) {
			double temp;

			for (int index = arrayToSort.length - 1; index >= 0; index--) {
				for (int scan = 0; scan < index; scan++) {
					if (arrayToSort[scan] > arrayToSort[scan + 1]) {
						temp = arrayToSort[scan];
						arrayToSort[scan] = arrayToSort[scan + 1];
						arrayToSort[scan + 1] = temp;
						numOfIterations++;
					}
				}
			}
			return convertArrayToObject(arrayToSort);
		}
		System.out.println("Bubble Sort failed");
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
	 *            of Objects to sort, if they are numbers
	 * @return sorted array of Objects
	 */
	public static Object[] quickSort(Object[] array) {
		numOfIterations = 0;
		double[] arrayToSort = getConvertedArray(array);

		if (null != arrayToSort) {

			arrayToSort = quickSortPartition(arrayToSort, 0, arrayToSort.length - 1);

			return convertArrayToObject(arrayToSort);
		}
		System.out.println("QuickSort failed");
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
				numOfIterations++;
			}
		}

		//recursion
		if (lowIndex < j)
			quickSortPartition(array, lowIndex, j);
		if (highIndex > i)
			quickSortPartition(array, i, highIndex);

		return array;
	}

	/**
	 * Method implements conversion of array of Objects to array of double
	 * elements with Exception implementation
	 * 
	 * @param array
	 *            of Objects to convert into double
	 * @return array of double elements
	 * @throws NotANumberInArrayException
	 */
	private static double[] getConvertedArray(Object[] array) {
		try {
			return convertArrayToDouble(array);
		} catch (ZeroLengthArrayException e) {
			return null;
		} catch (NotANumberInArrayException e) {
			return null;
		}
	}

	/**
	 * Method implements conversion of each element of Objects array to array of
	 * double elements
	 * 
	 * @param array
	 *            of Objects to convert into double
	 * @return array of double elements
	 * @throws NotANumberInArrayException
	 * @throws ZeroLengthArrayException
	 */
	private static double[] convertArrayToDouble(Object[] array)
			throws NotANumberInArrayException, ZeroLengthArrayException {

		if (0 == array.length)
			throw new ZeroLengthArrayException();

		double[] myArray = new double[array.length];
		int index = 0;

		for (Object obj : array) {
			if (obj instanceof Number) {
				myArray[index] = ((Number) obj).doubleValue();
				index++;
			} else
				throw new NotANumberInArrayException(obj);
		}
		return myArray;
	}

	/**
	 * Method implements conversion of each element of array to Object
	 * 
	 * @param array
	 *            of double elements to convert into Object
	 * @return array of Object elements
	 */
	private static Object[] convertArrayToObject(double[] array) {
		Object[] myArray = new Object[array.length];
		int index = 0;

		for (double temp : array) {
			myArray[index] = temp;
			index++;
		}
		return myArray;
	}
}
