package kamlanadh.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	byte count=0;
	byte maxTry=1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxTry)
		{
			count++;
			return true;
		}
		
		
		return false;
	}

	
}
