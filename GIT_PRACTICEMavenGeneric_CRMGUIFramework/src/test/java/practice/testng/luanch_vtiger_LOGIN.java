package practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class luanch_vtiger_LOGIN {

	WebDriver driver = null;

	@Parameters("BROWSER")
	@Test
	public void login(String browser) {
		System.err.println(browser);
		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();

		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.quit();

	}
	/*
	 * 
	 * @BeforeMethod public void launch_browser() { WebDriver driver = new
	 * FirefoxDriver();
	 * 
	 * driver.get("http://localhost:8888/"); }
	 * 
	 * //@Test(invocationCount = 4,threadPoolSize = 2)
	 * 
	 * @Test public void login() {
	 * 
	 * 
	 * driver.findElement(By.name("user_name")).sendKeys("admin");
	 * driver.findElement(By.name("user_password")).sendKeys("admin");
	 * driver.findElement(By.id("submitButton")).click(); driver.quit();
	 * 
	 * }
	 */

}
