package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static WebDriver driver = null;

	
	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver openBrowser(String browser) {

		/*
		 * ChromeOptions op = new ChromeOptions();
		 * op.getCapability("Rakib");
		 * op.addArguments("Hossain");
		 * driver = new ChromeDriver(op);
		 */
		
		//System.setProperty("WebDriver.hrome.driver","Drivers//chromedriver.exe");

		if(browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Incorrect Driver, Please input a correct driver");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		
		return driver;

	}

	public void quitBrowser() {
		driver.quit();
	}

	public void closeAllTab() {
		driver.close();
	}
}
