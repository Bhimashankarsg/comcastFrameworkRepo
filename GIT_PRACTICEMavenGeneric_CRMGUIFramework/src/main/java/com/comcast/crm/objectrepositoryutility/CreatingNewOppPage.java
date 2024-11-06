package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOppPage {

	WebDriver driver;

	public CreatingNewOppPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "potentialname")
	private WebElement oppNameEdit;

	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='related_to_display']/following-sibling::img")
	private WebElement orgimgplus;

	public WebElement getOrgPlusImg() {
		return orgimgplus;
	}
	
	public WebElement getOppNameEdit() {
		return oppNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOpp(String oppName) {
		oppNameEdit.sendKeys(oppName);
		
	}

	

}
