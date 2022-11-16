package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VeryfyElement {

	
	static RemoteWebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		// many "text" here .
		// how much text here we check it.
		By formfields = By.className("text");
		int fieldsCount = driver.findElements(formfields).size();
		System.out.println(fieldsCount);
		
		// Elements you will checks ( more then one "elements" (findElements)
		// Validation here 
		
		if(fieldsCount==0) {
			System.out.println("form fields are not available");
		}
		else {
			System.out.println("from fields are available");
		}
		
		// How do to find Single elements // 24:05
		// to verify the single element
		
		By companyLink = By.linkText("Company");
//		By companyLink = By.linkText("Company11");
//		driver.findElement(companyLink).click();
		
		// it is validation here
		
		boolean flag =  driver.findElement(companyLink).isDisplayed();
		System.out.println(flag);
		
		if(driver.findElements(companyLink).size() >=1 ) {
			System.out.println("contact sales link is present on the page");
		}
		
		System.out.println(isElementExist(companyLink));
		// Ans: - element is found...By.linkText: Company
		
		
		

	}
	public static boolean isElementExist( By locator) {
		int elementCount = driver.findElements(locator).size();
		System.out.println("total elements found: " + elementCount);
		
		if(elementCount >= 1) {
			System.out.println("element is found..." + locator);
			return true;				
		}
		else {
			System.out.println("element is not found.." + locator);
			return false; 			
		}
		
	}
	
	

}



