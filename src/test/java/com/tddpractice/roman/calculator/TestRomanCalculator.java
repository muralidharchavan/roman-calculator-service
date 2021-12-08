package com.tddpractice.roman.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestRomanCalculator {

	private IConverterUtil converter;

	@Test
	@DisplayName("Add Roman numbers")
	public void testRomanNumberAddition() throws Exception {
		converter = Mockito.mock(IConverterUtil.class);

		RomanCalculator calc = new RomanCalculator(converter);
		Mockito.when(converter.convertToNumber("I")).thenReturn(1);
		Mockito.when(converter.convertToNumber("II")).thenReturn(2);
		Mockito.when(converter.convertToNumber("III")).thenReturn(3);
		Mockito.when(converter.convertToNumber("X")).thenReturn(10);
		Mockito.when(converter.convertToNumber("XII")).thenReturn(12);
		Mockito.when(converter.convertToRoman(2)).thenReturn("II");
		Mockito.when(converter.convertToRoman(3)).thenReturn("III");
		Mockito.when(converter.convertToRoman(4)).thenReturn("IV");
		Mockito.when(converter.convertToRoman(8)).thenReturn("VIII");
		Mockito.when(converter.convertToRoman(22)).thenReturn("XXII");

		assertEquals("II", calc.add("I,I"));
		assertEquals("III", calc.add("I,I,I"));
		assertEquals("IV", calc.add("I,I,II"));
		assertEquals("VIII", calc.add("I,I,III,II,I"));
		assertEquals("XXII", calc.add("X,XII"));
	}

	@Test
	@DisplayName("Subtract Roman numbers")
	public void testRomanNumberSubtraction() throws Exception {
		converter = Mockito.mock(IConverterUtil.class);
		Mockito.when(converter.convertToNumber("I")).thenReturn(1);
		Mockito.when(converter.convertToNumber("II")).thenReturn(2);
		Mockito.when(converter.convertToNumber("III")).thenReturn(3);
		Mockito.when(converter.convertToNumber("IV")).thenReturn(4);
		Mockito.when(converter.convertToNumber("VI")).thenReturn(6);
		Mockito.when(converter.convertToNumber("X")).thenReturn(10);
		Mockito.when(converter.convertToNumber("XX")).thenReturn(20);
		Mockito.when(converter.convertToRoman(1)).thenReturn("I");
		Mockito.when(converter.convertToRoman(3)).thenReturn("III");
		Mockito.when(converter.convertToRoman(4)).thenReturn("IV");
		Mockito.when(converter.convertToRoman(13)).thenReturn("XIII");
		
		RomanCalculator calc = new RomanCalculator(converter);
		assertEquals("I", calc.subtract("II,I"));
		assertEquals("III", calc.subtract("VI,I,II"));
		assertEquals("IV", calc.subtract("X,IV,I,I"));
		assertEquals("XIII", calc.subtract("XX,I,III,II,I"));
	}

	@Test
	@DisplayName("Multiply Roman numbers")
	public void testRomanNumberMultiply() throws Exception {
		converter = Mockito.mock(IConverterUtil.class);
		Mockito.when(converter.convertToNumber("I")).thenReturn(1);
		Mockito.when(converter.convertToNumber("II")).thenReturn(2);
		Mockito.when(converter.convertToNumber("III")).thenReturn(3);
		Mockito.when(converter.convertToNumber("IV")).thenReturn(4);
		Mockito.when(converter.convertToNumber("VI")).thenReturn(6);
		Mockito.when(converter.convertToNumber("X")).thenReturn(10);
		Mockito.when(converter.convertToNumber("XX")).thenReturn(20);
		Mockito.when(converter.convertToRoman(2)).thenReturn("II");
		Mockito.when(converter.convertToRoman(12)).thenReturn("XII");
		Mockito.when(converter.convertToRoman(40)).thenReturn("XL");
		Mockito.when(converter.convertToRoman(120)).thenReturn("CXX");
		
		RomanCalculator calc = new RomanCalculator(converter);
		assertEquals("II", calc.multiply("II,I"));
		assertEquals("XII", calc.multiply("VI,I,II"));
		assertEquals("XL", calc.multiply("X,IV,I,I"));
		assertEquals("CXX", calc.multiply("XX,I,III,II,I"));
	}

	@Test
	@DisplayName("Divide Roman numbers - perfect division")
	public void testRomanNumberPerfectDivision() throws Exception {
		converter = Mockito.mock(IConverterUtil.class);
		Mockito.when(converter.convertToNumber("I")).thenReturn(1);
		Mockito.when(converter.convertToNumber("II")).thenReturn(2);
		Mockito.when(converter.convertToNumber("III")).thenReturn(3);
		Mockito.when(converter.convertToNumber("V")).thenReturn(5);
		Mockito.when(converter.convertToNumber("VI")).thenReturn(6);
		Mockito.when(converter.convertToNumber("VII")).thenReturn(7);
		Mockito.when(converter.convertToNumber("X")).thenReturn(10);
		Mockito.when(converter.convertToNumber("XLII")).thenReturn(42);
		Mockito.when(converter.convertToRoman(2)).thenReturn("II");
		Mockito.when(converter.convertToRoman(3)).thenReturn("III");
		Mockito.when(converter.convertToRoman(1)).thenReturn("I");
	
		RomanCalculator calc = new RomanCalculator(converter);
		assertEquals("II", calc.divide("II,I"));
		assertEquals("III", calc.divide("VI,I,II"));
		assertEquals("I", calc.divide("X,V,I,II"));
		assertEquals("II", calc.divide("XLII,I,III,VII,I"));
	}

	@Test
	@DisplayName("Divide Roman numbers - reminder with division")
	public void testRomanNumberReminderDivision() throws Exception {
		converter = Mockito.mock(IConverterUtil.class);

		Mockito.when(converter.convertToNumber("II")).thenReturn(2);
		Mockito.when(converter.convertToNumber("III")).thenReturn(3);
		Mockito.when(converter.convertToNumber("XIX")).thenReturn(19);
		Mockito.when(converter.convertToNumber("XX")).thenReturn(20);
		Mockito.when(converter.convertToRoman(1)).thenReturn("I");
		Mockito.when(converter.convertToRoman(3)).thenReturn("III");
		Mockito.when(converter.convertToRoman(6)).thenReturn("VI");
	
		RomanCalculator calc = new RomanCalculator(converter);
		assertEquals("III (I/III)", calc.divide("XX,III,II"));
		assertEquals("III (I/VI)", calc.divide("XIX,III,II"));
		assertEquals("III (I/III)", calc.divide("XX,II,III"));
	}

}
