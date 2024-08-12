package org.stepdefinition;

import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Compatability {

	WebDriver driver;
	
	WebDriver driver1;
	
	WebDriver driver2;
	
	 @Given("I open the browser Chrome")
	    public void i_open_the_browser_chrome() throws InterruptedException {
	       
		    driver = new ChromeDriver();
		 
		    driver.get("https://boyds.wp.shottqsr.com/");

			driver.manage().window().maximize();

			Thread.sleep(1000);
		 
	    }

	    @Given("I open the browser Edge")
	    public void i_open_the_browser_edge() throws InterruptedException {
	    
	    	driver1 = new EdgeDriver();
	    	
	    	driver1.get("https://boyds.wp.shottqsr.com/");

			driver1.manage().window().maximize();

			Thread.sleep(1000);
	    	
	    }
	 
	    @Given("I open the browser Firefox")
	    public void i_open_the_browser_firefox() throws InterruptedException {
	      
	    	driver2 = new FirefoxDriver();
	    	
	    	driver2.get("https://boyds.wp.shottqsr.com/");

			driver2.manage().window().maximize();

			Thread.sleep(1000);
	    	
	    }
	    
	    @When("I navigate to the website")
	    public void i_navigate_to_the_website() throws InterruptedException {
	        

          	Thread.sleep(3000);
	        
	    }
	    
	    @When("I navigate to the website on Windows")
	    public void i_navigate_to_the_website_on_windows() throws InterruptedException {
	       
	    	driver.get("https://boyds.wp.shottqsr.com/");

			driver.manage().window().maximize();

			Thread.sleep(2000);
	    	
	    }

	  

	    @When("I set screen resolution to 1920x1080")
	    public void i_set_screen_resolution_to_1920x1080() throws InterruptedException {
	        
	    	setScreenResolution(1920, 1080);
	    	
	    	Thread.sleep(3000);
	    	
	    }


	    @When("I set screen resolution to 1440x900")
	    public void i_set_screen_resolution_to_1440x900() throws InterruptedException {
	        
	    	setScreenResolution(1920, 1080);
	    	
	    	Thread.sleep(3000);
	    	
	    }
	    
	    @When("I set screen resolution to 1366x768")
	    public void i_set_screen_resolution_to_1366x768() throws InterruptedException {
	        
	    	setScreenResolution(1366, 768);
	    	
	    	Thread.sleep(3000);
	    	
	    }

	    @When("I set screen resolution to 1024x768")
	    public void i_set_screen_resolution_to_1024x768() throws InterruptedException {
	        
	    	setScreenResolution(1024, 768);
	    	
	    	Thread.sleep(3000);
	    	
	    }

	    private void setScreenResolution(int width, int height) {
	        
	    	driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
	        
	    	driver.get("https://boyds.wp.shottqsr.com/");
	    }

	    @Then("the website should load correctly")
	    public void the_website_should_load_correctly() throws InterruptedException {
	       
	    	Thread.sleep(1000);
	    	
	        WebElement homePage = driver.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[1]"));
	        
	    	assertTrue(homePage.isDisplayed());
	        
	    	assertEquals("Coffee that fuels the Achiever in each of us. One cup at a time.", homePage.getText());
	    	
	    	WebElement header = driver.findElement(By.id("masthead"));
	        assertTrue(header.isDisplayed());
	        
	        WebElement footer = driver.findElement(By.id("footer"));
	        assertTrue(footer.isDisplayed());
	        
	        driver.quit();
	        
	    }
	    
	    @Then("the website should load correctly1")
	    public void the_website_should_load_correctly1() throws InterruptedException {
	       
	    	Thread.sleep(1000);
	    	
	        WebElement homePage = driver1.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[1]"));
	        
	    	assertTrue(homePage.isDisplayed());
	        
	    	assertEquals("Coffee that fuels the Achiever in each of us. One cup at a time.", homePage.getText());
	    	
	    	WebElement header = driver1.findElement(By.id("masthead"));
	        assertTrue(header.isDisplayed());
	        
	        WebElement footer = driver1.findElement(By.id("footer"));
	        assertTrue(footer.isDisplayed());
	        
	        driver1.quit();
	        
	    }
	    
	    @Then("the website should load correctly2")
	    public void the_website_should_load_correctly2() throws InterruptedException {
	       
	    	Thread.sleep(1000);
	    	
	        WebElement homePage = driver2.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[1]"));
	        
	    	assertTrue(homePage.isDisplayed());
	        
	    	assertEquals("Coffee that fuels the Achiever in each of us. One cup at a time.", homePage.getText());
	    	
	    	WebElement header = driver2.findElement(By.id("masthead"));
	        assertTrue(header.isDisplayed());
	        
	        WebElement footer = driver2.findElement(By.id("footer"));
	        assertTrue(footer.isDisplayed());
	        
	        driver2.quit();
	        
	    }

	    @Then("the website should display correctly")
	    public void the_website_should_display_correctly() throws InterruptedException {
	        
	    	Thread.sleep(1000);
	    	
	        WebElement homePage = driver.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[1]"));
	        
	    	assertTrue(homePage.isDisplayed());
	        
	    	assertEquals("Coffee that fuels the Achiever in each of us. One cup at a time.", homePage.getText());
	    	
	    	WebElement header = driver.findElement(By.id("masthead"));
	        assertTrue(header.isDisplayed());
	        
	        WebElement footer = driver.findElement(By.id("footer"));
	        assertTrue(footer.isDisplayed());
	        
	        driver.quit();
	        
	    }
	
}

