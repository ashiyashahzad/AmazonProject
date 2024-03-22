package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomHomepage;

public class GuestAccountTest extends BaseAmazonClass{

	PomHomepage pomHome;
	public GuestAccountTest() {
		super(); 

	}
	@BeforeSuite
	public void initsetup() {
		initiate();
		pomHome = new PomHomepage();
	}
	@Test(priority = 0)
	public void guestSearchAndBuy() throws InterruptedException {
		Thread.sleep(5000);
		pomHome.typeInSearchBox(prop.getProperty("item_to_search"));
		pomHome.clickSearchBtn();
		Thread.sleep(2000);
		String actual_text=pomHome.productPageText();
//		String expected = prop.getProperty("item_to_search");
//		expected = "\"" + expected + "\"";
		Assert.assertEquals(actual_text,("\"" + prop.getProperty("item_to_search")+ "\""));
	}
	@AfterSuite
	public void closeBrowser() {
		//driver.close();
	}
	
}
