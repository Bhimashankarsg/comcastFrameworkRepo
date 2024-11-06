package com.comcast.crm.generic.webdriverutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementVisibility(WebDriver driver, By locator, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementToBeClickable(WebDriver driver, By locator, Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebDriver launchbrowser(String browser) {
		WebDriver driver = null;
		try {

			if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equals("edge")) {
				driver = new EdgeDriver();
			}
		} catch (Exception E) {
			System.out.println("Browser Launch - issue");

		}

		return driver;
	}

	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winid = it.next();
			driver.switchTo().window(winid);
			String actUrl = driver.getCurrentUrl();

			if (actUrl.contains(partialURL)) {
				break;
			}
		}

	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String winid = it.next();
			driver.switchTo().window(winid);
			String actUrl = driver.getCurrentUrl();

			if (actUrl.contains(partialTitle)) {
				break;
			}

		}

	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToMainWindow(WebDriver driver, WebElement element) {
		driver.switchTo().defaultContent();
	}

	public void switchToParentWindow(WebDriver driver, WebElement element) {
		driver.switchTo().parentFrame();
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element)

	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)

	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

	public void rightClick(WebDriver driver, WebElement element)

	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void scrollByAmount(WebDriver driver, int x, int y)

	{
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	public void scrollToElement(WebDriver driver, WebElement element)

	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	public void clickAndHold(WebDriver driver, WebElement element)

	{
		Actions act = new Actions(driver);
		act.clickAndHold(element);
	}

	public void quitwindow(WebDriver driver) {
		driver.quit();
		System.err.println("============ Window-Quit-success ========");
	}

	public void closewindow(WebDriver driver) {
		driver.close();
		System.err.println("============Window-Close-success==============");
	}

	public void maximizewindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizewindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void takescreenshotdriverFULLPAGE(WebDriver driver, String dstpath) throws IOException {
		Date d = new Date();
		Screenshot screenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.0f), 1000)) // Wait
																												// time
																												// between
																												// scrolling
				.takeScreenshot(driver);

		// Save the screenshot
		ImageIO.write(screenshot.getImage(), "JPEG", new File(dstpath + d.toString().replaceAll(":", "-") + ".jpeg"));

	}

	public void takescreenshotdriver(WebDriver driver, String dstpath) throws IOException {
		Date d = new Date();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(dstpath + d.toString().replaceAll(":", "-") + ".jpeg");
		FileHandler.copy(src, dest);
	}

	public void takescreenshotelement(WebDriver element, String dstpath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) element;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(dstpath);
		FileHandler.copy(src, dest);
	}

	public void scrollToElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public Object executeJavaScript(WebDriver driver, String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(script);
	}

	public String getElementText(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		return element.getText();
	}

	public void screenrecord() throws AWTException {
		Robot act = new Robot();
		act.keyPress(KeyEvent.VK_WINDOWS);
		act.keyPress(KeyEvent.VK_ALT);
		act.keyPress(KeyEvent.VK_R);
		act.keyRelease(KeyEvent.VK_WINDOWS);
		act.keyRelease(KeyEvent.VK_ALT);
		act.keyRelease(KeyEvent.VK_R);

	}

	public void clickElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}
	}

	public void enterText(WebDriver driver, By locator, String text) {
		WebElement element = driver.findElement(locator);
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		}
	}

	public boolean isElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void navigateRefresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public String getElementAttribute(WebDriver driver, By locator, String attribute) {
		WebElement element = driver.findElement(locator);
		return element.getAttribute(attribute);
	}

	public int getNumberOfElements(WebDriver driver, By locator) {
		return driver.findElements(locator).size();
	}

	public String getCssValue(WebDriver driver, By locator, String propertyName) {
		WebElement element = driver.findElement(locator);
		return element.getCssValue(propertyName);
	}

	public void switchToWindowByTitle(WebDriver driver, String windowTitle) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getTitle().equals(windowTitle)) {
				break;
			}
		}
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public void waitForElementToBeStale(WebDriver driver, By locator, Duration timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(locator)));
	}

	public long capturePageLoadTime(WebDriver driver) {
		long startTime = System.currentTimeMillis();
		driver.get(driver.getCurrentUrl());
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public void highlightElement(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
