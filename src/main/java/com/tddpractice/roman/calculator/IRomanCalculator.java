package com.tddpractice.roman.calculator;

public interface IRomanCalculator {
	
	
	/**
	 * Add Roman numerals
	 * @param operands
	 * @return
	 */
	public String add(String operands) throws Exception;
	
	/**
	 * Subtract Roman numerals
	 * @param operands
	 * @return
	 */
	public String subtract(String operands) throws Exception;
	
	/**
	 * Multiply Romans numerals
	 * @param operands
	 * @return
	 */
	public String multiply(String operands) throws Exception;
	
	/**
	 * Divide Roman numerals
	 * @param operands
	 * @return
	 */
	public String divide(String operands) throws Exception;

}
