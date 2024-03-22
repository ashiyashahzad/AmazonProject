package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackageAmazon.BaseAmazonClass;

public class PomSRP extends BaseAmazonClass{
	
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[1]/div/span/a/div/img") WebElement prodImage;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[2]/h2") WebElement prodName;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[4]/div/div[1]") WebElement prodPrice;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[3]/div") WebElement prodRating;
	@FindBy(linkText="Next") WebElement nextBtn;
	@FindBy(xpath="//span[@class=\"s-pagination-item s-pagination-selected\"]") WebElement pageNum;
	@FindBy(xpath="//*[@id=\"p_72/11192170011\"]/span/a/section") WebElement custReview4AndUp;
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[3]/div/span[1]") WebElement rating;
	@FindBy(id="s-result-sort-select") WebElement sortDropdown;
	
	
	
	public PomSRP() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyImageAvail() {
		boolean imagePresent=prodImage.isDisplayed();
		return imagePresent;
	}
	public boolean verifyNameAvail() {
		return prodName.isDisplayed();
		
	}
	public boolean verifyPriceAvail() {
		return prodPrice.isDisplayed();
		
	}
	public boolean verifyRatingAvail() {
		return prodRating.isDisplayed();
		
	}
	public void clickNextBtn() {
		nextBtn.click();
	}
	public String currentPagenumber() {
		return pageNum.getText();
		
	}
	public void clickCustReview$AndUp() {
		custReview4AndUp.click();
	}
	public String getRating() {
		return rating.getAttribute("aria-label");
	}
	
	public void selectPriceLowTOHigh() {
		Select s=new Select(sortDropdown);
		s.selectByVisibleText("Price: Low to high");
	}
	public void selectPriceHighToLow() {
		Select s=new Select(sortDropdown);
		s.selectByVisibleText("Price: High to low");
	}
	public void selectAvgCustomerReview() {
		Select s=new Select(sortDropdown);
		s.selectByVisibleText("Avg. customer review");
	}
	public void selectNewestArrivals() {
		Select s=new Select(sortDropdown);
		s.selectByVisibleText("Newest arrivals");
	}
}
