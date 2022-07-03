package bettervet.mobile.app.test;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import bettervet.mobile.app.base.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FirstTest extends Base{
	
//	public FirstTest(AndroidDriver<AndroidElement> driver) {
//		super(driver);
//	}
		
//	AndroidDriver<AndroidElement> driver;
	
	@Test
	public void welcomeScreenTest() throws MalformedURLException{
		
//		driver = setCapabilities();
		
		//		driver.findElement(By.xpath("//android.view.ViewGroup[@text='Login']")).click();
		String title = driver.findElementByAndroidUIAutomator("text(\"Experience better vet care from home\")").getText();
		System.out.println(title);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String login_button_text = driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).getText();
		String sign_up_button_text = driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Up']")).getText();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Up']")).click();
		System.out.println(login_button_text);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Up']")).click();
		System.out.println("1");
		driver.findElement(By.xpath	("//android.widget.TextView[@text='Sign Up']")).click();
		System.out.println("2");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sign Up']")).click();
		System.out.println("3");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("4");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("5");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("6");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("7");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("8");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("9");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("10");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("11");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("12");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		System.out.println("13");
		System.out.println(login_button_text);
		System.out.println(sign_up_button_text);
		
	}
}
