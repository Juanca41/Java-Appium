package bettervet.mobile.app.base;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseMethods {
	
	
	protected AndroidDriver driver;
	protected Logger log;
	AppiumDriverLocalService appium;

	@BeforeClass(alwaysRun = true)
	public void setCapabilities() throws MalformedURLException {
		
//		AndroidDriver<AndroidElement> driver;
		appium = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
//				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
//				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
				.withArgument(() -> "--base-path", "/wd/hub")
				.build();
		
		appium.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // Tell builder where node is installed. Or set this path in an environment variable named NODE_PATH
//        builder.usingDriverExecutable(new File("/usr/local/bin/node"));
        // Tell builder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
//        builder.withIPAddress("127.0.0.1");
//        builder.usingPort(4723);
        
//        boolean isAppiumRunning = checkIfServerIsRunning(4723);
        
//        if(isAppiumRunning == false) {
//        	appium = AppiumDriverLocalService.buildService(builder);
//            appium.start();
//            
//            Thread.sleep(15000);
//        }
		
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
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		System.out.println("App is up and running.");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		return driver;
	}
	
	@AfterTest(alwaysRun = true)
	public void shutDown() {
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void stopAppium() {
		appium.stop();
	}	
	
	 public static void sleep(int s) {
		try { //to stop the thread for a couple of seconds
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 
	 public static boolean checkIfServerIsRunning(int port) {
			
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
}
