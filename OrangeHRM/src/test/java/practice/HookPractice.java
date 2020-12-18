package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 *Hooks/Annotation are used to run a block of code over and over again without writing it.
 *There are few different hooks and each has its own functionality. 
 * 1. @Before method - it will run before each test method.
 * 2. @Before class - it will run before that specific class.
 * 3. @Before group - it will run before each test group. 
 * 4. @Before test - it will run before entire test run.
 * 5. @before suit - it will before test suit. 
 * 
 *   All 5 of them has @After annotation also. which will work same as before but it will run after.
 */

public class HookPractice {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite.");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after suite.");
	}
	
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("This is before group.");
	}
	
	@AfterGroups
	public void afterGroup() {
		System.out.println("This is after group.");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before all test.");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("This is after all test.");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class.");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is after class.");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method.");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after method.");
	}
	
	@Test(groups = {"oddTest","groupRed"})
	public void test1() {
		System.out.println("This is test1.");
	}
	@Test(groups = "evenTest")
	public void test2() {
		System.out.println("This is test2.");
	}
	@Test(groups = "oddTest")
	public void test3() {
		System.out.println("This is test3.");
	}
}
