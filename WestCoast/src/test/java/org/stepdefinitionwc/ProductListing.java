package org.stepdefinitionwc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductListing {

	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 @Given("I navigate to the product listing page")
	    public void iNavigateToTheProductListingPage() throws InterruptedException {
	        
		    driver.get("https://westcoast.wp.shottqsr.com/");
		    
		    Thread.sleep(1000);
			
			driver.manage().window().maximize();

			Thread.sleep(1000);
			
			driver.findElement(By.xpath("(//a[@href='/shop'])")).click();
			
			Thread.sleep(3000);
	        
	    }

	    @Then("the product listing page should load successfully")
	    public void theProductListingPageShouldLoadSuccessfully() throws InterruptedException {
	       
	    	WebElement productList = driver.findElement(By.xpath("(//div[@class='woo-container'])"));

	        assertTrue(productList.isDisplayed());

	        Thread.sleep(1000);
	        
	        List<WebElement> products = productList.findElements(By.xpath(".//div[@class='product-details']"));

	        assertFalse(products.isEmpty());

	        Thread.sleep(1000);
	        
	        for (WebElement product : products) {
	            System.out.println(product.getText());
	        }
	    	
	        WebElement categories = driver.findElement(By.xpath("//div[@class='filters_sec']"));
	        
	        assertTrue(categories.isDisplayed());
	        
	        String expectedText = "Categories";
	        String actualText = categories.getText();
	        assertTrue("Expected text not found in the empty cart message", actualText.contains(expectedText));
	    
	        Thread.sleep(1000);
	        
            WebElement certifications = driver.findElement(By.xpath("//div[@class='filters_sec']"));
	        
	        assertTrue(certifications.isDisplayed());
	        
	        String expectedText1 = "Certifications";
	        String actualText1 = certifications.getText();
	        assertTrue("Expected text not found in the empty cart message", actualText1.contains(expectedText1));
	    
	        Thread.sleep(1000);
	        
            WebElement roastLevels = driver.findElement(By.xpath("//div[@class='filters_sec']"));
	        
	        assertTrue(roastLevels.isDisplayed());
	        
	        String expectedText2 = "Roast Levels";
	        String actualText2 = roastLevels.getText();
	        assertTrue("Expected text not found in the empty cart message", actualText2.contains(expectedText2));
	    
	        Thread.sleep(1000);
	        
	        WebElement sort = driver.findElement(By.xpath("//span[@class='sort-by-tx']"));
	        
	    	assertTrue(sort.isDisplayed());
	        
	    	assertEquals("Sort by", sort.getText());

	    	Thread.sleep(2000);
	        
	        driver.quit();
	        
	    }
	
	    @When("I view the product details")
	    public void iViewTheProductDetails() throws InterruptedException {
	        
	    	driver.findElement(By.xpath("//a[@href='https://westcoast.wp.shottqsr.com/product/product-colombian-supremo-whole-bean-5lb/']")).click();
	        
	        Thread.sleep(3000);
	    	
	    }

	    @Then("the product details should be displayed correctly")
	    public void theProductDetailsShouldBeDisplayedCorrectly() throws InterruptedException {
	        
	    	WebElement productDetails = driver.findElement(By.xpath("//div[@id='product-1792']"));

	        String actualText = productDetails.getText();
	        System.out.println("Actual Product Details: " + actualText);

	        String expectedText = "Colombian Supremo Whole Bean Coffee: 5 lb.";
	        assertTrue("Product details do not contain the expected text", 
	            actualText.contains(expectedText));
	        
	    	Thread.sleep(1000);
	        
	        driver.quit();
	        
	    }
	    
	    @When("I navigate to the next page")
	    public void iNavigateToTheNextPage() {
	        
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	      
	        try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    @Then("the next set of products should be displayed")
	    public void theNextSetOfProductsShouldBeDisplayed() throws InterruptedException {
	        
	    	WebElement productList = driver.findElement(By.xpath("(//div[@class='woo-container'])"));
	    	
	    	List<WebElement> moreproducts = productList.findElements(By.xpath(".//div[@class='product-details']"));

		    assertFalse(moreproducts.isEmpty());

		    Thread.sleep(1000);
		        
		    for (WebElement product : moreproducts) {
		       System.out.println(product.getText());
		        }
	    	
	    	driver.quit();
	    	
	    }
   
	    @Then("each product should have an image and a link to the product details")
	    public void eachProductShouldHaveAnImageAndALinkToTheProductDetails() throws InterruptedException {
	        
	    	List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products columns-3']"));

	        for (WebElement product : products) {
	            
	            WebElement productImage = product.findElement(By.xpath(".//img"));
	            assert (productImage.isDisplayed()) : "Product image is not displayed for one of the products";

	            Thread.sleep(1000);
	            
	            WebElement productLink = product.findElement(By.xpath(".//a"));
	            assert (productLink.isDisplayed()) : "Product link is not displayed for one of the products";
	            
	            Thread.sleep(1000);
	            
	            WebElement productDetails = product.findElement(By.xpath(".//div[@class='product-details']"));
	            assert (productDetails.isDisplayed()) : "Product Details is not displayed for one of the products";
	            
	        }

	        Thread.sleep(1000);
	        
	        driver.quit();
	    }

}
