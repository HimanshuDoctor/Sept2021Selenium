package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	
	static WebDriver driver;

    public static void main(String[] args) {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.get("https://demo.opencart.com/index.php?route=account/login");
           By emailId = By.id("input-email");
           
           
           
           
//           Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//        		   						.withTimeout(Duration.ofSeconds(10))
//        		   						.pollingEvery(Duration.ofSeconds(2))
//        		   						.ignoring(NoSuchElementException.class)
//        		   						.withMessage("Element is not found....");
           
//           WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
//           email_ele.sendKeys("Himanshu_dctr@gmail.com");	
           
           
           waitForElementPresntUsingFluentWait(emailId , 10, 2).sendKeys("Himanshu@gmail.com");	  
          

	}
    
    public static WebElement waitForElementPresntUsingFluentWait(By locator, int timeOut, int pollingTime) {
    	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(timeOut))
				  .pollingEvery(Duration.ofSeconds(pollingTime))
				  .ignoring(NoSuchElementException.class)
				  .ignoring(StaleElementReferenceException.class)
				  .withMessage("Element is not found....");

    	  		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    	
    }
    
    // Both are same  
    
    public static WebElement waitForElementUsingWebDriverWait(By locator, int timeOut, int pollingTime) {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait
        .pollingEvery(Duration.ofSeconds(pollingTime))
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class)
        .withMessage("Element is not found....");

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }    

    
    
    
    
    
    

}
