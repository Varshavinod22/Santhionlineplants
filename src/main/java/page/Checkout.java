package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Checkout {
	
	private WebDriver driver;
	
	private By cartIcon = By.xpath("//a[@href='https://www.santhionlineplants.com/cart/']");
	private By proceedToCheckoutButton = By.xpath("/html/body/div[15]/div/div/div[2]/div/div/a");
	private By firstNameField = By.id("billing_first_name");
	private By lastNameField = By.id("billing_last_name");
    private By addressField = By.id("billing_address_1");
    private By cityField = By.id("billing_city");
    private By stateDropdown = By.id("billing_state_field");
    private By termsAndConditionsCheckbox = By.id("terms");
    private By placeOrderButton = By.id("place_order");
    
    public  Checkout(WebDriver driver)
    {
    	this.driver = driver;
    }
    
    public void clickCartIcon()
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
    	cartElement.click();
    }
    
    public void proceedToCheckoutButton()
    {
    	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
    	checkoutButton.click();
    	
    } 
    
    public void enterDeliveryDetails(String firstName, String lastName, String address, String city)
    {
    	driver.findElement(firstNameField).sendKeys(firstName);
    	driver.findElement(lastNameField).sendKeys(lastName);
    	driver.findElement(addressField).sendKeys(address);
    	driver.findElement(cityField).sendKeys(city);
    }
    
    public void selectState(String state)
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement stateDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(stateDropdown));
    	stateDropdownElement.click();
//    	stateDropdownElement.sendKeys(state);
    }
    
    public void agreeToTermsAndConditions()
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement termsElement = wait.until(ExpectedConditions.elementToBeClickable(termsAndConditionsCheckbox));
    	termsElement.click();
    }
    
    public void clickPlaceOrder()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement placeOrderButtonElement = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
    	placeOrderButtonElement.click();
    }
}
