package Selenium.Started.Nov;

import org.apache.poi.ss.formula.functions.IfFunc;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailed implements IRetryAnalyzer{

	int maxretry = 3;
	int retryCount = 0;
	
	public boolean retry(ITestResult result) {
		
		if(!result.isSuccess()&& retryCount < maxretry){
			retryCount ++;
			return true	;
		}
		return false;
	}

}
