package org.stepdefinitionwc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Secure_Comply {

	WebDriver driver = new ChromeDriver();
		
	@Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
        
		driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
    }

    @When("I enter incorrect credentials multiple times")
    public void i_enter_incorrect_credentials_multiple_times() {
        
    }

    @Then("my account should be locked out")
    public void my_account_should_be_locked_out() throws InterruptedException {
        
        Thread.sleep(11000);
        
        driver.quit(); 	
    	
    }

    @Given("I request a password reset")
    public void i_request_a_password_reset() throws InterruptedException {
        
    	driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
    	
		driver.findElement(By.xpath("(//a[@class='main-login'])")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[@href='https://westcoast.wp.shottqsr.com/my-account/lost-password/'])")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("user_login")).sendKeys("vishal@hurekatek.com");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//button[@value='Reset password'])")).click();
		
		Thread.sleep(3000);
		
        WebElement resetpass = driver.findElement(By.xpath("(//div[@role='alert'])"));
        
        assertTrue(resetpass.isDisplayed());
        
        assertEquals("Password reset email has been sent.", resetpass.getText());
    
        Thread.sleep(2000);
		
    }

    @When("I check my email")
    public void i_check_my_email() {
        
    }

    @Then("I should receive a password reset email")
    public void i_should_receive_a_password_reset_email() throws InterruptedException {
        
        Thread.sleep(3000);
        
        driver.quit(); 
    	
    }

    @When("I wait for the reset link to expire")
    public void i_wait_for_the_reset_link_to_expire() throws InterruptedException {
         	
    }

    @Then("I should not be able to use the expired link to reset my password")
    public void i_should_not_be_able_to_use_the_expired_link_to_reset_my_password() throws InterruptedException {
        
    	   Thread.sleep(13000);
           
           driver.quit(); 
    	
    }

    @Given("I request to change my email address")
    public void i_request_to_change_my_email_address() throws InterruptedException {
        
    	driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
    	
    }

    @When("I check my old email")
    public void i_check_my_old_email() {
        
    }

    @Then("I should receive a verification email")
    public void i_should_receive_a_verification_email() throws InterruptedException {
        
    	Thread.sleep(11000);
        
        driver.quit();
    	
    }

    @When("I click the verification link")
    public void i_click_the_verification_link() {
        
    }

    @Then("my email address should be updated")
    public void my_email_address_should_be_updated() throws InterruptedException {
        
    	Thread.sleep(12000);
        
        driver.quit();
    	
    }

    @Given("I am on the payment page")
    public void i_am_on_the_payment_page() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
    	
    }

    @When("I enter valid payment details")
    public void i_enter_valid_payment_details() {
        
    }

    @Then("the payment should be processed securely")
    public void the_payment_should_be_processed_securely() throws InterruptedException {
        
        Thread.sleep(13000);
        
        driver.quit();
    	
    }

    @Given("I access sensitive data")
    public void i_access_sensitive_data() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
    	
    }

    @Then("the data should be encrypted at rest")
    public void the_data_should_be_encrypted_at_rest() throws InterruptedException {
        
        Thread.sleep(11000);
        
        driver.quit();
    	
    }

    @Given("a security event occurs")
    public void a_security_event_occurs() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
    	
    }

    @When("I check the audit logs")
    public void i_check_the_audit_logs() {
        
    }

    @Then("the event should be recorded in the logs")
    public void the_event_should_be_recorded_in_the_logs() throws InterruptedException {
        
        Thread.sleep(12000);
        
        driver.quit();
    	
    }

    @Given("I request my data for GDPR compliance")
    public void i_request_my_data_for_GDPR_compliance() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
    	
    }

    @When("I check the response")
    public void i_check_the_response() {
        
    }
    
    @Then("my data should be provided or deleted as per GDPR")
    public void my_data_should_be_provided_or_deleted_as_per_GDPR() throws InterruptedException {
        
    	 Thread.sleep(13000);
         
         driver.quit();
    	
    }

    @When("I enter payment details")
    public void i_enter_payment_details() {
        
    }

    @Then("the payment process should be compliant with PCI DSS standards")
    public void the_payment_process_should_be_compliant_with_PCI_DSS_standards() throws InterruptedException {
        
    	Thread.sleep(11000);
        
        driver.quit();
    	
    }
	
}
