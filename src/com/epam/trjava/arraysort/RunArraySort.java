package com.epam.trjava.arraysort;

import com.epam.trjava.arraysort.logic.SortMethods;

public class RunArraySort {

	public static void main(String[] args) {
		//Object[] array = {};
		//Object[] array = {435, 'D', 0.999, -56, 454.3434, -546.253535, -56};
		Object[] array = {435, 1.45, 0.999, -56, 454.3434, -546.253535, -56};
		System.out.println("--- default array ---");
		printArray(array); System.out.println();
		
		printArray(selectionSort(array));
		System.out.println(); printNumOfIterations();
		
		printArray(insertionSort(array)); 
		System.out.println(); printNumOfIterations();
		
		printArray(bubbleSort(array));
		System.out.println(); printNumOfIterations();
		
		printArray(quickSort(array));
		System.out.println(); printNumOfIterations();
	}
	
	private static Object[] selectionSort(Object[] array){
		System.out.println();
		System.out.println("--- sorted by 'Selection Sort' ---");
		return SortMethods.selectionSort(array);
	}
	
	private static Object[] insertionSort(Object[] array){
		System.out.println();
		System.out.println("--- sorted by 'Insertion Sort' ---");
		return SortMethods.insertionSort(array);
	}
	
	private static Object[] bubbleSort(Object[] array){
		System.out.println();
		System.out.println("--- sorted by 'Bubble Sort' ---");
		return SortMethods.bubbleSort(array);
	}
	
	private static Object[] quickSort(Object[] array){
		System.out.println();
		System.out.println("--- sorted by 'QuickSort' ---");
		return SortMethods.quickSort(array);
	}
	
	private static void printNumOfIterations(){
		System.out.println("Iterations: " + SortMethods.numOfIterations);
	}
	
	private static void printArray(Object[] array){
		for(Object temp : array){
			System.out.print(temp + " ; ");
		}
	}

}
