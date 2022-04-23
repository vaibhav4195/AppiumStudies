package baseClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseParallel {
	public ThreadLocal<AppiumDriver<AndroidElement>> driver = new ThreadLocal<AppiumDriver<AndroidElement>>();
	
	public void setDriver(AppiumDriver<AndroidElement> driver) {
		this.driver.set(driver);
	}
	
	public AppiumDriver<AndroidElement> getDriver() {
		return this.driver.get();
	}
	
	@BeforeTest
	public void killAllNodes() throws Exception {
		//to kill a appium server if it already running
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If a control comes here, then it means that the port is in use
			isServerRunning = true;
		}finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public AppiumDriverLocalService startServer(String portNumber) {
		boolean flag = checkIfServerIsRunning(Integer.parseInt(portNumber));
		if(!flag)
		{
			startAppiumService(portNumber).start();
			
		}
		return startAppiumService(portNumber);
	}

		@BeforeMethod
		@Parameters({"portNumber","appName"})
		public void  parallelCapabilities(String portNumber,String appName) throws MalformedURLException{
	
			startServer(portNumber);
			DesiredCapabilities cap = new DesiredCapabilities();
			File appDir = new File("D:\\Users\\Temp\\Desktop\\AppiumPractise\\AppiumStudy\\src\\test\\resources");
			File app;
			if(appName.equalsIgnoreCase("GeneralStoreApp")) {
			app = new File(appDir,"General-Store.apk");
			
			}
			else {
				app = new File(appDir,"ApiDemos-debug.apk");
			}
			
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidDevice");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			setDriver(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"),cap));		
		}
		
		
		public AppiumDriverLocalService startAppiumService(String portNumber) {
			AppiumDriverLocalService service;
			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder.withIPAddress("127.0.0.1");
			builder.usingPort(Integer.parseInt(portNumber));
			service = AppiumDriverLocalService.buildService(builder);
			return service;
			
		}
		
		@AfterMethod
		public void closeDriver() {
			getDriver().quit();
		}
	
}
