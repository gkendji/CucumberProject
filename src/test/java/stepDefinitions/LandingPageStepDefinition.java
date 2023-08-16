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
	
	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortname) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("Top Deals")).click();
	    Set<String> s1 = driver.getWindowHandles(); //armazenamos as duas janelas abertas no set, getWindowHandles pega a janela Pai e a janela Filho
	    Iterator<String> i1 = s1.iterator(); //iterator() itera, vai para o proximo elemento da lista
	    String parentWindow = i1.next(); //next() vai para o proximo elemento, no caso volta para 0, ou seja, para a janela principal, a janela Pai
	    String childWindow = i1.next();
	    driver.switchTo().window(childWindow);
	    driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
	    Thread.sleep(2000);
	    offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	    
	    
	}
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_with_Landing_Page() {
		Assert.assertEquals(offerPageProductName, landingPageProductName);
	}
}
