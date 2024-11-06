package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage {
	WebDriver driver;

	public LeadsInfoPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "mouseArea_Last Name")
	private WebElement lastnameMsg;
	
	
	@FindBy(id = "dtlview_Company")
	private WebElement compnameMsg;
	
	public WebElement getlastnameMsg() {
		return lastnameMsg;
	}
	
	public WebElement getcompanyMsg() {
		return compnameMsg;
	}
	
	

}
