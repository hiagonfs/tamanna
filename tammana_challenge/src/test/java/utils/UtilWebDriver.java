package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilWebDriver {

	private static WebDriver driver;

	public static void initDriver() {
		configureDriver();
		driver = new ChromeDriver(configureDriver());
		WebDriverManager.chromedriver().setup();
	}

	public static WebDriver getDriver() {

		if (driver == null) {
			initDriver();
		}
		return driver;
	}

	public static ChromeOptions configureDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("headless");
		return chromeOptions;
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

}
