package practice;

import org.testng.annotations.Test;

public class HookPractice2 extends HookPractice {

	@Test(groups = "evenTest")
	public void test4() {
		System.out.println("This is test4.");
	}
	@Test(groups = "oddTest")
	public void test5() {
		System.out.println("This is test5.");
	}
	@Test(groups = "evenTest")
	public void test6() {
		System.out.println("This is test6.");
	}
}
