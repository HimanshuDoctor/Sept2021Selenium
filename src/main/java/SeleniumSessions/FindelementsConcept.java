package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindelementsConcept {
	
	static RemoteWebDriver driver;
	
	// you have to get the count of all the links / images on the page
	// then print the text of each link on the console
	// avoid blank test

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("https://www.amazon.ca/");
		
		
		//List<WebElement> linksList = driver.findElements(By.tagName("a")); //06:50
		By images = By.tagName("a");
		List<WebElement> linksList = getElements(images);
		
		
		System.out.println("total links: " + linksList.size()); // 326 links available on the page.
		
		// iterate array list
		// For loop
		
//		for(int i=0; i<linksList.size(); i++) {
//			
//			String text = linksList.get(i).getText();				
//			
//			if( ! text.isEmpty()) {
//				System.out.println(text);				
//			}						
//		}		
		
		// For each loop:
		
		for(WebElement e : linksList) {
			String text = e.getText();
			if( ! text.isEmpty()) {
				System.out.println(text);
			}
			
		}		
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
				
	}
		

}
