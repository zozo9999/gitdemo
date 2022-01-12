package com.eCommerce.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {
	private WebDriver driver;
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	public WebElement go_to_checkout;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button']")
	public WebElement checkout;
	@FindBy(xpath="//input[@class='submit-button btn btn_primary cart_button btn_action']")
	public WebElement continue_after;
	@FindBy(name="firstName")
	public WebElement fname;
	@FindBy(name="lastName")
	public WebElement lname;
	@FindBy(name="postalCode")
	public WebElement zip;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	public WebElement shopping_cart_bag;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']")
	public WebElement finish;
	@FindBy(xpath="//h2[@class='complete-header']")
	public WebElement confirm;
	
	public CheckOut(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
		
	public void go_to_checkout() {

//		String number_bag = shopping_cart_bag.getText();
//		if (number_bag.equals("1")) {
			go_to_checkout.click();	
//		}

		String number_bag = shopping_cart_bag.getText();
		if (number_bag.equals("1")) {
			go_to_checkout.click();	
		}

	}
	
	//go to check out
	public void check_out() {
		checkout.click();
	}
	
	public void enter_user_info(String fname, String lname, String zip) {
		this.fname.sendKeys(fname);
		this.lname.sendKeys(lname);
		this.zip.sendKeys(zip);
	}
	
	public void continue_after_checkout() {
		continue_after.click();
	}
	
	public void click_finish() {
		finish.click();
	}
	
	public String confirmed() {
		String result = "";
		result = confirm.getText();
		return result;
	}
	
	public void remove() {
		driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")).click();
	}
}
