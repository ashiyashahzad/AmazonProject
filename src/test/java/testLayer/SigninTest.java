package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomHomepage;
import pomPackage.PomSignin;
import pomPackage.PomYourAccount;
import pomPackage.PomYourAddresses;

public class SigninTest extends BaseAmazonClass {

	
	PomSignin pomSI;
	PomHomepage pomHome;
	PomYourAccount pomYA;
	PomYourAddresses pomYourAdd;

	// creating constructor
	public SigninTest() {
		super(); 

	}
	@BeforeClass
	public void initsetup() {
		//initiate();
		screenshot("Signin");
		pomSI=new PomSignin();
		pomHome=new PomHomepage();
		pomYA=new PomYourAccount();
		pomYourAdd=new PomYourAddresses();
	}

//	@Test(priority = 0)
//	public void signinEmptyEmail() throws InterruptedException {
//		//Thread.sleep(20000);
//		pomHome.clickSignInBtn();
//		pomSI.clickconitnue();
//		
//		pomSI.verifyEmptyEmailMessage();
//		
//	}	
//	@Test(priority = 1)
//	public void signinInvalidEmail() throws InterruptedException {
//		//Thread.sleep(20000);
//		//pomHome.clickSignInBtn();
//		pomSI.typeemailOrMob(prop.getProperty("invalidEmail"));
//		pomSI.clickconitnue();
//		
//		pomSI.verifyInvalidEmailMessage();
//		}
//	
//	@Test(priority = 3)
//	public void signinEmptyPassword() throws InterruptedException {
//		//Thread.sleep(20000);
//		//pomHome.clickSignInBtn();
//		pomSI.typeemailOrMob(prop.getProperty("validEmail"));
//		pomSI.clickconitnue();
//		pomSI.clicksigninsubmit();
//
//		pomSI.verifyEmptyPasswordMessage();
//		
//		
//	}
//	
//	@Test(priority = 4)
//	public void signinInvalidPassword() throws InterruptedException
//	{
//		//Thread.sleep(20000);
//		//pomHome.clickSignInBtn();
//		//pomSI.typeemailOrMob(prop.getProperty("validEmail"));
//		//pomSI.clickconitnue();
//		pomSI.typepassword(prop.getProperty("invalidPassword"));
//		pomSI.clicksigninsubmit();
//		
//		pomSI.verifyInvalidPasswordMessage();
//	}


	
	@Test(priority = 4)
	public void signinValidEmailPassword() throws InterruptedException {
		//Thread.sleep(20000);
		pomHome.clickSignInBtn();
		pomSI.typeemailOrMob(prop.getProperty("validEmail"));
		pomSI.clickconitnue();
		pomSI.typepassword(prop.getProperty("validPassword"));
		pomSI.clicksigninsubmit();
		
		
		String actual=pomSI.verifywelcomemsg();
		//System.out.println(actual);
		Assert.assertEquals(actual,"Hello, "+prop.getProperty("username"));
		}

	
	
	@Test(priority = 5, dependsOnMethods = "signinValidEmailPassword")
	public void youraccount() throws InterruptedException {
		//Thread.sleep(20000);
		pomHome.clickYourAccountLink();
		String actual_title= driver.getTitle();
		//System.out.println(actual_title);
		Assert.assertEquals(actual_title,"Your Account");	
		
	}
	
	@Test(priority = 6,dependsOnMethods ="signinValidEmailPassword")
	public void yourorders() throws InterruptedException {
		//Thread.sleep(20000);
		pomYA.clickOnYourOrders();
		String actual_title= driver.getTitle();
		//System.out.println(actual_title);
		Assert.assertEquals(actual_title,"Your Orders");	
		
	}
	
	@AfterSuite
	public void closebrowser() {
		//driver.close();
	}
}
