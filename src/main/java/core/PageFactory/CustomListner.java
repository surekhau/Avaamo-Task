package core.PageFactory;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner extends BaseTestCase implements ITestListener{
		
    
	@Override
	public void onTestFailure(ITestResult result) {
		takeScreenshot(result);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		takeScreenshot(result);
	}
	
	@Override		
	public void onTestFailedButWithinSuccessPercentage(ITestResult result){		
		takeScreenshot(result);
	}	

}
