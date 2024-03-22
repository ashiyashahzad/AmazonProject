package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackageAmazon.BaseAmazonClass;

public class PomHomepage extends BaseAmazonClass {

	
	@FindBy(css="#nav-link-accountList") WebElement welcomeMsg;
	@FindBy(css="#nav-flyout-ya-newCust > a") WebElement startHereLink;
	@FindBy(css="#nav-al-your-account > a:nth-child(2) > span") WebElement yourAccountLink;
	@FindBy(css="#nav-flyout-ya-signin > a > span") WebElement signInBtn;
	@FindBy(id="twotabsearchtextbox") WebElement searchBar;
	@FindBy(id="nav-search-submit-button") WebElement searchBtn;
	@FindBy(css="#search > span:nth-child(9) > div > h1 > div > div.sg-col-14-of-20.sg-col-18-of-24.sg-col.s-breadcrumb.sg-col-10-of-16.sg-col-6-of-12 > div > div > span.a-color-state.a-text-bold") WebElement productPageText;

	public PomHomepage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickStartHereLink() {
		Actions a=new Actions(driver);
		a.moveToElement(welcomeMsg).build().perform();
		startHereLink.click();
	}
	public void clickSignInBtn() {
		Actions a=new Actions(driver);
		a.moveToElement(welcomeMsg).build().perform();
		signInBtn.click();
	}
	
	public void clickYourAccountLink()
	{
		Actions a=new Actions(driver);
		a.moveToElement(welcomeMsg).build().perform();
		yourAccountLink.click();
	}
	public void typeInSearchBox(String item) {
		
		searchBar.sendKeys(item);

	}
	public void clickSearchBtn() {
		searchBtn.click();
	}
	public String productPageText() {
		return productPageText.getText();
	}
	
}
