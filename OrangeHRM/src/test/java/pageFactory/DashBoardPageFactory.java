package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;
import utils.SeleniumHelper;

public class DashBoardPageFactory {

	SeleniumHelper sh = new SeleniumHelper();
	
	public DashBoardPageFactory(WebDriver driver) {
		driver = DriverManager.getDriver();// we are assigning the driver
		PageFactory.initElements(driver, this);//looking the driver and its location,
	}


	

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	public WebElement dashboardTitle;

	@FindBy(xpath = " //b[contains(text(),'PIM')]")
	public WebElement pimTitle;
	
	@FindBy(xpath = "//select[@id='empsearch_employee_status']")
	public WebElement employmentStatusDropDown;
	 
	 
 
	public String getTextDashboardTitle() {
		return sh.waitForElement(dashboardTitle).getText();	
	}
	
	public void clickPim() {
		sh.waitForElement(pimTitle).click();
	}
	public void selectEmployeeStatus(int index) {
		sh.selectFromDropDown(employmentStatusDropDown, index);



}
}
