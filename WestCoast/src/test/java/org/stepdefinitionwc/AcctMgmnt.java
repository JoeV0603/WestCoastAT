package org.stepdefinitionwc;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AcctMgmnt {

	WebDriver driver = new ChromeDriver();
	
	@Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {
        
		driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class='main-login'])")).click();
			
		Thread.sleep(3000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test11@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();
		
		Thread.sleep(3000);
		
    }

    @When("the user updates their profile information")
    public void the_user_updates_their_profile_information() throws InterruptedException {
        
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/my-account/edit-account/']")).click();
    	
    	Thread.sleep(1000);
    	
        driver.findElement(By.id("account_first_name")).clear();
        
        driver.findElement(By.id("account_first_name")).sendKeys("Joe");
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='save_account_details']")));
		element.click();
        
        Thread.sleep(3000);
        
    }

    @Then("the profile information should be updated successfully")
    public void the_profile_information_should_be_updated_successfully() {
        
        String name = driver.findElement(By.id("account_first_name")).getAttribute("value");
        
        Assert.assertEquals("Joe", name);
        
        driver.quit();
        
    }

    @When("the user changes their password")
    public void the_user_changes_their_password() throws InterruptedException {
        
        Thread.sleep(1000);
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/my-account/edit-account/']")));
        editAccountLink.click();
    	
    	Thread.sleep(3000);
        
        driver.findElement(By.id("password_current")).sendKeys("Joevishal@0603");
        
        driver.findElement(By.id("password_1")).sendKeys("Joevishal@6394");
        
        driver.findElement(By.id("password_2")).sendKeys("Joevishal@6394");
        
        Thread.sleep(1000);
        
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='save_account_details']")));
		element.click();
        
        Thread.sleep(1000);
        
    }
    

    @Then("the password should be changed successfully")
    public void the_password_should_be_changed_successfully() throws InterruptedException {
    	
    	Thread.sleep(1000);
        
        String message = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
        
        Assert.assertEquals("Account details changed successfully.", message);
        
        driver.quit();
        
    }

    @Given("the user must be logged in")
    public void the_user_must_be_logged_in() throws InterruptedException {
        
		driver.get("https://westcoast.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class='main-login'])")).click();
			
		Thread.sleep(3000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test11@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@6394");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();
		
		Thread.sleep(3000);
		
    }
    
    @When("the user saves a new payment method")
    public void the_user_saves_a_new_payment_method() throws InterruptedException {
        
        Thread.sleep(1000);
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/my-account/payment-methods/']")));
        payment.click();
        
    	Thread.sleep(3000);
    	
    	WebElement addpay = driver.findElement(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/my-account/add-payment-method/']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addpay);
        
    	Thread.sleep(3000);

      try {
	    	
	    	WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(20)); 

	    	Thread.sleep(2000);
	    	
	    	WebElement iframeElement = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));
	    	driver.switchTo().frame(iframeElement);

            WebElement cardNumberField = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='number']")));
            cardNumberField.sendKeys("4242424242424242");

            driver.switchTo().defaultContent();
	        
            Thread.sleep(3000);
            
            WebElement iframeElement1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));
	    	driver.switchTo().frame(iframeElement1);

	    	WebElement expDateField = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='expiry']")));
	    	expDateField.sendKeys("1234");
	    	
	    	driver.switchTo().defaultContent();
	    	
            Thread.sleep(3000);
            
            WebElement iframeElement2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]")));
	    	driver.switchTo().frame(iframeElement2);

	    	WebElement cvcField = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='cvc']")));
	    	cvcField.sendKeys("567");
	    	
	    	driver.switchTo().defaultContent();
	    
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        }
      
        Thread.sleep(2000);
      
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	    WebElement element = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Add payment method']")));
	    element.click();
      
        Thread.sleep(7000);
        
	    }

    @Then("the payment method should be saved successfully")
    public void the_payment_method_should_be_saved_successfully() throws InterruptedException {
        
        Thread.sleep(1000);
        
        String message = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
        
        Assert.assertEquals("Payment method successfully added.", message);
        
        driver.quit();
    
    }

    @When("the user logs out")
    public void the_user_logs_out() throws InterruptedException {
       
        Thread.sleep(1000);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'customer-logout')]")));
		logoutButton.click();
    	
    	Thread.sleep(3000);
    	
    }

    @Then("the user should be logged out successfully")
    public void the_user_should_be_logged_out_successfully() throws InterruptedException {
        
    	Thread.sleep(1000);

        WebElement logout = driver.findElement(By.xpath("//div[@class='u-column1 col-8']"));

        String actualText = logout.getText();
        System.out.println("Actual logout message: " + actualText);

        String expectedText = "Please log in to continue";
        assertTrue("Logout message do not contain the expected text", 
            actualText.contains(expectedText));
        
    	Thread.sleep(1000);
    	
    	driver.quit();
        
    }

    @When("the user views their account details")
    public void the_user_views_their_account_details() throws InterruptedException {
      
        Thread.sleep(1000);
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acctDetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/my-account/edit-account/']")));
        acctDetails.click();
    	
    	Thread.sleep(3000);
    	
    }

    @Then("the account details should be displayed correctly")
    public void the_account_details_should_be_displayed_correctly() throws InterruptedException {
        
        String firstName = driver.findElement(By.id("account_first_name")).getAttribute("value");
        
        Assert.assertEquals("Joe", firstName);
        
        Thread.sleep(1000);
    	
        String lastName = driver.findElement(By.id("account_last_name")).getAttribute("value");
        
        Assert.assertEquals("Vishal", lastName);
        
        Thread.sleep(1000);
        
        String email = driver.findElement(By.id("account_email")).getAttribute("value");
        
        Assert.assertEquals("vishal+test11@hurekatek.com", email);
        
        Thread.sleep(1000);
        
        driver.quit();
        
    }
    
}
