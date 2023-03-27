package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.KidsJeansPage;
import pages.BasePage;
import pages.CartPage;
import pages.HomePage;

public class DemoQaTest extends BasePage{
	
	

	
	@Test(priority=0)
	public void getChildIframe() {
    driver.navigate().to("https://demoqa.com/nestedframes");
    driver.switchTo().frame("frame1").switchTo().frame(0);
    System.out.println(driver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());
	}
    
    @Test(priority=1)
	public void handleAllFourAlert() throws InterruptedException {
    driver.navigate().to("https://demoqa.com/alerts");
    driver.findElement(By.xpath("//button[@id='alertButton']")).click();
    driver.switchTo().alert().accept();
    driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
    Thread.sleep(5000);
    driver.switchTo().alert().accept();
    driver.findElement(By.xpath(" //button[@id='confirmButton']")).click();
    driver.switchTo().alert().accept();
    driver.findElement(By.xpath("//button[@id='promtButton")).click();
    driver.switchTo().alert().sendKeys("userid");
    }
    
    
    @Test()
	public void navigateToNewWndow() {
    driver.navigate().to("https://demoqa.com/browser-windows");
    driver.findElement(By.xpath("//button[text()='New Window']']")).click();
    String parent=driver.getWindowHandle();
    Set<String> handle=driver.getWindowHandles();
    Iterator<String> itr=handle.iterator();
    while(itr.hasNext())
    {
    	String win=itr.next();
    	if(!parent.equals(win))
    	{driver.switchTo().window(win);
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        driver.close();}
    }
    
	
   
	
}
  
 
  
	
	
	
	
	
	
	
	
}	
