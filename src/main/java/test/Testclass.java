package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import page.Account;
import page.Checkout;
import page.Home;

public class Testclass extends Base {
	
	private Home homepg;
	private Account accountpg;
	private Checkout checkoutpg;
	@BeforeTest
	
	public void setUp()
	
	{
		
		Driver();
		driver.get("https://www.santhionlineplants.com/");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		homepg = new Home(driver);
		accountpg = new Account(driver);
		checkoutpg = new Checkout(driver);
	}
	@Test
	public void testECommerceFlow() throws Exception
	{
		homepg.closePopUpIfPresent();
		homepg.addFirstProductToCart();
		homepg.quickViewSecondProduct();
		homepg.cateGory();
	 
		driver.get("https://www.santhionlineplants.com/products/");
		homepg.captureFullPageScreenshot("");
		homepg.captureFullPageScreenshot(By.xpath("/html/body/div[7]/div[2]/a/img"), "logo_image.png");
		driver.get("https://www.santhionlineplants.com/my-account/");
		accountpg.registerAccount("testexample432@gmail.com", "Qshwfg", "pkl");
		
		checkoutpg.clickCartIcon();
		checkoutpg.proceedToCheckoutButton();
		checkoutpg.enterDeliveryDetails("John", "D", "125 Abmc Street", "Panaji");
		checkoutpg.selectState("Goa");
		checkoutpg.agreeToTermsAndConditions();
		checkoutpg.clickPlaceOrder();
	}

	
	@AfterTest
	public void tearDown()
	{
		quit();
	}
}
