package baseClass;

import java.net.MalformedURLException;

import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirefoxMobile extends BaseFirefox1{

	static AndroidDriver<AndroidElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		driver = mobileCapabilities1();
		driver.get("https://mail.aqmtechnologies.com/action/login/aqmtechnologies.com");
		Thread.sleep(5000);
//		driver.findElementByClassName("android.widget.Button").click();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("vaibhav4195");
//		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
//		driver.findElement(By.cssSelector(".navbar-toggler")).click();
//		driver.findElement(By.cssSelector(".nav-link[routerlink='/products']")).click();
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,1000)", "");
//		String text = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();
//		System.out.println(text);
//		
//		Assert.assertEquals(text, "Devops");

	}

}
