package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePackageAmazon.BaseAmazonClass;

public class PomSignin extends BaseAmazonClass {
	
	
	
	@FindBy(id="ap_email") WebElement emailOrMob;
	@FindBy(id="continue") WebElement continueBtn;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="signInSubmit") WebElement signInSubmitBtn;
	@FindBy(id="nav-link-accountList-nav-line-1") WebElement welmsgaftersignin;
	@FindBy(css="#auth-error-message-box > div > div > ul > li > span") WebElement invalidEmailMessage;
	@FindBy(css="#auth-error-message-box > div > div > ul > li > span") WebElement invalidPasswordMessage;
	@FindBy(css="#auth-password-missing-alert > div > div") WebElement emptyPasswordMessage;
	@FindBy(css="#auth-email-missing-alert > div > div") WebElement emptyEmailMessage;
	
	public PomSignin() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void typeemailOrMob(String eOrM) {
		emailOrMob.clear();
		emailOrMob.sendKeys(eOrM);
	}
	public void clickconitnue() {
		continueBtn.click();
	}
	public void typepassword(String pswd) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));// created object of WebDriverWait class with parameter
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))); // wait till the element is visible
		password.clear();
		password.sendKeys(pswd);
	}
	public void clicksigninsubmit() {
		signInSubmitBtn.click();
	}
	public String verifywelcomemsg() {
		return welmsgaftersignin.getText();
	}
	public void verifyInvalidEmailMessage() {
		String actual_error=invalidEmailMessage.getText();
		System.out.println(actual_error);
		Assert.assertEquals(actual_error,prop.getProperty("expected_error_message_for_invalid_email"));
	}
	public void verifyInvalidPasswordMessage() {
		String actual_error=invalidPasswordMessage.getText();
		System.out.println(actual_error);
		Assert.assertEquals(actual_error,prop.getProperty("expected_error_message_for_invalid_password"));	
	}
	public void verifyEmptyEmailMessage() {
		String actual_error=emptyEmailMessage.getText();
		System.out.println(actual_error);
		Assert.assertEquals(actual_error,prop.getProperty("expected_error_message_for_empty_email"));	
		
	}
	public void verifyEmptyPasswordMessage() {
		String actual_error=emptyPasswordMessage.getText();
		System.out.println(actual_error);
		Assert.assertEquals(actual_error,prop.getProperty("expected_error_message_for_empty_password"));	
	}
	
}
