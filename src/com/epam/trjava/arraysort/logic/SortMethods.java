package com.epam.trjava.arraysort.logic;


/**
 * Class implements 4 method of array sorting
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */
public final class SortMethods {
	
	/**
	 * Method implements Selection Sort
	 * 
	 * @param array of Objects to sort, if they are numbers
	 * @return sorted array of Objects 
	 */
	public static Object[] selectionSort(Object[] array) {

		double[] arrayToSort = convertArrayToDouble(array);

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
				temp = arrayToSort[min];
				arrayToSort[min] = arrayToSort[index];
				arrayToSort[index] = temp;
			}
			return convertArrayToObject(arrayToSort);
			
		} else {
			System.out.println("Not a number in array");
			return null;
		}
	}

	
	/**
	 * Method implements conversion each element of array to double 
	 * 
	 * @param array of Objects to convert into double
	 * @return array of double elements
	 */
	private static double[] convertArrayToDouble(Object[] array) {

		double[] myArray = new double[array.length];
		int index = 0;

		for (Object obj : array) {
			if (obj instanceof Number) {
				myArray[index] = ((Number) obj).doubleValue();
				index++;
			} else
				return null;
		}

		return myArray;
	}
	
	/**
	 * Method implements conversion each element of array to Object
	 * 
	 * @param array of double elements to convert into Object
	 * @return array of Object elements
	 */
	private static Object[] convertArrayToObject(double[] array){
		
		Object[] myArray = new Object[array.length];
		int index = 0;
		
		for (double temp : array){
			myArray[index] = temp;
			index++;
		}
		
		return myArray;
	}

}
