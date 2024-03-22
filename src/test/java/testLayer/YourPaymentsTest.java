package testLayer;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomHomepage;
import pomPackage.PomYourAccount;
import pomPackage.PomYourPayments;

public class YourPaymentsTest extends BaseAmazonClass {
	
	PomHomepage pomHome;
	PomYourPayments pomYP;
	PomYourAccount pomYA;

	// creating constructor
	public YourPaymentsTest() {
		super(); 

	}
	@BeforeClass
	public void initsetup() {
		pomYP=new PomYourPayments();
		pomHome=new PomHomepage();
		pomYA=new PomYourAccount();
		pomHome.clickYourAccountLink();
		pomYA.clickOnYourPayments();
	}
	
	@Test(priority = 1)
	public void verifyYourAddressTitle() throws InterruptedException {
	
		String actual_title=pomYP.verifyTitle();
		System.out.println(actual_title);
		Assert.assertEquals(actual_title,"Your Payments");
	}
	@Test(priority = 2)
	public void addPaymentMethod() throws InterruptedException {
		Thread.sleep(1000);
		pomYP.clickAddPaymentMethodBtn();
		Thread.sleep(1000);
		pomYP.clickAddCardBtn();
		Thread.sleep(1000);
		driver.switchTo().frame(0);
		pomYP.typeCardNumber(prop.getProperty("card_number"));
		pomYP.typeName(prop.getProperty("name_on_card"));
		pomYP.selectMonth(prop.getProperty("exp_month"));
		pomYP.selectYear(prop.getProperty("exp_year"));
		pomYP.typeCvv(prop.getProperty("cvv"));
		pomYP.clickAddCardDetBtn();
		driver.switchTo().frame(1);
		System.out.println(pomYP.getAlertMsg());
	}
	

}
