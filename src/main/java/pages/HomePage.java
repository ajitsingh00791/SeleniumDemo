package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	By fashionLink= By.xpath("//div[.='Fashion']");
	By kidsLink=By.xpath("//a[.='Kids']");
	By boysAndGirlsJeansLink=By.xpath(" //a[contains(text(),'Boys & Girls Jeans')]");
	By crossMarkLink=By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 50);
	}
	
	
	public HomePage hoverOverFashionLink() {
		new Actions(driver).moveToElement(driver.findElement( fashionLink)).perform();
		return this;
	}
	
	public HomePage hoverOverKidsLink() {
		new Actions(driver).moveToElement(driver.findElement( kidsLink)).perform();
		return this;
	}
	
	public HomePage clickBoysAndGirlsJeansLink() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(boysAndGirlsJeansLink));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(boysAndGirlsJeansLink));
		return this;
	}
	 
	public HomePage clickCrossMarkLink() {
		driver.findElement(crossMarkLink).click();
		return this;
	}
		
}
