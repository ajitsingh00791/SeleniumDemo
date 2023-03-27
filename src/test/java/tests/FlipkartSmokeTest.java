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
		logger.log(LogStatus.INFO, "Hover on Fashion and Kids and click on BoysAndGirlsJeans");
		homePage.clickCrossMarkLink().hoverOverFashionLink().hoverOverKidsLink().clickBoysAndGirlsJeansLink();
		logger.log(LogStatus.INFO, "Get the product name from the kidsJeans page");
		String productName=kidsJeansPage.clickboysAndGirlsRegularMidRiseBlueJeansLink().getProductName();
		logger.log(LogStatus.INFO, productName);
		logger.log(LogStatus.INFO, "Get the product price from the kidsJeans page");
		String productPrice=kidsJeansPage.getProductPrice();
		logger.log(LogStatus.INFO, productPrice);
		logger.log(LogStatus.INFO, "click on boysAndGirlsRegularMidRiseBlueJeansLink and select the size and add it to the cart");
		kidsJeansPage.clickSizeLink().clickAddCartButton().goToCart();
		logger.log(LogStatus.INFO, "Checking if " + productName + "  is present in Cart");
		Assert.assertTrue(cartPage.verifyTheProductNameInCart(productName));
        logger.log(LogStatus.INFO, "Checking if " + productPrice + "  is present in Cart");
		Assert.assertTrue(cartPage.verifyTheProductPriceInCart(productPrice));
		
		
	}
	
	
	
	
	
	
	
	
}	
