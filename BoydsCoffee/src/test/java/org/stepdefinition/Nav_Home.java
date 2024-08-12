package org.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Nav_Home {

	WebDriver driver = new ChromeDriver();
	
	@Given("I am on the homepage")
    public void i_am_on_the_homepage() throws InterruptedException {
     
		driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
			
    }

    @Then("the homepage should load successfully")
    public void the_homepage_should_load_successfully() throws InterruptedException {

    	Thread.sleep(1000);
    	
        WebElement homePage = driver.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[1]"));
        
    	assertTrue(homePage.isDisplayed());
        
    	assertEquals("Coffee that fuels the Achiever in each of us. One cup at a time.", homePage.getText());
    	
    	WebElement header = driver.findElement(By.id("masthead"));
        assertTrue(header.isDisplayed());
        
        WebElement footer = driver.findElement(By.id("footer"));
        assertTrue(footer.isDisplayed());
    	
        Thread.sleep(1000);
        
        driver.quit(); 	
    	
    }

    @When("I click on the navigation links")
    public void i_click_on_the_navigation_links() throws InterruptedException {
        
    	driver.findElement(By.xpath("(//a[@class=\'main-login'])")).click();
		
		Thread.sleep(1000);
		
		WebElement loginSignup = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(loginSignup.isDisplayed());
	        
	    assertEquals("MY ACCOUNT", loginSignup.getText());
		
        driver.findElement(By.xpath("(//a[@href='https://boyds.wp.shottqsr.com/shop/']) [1]")).click();
		
		Thread.sleep(1000);
		
		WebElement shopAll = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(shopAll.isDisplayed());
	        
	    assertEquals("SHOP", shopAll.getText());
	     
	    driver.findElement(By.xpath("//a[@href='/category/whole-bean-ground/']")).click();
	    
	    Thread.sleep(1000);
	     
	    WebElement wholebeanGroud = driver.findElement(By.xpath("(//div[@class='title'])"));
	        
	    assertTrue(wholebeanGroud.isDisplayed());
	        
	    assertEquals("WHOLE BEAN/GROUND", wholebeanGroud.getText());
	    
	    driver.findElement(By.xpath("//a[@href='/category/portion-pack-coffee/']")).click();
	    
	    Thread.sleep(1000);
	    
	    WebElement cases = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(cases.isDisplayed());
	        
	    assertEquals("PORTION PACK COFFEE", cases.getText());
   	
	    driver.findElement(By.xpath("//a[@href='https://boyds.wp.shottqsr.com/wholesale-inquiries/']")).click();
	    
        Thread.sleep(1000);
	    
	    WebElement whlslInq = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(whlslInq.isDisplayed());
	        
	    assertEquals("WHOLESALE INQUIRIES", whlslInq.getText());
	    
        driver.findElement(By.xpath("//a[@href='https://boyds.wp.shottqsr.com/the-scoop-blog/']")).click();
	    
        Thread.sleep(1000);
	    
	    WebElement scoopBlog = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(scoopBlog.isDisplayed());
	        
	    assertEquals("THE SCOOP BLOG", scoopBlog.getText());
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//a[@href='/about-us']")).click();
	    
	    Thread.sleep(1000);
	    
        WebElement aboutUs = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(aboutUs.isDisplayed());
	        
	    assertEquals("About Us", aboutUs.getText());
	    
        Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//a[@href='/contact-us']")).click();
	    
	    Thread.sleep(1000);
	    
        WebElement contactUs = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(contactUs.isDisplayed());
	        
	    assertEquals("Contact Us", contactUs.getText());
	    
        Thread.sleep(1000);
	    
        driver.findElement(By.xpath("//a[@href='/subscribe-and-save-program/']")).click();
	    
	    Thread.sleep(1000);
	    
        WebElement subsProg = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(subsProg.isDisplayed());
	        
	    assertEquals("SUBSCRIBE AND SAVE PROGRAM", subsProg.getText());
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[@href='/shipping-and-return-policy/']")).click();
	    
	    Thread.sleep(1000);
	    
        WebElement shipReturn = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(shipReturn.isDisplayed());
	        
	    assertEquals("SHIPPING AND RETURN POLICY", shipReturn.getText());
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[@href='/terms-conditions/']")).click();
	    
	    Thread.sleep(1000);
	    
        WebElement termsConds = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(termsConds.isDisplayed());
	        
	    assertEquals("TERMS & CONDITIONS", termsConds.getText());
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[@href='/privacy-policy/']")).click();
	    
	    Thread.sleep(1000);
	    
        WebElement privPolicy = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(privPolicy.isDisplayed());
	        
	    assertEquals("PRIVACY POLICY", privPolicy.getText());
        
        Thread.sleep(1000);
        
	    driver.findElement(By.xpath("//a[@href='/customer-service/']")).click();
	    
	    Thread.sleep(1000);
	    
        WebElement custServ = driver.findElement(By.xpath("(//div[@class='title'])"));
        
	    assertTrue(custServ.isDisplayed());
	        
	    assertEquals("Customer Service", custServ.getText());
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//div[@class='site-logo']")).click();
	    
    }
    
    @Then("the corresponding pages should load successfully")
    public void the_corresponding_pages_should_load_successfully() throws InterruptedException {
        
        Thread.sleep(2000);
    	
        driver.quit();
    	
    }

    @Then("the featured products section should be displayed")
    public void the_featured_products_section_should_be_displayed() throws InterruptedException {

        WebElement featProd = driver.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[4]"));
        
    	assertTrue(featProd.isDisplayed());
        
    	assertEquals("Featured Products", featProd.getText());
    	
        Thread.sleep(2000);
    	
        driver.quit();   
    	
    }

    @Then("the new arrivals section should be displayed")
    public void the_new_arrivals_section_should_be_displayed() throws InterruptedException {
        
        Thread.sleep(2000);
    	
        driver.quit();
    	
    }

    @Then("the roast level section should be displayed")
    public void the_roast_level_section_should_be_displayed() throws InterruptedException {
        
        WebElement roastLevel = driver.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[2]"));
        
    	assertTrue(roastLevel.isDisplayed());
        
    	assertEquals("ROAST", roastLevel.getText());
    	
        Thread.sleep(2000);
    	
        driver.quit();   
    
    }
    
    @Then("the special offers section should be displayed")
    public void the_special_offers_section_should_be_displayed() throws InterruptedException {
        
        Thread.sleep(2000);
    	
        driver.quit();
    	
    }

    @When("I resize the browser window")
    public void i_resize_the_browser_window() throws InterruptedException {
       
        driver.manage().window().setSize(new Dimension(375, 812));
        
        Thread.sleep(1000);
        
        driver.manage().window().setSize(new Dimension(768, 1024));
        
        Thread.sleep(1000);
        
        driver.manage().window().setSize(new Dimension(1366, 768));
    
    }

    @Then("the website should adjust accordingly")
    public void the_website_should_adjust_accordingly() throws InterruptedException {
       
        Thread.sleep(2000);

        try {
            WebElement navBar = driver.findElement(By.id("site-navigation"));
            assertTrue("NavBar should be displayed", navBar.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("NavBar not found");
        }

        try {
            WebElement mainContent = driver.findElement(By.id("menu-main-menu"));
            assertTrue("Main content should be displayed", mainContent.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Main content not found");
        }

        driver.manage().window().setSize(new Dimension(375, 812));
        Thread.sleep(1000);
        
        try {
            WebElement navBar = driver.findElement(By.id("site-navigation"));
            assertTrue("NavBar should be displayed on mobile", navBar.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("NavBar not found on mobile");
        }

        try {
            WebElement mainContent = driver.findElement(By.id("menu-main-menu"));
            assertTrue("Main content should be displayed on mobile", mainContent.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Main content not found on mobile");
        }
        
        driver.manage().window().setSize(new Dimension(768, 1024));
        Thread.sleep(2000);

        driver.manage().window().setSize(new Dimension(1366, 768));
        Thread.sleep(2000);

        try {
            WebElement navBar = driver.findElement(By.id("site-navigation"));
            assertTrue("NavBar should be displayed on desktop", navBar.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("NavBar not found on desktop");
        }

        try {
            WebElement mainContent = driver.findElement(By.id("menu-main-menu"));
            assertTrue("Main content should be displayed on desktop", mainContent.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Main content not found on desktop");
        }

        driver.quit();
    }

    @Then("the website should load within acceptable time")
    public void the_website_should_load_within_acceptable_time() throws InterruptedException {
        
    	long acceptableLoadTime = 5000;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");

        long loadTime = loadEventEnd - navigationStart;

        System.out.println("Load Time: " + loadTime + " milliseconds");

        assertTrue("The website should load within " + acceptableLoadTime + " milliseconds. Actual load time: " + loadTime + " milliseconds.", loadTime <= acceptableLoadTime);

        driver.quit();
  	
    }

    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String pageName) {

        switch (pageName.toLowerCase()) {
            case "homepage":
                driver.get("https://boyds.wp.shottqsr.com/");
                break;
            case "product":
                driver.get("https://boyds.wp.shottqsr.com/shop/");
                break;
            case "contact":
                driver.get("https://boyds.wp.shottqsr.com/contact-us/");
                break;
            default:
                throw new IllegalArgumentException("Invalid page name: " + pageName);
        }
    }

    @Then("the design should be consistent across pages")
    public void the_design_should_be_consistent_across_pages() {

        By headerLocator = By.id("masthead");
        By footerLocator = By.id("footer");
        By navBarLocator = By.id("site-navigation");

        driver.get("https://boyds.wp.shottqsr.com/");
        WebElement header = driver.findElement(headerLocator);
        WebElement footer = driver.findElement(footerLocator);
        WebElement navBar = driver.findElement(navBarLocator);

        List<WebElement> headerLinks = header.findElements(By.tagName("li"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("li"));
        List<WebElement> navBarLinks = navBar.findElements(By.tagName("li"));

        String headerLinkText = headerLinks.get(0).getText();
        String footerLinkText = footerLinks.get(0).getText();
        String navBarLinkText = navBarLinks.get(0).getText();

        Dimension headerSize = header.getSize();
        Dimension footerSize = footer.getSize();
        Dimension navBarSize = navBar.getSize();

        String headerColor = header.getCssValue("color");
        String footerColor = footer.getCssValue("color");
        String navBarColor = navBar.getCssValue("color");

        String[] pages = {"product", "contact"};

        for (String page : pages) {
            driver.get("https://boyds.wp.shottqsr.com/" + page);

            WebElement headerOnPage = driver.findElement(headerLocator);
            WebElement footerOnPage = driver.findElement(footerLocator);
            WebElement navBarOnPage = driver.findElement(navBarLocator);

            List<WebElement> headerLinksOnPage = headerOnPage.findElements(By.tagName("li"));
            List<WebElement> footerLinksOnPage = footerOnPage.findElements(By.tagName("li"));
            List<WebElement> navBarLinksOnPage = navBarOnPage.findElements(By.tagName("li"));

            assertEquals("Header link text should be consistent", headerLinkText, headerLinksOnPage.get(0).getText());
            assertEquals("Footer link text should be consistent", footerLinkText, footerLinksOnPage.get(0).getText());
            assertEquals("NavBar link text should be consistent", navBarLinkText, navBarLinksOnPage.get(0).getText());

            assertSizeWithinTolerance("Header size should be consistent", headerSize, headerOnPage.getSize(), 2);
            assertSizeWithinTolerance("Footer size should be consistent", footerSize, footerOnPage.getSize(), 2);
            assertSizeWithinTolerance("NavBar size should be consistent", navBarSize, navBarOnPage.getSize(), 2);

            assertEquals("Header color should be consistent", headerColor, headerOnPage.getCssValue("color"));
            assertEquals("Footer color should be consistent", footerColor, footerOnPage.getCssValue("color"));
            assertEquals("NavBar color should be consistent", navBarColor, navBarOnPage.getCssValue("color"));
        }

        driver.quit();
 
    }
    
        @SuppressWarnings("unused")
		private void assertSizeWithinTolerance(String message, Dimension expected, Dimension actual, int tolerance) {
        boolean widthWithinTolerance = Math.abs(expected.width - actual.width) <= tolerance;
        boolean heightWithinTolerance = Math.abs(expected.height - actual.height) <= tolerance;
        if (!widthWithinTolerance || !heightWithinTolerance) {
            fail(message + " expected:<" + expected + "> but was:<" + actual + ">");
        }
    }
    
    @Then("the social media links should be functional")
    public void the_social_media_links_should_be_functional() throws InterruptedException {
        
        Thread.sleep(2000);
    	
        By facebookLink = By.cssSelector("a[href*='https://www.facebook.com/boyds/']");

        By instagramLink = By.cssSelector("a[href*='https://www.instagram.com/boydscoffeetime/']");

        verifySocialMediaLink(facebookLink, "Facebook");

        verifySocialMediaLink(instagramLink, "Instagram");

        driver.quit();
    }

    private void verifySocialMediaLink(By linkLocator, String platformName) {

        WebElement link = driver.findElement(linkLocator);

        String mainWindowHandle = driver.getWindowHandle();

        link.click();

        waitForNewWindow();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        
        String currentUrl = driver.getCurrentUrl();
        assertTrue(platformName + " link is not functional", currentUrl.contains(platformName.toLowerCase()));

        driver.close();
        driver.switchTo().window(mainWindowHandle);
    }

    private void waitForNewWindow() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
}
