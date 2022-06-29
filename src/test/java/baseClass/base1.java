package baseClass;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class base1 {
	public static AppiumDriver<MobileElement> driver;
	public static AppiumDriver<MobileElement> openApp() throws InterruptedException, IOException {
//		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
//		Thread.sleep(3000);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("deviceName", "bd6796e8");
		cap.setCapability("platformVersion", "11");
		cap.setCapability("appPackage", "com.android.mms");
		cap.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		cap.setCapability("noReset", true);
		
		driver = new AppiumDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("Application Started Successfully...");
		Thread.sleep(5000);
		return driver;
		
	}

}
