package com.tddpractice.roman.calculator;

import java.math.BigInteger;

public class RomanCalculator implements IRomanCalculator {

	@Override
	public String add(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		int result = 0;
		for (int i = 0; i < romanNums.length; i++) {
			result = result + ConverterUtil.convertToNumber(romanNums[i]);
		}
		return ConverterUtil.convertToRoman(result);
	}

	@Override
	public String subtract(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		int result = ConverterUtil.convertToNumber(romanNums[0]);
		for (int i = 1; i < romanNums.length; i++) {
			result = result - ConverterUtil.convertToNumber(romanNums[i]);
		}
		return ConverterUtil.convertToRoman(result);
	}

	@Override
	public String multiply(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		int result = 1;
		for (int i = 0; i < romanNums.length; i++) {
			result = result * ConverterUtil.convertToNumber(romanNums[i]);
		}
		return ConverterUtil.convertToRoman(result);
	}

	@Override
	public String divide(String operands) throws Exception {
		String[] romanNums = operands.split(",");
		Integer quotient = ConverterUtil.convertToNumber(romanNums[0]);
		Integer divisor = 1;
		Integer remainder = 0;
		for (int i = 1; i < romanNums.length; i++) {
			divisor = divisor * ConverterUtil.convertToNumber(romanNums[i]);
		}
		remainder = quotient % divisor;
		quotient = quotient / divisor;
		String result = "";
        int gcd = findGCD(divisor, remainder);
		if (remainder == 0)
			result = ConverterUtil.convertToRoman(quotient);
		else {
			result = ConverterUtil.convertToRoman(quotient) + " (" + ConverterUtil.convertToRoman(remainder/gcd) + "/"
					+ ConverterUtil.convertToRoman(divisor/gcd) + ")";
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
		RomanCalculator calc = new RomanCalculator();
		try {
			System.out.println(calc.divide("XX,III,II"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
