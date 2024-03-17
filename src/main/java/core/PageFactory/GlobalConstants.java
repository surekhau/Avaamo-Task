package core.PageFactory;//span[@id='lnkName' and text()='at_011']

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GlobalConstants {
	static String path = System.getProperty("user.dir");
	
	public static String CHROMEpATH = path+"\\drivers\\chromedriver.exe";
	public static String baseUrl = "https://c0.avaamo.com/web_channels/cce5f713-c1f4-4666-8976-b091299cda81/demo.html?banner=true&demo=true&banner_text=%20&banner_title=This%20is%20how%20the%20chat%20agent%20shows%20up";
	public static String firstName = "Surekha";
	public static String email = "surekha.ummadi@gmail.com";
	public static String wouldYouLikeToOrderQuestion = "We have a wide variety of freshly backed pizza . What would you like to Order ?";
	//public static String selectedToppingMessage = "Great ! You have Selected cheese";
	public static String confirmOrderQuestion = "Would you like to confirm the order?";
	public static String tryAgainQuestion = "Would You Like to Try Again ?";
	public static String orderPlacedMessage = "CONGRATS ! ORDER PLACED .";
	
	//bot before opening
	public static By botAvatar = By.xpath("//a[@class='avm-bot-avatar']");
	public static By welcomeNotification = By.xpath("//div[contains(@class,'welcome-notification')]");
	public static By closePopup = By.xpath("//a[@title='Close welcome popup']");
	
	//bot after opening
	public static By welcomeMessage = By.xpath("//div[@class='welcome-message']");
	public static By btnGetStarted = By.xpath("//a[text()='Get Started']");
	
	//login page
	public static By firstNameTextbox = By.xpath("//input[@id='first_name']");
	public static By emailTextbox = By.xpath("//input[@id='email']");
	public static By btnNext = By.xpath("//button[text()='Next']");
	public static By errorMessage = By.xpath("//div[@id='errors']");
	
	
	//order page
	public static By welcomeMessageAfterLogin = By.xpath("//p[text()='Welcome to McPizza Booking Journey']");
	public static By queryTextbox = By.id("queryTextbox");
	public static By btnSend = By.xpath("//button[@data-ele-name='send']");
	public static By btnSubmit = By.xpath("//button[@class='btn default_card_submit']");
	public static By btnThinCrust = By.xpath("//div[@aria-label='Thin Crust. ']//a[text()='Thick Crust']");
	public static By selectedPizzaDetails = By.xpath("//div[@class='conversation-item clearfix not-mine' and contains(@aria-label,'Bot sent, Text. Your')]");
	public static By btnThumbsUp = By.xpath("//button[contains(@class,'thumbs-up')]");
	public static By btnThumbsDown = By.xpath("//button[contains(@class,'thumbs-down')]");
	
	
	public static By inputTextboxInThumbsDownFeedbackForm = By.xpath("//input[@aria-label='Feedback to improve']");
	public static By btnSubmitInFeedbackForm = By.xpath("//div[@class='default_card_input']//button[text()='Submit']");
	public static By thumbsDownSelected = By.xpath("//button[contains(@class,'thumbs-down-selected')]");
	public static By thankYouMessageAfterThumbsDownFeedback = By.xpath("//div[@data-ele-name='feedback_sent']");
	
	public static By inputSelectBoxInThumbsUpFeedbackForm = By.xpath("//input[contains(@class,'textbox picklist')]");
	public static By selectOptionGood = By.xpath("//ul[@class='list picklist']//li[text()='Good']");
	public static By thumbsUpSelected = By.xpath("//button[contains(@class,'thumbs-up-selected')]");
	public static By thankYouMessageAfterThumbsUpFeedback = By.xpath("//div[@data-ele-name='feedback_sent']");
	
	
	
	
}