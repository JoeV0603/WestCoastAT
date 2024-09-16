package org.stepdefinitionwc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cust_Serv {

	WebDriver driver = new ChromeDriver();
	
	@Given("User is on the homepage")
    public void user_is_on_the_homepage() throws InterruptedException {
     
		driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(2000);	
		
    }

    @When("User navigates to the customer support page")
    public void user_navigates_to_the_customer_support_page() throws InterruptedException {
        
    	WebElement contact = driver.findElement(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/contact-us/']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", contact);
	    
	    Thread.sleep(5000);
    	
    }

    @Then("Customer support page should be displayed")
    public void customer_support_page_should_be_displayed() throws InterruptedException {
        
        WebElement custServ = driver.findElement(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/contact-us/']"));
        
	    assertTrue(custServ.isDisplayed());
	        
	    assertEquals("Contact Us", custServ.getText());
	    
	    Thread.sleep(2000);
    	
	    driver.quit();
	    
    }

    @Given("User is on the customer support page")
    public void user_is_on_the_customer_support_page() throws InterruptedException {
     
		driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);	
		
		driver.findElement(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/contact-us/']")).click();
	    
	    Thread.sleep(3000);
		
    }

    @Then("User should see the customer service email id")
    public void User_should_see_the_customer_service_email_id() throws InterruptedException {
	    
        WebElement email = driver.findElement(By.xpath("//a[@href='mailto:info@westcoastcoffee.com']"));
        
	    assertTrue(email.isDisplayed());
	        
	    assertEquals("info@westcoastcoffee.com", email.getText());
	    
	    Thread.sleep(2000);
    	
	    driver.quit();
	    
    }

    @Then("User should see the customer service phonenumber")
    public void User_should_see_the_customer_service_phonenumber() throws InterruptedException {
        
//        WebElement phone = driver.findElement(By.xpath("//a[@href='tel:18007352878']"));
//        
//	    assertTrue(phone.isDisplayed());
//	        
//	    assertEquals("800-735-2878", phone.getText());
//	    
//	    Thread.sleep(2000);
    	
	    driver.quit();
    	
    }  

    @Then("User should see the service location successfully")
    public void User_should_see_the_service_location_successfully() throws InterruptedException {
        
    	WebElement location = driver.findElement(By.xpath("//a[@href='https://www.google.com/maps/place/West+Coast+Coffee/@45.569088,-122.5710324,17z/data=!3m1!4b1!4m6!3m5!1s0x549505c3fcd7634b:0x15347108b099b4b8!8m2!3d45.5690843!4d-122.5684575!16s%2Fg%2F1tfm14xn?entry=ttu']"));

        String actualText = location.getText();
        System.out.println("Actual Location: " + actualText);

        String expectedText = "9120 NE Alderwood Rd.";
        assertTrue("Page does not contain the expected address", 
            actualText.contains(expectedText));
        
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//a[@href='https://www.google.com/maps/place/West+Coast+Coffee/@45.569088,-122.5710324,17z/data=!3m1!4b1!4m6!3m5!1s0x549505c3fcd7634b:0x15347108b099b4b8!8m2!3d45.5690843!4d-122.5684575!16s%2Fg%2F1tfm14xn?entry=ttu']")).click();
	    
	    Thread.sleep(5000);
    	
	    driver.quit();
    	
    }  
     
    @When("User submits a query through the Contact Us form")
    public void user_submits_a_query_through_the_Contact_Us_form() throws InterruptedException {
    	
    	driver.findElement(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/contact-us/']")).click();
	    
	    Thread.sleep(3000);
        
	    driver.findElement(By.xpath("//input[@name='name-2']")).sendKeys("Joe Vishal");
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//input[@name='email-1']")).sendKeys("vishal@hurekatek.com");
	    
	    Thread.sleep(1000);
	    
        driver.findElement(By.xpath("//input[@name='name-4']")).sendKeys("Los Angeles");
	    
	    Thread.sleep(1000);
	    
        driver.findElement(By.xpath("//input[@name='phone-1']")).sendKeys("1234567890");
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//textarea[@name='textarea-1']")).sendKeys("Test Message");
	    
	    Thread.sleep(1000);
	    	    
	    driver.findElement(By.xpath("//button[@class='forminator-button forminator-button-submit']")).click();
	    
	    Thread.sleep(3000);
        
    }

    @Then("Contact Us form confirmation message should be displayed")
    public void contact_us_form_confirmation_message_should_be_displayed() throws InterruptedException {
        
        WebElement contactUs = driver.findElement(By.xpath("//div[@role='alert']"));
        
	    assertTrue(contactUs.isDisplayed());
	        
	    assertEquals("Thank you for contacting us, we will be in touch shortly.", contactUs.getText());
	    
	    Thread.sleep(2000);
    	
	    driver.quit();
    	
    }
    
    @Then("Contact Us form confirmation email should be received")
    public void contact_us_form_confirmation_email_should_be_received() {
        
    	driver.quit();
    	
    }
	
}
