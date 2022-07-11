package bettervet.mobile.app.base;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseMethods {
	
	
	protected AndroidDriver<AndroidElement> driver;
	protected Logger log;

	@BeforeTest(alwaysRun = true)
	public void setCapabilities() throws MalformedURLException {
		
//		AndroidDriver<AndroidElement> driver;
		
		File appDir = new File("src/main/resources");
		File app = new File(appDir, "bettervet-staging.apk"); 	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S21");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");//new step
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability("platformName", "Android");
		caps.setCapability("appActivity", "com.bettervet.MainActivity");
		caps.setCapability("appPackage", "com.bettervet");
		caps.setCapability("setWebContentsDebuggingEnabled", true);
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println("App is up and running.");
		
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//		return driver;
	}
	
	@AfterTest(alwaysRun = true)
	public void shutDown() {
		driver.quit();
	}
	
	 public static void sleep(int s) {
		try { //to stop the thread for a couple of seconds
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
