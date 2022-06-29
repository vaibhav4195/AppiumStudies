package baseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseFirefox {
	public static AndroidDriver<AndroidElement> mobileFirefoxCapabilities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;
//		System.setProperty("webdriver.gecko.driver", "D:\\Users\\Temp\\Downloads\\geckodriver\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//		System.setProperty("PATH", "D:\\Users\\Temp\\Downloads\\geckodriver\\geckodriver.exe");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		
//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		cap.setCapability("marionette", true);
//		obj.setBrowserName("firefox"); 
//		obj.setVersion("18.0.1"); 
//		obj.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Gecko");
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Gecko");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "firefox");
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "firefox");
		
//		cap.setCapability("webdriver.gecko.driver", "D:\\Users\\Temp\\Downloads\\GeckodriverFolder\\geckodriver.exe");
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
//		cap.setBrowserName("firefox");
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Gecko");
//		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Gecko");
//		cap.setBrowserName("firefox");
//		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
		
		

		//		cap.setCapability("androidPackage", "com.android.gecko");

		//		"androidPackage": "com.android.chrome"
		//		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Gecko");
		//		cap.setCapability("appPackage", "org.mozilla.firefox");
		//		cap.setCapability("appActivity", ".App");

		//		cap.setCapability("browserName", "MozillaFirefox");
		//		cap.setCapability("platformName", "android");

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}

}
