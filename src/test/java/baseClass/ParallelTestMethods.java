package baseClass;

import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class ParallelTestMethods {
	AppiumDriver<AndroidElement> driver;
	
	public ParallelTestMethods(AppiumDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public void firstTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Mona");
		driver.hideKeyboard();
		driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("android:id/text1").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElementByXPath("//*[@text='Argentina']").click();
		Thread.sleep(3000);
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
	}
	
	public void secondTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
		
		TouchAction t = new TouchAction(driver);
		//longpress on src object move to destination address and relese their
		
		//When we have multiple actions to perform use this
//		t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		//For simply drag and drop we use this
		t.longPress(element(source)).moveTo(element(destination)).release().perform();
		
		
		
	}

}
