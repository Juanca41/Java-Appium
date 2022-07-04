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
		
		welcome_screen.assertTexts();
//		welcome_screen.goToLoginScreen();
		
		
		while(login_screen.inLoginPage() ==false) {
			welcome_screen.goToLoginScreen();
		}
		
		login_screen.LoginProcess(username, password);
		
	}
}
