package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumHelper extends DriverManager {

	WebDriverWait wait;
	WebDriver driver = DriverManager.getDriver();

	//will return the title of the page.
	public String getTitle() { 
		return driver.getTitle();

	}
	
	//
	public String getCurrentURL() {
		return driver.getCurrentUrl();
		}

	//will go to the given url or Website.
	public void goToUrl(String url) { 
		driver.get(url);
	}

	// will navigate to the url or Website.
	public void navigateToUrl(String url) { 
		driver.navigate().to(url);;
	}

	// will take the browesr tab to the previous page
	public void navigateBack() {
		driver.navigate().back();
	}

	// will take you to the forward tab 
	public void navigateForward() {
		driver.navigate().forward();
	}

	// will refresh the page
	public void refreshPage() { 
		driver.navigate().refresh();
	}

	// will sleep with given amount of sec
	public void sleep(int sec) {
		try {
			Thread.sleep(1000*sec);
		} catch (InterruptedException e) {
			System.out.println("System broke while sleeping.");
			e.printStackTrace();
		}
	}
	
	// Will get the element and return element.
		public WebElement getElement(String locator) {
			return driver.findElement(By.xpath(locator));
		}

		
	//Explicit Wait- will search for element until given condition is met.
	public WebElement waitForElement(WebElement element) {

		wait = new WebDriverWait(driver, 20);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		highlightElement(element);
		unhighlightElement(element);

		return webElement;
	}


	// Explicit wait - will search for element until given condition is met
	public void waitForElement() { 

		WebElement element = driver.findElement(By.name("Rakib"));
		wait	= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Rakib"))));
	}

	

	//Fluent Wait- will search for an element after every interval of time until the condition is met
	public WebElement waitForElementFluent(WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.visibilityOf(element));


	}

	//Will check if WebElement exist and return true or false.
	public boolean ifWebElementExist(WebElement element) {
		boolean isPresent;

		try {

			wait = new WebDriverWait(driver,20);
			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			return isPresent;

		}
		catch(Exception e) {
			return false;
		}
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		sleep(1);
	}
	public void unhighlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='0px solid red'", element);
		sleep(1);

	}

	//select from the dropDown by index
	public void selectFromDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	//select from the dropDown by value
	public void selectFromDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	//accept alert
	public void acceptAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	//dismiss alert
	public void dismissAlert() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	//switch to iframe using index
	public void switchToIframe(int index) {
		driver.switchTo().frame(index);
	}

	//switch to iframe using value
	public void switchToIframe(String value) {
		driver.switchTo().frame(value);
	}

	//switch to parent frame
	public void switchToParentFrame(){
		driver.switchTo().parentFrame();
	}

	//handaling the window
	public String getCurrentWindowHandle() {
		return driver.getWindowHandle(); 
	}

	//switch to new window
	public String switchWindow() {
		String parentWindow = getCurrentWindowHandle();
		Set <String> allWindows = driver.getWindowHandles();
		for(String windows : allWindows) {

			if(!windows.equals(parentWindow)) {
				driver.switchTo().window(windows);
			}	
		}
		String childWindow = getCurrentWindowHandle();
		return childWindow;

	}

	
	//Switch to next window
		public void switchToNextWindow() {

			String parent = getCurrentWindowHandle();
			Set <String> AllWindow = driver.getWindowHandles();
			for(String window : AllWindow) {

				if(!window.equals(parent)) {

					driver.switchTo().window(window);
				}
			}

		}




	//open a new tab
	public void openNewWIndow(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
	}

	public void openUrlNewWindow(String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open, ('"+ url +"')");

	}

	// take screenshot
	public void takeScreenshot() {

		String name = "Screen Shot" + date() + ".png";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			File localScreenshot = new File(new File("build"),"Screenshot");
			if(!localScreenshot.exists() || !localScreenshot.isDirectory()) {
				localScreenshot.mkdirs();	
			}
			File Screenshot = new File(localScreenshot,name);
			Files.copy(sourceFile, Screenshot);
		}
		catch(IOException e) {
			System.out.println("Screenshot didn't work");

		}
	}

	// date fuction 
	public String date() {

		DateFormat df = new SimpleDateFormat("MM-dd-yy HH.mm.ss");
		Date date = new Date();
		String finalDate = df.format(date);
		return finalDate;

	}

	//To read Excel sheet DDD
	public String getDataFromExcelSheet(String path, String sheetName, int rownum, int cellnum) {
		String data = null;
		try {
			File file = new File(path);
			FileInputStream fs = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet(sheetName);
			data = sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
		}


		catch(IOException e) {

			System.out.println("Unable to read file");
		}
		return data;
	}

	//to handle keybord and mouse action
	public void action() {
		Actions action = new Actions(driver);
		action.click();	
		
	}

	//Read proerties file from the project	
	public String readPropFile(String key) {
		
		Properties prop =new Properties();
		InputStream is =null;
		
		try{
			is = new FileInputStream("src/test/resources/config.properties");
			prop.load(is);
		}
		catch(Exception e) {
			System.out.println("Unable to read prop file.");
		}
		return prop.getProperty(key);
	}
	























}
