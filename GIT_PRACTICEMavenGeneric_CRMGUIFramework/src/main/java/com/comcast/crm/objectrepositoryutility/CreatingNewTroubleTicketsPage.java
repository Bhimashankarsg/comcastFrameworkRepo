package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewTroubleTicketsPage {

	WebDriver driver;

	public CreatingNewTroubleTicketsPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name='ticket_title']")
	private WebElement ticketNameEdit;

	@FindBy(name = "button")
	private WebElement saveBtn;

	public WebElement getTicketNameEdit() {
		return ticketNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createTTicket(String ticktName) {
		ticketNameEdit.sendKeys(ticktName);
		saveBtn.click();
	}

}
