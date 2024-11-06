package com.comcast.crm.listernerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryListenerImp implements IRetryAnalyzer {

int count=0;
int limitCount=5;
public boolean retry(ITestResult result) {
	// TODO Auto-generated method stub
	if(count<limitCount)
	{
		count++;
		return true;
		
		
	}
	
	return false;
}
}
