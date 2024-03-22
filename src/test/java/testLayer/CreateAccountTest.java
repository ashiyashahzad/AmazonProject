package testLayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomCreateAccount;
import pomPackage.PomHomepage;
import testdata.Excelsheet;

public class CreateAccountTest extends BaseAmazonClass{
	
	PomCreateAccount pomCA;
	PomHomepage pomHome;
	// creating constructor
	public CreateAccountTest() {
		super(); 

	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		screenshot("CreatAccount");
		pomCA=new PomCreateAccount();
		pomHome=new PomHomepage();
	}
	/*@Test(priority=1)
	public void title() {
		String actual=pomCA.verifytitle();
		System.out.println(actual);
		Assert.assertEquals(actual, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items");
	}*/
	@DataProvider(name="details")
	public Object[][] getdata(){
		Object result[][]=Excelsheet.readdata("Sheet1"); //DataProvider will read data from excel sheet Sheet1
		return result;
	
	}
	@Test(priority=2,dataProvider="details")
	public void createaccount(String uname,String mOrE, String pswd, String pswdagain) throws InterruptedException {
	Thread.sleep(20000);
	pomHome.clickStartHereLink();
	pomCA.typeyourname(uname);
	pomCA.typemobOrEmail(mOrE);
	pomCA.typepassword(pswd);
	pomCA.typepasswordAgain(pswdagain);
	pomCA.clickContinueBtn();
	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
}
