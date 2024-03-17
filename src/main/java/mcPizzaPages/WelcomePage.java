package mcPizzaPages;

import static org.junit.Assert.assertTrue;


import static core.PageFactory.Action.verifyElementPresent;
import static core.PageFactory.Action.waitForElement;
import static core.PageFactory.Action.getText;
import static core.PageFactory.Action.click;


import static core.PageFactory.GlobalConstants.botAvatar;
import static core.PageFactory.GlobalConstants.welcomeNotification;
import static core.PageFactory.GlobalConstants.closePopup;
import static core.PageFactory.GlobalConstants.welcomeMessage;
import static core.PageFactory.GlobalConstants.btnGetStarted;


import org.openqa.selenium.WebDriver;

public class WelcomePage {

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify bot in the page
	 * @param driver
	 */
	public static void verifyBotAvatar(WebDriver driver) {
		waitForElement(driver, botAvatar);
		assertTrue("Unable to see Bot", verifyElementPresent(driver, botAvatar));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify welcome notification in the page
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyWelcomeNotification(WebDriver driver) throws Exception {
		waitForElement(driver, welcomeNotification);
		String notificationMessage = getText(driver, welcomeNotification);
		assertTrue("Unable to see welcome message", notificationMessage.contains("McPizza")&&notificationMessage.contains("Welcome to Pizza Shoppe"));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to close welcome popup in the page
	 * @param driver
	 * @throws Exception
	 */
	public static void closeWelcomePopup(WebDriver driver) throws Exception {
		waitForElement(driver, closePopup);
		click(driver, closePopup);
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to open chat bot
	 * @param driver
	 * @throws Exception
	 */
	public static void openChatBot(WebDriver driver) throws Exception {
		waitForElement(driver, botAvatar);
		click(driver, botAvatar);
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify welcome message after open the chat bot
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyWelcomePage(WebDriver driver) throws Exception {
		waitForElement(driver, welcomeMessage);
		String welcomeMssg = getText(driver, welcomeMessage);
		assertTrue("Unable to see welcome message", welcomeMssg.equalsIgnoreCase("Welcome to Pizza Shoppe"));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify get started button in chat bot
	 * @param driver
	 */
	public static void verifyGetStartedButton(WebDriver driver){
		waitForElement(driver, btnGetStarted);
		assertTrue("Unable to see Get Started Button", verifyElementPresent(driver, btnGetStarted));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click the get started button
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnGetStartedButton(WebDriver driver) throws Exception{
		waitForElement(driver, btnGetStarted);
		click(driver, btnGetStarted);
	}
	
}