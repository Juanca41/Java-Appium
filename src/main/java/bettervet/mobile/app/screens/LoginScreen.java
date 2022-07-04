package bettervet.mobile.app.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginScreen extends BaseObject{
	
	public LoginScreen(AndroidDriver<AndroidElement> driver, Logger log) {
		super(driver, log);
	}
	
	public By login_screen_title = (By.xpath("//android.view.View[@text='Welcome Back']"));
	By remember_me = (By.xpath("//android.widget.TextView[@text='Remember Me']"));
	By forgot_password = (By.xpath("//android.widget.TextView[@text='Forgot your password?']"));
	By other_sign_in_options = (By.xpath("//android.view.View[@text='View other sign in options']"));
	By email_field = (By.xpath("//android.view.ViewGroup[2]/android.widget.EditText"));
	By pwd_field = (By.xpath("//android.view.ViewGroup[3]/android.widget.EditText"));
	By login_button = (By.xpath("//android.widget.TextView[@text='Log In']"));
	
	
	public Boolean inLoginPage() {
		return check_if_element_is_present(login_screen_title);
	}
	
	public void assertTexts() {
		assert_text(login_screen_title, "Welcome Back");
		assert_text(remember_me, "Remember Me");
		assert_text(forgot_password, "Forgot your password?");
		assert_text(other_sign_in_options, "View other sign in options");
	}
	
	public void LoginProcess(String username, String password) {
		assertTexts();
		type(email_field, username);
		type(pwd_field, password);
		clickLoginButton();
	}

	public void clickLoginButton() {
		
		click(login_button);
	}

}
