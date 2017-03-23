package com.epam.trjava.arraysort.logic.exception;

public class ZeroLengthArrayException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  ZeroLengthArrayException(){
		super();
		System.out.println("Array has no elements!");
	}

}
