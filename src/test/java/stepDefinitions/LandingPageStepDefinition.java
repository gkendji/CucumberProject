package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.setProperty("webdriver.chrome.driver", "C:/Users/guilh/ChromeDriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    
	}
	
	@When("user search for shortname {string} and extract atual name of product")
	public void user_search_for_shortname_and_extract_atual_name_of_product(String shortname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
	    Thread.sleep(2000);
	    landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	    System.out.println(landingPageProductName + " is extracted from homepage");
	}
	
//teste
	
}
