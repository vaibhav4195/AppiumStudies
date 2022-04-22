package baseClass;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class Ecommerce_tc_5 extends base{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Mona");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElementByXPath("//*[@text='Argentina']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//Added first two product
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		//validating values
		
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0;
		for(int i = 0;i < count; i++)
		{
			String amount = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			double amount1 =getAmount(amount);
			sum = sum + amount1;
		}
		System.out.println("Sum of products is: "+sum);
		
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double total1 =getAmount(total);
		System.out.println("Total Value of products is: "+total1);
		
		Assert.assertEquals(total1, sum);
		
		//Mobile Gestures
		WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkBox))).perform();
		WebElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(Duration.ofSeconds(2))).release().perform();
		
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();


	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double valueInDouble = Double.parseDouble(value);
		return valueInDouble;
	}
}
