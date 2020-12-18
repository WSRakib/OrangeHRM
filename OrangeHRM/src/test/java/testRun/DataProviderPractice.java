package testRun;

import org.testng.annotations.Test;

import pageFactory.Data;
import utils.SeleniumHelper;

public class DataProviderPractice {
	
//	@Test(dataProvider ="ages", dataProviderClass = DataProvider.class)
	
	@Test
	public void completeSentence() {
	
		SeleniumHelper sh = new SeleniumHelper();
		
		System.out.println("My name is "+sh.readPropFile("name"));
		System.out.println("I am "+sh.readPropFile("age")+ " years old");
	}
}
