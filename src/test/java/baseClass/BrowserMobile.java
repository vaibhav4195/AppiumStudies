package baseClass;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserMobile extends BaseChrome{

	static AndroidDriver<AndroidElement> driver;

	public static void main(String[] args) throws MalformedURLException {
		driver = mobileCapabilities();
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		driver.findElement(By.cssSelector(".nav-link[routerlink='/products']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		String text = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div/div/a")).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "Devops");
	}

}
