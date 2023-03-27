package tests;

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

public class FlipkartSmokeTest extends BasePage{
	
	

	
	@Test(priority=0)
	public void UserSelectTheProductAndVerifyTheProductNameAndPriceInCartPage() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		KidsJeansPage kidsJeansPage=new KidsJeansPage(driver);
		CartPage cartPage=new CartPage(driver);
		homePage.clickCrossMarkLink().hoverOverFashionLink().hoverOverKidsLink().clickBoysAndGirlsJeansLink();
		String productName=kidsJeansPage.clickboysAndGirlsRegularMidRiseBlueJeansLink().getProductName();
		String productPrice=kidsJeansPage.getProductPrice();
		kidsJeansPage.clickSizeLink().clickAddCartButton().goToCart();
		Assert.assertTrue(cartPage.verifyTheProductNameInCart(productName));
        Assert.assertTrue(cartPage.verifyTheProductPriceInCart(productPrice));
		
		
	}
	
	
	
	
	
	
	
	
}	
