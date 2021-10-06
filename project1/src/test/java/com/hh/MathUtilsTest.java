package com.hh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	int cachedValue = 0; 
	MathUtils mathUtils;
	
	
	@BeforeEach
	
	void init() {
		mathUtils = new MathUtils();
		
	}
	
	@Test
	void testAdd() {
		int expected = 2;
//		cachedValue = 10;
		int actual  = mathUtils.add(1, 1);
		assertEquals(expected, actual,"The add method should add two numbers");
		
	}
	
	@Test
	void testComputeCircleRadius() {
//		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793,  mathUtils.computeCircleArea(10), "should return right cirlce area");
		
	}
	
	@Test
	void testDivide() {
//		MathUtils mathUtils = new MathUtils();
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"divide by zero should throw");
		mathUtils.divide(1, 0);
	}
	

}
