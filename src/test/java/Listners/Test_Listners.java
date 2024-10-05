package Listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import CommonUtilities.Testutils;

public class Test_Listners implements ITestListener 
{
	Testutils util;
	
	public void onstart(ITestResult result)
	{
		System.out.println("---- Test Get Started ---- ");
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Gets Failure :- "+ result.getName());
		try {
			util.TakeScreenShot();
		} catch (IOException e) 
		{
			System.out.println("Throwing Exception while taking screenshot from failed method "+e.getMessage());
		}
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

