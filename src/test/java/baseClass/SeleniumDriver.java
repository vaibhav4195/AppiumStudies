package baseClass;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class SeleniumDriver extends base1 {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		//Open a chrome Browser
		System.setProperty("webdriver.chrome.driver", "D:\\VaibhavPratise\\chromedriver_win32_101\\chromedriver.exe");  
		WebDriver driver1 = new ChromeDriver();
	    driver1.navigate().to("https://mail.aqmtechnologies.com/action/login/aqmtechnologies.com");
	    driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        //Maximize the browser  
         driver1.manage().window().maximize();  
         driver1.findElement(By.name("custom_input")).sendKeys("vaibhav.pawde");
         driver1.findElement(By.name("passwd")).sendKeys("Vkgsckp#357");
         driver1.findElement(By.xpath("//button[text()='Go »']")).click();
         
         //Start a Appium server
  
        AppiumDriver<MobileElement> driver = openApp();
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
 		driver.findElementByXPath("(//android.widget.TextView[@resource-id='com.android.mms:id/from'])[1]").click();
 		List<MobileElement> ele= driver.findElementsByXPath("//android.widget.LinearLayout[@resource-id='com.android.mms:id/msg_list_item']");
 		int size = ele.size();
		
 		//Double tap using javascript
 		JavascriptExecutor js = (JavascriptExecutor)driver;
 		js.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
 			    "elementId", ((RemoteWebElement) ele.get(size-1)).getId()
 			));

 		//Extract the Text message
	 	String data = driver.findElementByClassName("android.widget.TextView").getText();
	 	//System.out.println(data);
	 	
	 	
	 	//Get the Four digit number from the message using regular expression
	 	Pattern pattern = Pattern.compile("(\\d{4})");

		//  \d is for a digit 
		//  {} is the number of digits here 4.
		
		Matcher matcher = pattern.matcher(data);
		String val = "";
		if (matcher.find()) {        
		   val = matcher.group(1);  // 4 digit number
		}
		System.out.println("OTP is: "+val);
		
		driver.close();
		
		//Put that generated otp in browser
		driver1.findElement(By.xpath("//*[@id='otpcode']")).sendKeys(val);
		driver1.findElement(By.xpath("//input[@type='submit']")).click();



        
		
	}

}
