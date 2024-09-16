package org.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cart {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait;
	
	
    @Given("the user is on the cart page")
    public void the_user_is_on_the_cart_page() throws InterruptedException {

    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

		Thread.sleep(1000);
		
		WebElement cartIcon = driver.findElement(By.xpath("//span[@class='xoo-wsc-sc-bki xoo-wsc-icon-bag2']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		Actions actions = new Actions(driver);
		actions.moveToElement(cartIcon).click().perform();
		
        Thread.sleep(3000);
        
        WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(cartLink).click().perform();
		
        Thread.sleep(5000);
        
    }

    @When("the user views the cart")
    public void the_user_views_the_cart() throws InterruptedException {
    	
    	Thread.sleep(5000);
        
        WebElement viewCart = driver.findElement(By.xpath("//div[@class='title']"));
        
    	assertTrue(viewCart.isDisplayed());
        
    	assertEquals("Cart", viewCart.getText());

    	Thread.sleep(2000);
    	
    }

    @Then("the cart should display the correct items")
    public void the_cart_should_display_the_correct_items() throws InterruptedException {
        
    	Thread.sleep(2000);
    	
    	try {
            
            WebElement cartTable = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']"));

            List<WebElement> cartRows = cartTable.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));

            List<String> expectedNames = Arrays.asList("French No.6- 12oz. Ground Coffee", "Good Morning- 12oz. Ground Coffee");
            List<Integer> expectedQuantities = Arrays.asList(1, 1);
            List<String> expectedPrices = Arrays.asList("$10.99", "$10.99");

            System.out.println("Number of items in cart: " + cartRows.size());
            System.out.println("Expected number of items: " + expectedNames.size());

            if (cartRows.size() != expectedNames.size()) {
                assert false : "Number of items in cart does not match expected";
            }

            for (int i = 0; i < cartRows.size(); i++) {
                WebElement row = cartRows.get(i);

                WebElement itemNameElement = row.findElement(By.cssSelector(".product-name a"));
                WebElement itemQuantityElement = row.findElement(By.cssSelector(".product-quantity input.qty"));
                WebElement itemPriceElement = row.findElement(By.cssSelector(".product-subtotal .amount"));

                String itemName = itemNameElement.getText().trim();
                int itemQuantity = Integer.parseInt(itemQuantityElement.getAttribute("value").trim());
                String itemPrice = itemPriceElement.getText().trim();

                System.out.println("Item " + (i + 1) + ":");
                System.out.println("Name: " + itemName);
                System.out.println("Quantity: " + itemQuantity);
                System.out.println("Price: " + itemPrice);

                if (!itemName.equals(expectedNames.get(i))) {
                    System.out.println("Expected Name: " + expectedNames.get(i));
                    System.out.println("Actual Name: " + itemName);
                    assert false : "Item name does not match expected";
                }
                if (itemQuantity != expectedQuantities.get(i)) {
                    System.out.println("Expected Quantity: " + expectedQuantities.get(i));
                    System.out.println("Actual Quantity: " + itemQuantity);
                    assert false : "Item quantity does not match expected";
                }
                if (!itemPrice.equals(expectedPrices.get(i))) {
                    System.out.println("Expected Price: " + expectedPrices.get(i));
                    System.out.println("Actual Price: " + itemPrice);
                    assert false : "Item price does not match expected";
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Element not found");
            e.printStackTrace();
            assert false : "Element not found in the cart";
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Null value encountered");
            e.printStackTrace();
            assert false : "Null value encountered during cart verification";
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred");
            e.printStackTrace();
            assert false : "An unexpected error occurred during cart verification";
        }
    	
        Thread.sleep(2000);
        
        driver.quit();
    }

    @Given("the user is on a product detail page")
    public void the_user_is_on_a_product_detail_page() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test1@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

		Thread.sleep(1000);
		
        driver.findElement(By.xpath("(//a[@href='https://boyds.wp.shottqsr.com/shop/']) [1]")).click();
		
		Thread.sleep(2000);
		
		WebElement product = driver.findElement(By.xpath("//a[@href='https://boyds.wp.shottqsr.com/product/100-brazil-ground-coffee-3oz-portion-packs-case-of-40/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(product));
		Actions actions = new Actions(driver);
		actions.moveToElement(product).click().perform();
		
		Thread.sleep(1000);
		
    }

    @When("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() throws InterruptedException {
    	 
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//button[@name='add-to-cart']")).click();
    	
        Thread.sleep(5000);
		
        WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
		Actions actions = new Actions(driver);
		actions.moveToElement(cartLink).click().perform();
		
		Thread.sleep(2000);
    }

    @Then("the cart should contain the added product from detail page")
    public void the_cart_should_contain_the_added_product_from_detail_page() throws InterruptedException {
        
    	Thread.sleep(2000);
    	
    	try {
    		   
            WebElement cartTable = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']"));
            
            List<WebElement> cartRows = cartTable.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));

            String expectedName = "100% Brazil Ground Coffee- 3oz Portion Packs (Case Of 40)";
            int expectedQuantity = 1;
            String expectedPrice = "$1.99";

            System.out.println("Number of items in cart: " + cartRows.size());
            System.out.println("Expected number of items: 1");

            if (cartRows.size() != 1) {
                assert false : "Number of items in cart does not match expected";
            }

            WebElement row = cartRows.get(0);
            WebElement itemNameElement = row.findElement(By.cssSelector(".product-name a"));
            WebElement itemQuantityElement = row.findElement(By.cssSelector(".product-quantity input.qty"));
            WebElement itemPriceElement = row.findElement(By.cssSelector(".product-subtotal .amount"));

            String itemName = itemNameElement.getText().trim();
            int itemQuantity = Integer.parseInt(itemQuantityElement.getAttribute("value").trim());
            String itemPrice = itemPriceElement.getText().trim();

            System.out.println("Item:");
            System.out.println("Name: " + itemName);
            System.out.println("Quantity: " + itemQuantity);
            System.out.println("Price: " + itemPrice);

            if (!itemName.equals(expectedName)) {
                System.out.println("Expected Name: " + expectedName);
                System.out.println("Actual Name: " + itemName);
                assert false : "Item name does not match expected";
            }
            if (itemQuantity != expectedQuantity) {
                System.out.println("Expected Quantity: " + expectedQuantity);
                System.out.println("Actual Quantity: " + itemQuantity);
                assert false : "Item quantity does not match expected";
            }
            if (!itemPrice.equals(expectedPrice)) {
                System.out.println("Expected Price: " + expectedPrice);
                System.out.println("Actual Price: " + itemPrice);
                assert false : "Item price does not match expected";
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Element not found");
            e.printStackTrace();
            assert false : "Element not found in the cart";
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Null value encountered");
            e.printStackTrace();
            assert false : "Null value encountered during cart verification";
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred");
            e.printStackTrace();
            assert false : "An unexpected error occurred during cart verification";
        }
    	
        Thread.sleep(2000);
        
        driver.quit();
    	
    }

    @Given("the user is on the product listing page")
    public void the_user_is_on_the_product_listing_page() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test2@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

		Thread.sleep(1000);
		
        driver.findElement(By.xpath("(//a[@href='https://boyds.wp.shottqsr.com/shop/']) [1]")).click();
		
		Thread.sleep(2000);
		
    }

    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart_from_listing_page() throws InterruptedException {
       
        Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//a[@href='?add-to-cart=3740']")).click();
    	
    	WebElement addProd = driver.findElement(By.xpath("//a[@href='?add-to-cart=3740']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addProd);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(addProd));
		Actions actions = new Actions(driver);
		actions.moveToElement(addProd).click().perform();
    	
    	Thread.sleep(2000);
    	
    	 WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);   
 		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
 		Actions actions1 = new Actions(driver);
 		actions1.moveToElement(cartLink).click().perform();
		
		Thread.sleep(2000);
    	
    }

    @Then("the cart should contain the added product from listing page")
    public void the_cart_should_contain_the_added_product_from_listing_page() throws InterruptedException {
        
        Thread.sleep(2000);
    	
    	try {
    		   
            WebElement cartTable = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']"));
            
            List<WebElement> cartRows = cartTable.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));

            String expectedName = "100% Brazil Ground Coffee- 3oz Portion Packs (Case Of 40)";
            int expectedQuantity = 1;
            String expectedPrice = "$1.99";

            System.out.println("Number of items in cart: " + cartRows.size());
            System.out.println("Expected number of items: 1");

            if (cartRows.size() != 1) {
                assert false : "Number of items in cart does not match expected";
            }

            WebElement row = cartRows.get(0);
            WebElement itemNameElement = row.findElement(By.cssSelector(".product-name a"));
            WebElement itemQuantityElement = row.findElement(By.cssSelector(".product-quantity input.qty"));
            WebElement itemPriceElement = row.findElement(By.cssSelector(".product-subtotal .amount"));

            String itemName = itemNameElement.getText().trim();
            int itemQuantity = Integer.parseInt(itemQuantityElement.getAttribute("value").trim());
            String itemPrice = itemPriceElement.getText().trim();

            System.out.println("Item:");
            System.out.println("Name: " + itemName);
            System.out.println("Quantity: " + itemQuantity);
            System.out.println("Price: " + itemPrice);

            if (!itemName.equals(expectedName)) {
                System.out.println("Expected Name: " + expectedName);
                System.out.println("Actual Name: " + itemName);
                assert false : "Item name does not match expected";
            }
            if (itemQuantity != expectedQuantity) {
                System.out.println("Expected Quantity: " + expectedQuantity);
                System.out.println("Actual Quantity: " + itemQuantity);
                assert false : "Item quantity does not match expected";
            }
            if (!itemPrice.equals(expectedPrice)) {
                System.out.println("Expected Price: " + expectedPrice);
                System.out.println("Actual Price: " + itemPrice);
                assert false : "Item price does not match expected";
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Element not found");
            e.printStackTrace();
            assert false : "Element not found in the cart";
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Null value encountered");
            e.printStackTrace();
            assert false : "Null value encountered during cart verification";
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred");
            e.printStackTrace();
            assert false : "An unexpected error occurred during cart verification";
        }
    	
        Thread.sleep(2000);
        
        driver.quit();
    	
    }

    @Given("the user has a product in the cart")
    public void the_user_has_a_product_in_the_cart() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

    	Thread.sleep(2000);
    	
		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test3@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

        Thread.sleep(5000);
		
        WebElement cartIcon = driver.findElement(By.xpath("//span[@class='xoo-wsc-sc-bki xoo-wsc-icon-bag2']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		Actions actions = new Actions(driver);
		actions.moveToElement(cartIcon).click().perform();
		
        Thread.sleep(2000);

        WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(cartLink).click().perform();
		
        Thread.sleep(2000);
    	
    }

    @When("the user increases the quantity of the product")
    public void the_user_increases_the_quantity_of_the_product() throws InterruptedException {
        
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//button[@class='plus']")).click();
    	
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//button[@name='update_cart']")).click();
    	
    	Thread.sleep(3000);
    	
    }

    @Then("the cart should reflect the increased quantity")
    public void the_cart_should_reflect_the_increased_quantity() throws InterruptedException {
        
    	Thread.sleep(3000);
    	
    	try {
            
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-quantity input.qty")));

            String actualQuantity = quantityInput.getAttribute("value").trim();

            String expectedQuantity = "2";

            System.out.println("Expected Quantity: " + expectedQuantity);
            System.out.println("Actual Quantity: " + actualQuantity);

            assert expectedQuantity.equals(actualQuantity) : "The cart quantity does not match the expected value";
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Quantity input element not found");
            e.printStackTrace();
            assert false : "Quantity input element not found in the cart";
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred");
            e.printStackTrace();
            assert false : "An unexpected error occurred during quantity verification";
        }
    	
    	Thread.sleep(2000);
    	
    	driver.quit();
    	
    }

    @When("the user decreases the quantity of the product")
    public void the_user_decreases_the_quantity_of_the_product() throws InterruptedException {
        
        Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//button[@class='minus']")).click();
    	
    	Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//button[@name='update_cart']")).click();
    	
    	Thread.sleep(3000);
    	
    }

    @Then("the cart should reflect the decreased quantity")
    public void the_cart_should_reflect_the_decreased_quantity() throws InterruptedException {
        
        Thread.sleep(3000);
    	
    	try {
            
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-quantity input.qty")));

            String actualQuantity = quantityInput.getAttribute("value").trim();

            String expectedQuantity = "1";

            System.out.println("Expected Quantity: " + expectedQuantity);
            System.out.println("Actual Quantity: " + actualQuantity);

            assert expectedQuantity.equals(actualQuantity) : "The cart quantity does not match the expected value";
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Quantity input element not found");
            e.printStackTrace();
            assert false : "Quantity input element not found in the cart";
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred");
            e.printStackTrace();
            assert false : "An unexpected error occurred during quantity verification";
        }
    	
    	Thread.sleep(2000);
    	
    	driver.quit();
    	
    }

    @When("the user logs out and logs back in")
    public void the_user_logs_out_and_logs_back_in() throws InterruptedException {
        
        Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//a[@class='logout main-login']")).click();
        
    	Thread.sleep(1000);
    	
        driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test3@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

		Thread.sleep(1000);
    	
    }

    @Then("the cart should still contain the same product")
    public void the_cart_should_still_contain_the_same_product() throws InterruptedException {
        
        Thread.sleep(1000);
		
        WebElement cartIcon = driver.findElement(By.xpath("//span[@class='xoo-wsc-sc-bki xoo-wsc-icon-bag2']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
		Actions actions = new Actions(driver);
		actions.moveToElement(cartIcon).click().perform();
		
        Thread.sleep(3000);

        WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink); 
		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(cartLink).click().perform();
		
        Thread.sleep(3000);
        
    	try {
    		   
            WebElement cartTable = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']"));
            
            List<WebElement> cartRows = cartTable.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));

            String expectedName = "French No.6- 12oz. Ground Coffee";
            int expectedQuantity = 1;
            String expectedPrice = "$10.99";

            System.out.println("Number of items in cart: " + cartRows.size());
            System.out.println("Expected number of items: 1");

            if (cartRows.size() != 1) {
                assert false : "Number of items in cart does not match expected";
            }

            WebElement row = cartRows.get(0);
            WebElement itemNameElement = row.findElement(By.cssSelector(".product-name a"));
            WebElement itemQuantityElement = row.findElement(By.cssSelector(".product-quantity input.qty"));
            WebElement itemPriceElement = row.findElement(By.cssSelector(".product-subtotal .amount"));

            String itemName = itemNameElement.getText().trim();
            int itemQuantity = Integer.parseInt(itemQuantityElement.getAttribute("value").trim());
            String itemPrice = itemPriceElement.getText().trim();

            System.out.println("Item:");
            System.out.println("Name: " + itemName);
            System.out.println("Quantity: " + itemQuantity);
            System.out.println("Price: " + itemPrice);

            if (!itemName.equals(expectedName)) {
                System.out.println("Expected Name: " + expectedName);
                System.out.println("Actual Name: " + itemName);
                assert false : "Item name does not match expected";
            }
            if (itemQuantity != expectedQuantity) {
                System.out.println("Expected Quantity: " + expectedQuantity);
                System.out.println("Actual Quantity: " + itemQuantity);
                assert false : "Item quantity does not match expected";
            }
            if (!itemPrice.equals(expectedPrice)) {
                System.out.println("Expected Price: " + expectedPrice);
                System.out.println("Actual Price: " + itemPrice);
                assert false : "Item price does not match expected";
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Element not found");
            e.printStackTrace();
            assert false : "Element not found in the cart";
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Null value encountered");
            e.printStackTrace();
            assert false : "Null value encountered during cart verification";
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred");
            e.printStackTrace();
            assert false : "An unexpected error occurred during cart verification";
        }
    	
        Thread.sleep(2000);
        
        driver.quit();
    	    	
    }
    
    @When("the user applies a discount code")
    public void the_user_applies_a_discount_code() throws InterruptedException {
       
    	Thread.sleep(2000);
		
    	driver.findElement(By.id("coupon_code")).sendKeys("KA7JY7EX");
    		
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//button[@name='apply_coupon']")).click();
    	
    	Thread.sleep(2000);
    	
    }

    @Then("the cart should reflect the discount")
    public void the_cart_should_reflect_the_discount() throws InterruptedException {
        
    	Thread.sleep(2000);
    	  
        WebElement couponCode = driver.findElement(By.xpath("//div[@class='woocommerce-message']"));
        
        assertTrue(couponCode.isDisplayed());
        
        assertEquals("Coupon code applied successfully.", couponCode.getText());
    
        Thread.sleep(2000);
        
        driver.quit();
    	
    }
    
    @When("the user removes the product from the cart")
    public void the_user_removes_the_product_from_the_cart() throws InterruptedException {
       
        Thread.sleep(1000);
    	
    	driver.findElement(By.xpath("//a[@class='remove']")).click();
    	
    	Thread.sleep(3000);
    	
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() throws InterruptedException {
        
    	Thread.sleep(2000);
  	  
        WebElement cartEmpty = driver.findElement(By.xpath("//div[@class='cart-empty woocommerce-info']"));
        
        assertTrue(cartEmpty.isDisplayed());
        
        assertEquals("Your cart is currently empty.", cartEmpty.getText());
    
        Thread.sleep(2000);
        
        driver.quit();
    	
    }

    @Given("the user is on the products listing page")
    public void the_user_is_on_the_products_listing_page() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test4@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

		Thread.sleep(1000);
		
        driver.findElement(By.xpath("(//a[@href='https://boyds.wp.shottqsr.com/shop/']) [1]")).click();
		
		Thread.sleep(2000);
		
    }
    
    @When("the user adds multiple products to the cart")
    public void the_user_adds_multiple_products_to_the_cart() throws InterruptedException {
        
        Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//a[@href='?add-to-cart=3740']")).click();
    	
    	Thread.sleep(2000);
		
        WebElement closeCart = driver.findElement(By.xpath("//a[@href='xoo-wsch-close xoo-wsc-icon-cross']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeCart);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(closeCart));
		Actions actions = new Actions(driver);
		actions.moveToElement(closeCart).click().perform();
        
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='?add-to-cart=3750']")).click();
    	
		Thread.sleep(2000);		
		
    }

    @Then("the cart should contain all the added products")
    public void the_cart_should_contain_all_the_added_products() throws InterruptedException {
        
    	Thread.sleep(2000);
    	
    	 WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
 		Actions actions = new Actions(driver);
 		actions.moveToElement(cartLink).click().perform();
		
		Thread.sleep(3000);
    	
    	try {
            
            WebElement cartTable = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']"));

            List<WebElement> cartRows = cartTable.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));

            List<String> expectedNames = Arrays.asList("100% Brazil Ground Coffee- 3oz Portion Packs (case of 40)", "100% Colombian – 5lb Whole Bean Coffee");
            List<Integer> expectedQuantities = Arrays.asList(1, 1);
            List<String> expectedPrices = Arrays.asList("$1.99", "$1.99");

            System.out.println("Number of items in cart: " + cartRows.size());
            System.out.println("Expected number of items: " + expectedNames.size());

            if (cartRows.size() != expectedNames.size()) {
                assert false : "Number of items in cart does not match expected";
            }

            for (int i = 0; i < cartRows.size(); i++) {
                WebElement row = cartRows.get(i);

                WebElement itemNameElement = row.findElement(By.cssSelector(".product-name a"));
                WebElement itemQuantityElement = row.findElement(By.cssSelector(".product-quantity input.qty"));
                WebElement itemPriceElement = row.findElement(By.cssSelector(".product-subtotal .amount"));

                String itemName = itemNameElement.getText().trim();
                int itemQuantity = Integer.parseInt(itemQuantityElement.getAttribute("value").trim());
                String itemPrice = itemPriceElement.getText().trim();

                System.out.println("Item " + (i + 1) + ":");
                System.out.println("Name: " + itemName);
                System.out.println("Quantity: " + itemQuantity);
                System.out.println("Price: " + itemPrice);

                if (!itemName.equals(expectedNames.get(i))) {
                    System.out.println("Expected Name: " + expectedNames.get(i));
                    System.out.println("Actual Name: " + itemName);
                    assert false : "Item name does not match expected";
                }
                if (itemQuantity != expectedQuantities.get(i)) {
                    System.out.println("Expected Quantity: " + expectedQuantities.get(i));
                    System.out.println("Actual Quantity: " + itemQuantity);
                    assert false : "Item quantity does not match expected";
                }
                if (!itemPrice.equals(expectedPrices.get(i))) {
                    System.out.println("Expected Price: " + expectedPrices.get(i));
                    System.out.println("Actual Price: " + itemPrice);
                    assert false : "Item price does not match expected";
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException: Element not found");
            e.printStackTrace();
            assert false : "Element not found in the cart";
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: Null value encountered");
            e.printStackTrace();
            assert false : "Null value encountered during cart verification";
        } catch (Exception e) {
            System.out.println("Exception: An unexpected error occurred");
            e.printStackTrace();
            assert false : "An unexpected error occurred during cart verification";
        }
    	
        Thread.sleep(2000);
        
        driver.quit();
		
    }

    @Given("the user has products in the wishlist")
    public void the_user_has_products_in_the_wishlist() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("username")).sendKeys("vishal+test5@hurekatek.com");
		
		driver.findElement(By.name("password")).sendKeys("Joevishal@0603");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='woocommerce-button button woocommerce-form-login__submit']")).click();

		Thread.sleep(2000);
		
		WebElement wishlist = driver.findElement(By.xpath("//a[@href='/wishlist']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", wishlist);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(wishlist));
		Actions actions = new Actions(driver);
		actions.moveToElement(wishlist).click().perform();
		
		Thread.sleep(2000);
    	
    }

    @When("the user adds a product from the wishlist to the cart")
    public void the_user_adds_a_product_from_the_wishlist_to_the_cart() throws InterruptedException {
        
        Thread.sleep(1000);
		
        driver.findElement(By.xpath("//a[@href='?add-to-cart=39']")).click();
    	
    	Thread.sleep(5000);
    	
    }

    @Then("the cart should contain the added product from wishlist")
    public void the_cart_should_contain_the_added_product_from_wishlist() throws InterruptedException {
        
        Thread.sleep(2000);
    	
        WebElement cartLink = driver.findElement(By.xpath("//a[@href='/cart/']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartLink);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(cartLink));
		Actions actions = new Actions(driver);
		actions.moveToElement(cartLink).click().perform();
		
		Thread.sleep(3000);
    	
        try {
     		   
                WebElement cartTable = driver.findElement(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']"));
                
                List<WebElement> cartRows = cartTable.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));

                String expectedName = "French No.6- 12oz. Ground Coffee";
                int expectedQuantity = 1;
                String expectedPrice = "$10.99";

                System.out.println("Number of items in cart: " + cartRows.size());
                System.out.println("Expected number of items: 1");

                if (cartRows.size() != 1) {
                    assert false : "Number of items in cart does not match expected";
                }

                WebElement row = cartRows.get(0);
                WebElement itemNameElement = row.findElement(By.cssSelector(".product-name a"));
                WebElement itemQuantityElement = row.findElement(By.cssSelector(".product-quantity input.qty"));
                WebElement itemPriceElement = row.findElement(By.cssSelector(".product-subtotal .amount"));

                String itemName = itemNameElement.getText().trim();
                int itemQuantity = Integer.parseInt(itemQuantityElement.getAttribute("value").trim());
                String itemPrice = itemPriceElement.getText().trim();

                System.out.println("Item:");
                System.out.println("Name: " + itemName);
                System.out.println("Quantity: " + itemQuantity);
                System.out.println("Price: " + itemPrice);

                if (!itemName.equals(expectedName)) {
                    System.out.println("Expected Name: " + expectedName);
                    System.out.println("Actual Name: " + itemName);
                    assert false : "Item name does not match expected";
                }
                if (itemQuantity != expectedQuantity) {
                    System.out.println("Expected Quantity: " + expectedQuantity);
                    System.out.println("Actual Quantity: " + itemQuantity);
                    assert false : "Item quantity does not match expected";
                }
                if (!itemPrice.equals(expectedPrice)) {
                    System.out.println("Expected Price: " + expectedPrice);
                    System.out.println("Actual Price: " + itemPrice);
                    assert false : "Item price does not match expected";
                }
            } catch (NoSuchElementException e) {
                System.out.println("NoSuchElementException: Element not found");
                e.printStackTrace();
                assert false : "Element not found in the cart";
            } catch (NullPointerException e) {
                System.out.println("NullPointerException: Null value encountered");
                e.printStackTrace();
                assert false : "Null value encountered during cart verification";
            } catch (Exception e) {
                System.out.println("Exception: An unexpected error occurred");
                e.printStackTrace();
                assert false : "An unexpected error occurred during cart verification";
            }
        	
            Thread.sleep(2000);
            
            driver.quit();
		
    }
   
}