package mcPizzaTests;

import org.testng.annotations.Test;

import core.PageFactory.BaseTestCase;
import static mcPizzaPages.LoginPage.*;
import static mcPizzaPages.WelcomePage.openChatBot;

import static mcPizzaPages.WelcomePage.clickOnGetStartedButton;
import static core.PageFactory.GlobalConstants.*;

public class TestLoginPage extends BaseTestCase {

	@Test
	public void testLoginWithWrongEmail() throws Exception {
		String email = "surekha.ummadi";
		openChatBot(driver);
		clickOnGetStartedButton(driver);
		switchToIframe(driver);
		fillFirstName(driver, firstName);
		fillEmail(driver, email);
		clickOnNextButton(driver);
		verifyErrorMessageWithWrongEmail(driver);
	}
	
	
	@Test
	public void testLogin() throws Exception {
		verifyLogin(driver);
	}

}
