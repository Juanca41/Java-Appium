package bettervet.mobile.app.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomeScreen extends BaseObject{
	
	public WelcomeScreen(AndroidDriver driver, Logger log) {
		super(driver, log);
	}
	
	By loading_screen = (By.id("com.bettervet:id/bootsplash_layout_id"));
	By welcome_screen_title = (By.xpath("//android.widget.TextView[@text='Experience better vet care from home']"));
//	AndroidElement title = driver.findElementByAndroidUIAutomator("text(\"Experience better vet care from home\")");
	By welcome_screen_subtitle = (By.xpath("//android.widget.TextView[@text='No more commuting. Get the care your pet needs from the safety and comfort of your home.']"));
	By have_account = (By.xpath("//android.widget.TextView[@text='Already have an account?']"));
	By sign_up_button = (By.xpath("//android.widget.TextView[@text='Sign Up']"));
	By login_button = (By.xpath("//android.widget.TextView[@text='Login']"));
	
	public void assertTexts() {
		assert_text(welcome_screen_title, "Experience better vet care from home");
		assert_text(welcome_screen_subtitle, "No more commuting. Get the care your pet needs from the safety and comfort of your home.");
		assert_text(have_account, "Already have an account?");
	}

	public void goToLoginScreen() {
		assertTexts();
		while(check_if_element_is_present(login_button) == true) {
			System.out.println("Login button is still present.");
			click(login_button);
			System.out.println("Login button was clicked.");
			if(check_if_element_is_present(login_button) == false) {
				break;
			}
		}
		
	}
	
//	@AndroidFindBy(xpath="//android.widget.TextView[@text='Login']")
//	public AndroidElement login_button;

}
