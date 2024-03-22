package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackageAmazon.BaseAmazonClass;

public class PomYourPayments extends BaseAmazonClass{
	
	@FindBy(xpath="//input[@class=\"a-button-input\"]") WebElement addPaymentMethodBtn;
	@FindBy(xpath="//span[@class=\"a-button a-button-primary pmts-button-input\"]/span[@class=\"a-button-inner\"]/input[@name=\"ppw-widgetEvent:AddCreditCardEvent\"]") WebElement addCardDetBtn;
	@FindBy(xpath="//input[@name=\"addCreditCardNumber\"]") WebElement cardNumBox;
	@FindBy(xpath="//input[@name=\"ppw-accountHolderName\"]") WebElement nameOnCardBox;
	@FindBy(xpath="//select[@name=\"ppw-expirationDate_month\"]") WebElement expDateDropdown;
	@FindBy(xpath="//select[@name=\"ppw-expirationDate_year\"]") WebElement expYearDropdown;
	@FindBy(xpath="//input[@name=\"addCreditCardVerificationNumber\"]") WebElement cvvBox;
	@FindBy(xpath="//input[@class=\"a-button-input\"]") WebElement addCardBtn;
	@FindBy(xpath="//div[@class=\"a-box a-alert a-alert-error\"]/div[@class=\"a-box-inner a-alert-container\"]/div[@class=\"a-alert-content\"]//div[@class=\"a-box a-alert a-alert-error\"]/div[@class=\"a-box-inner a-alert-container\"]/div[@class=\"a-alert-content\"]") WebElement alertMsg;
	
	public PomYourPayments() {
		PageFactory.initElements(driver, this);
	}
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public void clickAddPaymentMethodBtn() {
		addPaymentMethodBtn.click();
	}
	public void clickAddCardDetBtn() {
		addCardDetBtn.click();
	}
	public void typeCardNumber(String cardNo) {
		cardNumBox.sendKeys(cardNo);
	}
	public void typeName(String name) {
		nameOnCardBox.sendKeys(name);
	}
	public void selectMonth(String expDate) {
		
	Select s=new Select(expDateDropdown);
	s.selectByVisibleText(expDate);
	}
	public void selectYear(String expYr) {
		
		Select s=new Select(expYearDropdown);
		s.selectByVisibleText(expYr);
	}
	public void typeCvv(String cvv) {
		cvvBox.sendKeys(cvv);
	}
	public void clickAddCardBtn() {
		addCardBtn.click();
	}
	public String getAlertMsg() {
		return alertMsg.getText();
	}
	
}
