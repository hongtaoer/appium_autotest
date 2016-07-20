package com.willow.javalearn;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestInteface {

	@BeforeClass
	public static void beforeTest() {
		System.out.println("This is before method");
	}

	@Test
	public void testRun() {

		Person runObject = new Person();
		runObject.run();

		MyFirstInterface runObject2 = new Pig();
		runObject2.run();
	}

	@AfterClass
	public static void afterTest() {
		System.out.println("This is after method");
	}

	@Test
	public void testAssert() {
		assertEquals(new Integer(1), new Integer(1));
		assertNotNull(new Integer(1));
		assertNull(null);
		assertNotNull(null);

	}
}
