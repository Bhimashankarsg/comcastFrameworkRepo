package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class calenderPopUpsPage {

	WebDriver driver;

	public calenderPopUpsPage(WebDriver driver) // Rule-3: Object Initialization
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "subject")
	private WebElement eventText;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//b[text()='Event starts at']/parent::td/parent::tr/following-sibling::tr/td/select")
	private WebElement sthour;
	@FindBy(xpath = "//b[text()='Event starts at']/parent::td/parent::tr/following-sibling::tr/td/select[2]")
	private WebElement stmin;
	@FindBy(xpath = "//b[text()='Event starts at']/parent::td/parent::tr/following-sibling::tr/td/select[3]")
	private WebElement stimestmp;
	@FindBy(xpath = "//b[text()='Event ends on']/parent::td/parent::tr/following-sibling::tr/td/select")
	private WebElement endhour;
	@FindBy(xpath = "//b[text()='Event ends on']/parent::td/parent::tr/following-sibling::tr/td/select/following-sibling::select[1]")
	private WebElement endmin;
	@FindBy(xpath = "//b[text()='Event ends on']/parent::td/parent::tr/following-sibling::tr/td/select/following-sibling::select[2]")
	private WebElement etimestmp;
	
	@FindBy(name="eventsave")
	private WebElement eventcalsave;

	public WebElement getCalEventSave() {
		return eventcalsave;
	}
	
	public WebElement getSthour() {
		return sthour;
	}

	public WebElement getStmin() {
		return stmin;
	}

	public WebElement getStimestmp() {
		return stimestmp;
	}

	public WebElement getEndhour() {
		return endhour;
	}

	public WebElement getEndmin() {
		return endmin;
	}

	public WebElement getEtimestmp() {
		return etimestmp;
	}

	public WebElement geteventText() {
		return eventText;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void sendeventname(String evenname) {
		eventText.sendKeys(evenname);

	}
	
	public void selectstarthour(String hour)
	{
		Select starthr = new Select(sthour);
		starthr.selectByVisibleText(hour);

	}
	public void selectstartmin(String min)
	{
		Select starthr = new Select(stmin);
		starthr.selectByVisibleText(min);

	}
	public void selectstarttimestmp(String timestmp)
	{
		Select starthr = new Select(stimestmp);
		starthr.selectByVisibleText(timestmp);

	}
	public void selectendhour(String hour)
	{
		Select starthr = new Select(endhour);
		starthr.selectByVisibleText(hour);

	}
	public void selectendmin(String min)
	{
		Select starthr = new Select(endmin);
		starthr.selectByVisibleText(min);

	}
	public void selectendtimestmp(String timestmp)
	{
		Select starthr = new Select(etimestmp);
		starthr.selectByVisibleText(timestmp);

	}

}
