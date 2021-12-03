package com.tddpractice.roman.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRomanCalculator {

	@Test
	@DisplayName("Add Roman numbers")
	public void testRomanNumberAddition() throws Exception {
		RomanCalculator calc = new RomanCalculator();
		assertEquals("II",calc.add("I,I"));
		assertEquals("III",calc.add("I,I,I"));
		assertEquals("IV",calc.add("I,I,II"));
		assertEquals("VIII",calc.add("I,I,III,II,I"));
		assertEquals("XXII",calc.add("X,XII"));
	}

	@Test
	@DisplayName("Subtract Roman numbers")
	public void testRomanNumberSubtraction() throws Exception {
		RomanCalculator calc = new RomanCalculator();
		assertEquals("I",calc.subtract("II,I"));
		assertEquals("III",calc.subtract("VI,I,II"));
		assertEquals("IV",calc.subtract("X,IV,I,I"));
		assertEquals("XIII",calc.subtract("XX,I,III,II,I"));
	}

	@Test
	@DisplayName("Multiply Roman numbers")
	public void testRomanNumberMultiply() throws Exception {
		RomanCalculator calc = new RomanCalculator();
		assertEquals("II",calc.multiply("II,I"));
		assertEquals("XII",calc.multiply("VI,I,II"));
		assertEquals("XL",calc.multiply("X,IV,I,I"));
		assertEquals("CXX",calc.multiply("XX,I,III,II,I"));
	}

	@Test
	@DisplayName("Divide Roman numbers - perfect division")
	public void testRomanNumberPerfectDivision() throws Exception {
		RomanCalculator calc = new RomanCalculator();
		assertEquals("II", calc.divide("II,I"));
		assertEquals("III", calc.divide("VI,I,II"));
		assertEquals("I", calc.divide("X,V,I,II"));
		assertEquals("II", calc.divide("XLII,I,III,VII,I"));
	}

	@Test
	@DisplayName("Divide Roman numbers - reminder with division")
	public void testRomanNumberReminderDivision() throws Exception {
		RomanCalculator calc = new RomanCalculator();
		assertEquals("III (I/III)", calc.divide("XX,III,II"));
		assertEquals("III (I/VI)", calc.divide("XIX,III,II"));
		assertEquals("III (I/III)", calc.divide("XX,II,III"));
	}

}
