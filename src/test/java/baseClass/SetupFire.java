package baseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class SetupFire {
	
	WebDriver driver;
	WebDriverWait wait;
	String AppURL = "http://www.seleniumeasy.com";

	@BeforeTest
	public void setup() throws MalformedURLException {
		String path = "D:\\Users\\Temp\\Desktop\\AppiumPractise\\AppiumStudy\\geckodriver.exe";
		FirefoxOptions opt = new FirefoxOptions();
		opt.setBinary(path);
		// Create an object for Desired Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, opt.getBinary());
//		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "gecko");
	
		// Name of mobile web browser to automate. ‘Safari’ for iOS and ‘Chrome’
		// or ‘Browser’ for Android
		capabilities.setCapability("browsername", "firefox");

		// The kind of mobile device or emulator to use - iPad Simulator, iPhone
		// Retina 4-inch, Android Emulator, Galaxy S4 etc
		capabilities.setCapability("deviceName", "bd6796e8");

		// Which mobile OS platform to use - iOS, Android, or FirefoxOS
		capabilities.setCapability("platformName", "Android");

		// Java package of the Android app you want to run- Ex:
		// com.example.android.myApp
		capabilities.setCapability("appPackage", "org.mozilla.firefox");

		// Activity name for the Android activity you want to launch from your
		// package
		capabilities.setCapability("appActivity", "org.mozilla.firefox.App");

		// Initialize the driver object with the URL to Appium Server and
		// passing the capabilities
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		wait = new WebDriverWait(driver, 5);
	}
	
	@Test
	public void testSearchAppium() throws InterruptedException {
		driver.get("https://mail.aqmtechnologies.com/action/login/aqmtechnologies.com");
		Thread.sleep(5000);
		driver.findElement(By.className("android.widget.Button")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("vaibhav4195");
	}

}
