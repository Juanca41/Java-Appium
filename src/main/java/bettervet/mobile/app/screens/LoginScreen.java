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
	By other_sign_in_options = (By.xpath("//android.widget.TextView[@text='View other sign in options']"));
	By email_field = (By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.EditText"));
	By pwd_field = (By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.EditText"));
	By login_button = (By.xpath("//android.widget.TextView[@text='Log In']"));
	By incorrect_email_pwd_text = (By.xpath("//android.widget.TextView[@text='User or password invalid.']"));
	By incorrect_email_pwd_ok_button = (By.xpath("//android.widget.Button[@text='OK']"));
	By invalid_format_pwd = (By.xpath("//android.widget.TextView[@text='Your password must contain at least one number, a capital letter and a minimum of 6 characters']"));
	By invalid_format_email = (By.xpath("//android.widget.TextView[@text='Please enter a valid email address']"));
	By field_required_error = (By.xpath("//android.widget.TextView[@text='This field is required']"));
	By error_message_element = (By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView"));
	
	public Boolean inLoginPage() {
		return check_if_element_is_present(login_screen_title);
	}
	
	public void assertTexts() {
		assert_text(login_screen_title, "Welcome Back");
		assert_text(remember_me, "Remember Me");
		assert_text(forgot_password, "Forgot your password?");
		assert_text(other_sign_in_options, "View other sign in options");
	}
	
	public void loginProcess(String username, String password) {
		assertTexts();
		type(email_field, username);
		type(pwd_field, password);
		clickLoginButton();
	}
	
	public void positiveLoginProcess(String username, String password) {
		loginProcess(username, password);
		
	}
	
	public void negativeLoginProcessWithIncorrectCredentials() {
		loginProcess("juancarlosgularte@bettervet.com", "Incorrect10");
		assert_text(incorrect_email_pwd_text, "User or password invalid.");
	}
	
	public void negativeLoginProcess(String username, String password, String error) {
		loginProcess(username, password);
		assert_text(error_message_element, error);
	}
	

	public void clickLoginButton() {
		
		click(login_button);
	}

}
