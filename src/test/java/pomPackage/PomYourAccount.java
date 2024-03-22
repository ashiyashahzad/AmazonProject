package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackageAmazon.BaseAmazonClass;

public class PomYourAccount extends BaseAmazonClass{

	
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2") WebElement yourOrders;
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(2) > a > div > div > div > div.a-column.a-span9.a-span-last > h2") WebElement loginSec;
	@FindBy(css="#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2") WebElement yourAddresses;
	@FindBy(xpath="//div[@data-card-identifier=\"PaymentOptions\"]") WebElement yourPayments;
	
	
	public PomYourAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnYourOrders() {
		yourOrders.click();
	}
	public void clickOnLoginAndSec() {
		loginSec.click();
	}
	public void clickOnYourAddresses() {
		yourAddresses.click();
	}
	public void clickOnYourPayments() {
		yourPayments.click();
	}
}
