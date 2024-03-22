package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackageAmazon.BaseAmazonClass;

public class PomLoginSec extends BaseAmazonClass{
	
	@FindBy(xpath="//*[@id=\"NAME_BUTTON\"]/span/a") WebElement editNameBtn;
	@FindBy(id="ap_customer_name") WebElement newNameBox;
	@FindBy(css="#SUCCESS_MESSAGES > div > div") WebElement editValidationMsg;
	@FindBy(id="cnep_1C_submit_button") WebElement saveBtn;
			

	
	public PomLoginSec() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickEditName()
	{
		editNameBtn.click();
	}
	public void clearNewNameBox() {
		newNameBox.clear();
	}
	public void typeNewName(String name) {
		newNameBox.sendKeys(name);
	}
	public String afterEditMsg() {
		return editValidationMsg.getText();
	}
	public void clickSaveBtn()
	{
		saveBtn.click();
	}
}
