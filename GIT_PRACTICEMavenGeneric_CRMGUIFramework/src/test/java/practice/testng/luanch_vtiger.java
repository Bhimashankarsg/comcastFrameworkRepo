package practice.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class luanch_vtiger {
	WebDriver driver=null;

	@Parameters("BROWSER")
	@Test(groups = "smoketest")
	public void launch_browser(String browser) {
		System.out.println(browser);
		if (browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (browser.equals("firefox"))
			driver = new FirefoxDriver();

		driver.get("http://localhost:8888/");
		driver.findElement(By.id("submitButton")).click();
		driver.quit();

	}
}
