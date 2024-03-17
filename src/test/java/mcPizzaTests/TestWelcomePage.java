package mcPizzaTests;

import static mcPizzaPages.WelcomePage.verifyBotAvatar;
import static mcPizzaPages.WelcomePage.verifyWelcomeNotification;
import static mcPizzaPages.WelcomePage.closeWelcomePopup;
import static mcPizzaPages.WelcomePage.openChatBot;
import static mcPizzaPages.WelcomePage.verifyWelcomePage;
import static mcPizzaPages.WelcomePage.verifyGetStartedButton;
import org.testng.annotations.Test;

import core.PageFactory.BaseTestCase;

public class TestWelcomePage extends BaseTestCase {
	
	@Test
	public void testVerifyWelcomeMessage() throws Exception {
		verifyBotAvatar(driver);
		verifyWelcomeNotification(driver);
		closeWelcomePopup(driver);
	}
	
	@Test
	public void verifyWelcomeScreenAfterOpeningChatBotAndBeforeLogin() throws Exception {
		openChatBot(driver);
		verifyWelcomePage(driver);
		verifyGetStartedButton(driver);
	}

}
