package com.epam.trjava.arraysort.logic.exception;

public class ZeroLengthArrayException extends Exception {
	
	/**
	 *  Check: if array does not include any of elements
	 */
	private static final long serialVersionUID = 1L;

	public  ZeroLengthArrayException(){
		super();
		System.out.println("Array has no elements!");
	}

}
