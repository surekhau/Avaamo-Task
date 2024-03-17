package mcPizzaTests;

import org.testng.annotations.Test;

import core.PageFactory.BaseTestCase;
import static mcPizzaPages.LoginPage.*;
import static mcPizzaPages.OrdersPage.*;

import static core.PageFactory.GlobalConstants.*;

public class TestOrderPage extends BaseTestCase{
	String foodType = "veg";
	String topping = "cheese";
	String crustType = "thin crust";
	String size = "Medium";
	
	@Test
	public void TestFailedOrderVegPizza() throws Exception {
		verifyLogin(driver);
		typeAQuestionInChatBox(driver);
		clickOnSendButton(driver);
		verifyQuestionsOrConfirmationFromBot(driver, wouldYouLikeToOrderQuestion);
		screenshot();
		selectVegOrNonVeg(driver, foodType);
		selectYourTopping(driver, topping);
		verifyQuestionsOrConfirmationFromBot(driver, "Great ! You have Selected "+topping+"");
		screenshot();
		selectThinCrust(driver);
		selectPizzaSize(driver, size);
		verifySelectedPizzaDetails(driver, foodType, topping, crustType, size);
		screenshot();
		verifyQuestionsOrConfirmationFromBot(driver, confirmOrderQuestion);
		confirmOrder(driver, "No");
		verifyQuestionsOrConfirmationFromBot(driver, tryAgainQuestion);
		screenshot();
		confirmOrder(driver, "yes");
	}
	
	@Test
	public void TestContinueOrderVegPizza() throws Exception {
		verifyLogin(driver);
		typeAQuestionInChatBox(driver);
		clickOnSendButton(driver);
		verifyQuestionsOrConfirmationFromBot(driver, wouldYouLikeToOrderQuestion);
		screenshot();
		selectVegOrNonVeg(driver, foodType);
		selectYourTopping(driver, topping);
		verifyQuestionsOrConfirmationFromBot(driver, "Great ! You have Selected "+topping+"");
		selectThinCrust(driver);
		screenshot();
		selectPizzaSize(driver, size);
		verifySelectedPizzaDetails(driver, foodType, topping, crustType, size);
		verifyQuestionsOrConfirmationFromBot(driver, confirmOrderQuestion);
		confirmOrder(driver, "Yes");
		screenshot();
		verifyQuestionsOrConfirmationFromBot(driver, orderPlacedMessage);
		clickOnBtnThumbsDown(driver);
		fillFeedbackForThumbsDown(driver);
		clickOnSubmit(driver);
		screenshot();
		verifyAfterSelectedThumbsDown(driver);
	}
	
	@Test
	public void TestContinueOrderNonVegPizza() throws Exception {
		foodType = "non-veg";
		topping = "bacon";
		size = "Large";
		verifyLogin(driver);
		typeAQuestionInChatBox(driver);
		clickOnSendButton(driver);
		verifyQuestionsOrConfirmationFromBot(driver, wouldYouLikeToOrderQuestion);
		screenshot();
		selectVegOrNonVeg(driver, foodType);
		selectYourTopping(driver, topping);
		verifyQuestionsOrConfirmationFromBot(driver, "Great ! You have Selected "+topping+"");
		selectThinCrust(driver);
		screenshot();
		selectPizzaSize(driver, size);
		verifySelectedPizzaDetails(driver, foodType, topping, crustType, size);
		verifyQuestionsOrConfirmationFromBot(driver, confirmOrderQuestion);
		screenshot();
		confirmOrder(driver, "Yes");
		verifyQuestionsOrConfirmationFromBot(driver, orderPlacedMessage);
		clickOnBtnThumbsUP(driver);
		fillFeedbackForThumbsUp(driver);
		screenshot();
		clickOnSubmit(driver);
		verifyAfterSelectedThumbsUp(driver);
	}

}
