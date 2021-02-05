package com.valdal14.recursion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FactorialTest {

	@Test
	@DisplayName("Should return 120")
	void calculateFactorial_one() {
		assertEquals(Factorial.calculateFactorial(5), 120);
	}
	
	@Test
	@DisplayName("Should return 1")
	void calculateFactorial_two() {
		assertEquals(Factorial.calculateFactorial(0), 1);
	}
	
	@Test
	@DisplayName("Should return 1")
	void calculateFactorial_three() {
		assertEquals(Factorial.calculateFactorial(1), 1);
	}
	
	@Test
	@DisplayName("Should return 120")
	void calculateFactorial_four() {
		assertEquals(Factorial.calculateFactorial(-5), 120);
	}
	
	@Test
	@DisplayName("Should return 3628800")
	void calculateFactorial_five() {
		assertEquals(Factorial.calculateFactorial(10), 3628800);
	}
	
}
