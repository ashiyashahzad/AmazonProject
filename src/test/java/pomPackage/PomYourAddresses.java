package pomPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackageAmazon.BaseAmazonClass;

public class PomYourAddresses extends BaseAmazonClass {
	
	@FindBy(css="#ya-myab-address-add-link > div") WebElement addAddressBox;
	@FindBy(css="#a-page > div.a-section > div > div:nth-child(2) > h2") WebElement addAddressWindowTitle;
	@FindBy(css="#address-ui-widgets-countryCode > span > span") WebElement countryDropdown;
	@FindBy(id="address-ui-widgets-enterAddressFullName") WebElement fullName;
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber") WebElement phoneNumber;
	@FindBy(id="address-ui-widgets-enterAddressLine1") WebElement address;
	@FindBy(id="address-ui-widgets-enterAddressCity") WebElement city;
	@FindBy(css="#address-ui-widgets-enterAddressStateOrRegion > span > span") WebElement province;
	@FindBy(id="address-ui-widgets-enterAddressPostalCode") WebElement postalCode;
	@FindBy(id="address-ui-widgets-use-as-my-default") WebElement makeAddressDefaultCheckbox;
	@FindBy(css="#address-ui-widgets-form-submit-button > span > input") WebElement addAddressBtn;
	@FindBy(id="address-ui-widgets-original-address-block_id-input") WebElement originalAddressRadioBtn;
	@FindBy(id="address-ui-widgets-suggested-address-block_id-input") WebElement suggestedAddressRadioBtn;
	@FindBy(css="#a-autoid-2 > span > input") WebElement saveAddressBtn;
	@FindBy(css="#yaab-alert-box > div") WebElement addressAddValidationMsg;
	@FindBy(id="ya-myab-address-delete-btn-0") WebElement addressRemoveBtn;
	@FindBy(css="#deleteAddressModal-0-submit-btn > span > input") WebElement confirmDeleteAddressBtn;
	@FindBy(css="#address-ui-widgets-enterAddressFormContainer > div.a-row.a-expander-container.a-expander-inline-container.address-ui-widgets-desktop-delivery-instructions-expander > a > span > span") WebElement addDeliveryInsLink;
	@FindBy(css="#address-ui-widgets-delivery-instructions-desktop-widget-html-container > div > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-other-form-block.ma-form-section-without-spacing > div:nth-child(3) > a > span > div > div.a-row > span") WebElement addDeliveryInsLink2;
	@FindBy(css="#address-ui-widgets-delivery-instructions-desktop-widget-html-container > div > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-apartment-form-block.ma-form-section-without-spacing > div:nth-child(1) > div > div.a-row.a-spacing-top-mini > span > input") WebElement secCodeBox;
	@FindBy(css="#address-ui-widgets-delivery-instructions-desktop-widget-html-container > div > div > div.a-row.ma-cdp-form > div.a-section.ma-property-type-form-block.ma-other-form-block.ma-form-section-without-spacing > div:nth-child(3) > a") WebElement addDeliveryInsLink4;
	@FindBy(xpath="//*[@id=\"address-ui-widgets-delivery-instructions-desktop-widget-html-container\"]/div/div/div[1]/div[6]/div[3]/a") WebElement add;
	
	@FindBy(css="#address-ui-widgets-delivery-instructions-desktop-widget-html-container > div > div > div.a-row.ma-cdp-form > div.a-row.a-spacing-micro.ma-property-type-selector > span > div > span.a-button.a-button-normal.a-button-toggle.a-button-small.ma-property-type-button.ma-apartment-type-button > span > button") WebElement appartmentButton;


	public PomYourAddresses() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	public void clickOnAddAddressBox() {
		
		addAddressBox.click();
	}
	public String verifyAddAddressWindowTitle() {
		return addAddressWindowTitle.getText();
	}
	public String verifyAutoSelectedCountry() {
		return countryDropdown.getText();
	}
	public void typeFullName(String fn) {
		fullName.sendKeys(fn);
	}
	public void typePhoneNum(String phNo) {
		phoneNumber.sendKeys(phNo);
	}
	public void typeAddress(String adrs) {
		address.sendKeys(adrs);
	}
	public void typeCity(String cityname) {
		city.sendKeys(cityname);
	}
	public void selectProvince(String prov) throws InterruptedException {
//		Select s=new Select(province);
//		s.selectByValue(prov);
		province.findElement(By.xpath("//option[text()='"+prov+"']")).click();
		
	}
	public void typePostalCode(String postcode) {
		postalCode.sendKeys(postcode);
	}
	public void clickAddAddressBtn() {
		
		addAddressBtn.click();
	}
	public void clickDefaultAddressCheckbox() {
		
		makeAddressDefaultCheckbox.click();
	}
	public void clickOriginalAddressRadioBtn() {
		originalAddressRadioBtn.click();
	}
	
	public Boolean originalAddressRadioBtnExists() {
		Boolean flag = false;
		try
		{
			flag = originalAddressRadioBtn.isDisplayed();
		}
		catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public void clickSuggestedAddressRadioBtn() {
		suggestedAddressRadioBtn.click();
	}
	public void clickSaveAddressBtn() {
		saveAddressBtn.click();
	}
	public String verifyMsg() {
		return addressAddValidationMsg.getText();
	}
	public void clickRemoveAddressBtn() {
		addressRemoveBtn.click();
	}
	public void clickConfirmDeleteBtn() {
		//Alert alert=driver.switchTo().alert();
		//alert.accept();
		confirmDeleteAddressBtn.submit();
	}
	
	public void clickAddDeliveryInstrLink() throws InterruptedException {
		addDeliveryInsLink.click();
		Thread.sleep(500);
		appartmentButton.click();
	}
	public void typeSecCode(String sc) throws InterruptedException {
		//System.out.println(secCodeBox);
		//System.out.println(secCodeBox.getTagName());
		add.isDisplayed();
		secCodeBox.sendKeys(sc);
	}

	public void clickAddDeliveryInstrLink2() {
		addDeliveryInsLink2.click();
	}

	

}
