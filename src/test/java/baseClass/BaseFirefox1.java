package baseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseFirefox1 {
	public static AndroidDriver<AndroidElement> mobileCapabilities1() throws MalformedURLException {
		
		
		
//		DesiredCapabilities capabilities = DesiredCapabilities. firefox();
//		capabilities. setCapability("marionette",true);
//		WebDriver driver= new FirefoxDriver(capabilities);
		AndroidDriver<AndroidElement> driver;
//		System.setProperty("webdriver.gecko.driver", "D:\\Users\\Temp\\Desktop\\geckodriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("marionette",true);
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "firefox");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}

}
