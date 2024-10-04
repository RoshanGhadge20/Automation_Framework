package Listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Test_Listners implements ITestListener 
{
	
	public void onstart(ITestResult result)
	{
		System.out.println("---- Test Get Started ---- ");
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Gets Failure :- "+ result.getName());
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Success :- "+result.getName());
	}
	
	public void onFinish(ITestResult result) 
	{
		System.out.println("------ Test Completed ------");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Gets Skipped  :- "+result.getName());
	}
}

