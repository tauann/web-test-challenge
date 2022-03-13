package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoreDriver {
	static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null)
			setUp();
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	private static void setUp() {
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
