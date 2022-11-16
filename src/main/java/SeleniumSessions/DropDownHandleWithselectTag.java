package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithselectTag {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement coutry = driver.findElement(By.id("Form_getForm_Country"));
		
		Select select = new Select(coutry);
//		select.selectByIndex(5);                // 1..selectByIndex()   
//		select.selectByVisibleText("India");   // 2..selectByVisibleText()
//		select.selectByValue("Cuba");         // 3..selectByValue()
		
		By country = By.id("Form_getForm_Country");
		doDropDownSelectByIndex(country,10);
		doDropDownSelectByVisibleText(country, "India");
		doDropDownSelectByValue(country,"Cuba" );

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);	
		
	}
	// 1..selectByIndex() 
	
	public static void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	// 2..selectByVisibleText()
	
	public static void doDropDownSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}	
	
	// 3..selectByValue()
	
	public static void doDropDownSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
    }	
	

}
