package com.eCommerce.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(Listen.class)
public class Main {
	private static WebDriver driver;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	public WebElement menubar;
	
	@FindBy(xpath="//a[@id='reset_sidebar_link']")
	public WebElement reset_app;
	public Main() {
		// TODO Auto-generated constructor stub
	}

	//Before Test, set up init
	@Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void bfTest() throws IOException {
//		if(browser.equalsIgnoreCase("firefox")){
//			
//		}
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Junghwan Shin\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		// BaseInit setup = new BaseInit(driver);
		String url = "https://www.saucedemo.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
		
		BasicConfigurator.configure();
		Logger log = Logger.getLogger("devpinoyLogger");
	}
	
	//Verify login sucessfully
	@Test
	public void test_case_01 () {
		Login login = new Login(driver);
		login.enter_username("standard_user");
		login.enter_password("secret_sauce");
		login.click_login();
		
		List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		int number_products = list_products.size();
		System.out.println("Verifying login is the number of products: " + number_products);
		AssertJUnit.assertEquals(number_products, 6);
	}
	
	//Verify sorting A to Z 
	@Test
	public void test_case_02 () {
		Sorting sort = new Sorting(driver);
		sort.click_list_sort("A to Z"); //click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Sauce Labs Backpack");
		AssertJUnit.assertEquals(last_product, "Test.allTheThings() T-Shirt (Red)");
	}
	//Verify sorting Z to A
	@Test
	public void test_case_03 () {
		Sorting sort = new Sorting(driver);
		sort.click_list_sort("Z to A"); //click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "Test.allTheThings() T-Shirt (Red)");
		AssertJUnit.assertEquals(last_product, "Sauce Labs Backpack");	
	}	
	//Verify sorting price low to high
	@Test
	public void test_case_04 () {
		Sorting sort = new Sorting(driver);
		sort.click_list_sort("Low"); //click A to Z
		String first_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]")).getText();
		String last_product = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[6]")).getText();
		AssertJUnit.assertEquals(first_product, "$7.99");
		AssertJUnit.assertEquals(last_product, "$49.99");	
	}
	//Verify sorting price high to low
	//Special verifying.
	//Go over each price with assertion.
	@Test
	public void test_case_05 () {
		ArrayList ar = new ArrayList<String>();
		ArrayList actual_ar = new ArrayList<String>();
		actual_ar.add("$49.99");actual_ar.add("$29.99");actual_ar.add("$15.99");actual_ar.add("$15.99");
		actual_ar.add("$9.99");actual_ar.add("$7.99");
		Sorting sort = new Sorting(driver);
		sort.click_list_sort("High"); //click A to Z
		List<WebElement> list_products = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		for(WebElement a : list_products) {
			ar.add(a.getText());
		}
		for(int i = 0; i < ar.size(); i++) {
			AssertJUnit.assertEquals(ar.get(i), actual_ar.get(i));
		}
		
	}
	//Verify to be click to buy product and remove
	@Test
	public void test_case_06 () throws InterruptedException {
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
	//Verify buy products and it is correct number of products in the cart.
	@Test
	public void test_case_07 () {
		WebElement first_product = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]"));
		first_product.click();
		String number_of_products = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		AssertJUnit.assertEquals(number_of_products, "1");
	}
	//verify more than one to be able to buy product
	@Test
	public void test_case_08 () {
		WebElement first_product = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		String number_of_products = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		AssertJUnit.assertEquals(number_of_products, "2");		
	}
	//verify check out from one product
	@Test
	public void test_case_09 () throws InterruptedException {
		//we need to reset because the web application is stuck with chosen options.
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='reset_sidebar_link']")).click();
		driver.navigate().refresh();
		CheckOut checkout = new CheckOut(driver);
		//shopping_cart_link
		WebElement first_product = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[5]"));
		first_product.click();
		
		checkout.go_to_checkout();
		checkout.check_out();
		checkout.enter_user_info("James", "James", "2000");
		checkout.continue_after_checkout();
		checkout.click_finish();
		String recipt = checkout.confirmed();
		AssertJUnit.assertEquals(recipt, "THANK YOU FOR YOUR ORDER");
		//Back to home
		driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small']")).click();
		
	}
	//verify removing products in the checkout page.
	@Test
	public void test_case_10 () {
		CheckOut checkout = new CheckOut(driver);
		WebElement first_product = driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[2]"));
		first_product.click();
		checkout.go_to_checkout();
		checkout.remove();
	}
	//verify cannot proceed without fname, lname, zip
	//Test case 11 is not good because zip code allows text instead of allowing only number.
	@Test
	public void test_case_11 () {
		AssertJUnit.assertEquals("1", "z");
	}
	//Verify social media icons
	//facebook
	//twitter
	//linkedin
	@Test
	public void test_case_0 () {
		

	}
	@AfterTest(alwaysRun = true)
	public void afTest() throws IOException {
		driver.quit();
	}
	
}
