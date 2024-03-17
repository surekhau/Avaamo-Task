package core.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	public static TestName testName = new TestName();
	public static WebDriverWait webDriverWait;
	

	/**
	 * Author: Surekha Description: Waits for the element to be loaded
	 */
	public static void waitFor(WebDriver driver, By by) {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Waiting for Element with id " + by.toString());
		webDriverWait = new WebDriverWait(driver, 90);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	/**
	 * Author: Surekha Description: this is used to mouse hover on the element
	 */
	public static void mouseHover(WebDriver driver, WebElement element) {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Waiting for Element with id " + element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	/**
	 * Author: Surekha Description: Wait for the element 2 seconds in a loop if
	 * the element is present then it will continue
	 */
	public static void waitForElement(WebDriver driver, By by) {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Waiting for Element with id " + by.toString());
		for (int i = 0; i <= 20; i++) {
			if (!verifyElementPresent(driver, by)) {
				waitTill(2000);
			} else {
				break;
			}

		}
	}


	/**
	 * @author: Surekha
	 * @desc: This function verify if the element is present. It returns true if
	 *        the element is present and returns false if the element is not
	 *        present
	 */
	public static boolean verifyElementPresent(WebDriver driver, By by) {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Verifying for element to be present " + by.toString());
		try {
			if (driver.findElement(by).isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Author:surekha Description:This function verify if the element is not
	 * present It throw an exception if the element is present and returns true
	 * if the element is not present
	 */
	public static boolean verifyElementNotPresent(WebDriver driver, By by) {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "verifying for element not to be present on page soruce" + by.toString());
		try {
			driver.findElement(by);
			throw new Exception("Element founded");
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * @author: SUREKHA
	 * @desc: This Function get the first web element
	 * @param driver
	 * @param by
	 * @return
	 */

	public static WebElement getWebElement(WebDriver driver, By by) {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Reading Element " + by.toString());
		WebElement ele = driver.findElement(by);
		return ele;
	}

	/**
	 * @author SUREKHA
	 * @desc: This function clicks an element
	 * @param driver
	 * @param by
	 * @throws Exception
	 */

	public static void click(WebDriver driver, By by) throws Exception {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		try {
			getWebElement(driver, by).click();
		} catch (Exception e) {
			log(callerInfo, "Element Not displayed" + by);
			throw e;
		}
		log(callerInfo, "On Page " + driver.getCurrentUrl());
	}
	
	/**
	 * @author SUREKHA
	 * @desc: This function jsclicks an element
	 * @param driver
	 * @param by
	 * @throws Exception
	 */

	public static void jsClick(WebDriver driver, By by) throws Exception {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		try {
			waitFor(driver, by);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", getWebElement(driver, by));
		} catch (Exception e) {
			log(callerInfo, "Element Not displayed" + by);
			throw e;
		}
		log(callerInfo, "On Page " + driver.getCurrentUrl());
	}

	/**
	 * @author: Surekha
	 * @desc: This function clears the text present in the element specified
	 */
	public static void clear(WebDriver driver, By by) throws Exception {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Clearing the element " + by.toString());
		waitUntillElementIsPresent(driver, by);
		driver.findElement(by).clear();
	}

	/**
	 * @author:Surekha
	 * @desc:This function send the text to the textbox specified
	 */
	public static void sendKeys(WebDriver driver, By by, String text) throws Exception {
		waitFor(driver, by);
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Send keys to the element " + by.toString() + " and text " + text);
		driver.findElement(by).sendKeys(text);
	}

	/**
	 * @author: Surekha
	 * @desc: This function select an element in dropdown by using visible text
	 */

	public static void selectFromDropDown(WebDriver driver, By by, String option) {
		Select droplist = new Select(getWebElement(driver, by));
		droplist.selectByVisibleText(option);
	}

	/**
	 * @author: Surekha
	 * @desc: This function getText of an webelement
	 * 
	 */

	public static String getText(WebDriver driver, By by) throws Exception {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Get text of the element " + by.toString());
		waitUntillElementIsPresent(driver, by);
		return driver.findElement(by).getText();
	}
	
	/**
	 * @author: Surekha
	 * @desc: This function attribute value of an webelement
	 * 
	 */

	public static String getAttributeValue(WebDriver driver, By by, String value) throws Exception {
		StackTraceElement caller = new Throwable().getStackTrace()[1];
		String callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		log(callerInfo, "Get text of the element " + by.toString());
		waitUntillElementIsPresent(driver, by);
		return driver.findElement(by).getAttribute(value);
	}

	/**
	 * @author: Surekha
	 * @desc: This function prints the data to the console and logs the data in
	 *        the log file
	 */
	public static void log(String callerInfo, String msg) {
		if (callerInfo == null) {
			StackTraceElement caller = new Throwable().getStackTrace()[1];
			callerInfo = caller.getClassName() + " " + caller.getMethodName() + " line " + caller.getLineNumber();
		}
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.print("--->" + sdf.format(cal.getTime()) + " ");
		System.out.println(callerInfo + " | " + msg);
	}

	/**
	 * @author: Surekha
	 * @Desc: browser waits for specified time
	 * @params: long << time
	 */
	public static void waitTill(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	}

	/**
	 * Author: Surekha Description: Wait untill the element is present
	 */
	public static void waitUntillElementIsPresent(WebDriver driver, By by) throws Exception {
		for (int i = 0; i < 20; i++) {
			try {
				driver.findElement(by);
				break;
			} catch (Exception ex) {
				waitTill(1000);
			}
		}
	}

	
}
