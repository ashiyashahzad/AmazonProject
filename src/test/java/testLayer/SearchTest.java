package testLayer;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomHomepage;
import pomPackage.PomSRP;
import pomPackage.PomSignin;

public class SearchTest extends BaseAmazonClass {
	
	PomSignin pomSI;
	PomHomepage pomHome;
	PomSRP pomSrp;

	// creating constructor
	public SearchTest() {
		super(); 

	}
	@BeforeClass
	public void initsetup() {
		//initiate();
		pomSI=new PomSignin();
		pomHome=new PomHomepage();
		pomSrp=new PomSRP();
	}
	@Test(priority=0)
	public void verifyProductPageTitle() throws InterruptedException {
		Thread.sleep(5000);
		pomHome.typeInSearchBox(prop.getProperty("item_to_search"));
		pomHome.clickSearchBtn();
		Thread.sleep(5000);
		String actual_title=pomSrp.verifyTitle();
		//System.out.println(actual_title);
		Assert.assertEquals(actual_title, "Amazon.ca : shoes");
			}
	@Test(priority=1)
	public void verifyProductImage() {
		assertEquals(pomSrp.verifyImageAvail(), true);
		
	}
	@Test(priority=2)
	public void verifyProductName() {
		assertEquals(pomSrp.verifyNameAvail(), true);
	}
	@Test(priority=3)
	public void verifyProductPrice() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals(pomSrp.verifyPriceAvail(), true);
	}
	@Test(priority=4)
	public void verifyProductRating() {
		
		assertEquals(pomSrp.verifyRatingAvail(), true);
	}
	
	@Test(priority=5)
	public void numberOfProductsPerPage() {
		List<WebElement> list = driver.findElements(By.xpath("//div[@data-component-type=\"s-search-result\"]"));
		int itemsCount = list.size();
		//System.out.println("number of products per page:"+itemsCount);
		assertEquals(itemsCount, 60);
		
	}
	@Test(priority=6)
	
		public void navigationToNextPage() throws InterruptedException {

			Thread.sleep(2000);
			pomSrp.clickNextBtn();
			Thread.sleep(1000);
			String current_page=pomSrp.currentPagenumber();
			Assert.assertEquals(current_page,"2","Not navigated to next page");
	}
	@Test(priority=7)
	public void sortingLowToHigh() throws InterruptedException {
		
		
		pomSrp.selectPriceLowTOHigh();
		Thread.sleep(2000);
		List<WebElement> price=driver.findElements(By.xpath("//div[@data-cy=\"price-recipe\"]//span[@class=\"a-price\"]"));
		List<WebElement> price2=driver.findElements(By.xpath("//div[@class=\"a-row a-size-base a-color-secondary\"]/span[@class=\"a-color-base\"]"));

		List<String> prices=new ArrayList<String>();
		List<String> prices2=new ArrayList<String>();
		
		for(WebElement e:price)
		{
			prices.add(e.getText());
		}
		
		for(WebElement e:price2)
		{
			prices2.add(e.getText());
		}
		
		List<String> sortedPrices=new ArrayList<String>(prices);
		List<String> sortedPrices2=new ArrayList<String>(prices2);
		Collections.sort(sortedPrices);
		Collections.sort(sortedPrices2);
//		System.out.println(prices.toString());
//		System.out.println(prices2.toString());
//		System.out.println(sortedPrices.toString());
//		System.out.println(sortedPrices.equals(prices));
//		System.out.println(sortedPrices2.equals(prices2));
		Assert.assertEquals((sortedPrices2.equals(prices2) &&sortedPrices.equals(prices)), true);
				
	}
	
//	@Test(priority=7)
//	public void filterOnCustReview() {
//		
//		
////		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\\\"search\\\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[3]/div/span[1]"));
//		//int i =3;
//		
//		for(int i = 3; i<=63; i++) 
//		{
//			WebElement abc = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div["+i+"]/div/div/div/div/span/div/div/div[2]/div[3]/div/span[1]"));
//			System.out.println(abc.getAttribute("aria-label"));
//			
//		}
////		i=4;
////		WebElement xyz = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div["+i+"]/div/div/div/div/span/div/div/div[2]/div[3]/div/span[1]"));
////		System.out.println(xyz.getAttribute("aria-label"));
////		for(WebElement prod:list) {
////			String rating=prod.getAttribute("aria-label");
			
//		}


	@AfterSuite
	public void closebrowser() {
		driver.close();
	}
}

