package baseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class FirefoxBase {
	
	static AndroidDriver<AndroidElement> driver;
	public static AndroidDriver<AndroidElement> mobileCapabilities3() throws MalformedURLException {
		
		
		FirefoxOptions fx = new FirefoxOptions();
		fx.setBinary("D:\\Users\\Temp\\Desktop\\AppiumPractise\\AppiumStudy\\geckodriver.exe");
	
		DesiredCapabilities cap = new DesiredCapabilities();
//		File gk = new File("D:\\Users\\Temp\\Desktop\\AppiumPractise\\AppiumStudy\\geckodriver.exe");
//		System.setProperty("webdriver.gecko.driver",new FirefoxBinary(gk));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
//		cap.setCapability("appPackage", "org.mozilla.firefox");
//		cap.setCapability("appActivity", ".App");
		cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, fx.getBinary());	
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "gecko");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "firefox");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		
//		driver = FirefoxBinary(gk);

//		cap.setCapability("appPackage", "org.mozilla.firefox");
//		cap.setCapability("appActivity", ".App");
	
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

}
