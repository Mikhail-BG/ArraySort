package com.epam.trjava.arraysort.logic.exception;

public class NotANumberInArrayException extends Exception {

	/**
	 * Check: if array includes not a number value
	 */
	private static final long serialVersionUID = 1L;

	public NotANumberInArrayException(Object obj){
		super();
		System.out.println("Value '" + obj.toString() + "' not a number!");
	}
}
