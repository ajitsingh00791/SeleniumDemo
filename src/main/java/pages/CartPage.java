package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

   By productNameText=By.xpath("//a[contains(text(),'Cremlin Clothing Regular Boys & Girls Blue Jeans')]");
   By PriceText= By.xpath("//span[@class='_2-ut7f _1WpvJ7']");
  	
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) { 
		this.driver=driver; 
		wait = new WebDriverWait(driver, 10);
	}
	
	
	public String getProductName()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(productNameText));
		return driver.findElement(productNameText).getText() ;
	}
	
	public String getProductPrice()
	{
		return driver.findElement(PriceText).getText();
	}
	
	public boolean verifyTheProductNameInCart(String productName)
	 {
		 return this.getProductName().contains(productName);
	 }
	 
	public boolean verifyTheProductPriceInCart(String price)
	 {
		 return this.getProductPrice().contains(price);
	 }
}