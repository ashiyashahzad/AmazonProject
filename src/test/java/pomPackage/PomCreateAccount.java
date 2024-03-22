package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePackageAmazon.BaseAmazonClass;

public class PomCreateAccount extends BaseAmazonClass{

	
	
	@FindBy(id="ap_customer_name") WebElement yourName;
	@FindBy(id="ap_email") WebElement mobOrEmail;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="ap_password_check") WebElement passwordAgain;
	@FindBy(id="continue") WebElement continueBtn;
	
	
	
	public PomCreateAccount() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void typeyourname(String name) throws InterruptedException {
		
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));// created object of WebDriverWait class with parameter
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("yourName"))); // wait till the element is visible
		yourName.sendKeys(name);
		
	}
	public void typemobOrEmail(String mOrE) {
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));// created object of WebDriverWait class with parameter
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobOrEmail"))); // wait till the element is visible
		mobOrEmail.sendKeys(mOrE);
	}
	
	public void typepassword(String pswd) {
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));// created object of WebDriverWait class with parameter
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))); // wait till the element is visible
		password.sendKeys(pswd);
	}
	public void typepasswordAgain(String pswdagain) {
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));// created object of WebDriverWait class with parameter
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("passwordAgain"))); // wait till the element is visible
		passwordAgain.sendKeys(pswdagain);
	}
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	
	public String verifytitle() { // to verify the title of the page
		return driver.getTitle();
	}
	
	
}
