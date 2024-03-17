package mcPizzaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import static core.PageFactory.Action.*;
import static core.PageFactory.GlobalConstants.*;
import static org.junit.Assert.assertTrue;

public class OrdersPage {
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to type question in chat box
	 * @param driver
	 * @throws Exception
	 */
	public static void typeAQuestionInChatBox(WebDriver driver) throws Exception {
		waitForElement(driver, queryTextbox);
		sendKeys(driver, queryTextbox, "I want to order a pizza");
		Reporter.log("<p>Successfully Send 'I want to order a pizza' to Bot</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on send button
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnSendButton(WebDriver driver) throws Exception {
		waitForElement(driver, btnSend);
		click(driver, btnSend);
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify any questions/confirmation according to the arguments
	 * @param driver
	 */
	public static void verifyQuestionsOrConfirmationFromBot(WebDriver driver,String question) {
		waitForElement(driver, By.xpath("//div[@class='message-wrap']//p[text()='"+question+"']"));
		assertTrue("unable to see question "+question+"",verifyElementPresent(driver, By.xpath("//div[@class='message-wrap']//p[text()='"+question+"']")));
		Reporter.log("<p>Succssfully see the "+question+"</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to select veg or non-veg according to given arguments
	 * @param driver
	 * @throws Exception
	 */
	public static void selectVegOrNonVeg(WebDriver driver, String foodType) throws Exception {
		waitForElement(driver, By.xpath("//a[text()='"+foodType+"']"));
		click(driver, By.xpath("//a[text()='"+foodType+"']"));
		Reporter.log("<p>Selected "+foodType+" pizza</P>");
	}

	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to select toppings according to given arguments
	 * @param driver
	 * @throws Exception
	 */
	public static void selectYourTopping(WebDriver driver, String topping) throws Exception {
		topping = topping+"_id";
		//waitForElement(driver, By.xpath("//input[@value='"+topping+"']"));
		jsClick(driver, By.xpath("//input[@value=\""+topping+"\"]"));
		click(driver, btnSubmit);
		Reporter.log("<p>Selected "+topping+"</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to select thin crust
	 * @param driver
	 * @throws Exception
	 */
	public static void selectThinCrust(WebDriver driver) throws Exception {
		waitForElement(driver, btnThinCrust);
		click(driver, btnThinCrust);
		Reporter.log("<p>Selected thin curst pizza</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to select pizza size according to the arguments
	 * @param driver
	 * @throws Exception
	 */
	public static void selectPizzaSize(WebDriver driver, String size) throws Exception {
		waitForElement(driver, By.xpath("//a[@title='"+size+"']"));
		click(driver, By.xpath("//a[@title='"+size+"']"));
		Reporter.log("<p>Selected "+size+" size pizza</P>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify all the pizza details after we entered and before confirmation
	 * @param driver
	 * @throws Exception
	 */
	public static void verifySelectedPizzaDetails(WebDriver driver,String foodType,String topping,String crustType,String size) throws Exception {
		size = size.toLowerCase();
		waitForElement(driver, selectedPizzaDetails);
		String details = getAttributeValue(driver, selectedPizzaDetails, "aria-label");
		assertTrue("Ordered details are not correct", details.contains("Your Pizza Will Look like this :")&&details.contains("Pizza Type :  "+foodType+"")&&details.contains("Toppings : "+topping+"")&&details.contains("Crust : "+crustType+"")&&details.contains("Size : "+size+""));
		Reporter.log("<p>Verified all selected details for Pizza</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to confirm order
	 * @param driver
	 * @throws Exception
	 */
	public static void confirmOrder(WebDriver driver, String confirmation) throws Exception {
		waitForElement(driver, By.xpath("//a[text()='"+confirmation+"']"));
		click(driver, By.xpath("//a[text()='"+confirmation+"']"));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on button thumbs up
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnBtnThumbsUP(WebDriver driver) throws Exception {
		waitForElement(driver, btnThumbsUp);
		click(driver, btnThumbsUp);
		Reporter.log("<p>Selected Thumbs UP to give feedback</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on thumbs down
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnBtnThumbsDown(WebDriver driver) throws Exception {
		waitForElement(driver, btnThumbsDown);
		click(driver, btnThumbsDown);
		Reporter.log("<p>Selected Thumbs Down to give feedback</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to fill feedback form for thumbs down
	 * @param driver
	 * @throws Exception
	 */
	public static void fillFeedbackForThumbsDown(WebDriver driver) throws Exception {
		waitForElement(driver, inputTextboxInThumbsDownFeedbackForm);
		sendKeys(driver, inputTextboxInThumbsDownFeedbackForm, "Testing");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to fill feedback form for thumbs up
	 * @param driver
	 * @throws Exception
	 */
	public static void fillFeedbackForThumbsUp(WebDriver driver) throws Exception {
		waitForElement(driver, inputSelectBoxInThumbsUpFeedbackForm);
		click(driver, inputSelectBoxInThumbsUpFeedbackForm);
		waitForElement(driver, selectOptionGood);
		click(driver, selectOptionGood);
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to click on submit in feedback form
	 * @param driver
	 * @throws Exception
	 */
	public static void clickOnSubmit(WebDriver driver) throws Exception {
		waitForElement(driver, btnSubmitInFeedbackForm);
		click(driver, btnSubmitInFeedbackForm);
		Reporter.log("<p>Submitted Feedback</p>");
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify thank you message after thumbs down feedback
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyAfterSelectedThumbsDown(WebDriver driver) throws Exception {
		waitForElement(driver, thumbsDownSelected);
		assertTrue("Unable to select thumbs down", verifyElementPresent(driver, thumbsDownSelected));
		String messageThankYou = getText(driver, thankYouMessageAfterThumbsDownFeedback);
		assertTrue("Unable to see thank you message after submiting feedback for thumbsdown", messageThankYou.equalsIgnoreCase("Thank You for Your Valuable Feedback"));
	}
	
	/**
	 * @author: SUREKHA
	 * @Desc: This function is used to verify thank you message after thumbs up feedback
	 * @param driver
	 * @throws Exception
	 */
	public static void verifyAfterSelectedThumbsUp(WebDriver driver) throws Exception {
		waitForElement(driver, thumbsUpSelected);
		assertTrue("unable to select thumbs up", verifyElementPresent(driver, thumbsUpSelected));
		String messageThankYou = getText(driver, thankYouMessageAfterThumbsUpFeedback);
		assertTrue("Unable to see thank you message after submiting feedback for thumbsup", messageThankYou.equalsIgnoreCase("Thank You for Your Support"));
	}
	
}
