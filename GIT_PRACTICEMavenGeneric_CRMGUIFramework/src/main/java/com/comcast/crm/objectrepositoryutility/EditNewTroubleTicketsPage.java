package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditNewTroubleTicketsPage {

	WebDriver driver;

	public EditNewTroubleTicketsPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='parentid']/following-sibling::img")
	private WebElement ticketNameEditdetails;

	@FindBy(name = "button")
	private WebElement saveBtn;
/**
 * 
 * @return ticketNameEditdetails
 * 
 * getTicketnameeditdetails() is invoked which return webelement
 */
	public WebElement getTicketNameEditdetails() {
		return ticketNameEditdetails;
	}
	
	
/**
 * @return saveBtn
 * 
 * save button which return webelement savebtn
 */
	public WebElement getSaveBtn() {
		return saveBtn;
	}



}
