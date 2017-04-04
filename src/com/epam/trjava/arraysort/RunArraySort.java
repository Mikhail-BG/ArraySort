package com.epam.trjava.arraysort;

import com.epam.trjava.arraysort.logic.ArrayOperations;
import com.epam.trjava.arraysort.logic.SortMethods;

public class RunArraySort {

	public static void main(String[] args) {
		//double[] array = {};
		//double[] array = {435, 'D', 0.999, -56, 454.3434, -546.253535, -56};
		double[] array = {435, 1.45, 0.999, -56, 454.3434, -546.253535, -56};
		System.out.println("--- default array ---");
		ArrayOperations.printArray(array); 
		System.out.println();
		
		ArrayOperations.printArray(selectionSort(array));
		System.out.println();
		
		ArrayOperations.printArray(insertionSort(array)); 
		System.out.println();
		
		ArrayOperations.printArray(bubbleSort(array));
		System.out.println();
		
		ArrayOperations.printArray(quickSort(array));
		System.out.println();
	
	}
	
	private static double[] selectionSort(double[] array){
		System.out.println();
		System.out.println("--- sorted by 'Selection Sort' ---");
		return SortMethods.selectionSort(array);
	}
	
	private static double[] insertionSort(double[] array){
		System.out.println();
		System.out.println("--- sorted by 'Insertion Sort' ---");
		return SortMethods.insertionSort(array);
	}
	
	private static double[] bubbleSort(double[] array){
		System.out.println();
		System.out.println("--- sorted by 'Bubble Sort' ---");
		return SortMethods.bubbleSort(array);
	}
	
	private static double[] quickSort(double[] array){
		System.out.println();
		System.out.println("--- sorted by 'QuickSort' ---");
		return SortMethods.quickSort(array);
	}
}
