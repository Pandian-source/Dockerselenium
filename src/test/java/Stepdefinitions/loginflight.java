package Stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginflight {

	public static WebDriver driver = null;

@Given("user open the chrome browser")
public void user_open_the_chrome_browser() 
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pandiyan\\eclipse-workspace\\Seleniumwithcucumber\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser opened");
	}
@Then("user is on login page")
public void user_is_on_login_page() 
	{
		String baseUrl = "https://b2bui2.tltid.com/login";
		String expectedTitle = "Login";
		String actualTitle = "";
		driver.get(baseUrl);
		actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("Test Passed");
		} 
		else 
		{
			System.out.println("Test Failed");
		} }
@When("user enters username and password")
public void user_enters_username_and_password() 
	{
		System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.click();
		System.out.println("username field clicked");
		username.sendKeys("a.pandian@wintlt.com");
		System.out.println("Username field entered");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.click();
		System.out.println("password field clicked");
		password.sendKeys("12345S#");
		System.out.println("password field entered");

	}
@And("click the login button")
public void click_the_login_button() 
	{
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		System.out.println("Entered username and password");
		System.out.println("clicked the login button");
	}
@Then("user is navigated to the home page")
public void user_is_navigated_to_the_home_page() throws InterruptedException 
	{
		System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		Thread.sleep(30000);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[2]"))).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("YVR");
		System.out.println("Navigated the application page");
		driver.close();
		System.out.println("browser closed");
	}
}
