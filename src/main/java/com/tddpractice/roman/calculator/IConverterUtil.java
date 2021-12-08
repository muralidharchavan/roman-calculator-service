package com.tddpractice.roman.calculator;

public interface IConverterUtil {
	
	/**
	 * Convert a roman numeral to a number
	 * 
	 * @param rom
	 * @return
	 * @throws Exception
	 */
	public int convertToNumber(String rom) throws Exception;
	
	/**
	 * Convert a number to a roman numeral
	 * 
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public String convertToRoman(int num) throws Exception;

}