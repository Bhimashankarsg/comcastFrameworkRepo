package practice_Products;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass_practice;
import com.comcast.crm.objectrepositoryutility.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInfoPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class practice_createproductTest_TC1 extends BaseClass_practice {

	@Test(groups ="smoketest")
	public void practice_createprodTest() throws IOException, Throwable {

		String PRODNAME = eLib.getDataFromExcel("product_assignment", 1, 2) + jLib.getRandomNumber();
		HomePage hp = new HomePage(driver);

		hp.getProdLink().click();

		// step 2 : navigate to module
		ProductsPage prodpage = new ProductsPage(driver);
		prodpage.getCreateNewProdBtn().click();

		// step 4: Enter all the details & create new

		CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
		cnpp.createProd(PRODNAME);

		ProductInfoPage pinfop = new ProductInfoPage(driver);
		String headerInfo = pinfop.getproductHeaderMsg().getText();

		System.out.println(headerInfo);
		System.out.println(PRODNAME);
		// Verify Header msg Expected Result
		
		assertObj.hardAssert(headerInfo, PRODNAME);
		/*
		 * boolean status2=headerInfo.contains(PRODNAME); Assert.assertTrue(status2);
		 */
		/*
		 * if (headerInfo.contains(PRODNAME)) { System.out.println(PRODNAME +
		 * " (msg)  is verified==Pass"); } else { System.out.println(PRODNAME +
		 * " (msg) is not verified==Fail"); }
		 */

		//wLib.takescreenshotdriverFULLPAGE(driver, "./photos/product_");
		
		

	}

}
