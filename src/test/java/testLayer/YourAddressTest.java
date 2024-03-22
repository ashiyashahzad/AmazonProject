package testLayer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomHomepage;
import pomPackage.PomSignin;
import pomPackage.PomYourAccount;
import pomPackage.PomYourAddresses;
import testdata.ExcelsheetInvalidAddress;
import testdata.ExcelsheetValidAddress;

public class YourAddressTest extends BaseAmazonClass{
	
	PomSignin pomSI;
	PomYourAccount pomYA;
	PomYourAddresses pomYourAdd;
	PomHomepage pomHome;
	SigninTest signin;
	
	// creating constructor
		public YourAddressTest() {
			super(); 

		}
		@BeforeClass
		public void initsetup() {
			pomHome = new PomHomepage();
			pomYourAdd=new PomYourAddresses();
			pomYA=new PomYourAccount();
			pomHome.clickYourAccountLink();
			pomYA.clickOnYourAddresses();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
		
		@Test(priority = 1)
		public void verifyYourAddressTitle() throws InterruptedException {
			//pomYA.clickOnYourAddresses();
			String actual_title=pomYourAdd.verifyTitle();
			//System.out.println(actual_title);
			Assert.assertEquals(actual_title,"Your Addresses");
		}
		@Test(priority = 2)
		public void verifyAddAddressTitle() {
			pomYourAdd.clickOnAddAddressBox();
			String actual_text=pomYourAdd.verifyAddAddressWindowTitle();
			//System.out.println(actual_text);
			Assert.assertEquals(actual_text,"Add a new address");
		}
		@Test(priority = 3)
		public void verifyCountryValue() {
			String actual_country=pomYourAdd.verifyAutoSelectedCountry();
			//System.out.println(actual_country);
			Assert.assertEquals(actual_country,"Canada");
		}
		@DataProvider(name="validAddressDetails")
		public Object[][] getdata(){
			Object result[][]=ExcelsheetValidAddress.readdata("Sheet1"); //DataProvider will read data from excel sheet Sheet1
			return result;
		
		}
		@Test(priority=4,dataProvider="validAddressDetails")
		public void addAddress(String fname,String phNo, String addrs, String city, String province, String post, String suggested, String secCode) throws InterruptedException {
		//Thread.sleep(20000);
		pomHome.clickYourAccountLink();
		pomYA.clickOnYourAddresses();
		pomYourAdd.clickOnAddAddressBox();
		pomYourAdd.typeFullName(fname);;
		pomYourAdd.typePhoneNum(phNo);
		pomYourAdd.typeAddress(addrs);
		pomYourAdd.typeCity(city);
		pomYourAdd.selectProvince(province);
		pomYourAdd.typePostalCode(post);
		pomYourAdd.clickDefaultAddressCheckbox();
		pomYourAdd.clickAddDeliveryInstrLink();
		//pomYourAdd.clickAddDeliveryInstrLink2();
		pomYourAdd.typeSecCode(secCode);
		pomYourAdd.clickAddAddressBtn();
		if(suggested=="y") 
			{
			pomYourAdd.clickSuggestedAddressRadioBtn();
			}
		else
			{
			pomYourAdd.clickOriginalAddressRadioBtn();
			}
		pomYourAdd.clickSaveAddressBtn();
		String actual_text=pomYourAdd.verifyMsg();
		//System.out.println(actual_text);
		Assert.assertEquals(actual_text,"Address saved");
		Thread.sleep(2000);
		pomYourAdd.clickRemoveAddressBtn();
		pomYourAdd.clickConfirmDeleteBtn();
		}
		
		
		@DataProvider(name="InvalidvalidAddressDetails")
		public Object[][] getInvaliddata(){
			Object result[][]=ExcelsheetInvalidAddress.readdata("Sheet1"); //DataProvider will read data from excel sheet Sheet1
			return result;
		
		}
		
		@Test(priority=5,dataProvider="InvalidvalidAddressDetails")
		public void addInvalidAddress(String fname,String phNo, String addrs, String city, String province, String post, String suggested, String secCode) throws InterruptedException {
		pomHome.clickYourAccountLink();
		pomYA.clickOnYourAddresses();
		pomYourAdd.clickOnAddAddressBox();
		pomYourAdd.typeFullName(fname);;
		pomYourAdd.typePhoneNum(phNo);
		pomYourAdd.typeAddress(addrs);
		pomYourAdd.typeCity(city);
		pomYourAdd.selectProvince(province);
		pomYourAdd.typePostalCode(post);
		pomYourAdd.clickDefaultAddressCheckbox();
		pomYourAdd.clickAddAddressBtn();
		
		Assert.assertEquals(pomYourAdd.originalAddressRadioBtnExists(),false);
		//pomYourAdd.clickSaveAddressBtn();
		//String actual_text=pomYourAdd.verifyMsg();
		//System.out.println(actual_text);
		//Assert.assertEquals(actual_text,"Address saved");
		//Thread.sleep(20000);
		}
		
		@AfterSuite
		public void closebrowser() {
		//	driver.close();
		}
}
