package com.hh;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@DisplayName("When running MathUtils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

	int cachedValue = 0; 
	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;
	
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all");
	}
	
	@BeforeEach
	
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags: "+testInfo.getTags() );
		
		
	}
	
	
	@AfterEach
	void cleanup() {
		
		System.out.println("Cleaning up...");
	}
	
	@Test
	@DisplayName("Testing add method")
	void testAdd() {
		int expected = 2;
//		cachedValue = 10;
		int actual  = mathUtils.add(1, 1);
		assertEquals(expected, actual,"The add method should add two numbers");
		
	}
	
	
	
	@Test
	@Tag("Circle")
	void testComputeCircleRadius() {
//		repetitionInfo.getCurrentRepetition();
//		MathUtils mathUtils = new MathUtils();
		assertEquals(314.1592653589793,  mathUtils.computeCircleArea(10), "should return right cirlce area");
		
	}
	
	@Test
	@DisplayName("multiply method")
	@Tag("Math")
	void testMultiply() {
		System.out.println("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
//		assertEquals(4,mathUtils.multiply(2, 2), "should return the right product");
		assertAll(
				()-> assertEquals(4, mathUtils.multiply(2, 2)),
				()-> assertEquals(0, mathUtils.multiply(2, 0)),
				()-> assertEquals(-2, mathUtils.multiply(2,-1))
				);
		
	}
	
	
	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class AddTest{
		
		@Test
		@DisplayName("when adding two positive numbers ")
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1),"should return the right sum");
		}
		
		@Test	
		@DisplayName("when adding two negative numbers")
		void testAddNegative() {
			int expected = -2;
			int actual = mathUtils.add(-1, -1);
			
			assertEquals(expected, 	actual , ()-> "should return sum"+expected+" but returned "+actual);
		}
		
		
	}
	@Test
	@Tag("Math")
//	@EnabledOnOs(OS.LINUX)
	void testDivide() {
		boolean isServerUp = false;
		
		assumeTrue(isServerUp);
//		MathUtils mathUtils = new MathUtils();
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0),"divide by zero should throw");
		mathUtils.divide(1, 0);
	}
	
	@Test
	@Disabled
	@DisplayName("TDD method. should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
}
