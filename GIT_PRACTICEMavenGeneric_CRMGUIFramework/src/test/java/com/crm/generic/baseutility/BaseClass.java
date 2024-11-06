package com.crm.generic.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	@BeforeSuite
	public void configBS()
	{
		System.out.println("=== connect to DB , report config  BS ===");
	}
	
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("=====Launch Browser BC=======");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("=== Login to application BM=====");
	}

	@AfterMethod
	public void configAM() {
		System.out.println("==== Logout AM =====");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("==== close the Browser AC======");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("=== close DB, Report Backup AS ====");
	}
	
}
