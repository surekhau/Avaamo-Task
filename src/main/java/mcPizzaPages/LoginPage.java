package mcPizzaPages;

import static core.PageFactory.Action.*;
import static core.PageFactory.Action.waitForElement;
import static core.PageFactory.GlobalConstants.*;
import static mcPizzaPages.WelcomePage.clickOnGetStartedButton;
import static mcPizzaPages.WelcomePage.openChatBot;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to switch frames
	 * @param driver
	 */
	public static void switchToIframe(WebDriver driver) {
		WebElement iframeAvaamo = driver.findElement(By.name("avaamoIframe"));
		driver.switchTo().frame(iframeAvaamo);
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to fill first name in chat bot
	 * @param driver
	 * @throws Exception
	 */
	public static void fillFirstName(WebDriver driver, String name) throws Exception{
		waitForElement(driver, firstNameTextbox);
		sendKeys(driver, firstNameTextbox, name);
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to fill email in chat bot
	 * @param driver
	 * @throws Exception
	 */
	public static void fillEmail(WebDriver driver, String email) throws Exception{
		waitForElement(driver, emailTextbox);
		sendKeys(driver, emailTextbox, email);
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click next button in chat bot
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnNextButton(WebDriver driver) throws Exception{
		waitForElement(driver, btnNext);
		click(driver, btnNext);
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify error message for wrong email
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyErrorMessageWithWrongEmail(WebDriver driver) throws Exception {
		mouseHover(driver, driver.findElement(emailTextbox));
		waitForElement(driver, errorMessage);
		String errorMessgageForWrongEmail = getText(driver, errorMessage);
		assertTrue("Unable to see error message", errorMessgageForWrongEmail.contains("Please enter valid Email"));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify welcome message after login
	 * @param driver
	 */
	public static void verifyWelcomeMessageAfterLogin(WebDriver driver) {
		waitForElement(driver, welcomeMessageAfterLogin);
		assertTrue("Unable to see welcome message after login", verifyElementPresent(driver, welcomeMessageAfterLogin));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to login into the chat bot
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyLogin(WebDriver driver) throws Exception {
		openChatBot(driver);
		clickOnGetStartedButton(driver);
		switchToIframe(driver);
		fillFirstName(driver, firstName);
		fillEmail(driver, email);
		clickOnNextButton(driver);
		verifyWelcomeMessageAfterLogin(driver);
	}


}
