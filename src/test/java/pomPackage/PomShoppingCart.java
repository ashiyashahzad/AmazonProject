package pomPackage;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackageAmazon.BaseAmazonClass;

public class PomShoppingCart extends BaseAmazonClass {

	@FindBy(xpath="//div[@data-component-type=\"s-search-result\"][@data-index=\"3\"]") WebElement product;
	@FindBy(id="add-to-cart-button") WebElement addToCartButton;
	@FindBy(xpath="//*[@id=\"sw-gtc\"]/span/a") WebElement goToCartLink;
	//@FindBy(xpath="//*[@id=\"quantity\"]") WebElement quantityDropdown;
	@FindBy(xpath="//div[@class=\"sc-badge-price-to-pay\"]") WebElement itemPrice;
	@FindBy(xpath="//*[@id=\"sc-subtotal-amount-buybox\"]/span") WebElement totalPrice;
	@FindBy(xpath="//*[@id=\"sc-subtotal-label-activecart\"]") WebElement totalItemsCount;
	@FindBy(id="nav-cart") WebElement cartLink;
	
	@FindBy(xpath="//span[@class=\"edp-feature-declaration\"][@data-edp-feature-name=\"title\"]") WebElement productInfo;
	
	public PomShoppingCart() {
		PageFactory.initElements(driver, this);
	}
	
	public String clickOnProduct() {
		String asin = product.getAttribute("data-asin");
		product.click();
		return asin;
	}
//	public String getProductId() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		return productInfo.getAttribute("data-edp-asin");
//	}

	public void clickOnAddToCartButton() {		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		addToCartButton.click();
	}
	public void clickOnGoToCartLink() {
		goToCartLink.click();
	}
	
	public void clickCartLink() {
		cartLink.click();
	}
	public String getQuantity(String asin ) {
		WebElement quantityDropdown = driver.findElement(By.xpath("//div[@data-asin=\""+ asin +"\"]/div[@class=\"sc-list-item-content\"]/div/div[@class=\"sc-item-content-group\"]/div/span/span/span/span/select"));
		
		Select s=new Select(quantityDropdown);
		return s.getFirstSelectedOption().getText();
		
	}
//	public int getItemPrice() {
//		String item_price=itemPrice.getText();
//		String numericPrice=item_price.replaceAll("[^0-9]","");
//		int priceInt=Integer.parseInt(numericPrice);
//		return priceInt;
//	}
	public BigDecimal getTotalPrice() {
		//System.out.println(totalItemsCount.getText());
		if(totalItemsCount.getText().contains("Subtotal (0 items):"))
		{
			return new BigDecimal("0.00");
		}
		else
		{
			//System.out.println(totalPrice.getText());
			String tot_price=totalPrice.getText();
			String numericPrice=tot_price.replaceAll("[^0-9.]","");
			BigDecimal priceInt= new BigDecimal(numericPrice);
			return priceInt;
		}
	}
	public void selectQuanity(int x,String asin) {
		WebElement quantityDropdown = driver.findElement(By.xpath("//div[@data-asin=\""+ asin +"\"]/div[@class=\"sc-list-item-content\"]/div/div[@class=\"sc-item-content-group\"]/div/span/span/span/span/select"));
		Select s=new Select(quantityDropdown);
		s.selectByIndex(x);
	}
	
	public boolean checkProduct(String asin)
	{
		boolean flag = false;
		try
		{
			driver.findElement(By.xpath("//div[@data-asin=\""+ asin +"\"]"));
			flag = true;
		}
		catch(Exception ex)
		{
			flag = false;
		}
		return flag;
	}
	
	public String getCartProductQuantity(String asin )
	{
		return driver.findElement(By.xpath("//div[@data-asin=\""+ asin +"\"]")).getAttribute("data-quantity");
	}
	
	public BigDecimal getCartProductCost(String asin)
	{
		//System.out.println( driver.findElement(By.xpath("//div[@data-asin=\""+ asin +"\"]")).getAttribute("data-price"));
		return (new BigDecimal(driver.findElement(By.xpath("//div[@data-asin=\""+ asin +"\"]")).getAttribute("data-price")));
	}
	
}
