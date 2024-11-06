package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppInfoPage {
	WebDriver driver;

	public OppInfoPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headeroppMsg;
	
	
	@FindBy(xpath = "//a[@title='Organizations']")
	private WebElement headerorgMsg;
	

	public WebElement getOppHeaderMsg() {
		return headeroppMsg;
	}
	
	public WebElement getOrgHeaderMsg() {
		return headerorgMsg;
	}
	
	

}
