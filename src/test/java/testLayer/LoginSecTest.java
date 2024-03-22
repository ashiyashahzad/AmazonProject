package testLayer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePackageAmazon.BaseAmazonClass;
import pomPackage.PomHomepage;
import pomPackage.PomLoginSec;
import pomPackage.PomYourAccount;

public class LoginSecTest extends BaseAmazonClass {

	PomYourAccount pomYA;
	PomHomepage pomHome;
	PomLoginSec pomLS;
	
	// creating constructor
		public LoginSecTest() {
			super(); 

		}
		@BeforeClass
		public void initsetup() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			pomHome = new PomHomepage();
			pomYA=new PomYourAccount();
			pomHome.clickYourAccountLink();
			pomLS=new PomLoginSec();
		}
		@Test
		public void editName() {
			pomYA.clickOnLoginAndSec();
			pomLS.clickEditName();
			pomLS.clearNewNameBox();
			pomLS.typeNewName(prop.getProperty("new_name"));
			pomLS.clickSaveBtn();
			String actual=pomLS.afterEditMsg();
			//System.out.println(actual);
			Assert.assertEquals(actual,"Name updated.");
			pomLS.clickEditName();
			pomLS.clearNewNameBox();
			pomLS.typeNewName(prop.getProperty("username"));
			pomLS.clickSaveBtn();
			
		}
		
}
