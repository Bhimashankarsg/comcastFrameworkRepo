package com.comcast.crm.assertUtility;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class assertUtility {

	public void softAssert(String actparam, String expparam) {
		// TODO Auto-generated method stub
		SoftAssert softObj = new SoftAssert();

		boolean status = actparam.contains(expparam);
		softObj.assertTrue(status);
		softObj.assertAll();
	}

	public void hardAssert(String actparam, String expparam) {

		// TODO Auto-generated method stub
		boolean status = actparam.contains(expparam);
		Assert.assertTrue(status);

	}
}
