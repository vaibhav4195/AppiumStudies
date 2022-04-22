package baseClass;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.Dependencies;
import pageObjects.HomePage;
import pageObjects.Preferances;

public class Basics extends base {
	public static AndroidDriver<AndroidElement> driver;
	
	public static void main(String[] args)  {
		try {
			driver = capabilities();
			System.out.println("Application Started....");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			HomePage h =new HomePage(driver);
			//Constructor of class will be invoked when yo create object for the class
			//Default constructor is called
			//Constructor can be defined with arguments
			//You can call the methods or variables of the class with class object
			h.Preferences.click();
			
			
//			driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']"));
//			driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
			
			Preferances p = new Preferances(driver);
			
//			driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
			p.Dependencies.click();
			
			Dependencies d = new Dependencies(driver);
			d.Wifi.click();
//			driver.findElementById("android:id/checkbox").click();
			//To handle duplicate elements by index
			
			d.WifiSetting.click();
//			driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
			
			d.EditBox.sendKeys("Hello");
//			driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
			//To handle duplicate elements by findElements
//			driver.findElementsByClassName("android.widget.Button").get(1).click();
			p.Btn.get(1).click();
		
		} catch (MalformedURLException e) {
			System.out.println("Application Launching Failed...");
			e.printStackTrace();
		}
		
	
	}

}
