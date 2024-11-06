package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {// Rule-1: Create a Seperate Java Class
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver)	// Rule-3: Object Initialization
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name = "user_name")					// Rule-2 : Object Creation
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	

	public WebElement getUsernameEdit() {		// Rule-4:Object Encapsulation
		return usernameEdit;					//Rule-5 : Object Utilization
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	

	public void loginToApp(String username, String password) {
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);

		loginBtn.click();
	}
	
	public void loginToApp(String url,String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);

		loginBtn.click();
	}

	
}
