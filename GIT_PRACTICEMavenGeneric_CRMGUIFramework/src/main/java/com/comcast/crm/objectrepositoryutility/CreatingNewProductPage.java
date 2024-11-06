package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewProductPage {

	WebDriver driver;

	public CreatingNewProductPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement prodNameEdit;

	@FindBy(name="button")
	private WebElement saveBtn;
	
	

	public WebElement getProdNameEdit() {
		return prodNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createProd(String prodName) {
		prodNameEdit.sendKeys(prodName);
		saveBtn.click();
	}

	

}
