package org.stepdefinitionwc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class End2End {

	WebDriver driver = new ChromeDriver();
	
	@Given("the user logs into the website")
	
	public void the_user_logs_into_the_website() throws InterruptedException {
		
		driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class='main-login'])")).click();
			
		Thread.sleep(3000);
		
		driver.findElement(By.name("username")).sendKeys("vishal@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@6394");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

		Thread.sleep(3000);
		
	}

	@And("User navigates to shop all tab")
    
	public void User_navigates_to_shop_all_tab() throws InterruptedException {

	    
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@href='/shop']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("product-search")).sendKeys("Colombian");
		
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/product/product-decaf-colombian-whole-bean-coffee-5lb/']")));
		element.click();

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[@class='single_add_to_cart_button button alt'])")).click();
		
		Thread.sleep(5000);
		
}
	
	@Then("the user adds Decaf Colombian Whole Bean Coffee 5 lb to the cart")
	
	public void the_user_adds_Decaf_Colombian_Whole_Bean_Coffee_5_lb_to_the_cart() throws InterruptedException {

	   Thread.sleep(2000);
		
	   WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
		Actions actions = new Actions(driver);
		actions.moveToElement(cartLink).click().perform();
		
       Thread.sleep(2000);
		
       driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();;
		
	   Thread.sleep(3000);
		
	}

	 @And("the final check out is done with order confirmation")
    
	 public void the_final_check_out_is_done_with_order_confirmation() throws InterruptedException {	 
		 
       Thread.sleep(2000);
       
       driver.findElement(By.xpath("//div[@class='nxtstp stpbutn']")).click();
       	
	   Thread.sleep(3000);
	   	   
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nextstp-2 stpbutn']")));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
       
       Thread.sleep(5000);
       
       WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
       WebElement element2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='custom_shipping_method_ups_ground']")));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
       
	    Thread.sleep(3000);
	    
	    WebElement element1 = driver.findElement(By.xpath("//div[@class='nextstp-3 stpbutn']"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
       
	    Thread.sleep(3000);
	   
	    try {
	    	
	    	WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10)); 

	    	Thread.sleep(2000);
	    	
	    	WebElement iframeElement1 = driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]"));
	    	driver.switchTo().frame(iframeElement1);

            WebElement cardNumberField = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='number']")));
            cardNumberField.sendKeys("4242424242424242");

            driver.switchTo().defaultContent();
	        
            Thread.sleep(2000);
            
            WebElement iframeElement2 = driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]"));
	    	driver.switchTo().frame(iframeElement2);

	    	WebElement expDateField = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='expiry']")));
	    	expDateField.sendKeys("1234");
	    	
	    	driver.switchTo().defaultContent();
	    	
            Thread.sleep(2000);
            
            WebElement iframeElement3 = driver.findElement(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]"));
	    	driver.switchTo().frame(iframeElement3);

	    	WebElement cvcField = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cvc']")));
	    	cvcField.sendKeys("567");
	    	
	    	driver.switchTo().defaultContent();
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	    
	    	Thread.sleep(3000);
			
		    driver.findElement(By.xpath("//button[@name='woocommerce_checkout_place_order']")).click();
	    	
	        Thread.sleep(25000);
	 
	        WebDriverWait wait5 = new WebDriverWait(driver,Duration.ofSeconds(10));
	        
	        WebElement orderReceived = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", orderReceived);
	        
	    	assertTrue(orderReceived.isDisplayed());
	        
	    	assertEquals("Thank you. Your order has been received.", orderReceived.getText());

	    	Thread.sleep(3000);
	        
	      driver.close();
	  
	    }
	 }
 }
