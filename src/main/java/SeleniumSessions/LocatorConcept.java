package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); // Lunch the Browser
		driver = new ChromeDriver(); 
		//driver.get("https://demo.opencart.com/index.php? route = account/login");
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		// Lunch the url application
		
		// 1.id		
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
		// 2nd: 
//		WebElement emailId = driver.findElement(By.id("input-email")); // create webElement but not perform action  
//		WebElement password = driver.findElement(By.id("input-password")); 
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
		
				
		// 3th: By locator 
		
//		By username = By.id("input-emial");
//		By password = By.id("input-password");
//		
//	    driver.findElement(username).sendKeys("test@gmail.com");
//	    driver.findElement(password).sendKeys("test@123");
	       
//	         // or
		
//	    By username = By.id("input-emial");
//		By password = By.id("input-password");	    
//	    
//	    WebElement emailId = driver.findElement(username);
//	    WebElement pwd = driver.findElement(password);
//		
//	    emailId.sendKeys("test@gmail.com");
//	    pwd.sendKeys("test@123");
//	   
		//4th ; By locator with generic method
	    
//	    By username = By.id("input-emial");
//		By password = By.id("input-password");
//		
//		getElement(username).sendKeys("test@gmail.com");
		
		// call getElement Method directly without creating object,
		//yes because of Method (*1) is static is nature
		
//		getElement(password).sendKeys("test@123");
		
		// in 4th: only one time write a "driver.findElement" (see (*1)in Method ) 
		
		//5th: By locator with generic method(getElement() with action methods)
		
//		By username = By.id("input-emial");
//		By password = By.id("input-password");
//		
//		doSendKeys(username, "test@gmail.com");
//		doSendKeys(password, "test123");
		
		// 6th: ElementUtil class with generic methods ( lesson_5 (07:28) )
		
//		By username = By.id("input-emial");
//		By password = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(username, "test@gmail.com");
//		eleUtil.doSendKeys(password, "test123");
		
		// 7th: String locator Values:
		
		String userNameId = "input-email";
		String passwordId = "input-password";
			
				
		doSendKeys("id", userNameId, "Himanshu@gmail.com");
		doSendKeys("id", passwordId, "Himanshu123");
		
			
	}

	public static By getBy(String locatorType, String locatorValue){
		By locator = null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			System.out.println("please pass the right locator type and value...."); 
			break;
		}
		
		return locator;	
		
	}	
	
	// 4th:( static Method (*1)
	// 01:15 to 01:19  see video ( Generic Method )
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator); 		
	}
	
	// 7th: 
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue)); 	
		
	}
	
	// 5th:
	public static void doSendKeys(By locator, String value){		
		getElement(locator).sendKeys(value);
		
	}
	// 7th:
	public static void doSendKeys(String locatorType, String locatorValue, String value){		
		getElement(locatorType, locatorValue).sendKeys(value);
		
	}
	   

}
