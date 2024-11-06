package practice.hometest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class skincare_clinique {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.clinique.in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement sk=driver.findElement(By.xpath("(//a[contains(text(),'Skincare')])[2]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(sk).perform();
		
		List<WebElement> allsk=driver.findElements(By.xpath("//a[contains(text(),'All Skincare')]/.."));
		
		for(WebElement skdetails:allsk)
		{
			System.out.println(skdetails.getText());
			
		
		}
		
		}
		
	

}
