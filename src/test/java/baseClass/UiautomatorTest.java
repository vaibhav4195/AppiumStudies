package baseClass;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UiautomatorTest extends base {

//	public static AndroidDriver<AndroidElement> driver;
	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Use AndroidUIAutomator
		//driver.findElement(MobileBy.AndroidUIAutomator("attribute(\"value\")"));
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
//		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Animation\")")).click();
		
		//validate clickable feature for all options
	System.out.println(driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)")).size());

		
		
		
//		try {
//			driver = capabilities();
//			System.out.println("Application Started....");
//			
//			driver.findElementByA
//			
//			
//			
//		}catch (MalformedURLException e) {
//			System.out.println("Application Launching Failed...");
//			e.printStackTrace();
//		}
		
	}

}
