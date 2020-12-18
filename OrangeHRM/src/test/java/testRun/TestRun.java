package testRun;

import org.testng.annotations.Test;

import utils.DriverManager;
import utils.SeleniumHelper;

public class TestRun extends SeleniumHelper{

	@Test
	public void firstTest() {
		DriverManager dm = new DriverManager();
		dm.openBrowser("chrome");
		SeleniumHelper sh = new SeleniumHelper();
		sh.goToUrl("https://opensource-demo.orangehrmlive.com/");
		sh.navigateToUrl("https://www.google.com/"); 
		sh.refreshPage();
		System.out.println(sh.getTitle()); 
		dm.quitBrowser();


	}

	@Test
	public void dataDriven() {
		SeleniumHelper sl = new SeleniumHelper();
		String cell1 = sl.getDataFromExcelSheet("documents/Test reports.xlsx", "Sheet1", 1,4);
		System.out.println(cell1);
	}

}
