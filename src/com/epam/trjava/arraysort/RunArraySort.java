package com.epam.trjava.arraysort;

import com.epam.trjava.arraysort.logic.SortMethods;

public class RunArraySort {

	public static void main(String[] args) {
		Object[] array = {1, 5.3, 6, 0};
		
		System.out.println("--- default array ---");
		printArray(array);
		printArray(selectionSort(array));
	}
	
	private static Object[] selectionSort(Object[] array){
		System.out.println("--- sorted by selection sort ---");
		return SortMethods.selectionSort(array);
	}
	
	private static void printArray(Object[] array){
		for(Object temp : array){
			System.out.println(temp);
		}
	}

}
