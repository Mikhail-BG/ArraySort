package com.epam.trjava.arraysort;

import com.epam.trjava.arraysort.logic.SortMethods;

public class RunArraySort {

	public static void main(String[] args) {
		//Object[] array = {1, 5, 9.999, 0, 45, -454.4, -0.4};
		Object[] array = {5, 1.45, 0.999, -56};
		System.out.println("--- default array ---");
		printArray(array);
		printArray(selectionSort(array));
		printArray(insertionInsert(array));
	}
	
	private static Object[] selectionSort(Object[] array){
		System.out.println();
		System.out.println("--- sorted by 'Selection Sort' ---");
		return SortMethods.selectionSort(array);
	}
	
	private static Object[] insertionInsert(Object[] array){
		System.out.println();
		System.out.println("--- sorted by 'Insertion Sort' ---");
		return SortMethods.insertionSort(array);
	}
	
	private static void printArray(Object[] array){
		for(Object temp : array){
			System.out.print(temp + " ; ");
		}
	}

}
