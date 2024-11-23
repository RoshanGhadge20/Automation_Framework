package Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer 
{

	int count=0;
	int max_retry=2;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if (!result.isSuccess() )
		{
		if (count<=max_retry)
		{
			count++;
			System.out.println("Retrying Test:- "+ result.getName() + "Retry Time:- "+ this.count);
			return true;
		}
		}
		return false;
	}

}
