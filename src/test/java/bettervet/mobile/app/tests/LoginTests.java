package bettervet.mobile.app.tests;
import java.net.MalformedURLException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import bettervet.mobile.app.base.BaseMethods;
import bettervet.mobile.app.screens.LoginScreen;
import bettervet.mobile.app.screens.WelcomeScreen;

public class LoginTests extends BaseMethods{
	
//	public FirstTest(AndroidDriver<AndroidElement> driver) {
//		super(driver);
//	}
		
//	AndroidDriver<AndroidElement> driver;
	
	@Parameters({ "username", "password" })
	@Test
	public void positiveLogin(String username, String password) throws MalformedURLException{
		
//		driver = setCapabilities();
		
		WelcomeScreen welcome_screen = new WelcomeScreen(driver, log);
		LoginScreen login_screen = new LoginScreen(driver, log);
		
//		welcome_screen.assertTexts();
		welcome_screen.goToLoginScreen();
		
//		while(true) {
//			welcome_screen.goToLoginScreen();
//			if(login_screen.inLoginPage()==true) {
//				break;
//			}
//		}
		
		login_screen.positiveLoginProcess(username, password);
		
	}
	
	@Test
	public void negativeLoginWithInvalidCredentials() throws MalformedURLException{
		
		WelcomeScreen welcome_screen = new WelcomeScreen(driver, log);
		LoginScreen login_screen = new LoginScreen(driver, log);
		
		welcome_screen.goToLoginScreen();
		login_screen.negativeLoginProcessWithIncorrectCredentials();;
		
	}
	
	@Parameters({ "username", "password", "error" })
	@Test
	public void negativeLoginErrors(String username, String password, String error) throws MalformedURLException{
		
		WelcomeScreen welcome_screen = new WelcomeScreen(driver, log);
		LoginScreen login_screen = new LoginScreen(driver, log);
		
		welcome_screen.goToLoginScreen();
		login_screen.negativeLoginProcess(username, password, error);
		
	}
}
