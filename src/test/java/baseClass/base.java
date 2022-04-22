package baseClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {


		public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{
			File appDir = new File("D:\\Users\\Temp\\Desktop\\AppiumPractise\\AppiumStudy\\src\\test\\resources");
			File app = new File(appDir,"ApiDemos-debug.apk");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidDevice");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			AndroidDriver<AndroidElement>driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			return driver;
			
//			File appDir = new File("D:\\Users\\Temp\\Desktop\\AppiumPractise\\AppiumStudy\\src\\test\\resources");
//			File app = new File(appDir,"General-Store.apk");
//			
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
//			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
//			AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
//			return driver;
			
			
		}
		
	
}
