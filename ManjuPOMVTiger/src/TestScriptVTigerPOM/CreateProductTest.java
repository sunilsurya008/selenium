package TestScriptVTigerPOM;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericLib.Base;
import GenericLib.Utility;
import TestScriptVTigerPOM.CreateNewProductPage;
import TestScriptVTigerPOM.HomePage;
import TestScriptVTigerPOM.ProductsPage;

@Listeners(GenericLib.ListenerImp.class)

public class CreateProductTest extends Base
{
	public HomePage hp;

	public ProductsPage pp;

	public CreateNewProductPage cnp;
	
	public Utility util = new Utility();

	@DataProvider

	public Object[][] giveData()
	{
		return util.getAllData("./testdata\\testData.xlsx", "Products");
	}
	
	@Test(dataProvider="giveData")
	public void createProductTest(String prodName, String man, String cat, String ven)
	{
		hp = PageFactory.initElements(driver, HomePage.class);

		pp = PageFactory.initElements(driver, ProductsPage.class);

		cnp = PageFactory.initElements(driver, CreateNewProductPage.class);

		hp.getProductsLink().click();

		pp.getCreateProductImg().click();

		cnp.createProduct(prodName, man, cat, ven, driver);

		System.out.println("Successfully Created --> PASS");
		System.out.println(" Bye Bye");
	}
}