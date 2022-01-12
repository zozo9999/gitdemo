package StepDefinitions;

import io.cucumber.java.en.Given;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;
public class CCB_Shopping_Products {
	private WebDriver driver;
	public CCB_Shopping_Products() {
		// TODO Auto-generated constructor stub
	}
	@Given("I am on the shopping page.")
	public void i_am_on_the_shopping_page() {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("Click a product")
	public void click_a_product() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> list_products = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
		for(WebElement a : list_products) {
			a.click();
		}
		//btn btn_secondary btn_small btn_inventory
		List<WebElement> list_products2 = driver.findElements(By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']"));
		Thread.sleep(1000);
		for(WebElement a : list_products2) {
			a.click();
		}
	}

	@When("Click check out")
	public void click_check_out() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I validate the checkout")
	public void i_validate_the_checkout() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
