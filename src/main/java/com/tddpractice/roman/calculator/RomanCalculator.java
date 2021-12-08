package com.tddpractice.roman.calculator;

import java.math.BigInteger;

public class RomanCalculator implements IRomanCalculator {
	
	IConverterUtil converter = null;
	
	public RomanCalculator(IConverterUtil util) {
		this.converter = util;
	}

	@Override
	public String add(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		int result = 0;
		for (int i = 0; i < romanNums.length; i++) {
			result = result + converter.convertToNumber(romanNums[i]);
		}
		return converter.convertToRoman(result);
	}

	@Override
	public String subtract(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		int result = converter.convertToNumber(romanNums[0]);
		for (int i = 1; i < romanNums.length; i++) {
			result = result - converter.convertToNumber(romanNums[i]);
		}
		return converter.convertToRoman(result);
	}

	@Override
	public String multiply(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		int result = 1;
		for (int i = 0; i < romanNums.length; i++) {
			result = result * converter.convertToNumber(romanNums[i]);
		}
		return converter.convertToRoman(result);
	}

	@Override
	public String divide(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		Integer quotient = converter.convertToNumber(romanNums[0]);
		Integer divisor = 1;
		Integer remainder = 0;
		for (int i = 1; i < romanNums.length; i++) {
			divisor = divisor * converter.convertToNumber(romanNums[i]);
		}
		remainder = quotient % divisor;
		quotient = quotient / divisor;
		String result = "";
        int gcd = findGCD(divisor, remainder);
		if (remainder == 0)
			result = converter.convertToRoman(quotient);
		else {
			result = converter.convertToRoman(quotient) + " (" + converter.convertToRoman(remainder/gcd) + "/"
					+ converter.convertToRoman(divisor/gcd) + ")";
		}

		return result;
	}

	private int findGCD(Integer divisor, Integer remainder) {
		BigInteger divsr = new BigInteger(String.valueOf(divisor));
		BigInteger rmdr = new BigInteger(String.valueOf(remainder));
		BigInteger gcd = divsr.gcd(rmdr);
		return gcd.intValue();
	}

	public static void main(String args[]) {
	
	}

}
