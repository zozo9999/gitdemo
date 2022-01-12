package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.eCommerce.mavenProject.*;
public class Step_def {
	private WebDriver driver = new ChromeDriver();;
	Login login;
	Sorting sort;
	public Step_def() {
		// TODO Auto-generated constructor stub
	}
	@Given("a browser is given to a user")
	public void a_browser_is_given_to_a_user() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
	}

	@Given("go to a website")
	public void go_to_a_website() {
	    // Write code here that turns the phrase above into concrete actions
				
	}

	@When("enter user info")
	public void enter_user_info() {
	    // Write code here that turns the phrase above into concrete actions
	    login = new Login(driver);
	    login.enter_username("standard_user");
	    login.enter_password("secret_sauce");
	    
	}

	@When("click login")
	public void click_login() {
	    // Write code here that turns the phrase above into concrete actions
		login = new Login(driver);
		login.click_login();		
	}

	@Then("a user entered")
	public void a_user_entered() {
	    // Write code here that turns the phrase above into concrete actions
		sort = new Sorting(driver);
		sort.click_list_sort("Z to A");
	}

	@Given("a user is on the browser.")
	public void a_sorting_function_is_given() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
					    
		login = new Login(driver);
	    login.enter_username("standard_user");
	    login.enter_password("secret_sauce");
	    
		login.click_login();   
	}

	@When("clicks the sorting")
	public void clicks_the_sorting() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		sort = new Sorting(driver);
		sort.click_list_sort("Z to A");
	}

	@When("click high to low")
	public void click_a_to_z_z_to_a_low_to_high_high_to_low() {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Then("the products become high price.")
	public void verifying_the_steps() {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Given("product pages are shown")
	public void product_pages_are_shown() {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("clicks product add to cart")
	public void clicks_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement first_product = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]"));
		first_product.click();
		
	}

	@Then("I verify that every product can be added.")
	public void i_verify_that_every_product_can_be_added() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement first_product = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]"));
		first_product.isDisplayed();
	}
}
