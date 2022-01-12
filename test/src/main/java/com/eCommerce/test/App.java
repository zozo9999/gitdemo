package com.eCommerce.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "2chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get("https:www.google.com/");
        System.out.println( "Hello World!" );
    }
}
