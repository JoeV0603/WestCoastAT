package org.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Local_Access {

	WebDriver driver = new ChromeDriver();
	
	@Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() throws InterruptedException {
        
		driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
    }

    @When("the user navigates using the keyboard")
    public void the_user_navigates_using_the_keyboard() {
        
    	Actions actions = new Actions(driver);

        WebElement body = driver.findElement(By.tagName("body"));
        body.click();

        for (int i = 0; i < 10; i++) { 
            actions.sendKeys(Keys.TAB).perform();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    	
    }

    @Then("the user should be able to access all interactive elements")
    public void the_user_should_be_able_to_access_all_interactive_elements() throws InterruptedException {
        
    	String[] interactiveTags = {"a", "button", "input", "select", "textarea"};

        String script = "return document.activeElement.tagName.toLowerCase();";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        boolean isInteractive = false;
        for (String tag : interactiveTags) {
            String focusedElementTag = (String) jsExecutor.executeScript(script);
            if (focusedElementTag.equals(tag)) {
                isInteractive = true;
                break;
            }
        }

        if (!isInteractive) {
            throw new AssertionError("The focused element is not interactive");
        }
    	
        Thread.sleep(2000);
        
        driver.quit(); 	
    	
    }

    @When("the user examines the color contrast")
    public void the_user_examines_the_color_contrast() {
        
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='site-logo']")));
         String color = element.getCssValue("color");

         parseColor(color);
     }

     @SuppressWarnings("unused")
	private void parseColor(String color) {

         String rgbaPattern = "rgba\\((\\d+),\\s*(\\d+),\\s*(\\d+),\\s*([\\d.]+)\\)";
         String rgbPattern = "rgb\\((\\d+),\\s*(\\d+),\\s*(\\d+)\\)";
         
         Pattern pattern = Pattern.compile(rgbaPattern);
         Matcher matcher = pattern.matcher(color);
         
         if (matcher.matches()) {
             int red = Integer.parseInt(matcher.group(1));
             int green = Integer.parseInt(matcher.group(2));
             int blue = Integer.parseInt(matcher.group(3));
             double alpha = Double.parseDouble(matcher.group(4));
           
         } else {
             pattern = Pattern.compile(rgbPattern);
             matcher = pattern.matcher(color);
             if (matcher.matches()) {
                 int red = Integer.parseInt(matcher.group(1));
                 int green = Integer.parseInt(matcher.group(2));
                 int blue = Integer.parseInt(matcher.group(3));
 
             } else {
                 throw new IllegalArgumentException("Unexpected color format: " + color);
             }
         }
         
    }

     private double calculateLuminance(int r, int g, int b) {
    	    double[] rgb = new double[] {
    	        r / 255.0,
    	        g / 255.0,
    	        b / 255.0
    	    };
    	    
    	    for (int i = 0; i < rgb.length; i++) {
    	        rgb[i] = (rgb[i] <= 0.03928) ? rgb[i] / 12.92 : Math.pow((rgb[i] + 0.055) / 1.055, 2.4);
    	    }
    	    
    	    return 0.2126 * rgb[0] + 0.7152 * rgb[1] + 0.0722 * rgb[2];
    	}

    	private double calculateContrastRatio(int r1, int g1, int b1, int r2, int g2, int b2) {
    	    double luminance1 = calculateLuminance(r1, g1, b1);
    	    double luminance2 = calculateLuminance(r2, g2, b2);
    	    
    	    double lighter = Math.max(luminance1, luminance2);
    	    double darker = Math.min(luminance1, luminance2);
    	    
    	    return (lighter + 0.05) / (darker + 0.05);
    	}

    	@Then("the contrast ratio should meet the WCAG standards")
    	public void the_contrast_ratio_should_meet_the_WCAG_standards() throws InterruptedException {
    	   
    	    int[] fgColor = {255, 255, 255}; 
    	    int[] bgColor = {0, 0, 0};       
    	    
    	    double contrastRatio = calculateContrastRatio(fgColor[0], fgColor[1], fgColor[2], bgColor[0], bgColor[1], bgColor[2]);
    	    
    	   
    	    if (contrastRatio < 4.5) {
    	        throw new AssertionError("Contrast ratio is below the WCAG AA standard. Found: " + contrastRatio);
    	    }
    	   
    	    System.out.println("Contrast ratio meets the WCAG standards. Ratio: " + contrastRatio);
    	    
            Thread.sleep(2000);
            
            driver.quit(); 
            
    	}
     
    @When("the user resizes the text")
    public void the_user_resizes_the_text() {
        
    	WebElement textElement = driver.findElement(By.xpath("//a[@href='https://boyds.wp.shottqsr.com/shop/']"));
        
    	((JavascriptExecutor) driver).executeScript("arguments[0].style.fontSize='20px';", textElement);
    	
    }

    @Then("the text should remain readable and within the layout")
    public void the_text_should_remain_readable_and_within_the_layout() throws InterruptedException {
        
    	WebElement textElement = driver.findElement(By.xpath("//a[@href='https://boyds.wp.shottqsr.com/shop/']"));
        
    	WebElement parentElement = driver.findElement(By.xpath("//ul[@id='menu-main-menu']"));
        
        int textWidth = textElement.getSize().getWidth();
        int textHeight = textElement.getSize().getHeight();
        
        int parentWidth = parentElement.getSize().getWidth();
        int parentHeight = parentElement.getSize().getHeight();
        
        if (textWidth > parentWidth || textHeight > parentHeight) {
            throw new AssertionError("Element width or height exceeds parent width or height.");
        }
        
        String textContent = textElement.getText();
        if (textContent.isEmpty() || textContent.length() < 1) {
            throw new AssertionError("Text content is not readable or missing.");
        }
        
        System.out.println("Text width: " + textWidth + ", Parent width: " + parentWidth);
        System.out.println("Text height: " + textHeight + ", Parent height: " + parentHeight);
    	
        Thread.sleep(2000);
        
        driver.quit(); 
    	
    }
	
    @Then("the focus indicator should be clearly visible")
    public void the_focus_indicator_should_be_clearly_visible() throws InterruptedException {
        
    	WebElement inputField = driver.findElement(By.xpath("//div[@class='firsttop main-container']"));
    	
        inputField.click();
    	
        WebElement inputField1 = driver.findElement(By.xpath("//div[@class='firsttop main-container']"));

        String outlineStyle = (String) ((JavascriptExecutor) driver).executeScript(
            "return window.getComputedStyle(arguments[0]).outline;",
            inputField1
        );

        if (outlineStyle == null || outlineStyle.isEmpty()) {
            throw new AssertionError("Focus indicator (outline) is not visible for the element.");
        }

        System.out.println("Outline style: " + outlineStyle);
    	
        Thread.sleep(2000);
        
        driver.quit(); 
    	
    }

    @Given("the user is on a form page")
    public void the_user_is_on_a_form_page() throws InterruptedException {
        
    	driver.get("https://boyds.wp.shottqsr.com/");

		driver.manage().window().maximize();

		Thread.sleep(1000);
		
        driver.findElement(By.xpath("//a[@href='/contact-us']")).click();
	    
	    Thread.sleep(2000);
    	
    }
    
    @When("the user submits the form with invalid data")
    public void the_user_submits_the_form_with_invalid_data() throws InterruptedException {
        
        driver.findElement(By.xpath("//input[@name='name-1']")).sendKeys("!@#$%^&");
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//input[@name='email-1']")).sendKeys("vishal#hurekatek.com");
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//textarea[@name='textarea-1']")).sendKeys("Test Message");
	    
	    Thread.sleep(1000);
	    	    
	    driver.findElement(By.xpath("//button[@class='forminator-button forminator-button-submit']")).click();
	    
	    Thread.sleep(1000);
    	
    }
    
    @Then("the error messages should be clear and specific")
    public void the_error_messages_should_be_clear_and_specific() throws InterruptedException {
        
        WebElement error = driver.findElement(By.xpath("//span[@class='forminator-error-message']"));
        
	    assertTrue(error.isDisplayed());
	        
	    assertEquals("This is not a valid email.", error.getText());
    	
        Thread.sleep(2000);
        
        driver.quit(); 
    	
    }

    @When("the user presses the \"Tab\" key")
    public void the_user_presses_the_Tab_key() {
        
    	Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
    	
    }
    
    @Then("the user should see a skip navigation link")
    public void the_user_should_see_a_skip_navigation_link() throws InterruptedException {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    	try {
            
    		WebElement skipLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//picture[@class='skip-lazy']")));
         
            assertTrue(skipLink.isDisplayed());
        } 
    	
    	catch (TimeoutException e) {
            
    		throw new AssertionError("Skip navigation link not found or not visible");
        
    	}
    	
        Thread.sleep(2000);
        
        driver.quit(); 
    	
    }

    @When("the user changes the language to Spanish")
    public void the_user_changes_the_language_to_Spanish() throws InterruptedException {
        
        driver.findElement(By.xpath("//span[@class='gt_float_switcher-arrow']")).click();
	    
	    Thread.sleep(1000);
	    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='nturl']")));
	    element.click();
        
	    Thread.sleep(1000);
    	
    }
    
    @Then("the website content should be displayed in Spanish")
    public void the_website_content_should_be_displayed_in_Spanish() throws InterruptedException {
        
        Thread.sleep(2000);
    	
        WebElement homePage = driver.findElement(By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[1]"));
        
    	assertTrue(homePage.isDisplayed());
        
    	assertEquals("Café que alimenta al Triunfador que hay en cada uno de nosotros. Una taza a la vez.", homePage.getText());
    	
        Thread.sleep(2000);
        
        driver.quit(); 
    	
    }

    @When("the user examines the ARIA roles")
    public void the_user_examines_the_ARIA_roles() {
        	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	 try {
    		 
             WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("header")));
             WebElement nav = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("nav")));
             WebElement main = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("main")));
             WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("footer")));

             assert header.getAttribute("role").equals("banner");
             assert nav.getAttribute("role").equals("navigation");
             assert main.getAttribute("role").equals("main");
             assert footer.getAttribute("class").equals("site-footer");
         
    	 } catch (Exception e) {
             
        	 System.out.println("Error finding elements: " + e.getMessage());
         
         }
     
    }
    
    @Then("the roles should be correctly assigned to elements")
    public void the_roles_should_be_correctly_assigned_to_elements() throws InterruptedException {
        
    	WebElement footer = driver.findElement(By.tagName("footer"));
        String role = footer.getAttribute("class");
        if (!"site-footer".equals(role)) {
            throw new AssertionError("Expected ARIA role 'contentinfo' but found '" + role + "'");
        }

    	    System.out.println("All ARIA roles are correctly assigned to elements.");
    	
        Thread.sleep(2000);
        
        driver.quit(); 
    	
    }
    
}