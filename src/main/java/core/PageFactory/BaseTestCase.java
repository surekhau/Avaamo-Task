package core.PageFactory;

import static core.PageFactory.GlobalConstants.baseUrl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(CustomListner.class)
public class BaseTestCase extends TestListenerAdapter{
	static String method;
	public static WebDriver driver;
	static String path = System.getProperty("user.dir");
	public static String CHROMEpATH = path+"\\drivers\\chromedriver.exe";

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println(path);
		System.out.println(CHROMEpATH);
		System.setProperty("webdriver.chrome.driver", CHROMEpATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(baseUrl);
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		screenshot();
		System.out.println("END : " + this.getClass().getSimpleName());
		System.out.println("---------------ENDED BROWSER----------------------");
		driver.quit();
	}
	
	public static void screenshot() {
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss.SSS");

		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports"; 
		File destFile=new File((String) reportDirectory+"/failure_screenshots/"+driver.getTitle()+"_"+formater.format(calendar.getTime())+".png");
		 FileUtils.copyFile(srcFile, destFile);
		 Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		}catch (IOException e) {
            e.printStackTrace();
        }
		 
	}

	public static void takeScreenshot (ITestResult result) {
		String methodName = result.getName();
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss.SSS");
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                File destFile = new File((String) reportDirectory+"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
            	Reporter.log("Test Result: PASS",true);
                e.printStackTrace();
            }
        }else {
        	try {
				screenshot();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
	
	
}
