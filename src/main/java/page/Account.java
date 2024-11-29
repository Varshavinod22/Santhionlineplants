package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {
	
	private WebDriver driver;
	
	private By emailField = By.name("email");
	private By firstNameField = By.name("first_name");
	private By lastNameField =By.name("last_name");
	private By termsCheckbox =By.id("profile_terms_field");
	private By registerButton = By.name("register");
	
	public Account(WebDriver driver)
	{
		this.driver = driver;
	}

	public void registerAccount(String email, String firstName, String lastName)
	{
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(termsCheckbox).click();
		driver.findElement(registerButton).click();
	}
}
