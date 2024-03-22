package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackageAmazon.BaseAmazonClass;

public class PomYourOrders extends BaseAmazonClass {
	
	@FindBy(linkText="Orders") WebElement ordersTab;
	@FindBy(linkText="Buy Again") WebElement buyAgainTab;
	@FindBy(linkText="Not Yet Shipped") WebElement notYetShippedTab;
	@FindBy(linkText="Cancelled Orders") WebElement cancelledOrdersTab;

	public PomYourOrders() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBuyAgainTab() {
		buyAgainTab.click();

	}
	public void clickOnNotYetShippedTab() {
		notYetShippedTab.click();

	}
	public void clickOnCancelledOrdersTab() {
		cancelledOrdersTab.click();

	}

}
