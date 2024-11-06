package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TTicketInfoPage {
	WebDriver driver;

	public TTicketInfoPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "mouseArea_Title")
	private WebElement headerMsg;
	//input[@id='parentid']/following-sibling::img
	
	public WebElement getEditBtn() {
		return editBtn;
	}

	@FindBy(name = "Edit")
	private WebElement editBtn;
	
	public WebElement getTTicketHeaderMsg() {
		return headerMsg;
	}
	
	

}
