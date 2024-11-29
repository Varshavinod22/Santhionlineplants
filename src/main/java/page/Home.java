package page;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	
	private WebDriver driver;
	
	private By firstProductAddToCart =By.xpath("/html/body/div[17]/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[2]/fieldset/input");
	private By secondProductQuickView =By.xpath("/html/body/div[17]/div/div/div/div[1]/div[1]/div[2]/div/div[1]/div/div/a");
	private By dropDown=By.xpath("/html/body/div[7]/div[1]/form/ul/li/a");
	private By itemSelect=By.xpath("//*[@id=\"agileinfo-nav_search\"]/div/div/li[5]/a");
	private By addtoCart=By.xpath("//*[@id=\"main\"]/ul/li[1]/div/a[2]");
	private By headerSection=By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a");
	private By sectiontoCart=By.xpath("/html/body/div[17]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/fieldset/input");
	private By indoorPlant=By.xpath("/html/body/div[8]/ul/li[2]");
	private By selectPlant=By.xpath("/html/body/div[8]/ul/li[2]/ul/li[2]/a");
	private By plant=By.xpath("//*[@id=\"main\"]/ul/li[1]/div/a[2]");
	private By popUpCloseButton = By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]");
    
    public Home(WebDriver driver)
    {
    	this.driver=driver;
    
    }
    
    public void addFirstProductToCart() {
    	driver.findElement(firstProductAddToCart).click();
    }
    
    
    public void quickViewSecondProduct() {
    	Actions act =new Actions(driver);
    	act.moveToElement(driver.findElement(secondProductQuickView)).perform();
    	driver.findElement(secondProductQuickView).click();
    }
    
    public void cateGory()
    {
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    driver.findElement(dropDown).click();	
    driver.findElement(itemSelect).click();
    driver.findElement(addtoCart).click();
    driver.findElement(headerSection).click();
    driver.findElement(sectiontoCart).click();
    driver.findElement(indoorPlant).click();
    driver.findElement(selectPlant).click();
    driver.findElement(plant).click();
    
    }
    public void closePopUpIfPresent()
    {
    driver.findElement(popUpCloseButton).click();
    }
    
    public void captureFullPageScreenshot(String fileName) throws Exception
    {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File screenshot = ts.getScreenshotAs(OutputType.FILE);
    	FileHandler.copy(screenshot, new File("src/test/resources/Screenshot/productpage.png"));
    }
    
    public void captureFullPageScreenshot(By elementLocator,String fileName) throws Exception
    {
    	WebElement element = driver.findElement(elementLocator);
    	File screenshoticon = element.getScreenshotAs(OutputType.FILE);
    	FileHandler.copy(screenshoticon, new File("src/test/resources/Screenshot/icon.png"));
    }
}
    
    
    
         

