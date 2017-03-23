package com.epam.trjava.arraysort.logic;

import com.epam.trjava.arraysort.logic.exception.NotANumberInArrayException;

/**
 * Class implements 4 method of array sorting
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */
public final class SortMethods {

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
	 * @see https://en.wikipedia.org/wiki/Insertion_sort
	 * @param array
	 *            of Objects to sort, if they are numbers
	 * @return sorted array of Objects
	 */
	public static Object[] insertionSort(Object[] array) {
		double[] arrayToSort = getConvertedArray(array);

		if (null != arrayToSort) {
			double temp;
			int scan = 0;
			for(int index = 1; index < arrayToSort.length; index++){
				temp = arrayToSort[index];
				scan = index - 1;
				
				while(scan >= 0 && arrayToSort[scan] > temp){
					arrayToSort[scan + 1] = arrayToSort[scan];
					arrayToSort[scan] = temp;
					scan--;
				}
			}
			return convertArrayToObject(arrayToSort);
		}
		System.out.println("Insertion Sort failed");
		return array;
	}

	private static double[] getConvertedArray(Object[] array) {
		try {
			return convertArrayToDouble(array);
		} catch (NotANumberInArrayException e) {
			return null;
		}
	}

	/**
	 * Method implements conversion of each element of array to double
	 * 
	 * @param array
	 *            of Objects to convert into double
	 * @return array of double elements
	 * @throws NotANumberInArrayException
	 */
	private static double[] convertArrayToDouble(Object[] array) throws NotANumberInArrayException {
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
