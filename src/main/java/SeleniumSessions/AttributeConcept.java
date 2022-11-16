package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		ElementUtil elutil = new ElementUtil(driver);
			
//		String hrefVal = driver.findElement(By.linkText("Amazon Devices")).getAttribute("href");
//		System.out.println(hrefVal);
		
		By amazonDevicesList = By.linkText("Amazon Devices");
		String hrefVal = getAttributeValue(amazonDevicesList, "href");
//		System.out.println(hrefVal);
		
		// here Validation of 'href'
		if(hrefVal.contains("footer_devices")) {
			System.out.println("this is correct href");
		}
		
		
		
		 
		
	}
	 // capture any attribute value (href) or any specific WebElement
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);		
	}
	
	public static String getAttributeValue(By locator, String attrName) {
		String attrVal = getElement(locator).getAttribute(attrName);
		System.out.println(attrVal);
		return attrVal;
	}

}
