package baseClass;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_tc_4 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Mona");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
		driver.findElementByXPath("//*[@text='India']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		//validating values
		String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		amount1 = amount1.substring(1);
		double amount1value = Double.parseDouble(amount1);
		
		String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		amount2 = amount2.substring(1);
		double amount2value = Double.parseDouble(amount2);
		
		double sumOfProduct = amount1value + amount2value;
		System.out.println("Sum of products is: "+sumOfProduct);
		
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println("Total Value of products is: "+sumOfProduct);
		
		Assert.assertEquals(totalValue, sumOfProduct);


	}
}
