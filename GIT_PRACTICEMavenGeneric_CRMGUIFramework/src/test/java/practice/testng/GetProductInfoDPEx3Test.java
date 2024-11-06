package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

import DataProviderPackage.DataProviderClassFile;

public class GetProductInfoDPEx3Test {
	@Test(dataProvider = "mobprice",dataProviderClass = DataProviderClassFile.class)
	public void getProductInfoTest(String brandname, String productname) throws Throwable {

		WebDriver driver = new ChromeDriver();

		DataProviderClassFile dpclasspack = new DataProviderClassFile();
		dpclasspack.mobileprice();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");

		// search product

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname, Keys.ENTER);

		// capture product info

		String x = "//span[text()=\"" + productname
				+ "\"]/../../../../div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/a/span[1]/span[2]/span[2]";
		System.out.println(x);
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println("Price of product: ");
		System.out.println(price);
		driver.quit();
	}

	@DataProvider(name = "mobprice2")
	public Object[][] mobileprice() throws Throwable {

		ExcelUtility eLib = new ExcelUtility();
		int rowcount = eLib.getRowcount("product");
		Object[][] objArr = new Object[rowcount][2];
		System.out.println("I am from WITHINCLASS");
		for (int i = 0; i < rowcount; i++) {

			objArr[i][0] = eLib.getDataFromExcel("product", i + 1, 0);
			objArr[i][1] = eLib.getDataFromExcel("product", i + 1, 1);

		}

		return objArr;

	}

}
