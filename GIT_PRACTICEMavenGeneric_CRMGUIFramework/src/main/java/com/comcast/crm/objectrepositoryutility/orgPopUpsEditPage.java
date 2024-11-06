package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class orgPopUpsEditPage {

	WebDriver driver;

	public orgPopUpsEditPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchText;

	@FindBy(name = "search")
	private WebElement searchBtn;

	

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public void seacrForOrg(String searchOrg)
	{
		searchText.sendKeys(searchOrg);
		searchBtn.click();
		
		
	}
	
}
