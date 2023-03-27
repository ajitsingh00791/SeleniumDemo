package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KidsJeansPage {
	
	By boysAndGirlsRegularMidRiseBlueJeansLink=By.xpath("//a[contains(text(),'Boys & Girls Regular Mid Rise Blue Jeans')]");
	By boysAndGirlsRegularMidRiseBlueJeansText=By.xpath("//span[contains(text(),'Boys & Girls Regular Mid Rise Blue Jeans')]");
	By specialPriceText=By.xpath("//div[@class='_30jeq3 _16Jk6d']");
	By sizeLink=By.xpath("//a[.='4 - 5 Years']");
	By addCartButton=By.xpath("//button[text()='Add to cart']");
	By cartLink=By.xpath("//span[.='Cart']");
	
	WebDriver driver;
	WebDriverWait wait;
	
	public KidsJeansPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 40);
	}
	
	
	public KidsJeansPage clickboysAndGirlsRegularMidRiseBlueJeansLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(boysAndGirlsRegularMidRiseBlueJeansLink));
		 driver.findElement(boysAndGirlsRegularMidRiseBlueJeansLink).click();
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		 return this;
	}
	
	public KidsJeansPage clickSizeLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(sizeLink));
		 driver.findElement(sizeLink).click();
		 return this;
	}
	
	public KidsJeansPage clickAddCartButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addCartButton));
		//new Actions(driver).moveToElement(driver.findElement(addCartButton)).perform(); 
		driver.findElement( addCartButton).click();
		
	     return this;
	}
	
	
    
	public String getProductName()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(boysAndGirlsRegularMidRiseBlueJeansText));
		 String productName=driver.findElement(boysAndGirlsRegularMidRiseBlueJeansText).getText();
		return productName.replace(" Regular Mid Rise","");
	}
	
	public String getProductPrice()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(specialPriceText));
		String productPrice=driver.findElement(specialPriceText).getText();
		return productPrice.replace("₹","");
	}
	
	public KidsJeansPage goToCart() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartLink));
		driver.findElement( cartLink).click();
		return this;
	}
	
	public boolean verifyCartPageLoaded() {
		wait.until(ExpectedConditions.urlToBe("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART"));
		return driver.getTitle().contains("Shopping Cart | Flipkart.com");
	}
	
}