package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sun.org.apache.xpath.internal.operations.Or;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {

	static RemoteWebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		WebElement firstName = driver.findElement(By.id("Form_getForm_Name"));
//		firstName.sendKeys("Himanshu");
		
		
		// Tomorrow id change then . come here Exception.
//		WebElement firstName = driver.findElement(By.id("Form_getForm_Name11"));
		// Exception:- NoSuchElementException 
//		firstName.sendKeys("Himanshu");
		
		// How many className(count) same here.
		// result is "6"
		
//		List<WebElement> list = driver.findElements(By.className("text"));
//		System.out.println(list.size());
		
		// Tomorrow class name change  then "text11" 
		// what will be output.  
		
		List<WebElement> list = driver.findElements(By.className("text11"));
		System.out.println(list.size());
		// Result is here is "0" 
		
		/*
		 * --This more deference between findElement and findElements it is Basic
		 * --deference if locator is wrong when you use driver.findElements (by.id) or
		 * (By.ClasName) Or (By.tegName)Or any others locator staterge, that are using
		 * other locator is wrong. that way not give you No such element Exception,
		 *  Q..it will give you what?
		 *  Ans:-.. No Exception will be thrown here if element is
		 * not found/locator is worng list size will be // '0'
		 */		
		
		
		
	}	
		
}



