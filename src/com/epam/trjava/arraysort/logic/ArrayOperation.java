package com.epam.trjava.arraysort.logic;

/**
 * Class for some operations of double[] array
 * 
 * @autor Mikhail Bahatyrou
 * @version 1.0
 */

public final class ArrayOperation {

	private ArrayOperation() {
	}

	/**
	 * Method allows to print array of double[]
	 * 
	 * @param array - array to print
	 */
	public static void printArray(double[] array) {
		for (double temp : array) {
			System.out.print(temp + " ; ");
		}
	}
}
