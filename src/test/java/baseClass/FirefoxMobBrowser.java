package baseClass;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirefoxMobBrowser extends  FirefoxBase{
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		driver = mobileCapabilities3();
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
//		Thread.sleep(7000);
//		//Just like window handles here we use ContextHandle
//		Set<String>contexts = driver.getContextHandles();
//		for(String contextName : contexts) {
//			System.out.println(contextName);
//		}
//		driver.context("NATIVE_APP");
		Thread.sleep(7000);
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
