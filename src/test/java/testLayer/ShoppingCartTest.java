package testLayer;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomHomepage;
import pomPackage.PomSRP;
import pomPackage.PomShoppingCart;
import pomPackage.PomSignin;

public class ShoppingCartTest extends BaseAmazonClass {
	
	
	PomShoppingCart pomSC;
	PomSRP pomSrp;
	PomHomepage pomHome;
	String prodId;
	String secondprodId;
	int oldQty;

	// creating constructor
	public ShoppingCartTest() {
		super(); 

	}
	@BeforeClass
	public void initsetup() {
		pomSC=new PomShoppingCart();
		pomHome=new PomHomepage();
		pomSrp=new PomSRP();
		//pomHome.clickYourAccountLink();
		}
	
	public String addItem(String productSearch) throws InterruptedException
	{
		String prodId;
		
		
		Thread.sleep(5000);
		pomHome.typeInSearchBox(productSearch);
		pomHome.clickSearchBtn();
		Thread.sleep(5000);
		prodId=pomSC.clickOnProduct();
		//String prodId=pomSC.getProductId();
		pomSC.clickOnAddToCartButton();
		
		return prodId;
	}
	
	@Test(priority=1)
	public void addItemVerify() throws InterruptedException {
//		Thread.sleep(2000);
//		pomHome.typeInSearchBox(prop.getProperty("item_to_search2"));
//		pomHome.clickSearchBtn();
//		Thread.sleep(5000);
//		prodId=pomSC.clickOnProduct();
//		//String prodId=pomSC.getProductId();
//		pomSC.clickOnAddToCartButton();
		prodId = addItem(prop.getProperty("item_to_search2"));
		pomSC.clickOnGoToCartLink();
		
		assertEquals(pomSC.checkProduct(prodId), true); 
	}
	
	@Test(priority=2)
	public void quantityIncrease() throws InterruptedException {
		pomSC.clickCartLink();
		//System.out.println(pomSC.getItemPrice());
		//System.out.println(pomSC.getQuantity(prodId));
		//System.out.println(pomSC.getTotalPrice());
		int oldQty = Integer.parseInt(pomSC.getCartProductQuantity(prodId));
		BigDecimal oldTotPrice = pomSC.getTotalPrice();
		pomSC.selectQuanity(2,prodId);
		Thread.sleep(5000);
		int newQty = Integer.parseInt(pomSC.getCartProductQuantity(prodId));
		this.oldQty = newQty;
		BigDecimal actualTotalPrice = pomSC.getTotalPrice();
		BigDecimal qtyDiff = new BigDecimal(newQty - oldQty);
		BigDecimal priceOfItemsAdded = qtyDiff.multiply(pomSC.getCartProductCost(prodId));
		BigDecimal expTotPrice = oldTotPrice.add(priceOfItemsAdded);

		Assert.assertEquals(actualTotalPrice, expTotPrice);
	}
	
	@Test(priority=3)
	public void addSameItem() throws InterruptedException {
		BigDecimal oldTotPrice = pomSC.getTotalPrice();
		prodId = addItem(prop.getProperty("item_to_search2"));
		pomSC.clickCartLink();
		int newQty = Integer.parseInt(pomSC.getCartProductQuantity(prodId));
		BigDecimal actualTotalPrice = pomSC.getTotalPrice();
		BigDecimal qtyDiff = new BigDecimal(newQty - this.oldQty);
		BigDecimal priceOfItemsAdded = qtyDiff.multiply(pomSC.getCartProductCost(prodId));
		BigDecimal expTotPrice = oldTotPrice.add(priceOfItemsAdded);
		this.oldQty = newQty;
		
		Assert.assertEquals(actualTotalPrice, expTotPrice);
		Assert.assertEquals(qtyDiff.toString(), "1");
	}
	
	@Test(priority=4)
	public void addMultipleItem() throws InterruptedException {
		BigDecimal oldTotPrice = pomSC.getTotalPrice();
		secondprodId = addItem("cocomelon toys");
		pomSC.clickCartLink();
		int newQty = Integer.parseInt(pomSC.getCartProductQuantity(secondprodId));
		BigDecimal actualTotalPrice = pomSC.getTotalPrice();
		BigDecimal priceOfItemsAdded = pomSC.getCartProductCost(secondprodId);
		BigDecimal expTotPrice = oldTotPrice.add(priceOfItemsAdded);
		Assert.assertEquals(actualTotalPrice, expTotPrice);
		Assert.assertEquals(newQty, 1);
	}
	
	
	@Test(priority=5)
	public void quantityDecrease() throws InterruptedException {
		pomSC.clickCartLink();
		int oldQty = Integer.parseInt(pomSC.getCartProductQuantity(prodId));
		BigDecimal oldTotPrice = pomSC.getTotalPrice();
		pomSC.selectQuanity(1,prodId);
		Thread.sleep(5000);
		int newQty = Integer.parseInt(pomSC.getCartProductQuantity(prodId));
		
		BigDecimal actualTotalPrice = pomSC.getTotalPrice();
		BigDecimal qtyDiff = new BigDecimal(newQty - oldQty);
		BigDecimal priceOfItemsAdded = qtyDiff.multiply(pomSC.getCartProductCost(prodId));
		BigDecimal expTotPrice = oldTotPrice.add(priceOfItemsAdded);
		//System.out.println(expTotPrice);
		//System.out.println(actualTotalPrice);
		Assert.assertEquals(actualTotalPrice, expTotPrice);
	}
	
	@Test(priority=6)
	public void quantityRemove() throws InterruptedException {
		pomSC.clickCartLink();
		BigDecimal productCost = pomSC.getCartProductCost(prodId);
		int oldQty = Integer.parseInt(pomSC.getCartProductQuantity(prodId));
		BigDecimal oldTotPrice = pomSC.getTotalPrice();
		pomSC.selectQuanity(0,prodId);
		Thread.sleep(500);
		BigDecimal actualTotalPrice = pomSC.getTotalPrice();
		BigDecimal priceOfItemsRemoved = productCost.multiply(new BigDecimal(oldQty));
		BigDecimal expTotPrice = oldTotPrice.subtract(priceOfItemsRemoved);
//		System.out.println(actualTotalPrice);
//		System.out.println(expTotPrice);
		Assert.assertEquals(actualTotalPrice, expTotPrice);
	}
	
	@Test(priority=7)
	public void quantityRemoveAll() throws InterruptedException {
		pomSC.clickCartLink();
		BigDecimal productCost = pomSC.getCartProductCost(secondprodId);
		int oldQty = Integer.parseInt(pomSC.getCartProductQuantity(secondprodId));
		BigDecimal oldTotPrice = pomSC.getTotalPrice();
		pomSC.selectQuanity(0,secondprodId);
		Thread.sleep(500);
		BigDecimal actualTotalPrice = pomSC.getTotalPrice();
		BigDecimal priceOfItemsRemoved = productCost.multiply(new BigDecimal(oldQty));
		BigDecimal expTotPrice = oldTotPrice.subtract(priceOfItemsRemoved);
//		System.out.println(actualTotalPrice);
//		System.out.println(expTotPrice);
		Assert.assertEquals(actualTotalPrice, expTotPrice);
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.close();
	}
}
