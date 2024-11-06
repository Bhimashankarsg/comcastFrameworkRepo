package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewLeadsPage {

	WebDriver driver;

	public CreatingNewLeadsPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	
	@FindBy(name = "company")
	private WebElement companyNameEdit;

	@FindBy(name="button")
	private WebElement saveBtn;
	
	

	

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createLeads(String lastName,String compName) {
		lastNameEdit.sendKeys(lastName);
		companyNameEdit.sendKeys(compName);
		saveBtn.click();
		
	}


	

}
