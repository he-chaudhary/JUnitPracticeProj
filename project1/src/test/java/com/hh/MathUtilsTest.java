package com.hh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void testAdd() {
		MathUtils mathUtils = new MathUtils();
		int expected = 2;
		int actual  = mathUtils.add(1, 1);
		assertEquals(expected, actual,"The add method should add two numbers");
		
	}
	
	@Test
	void testComputeCircleRadius() {
		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793,  mathUtils.computeCircleArea(10), "should return right cirlce area");
		
	}
	
	

}
