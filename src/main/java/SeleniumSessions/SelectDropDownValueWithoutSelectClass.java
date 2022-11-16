package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownValueWithoutSelectClass {
	
	// Questions :- SelectDropDownValueWithoutSelectClass
	// not allowed to .get() options
	// not allowed select class aswell

	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		By country = By.id("Form_getForm_Country");	
		
		By countryOptions = By.xpath("//select[@id=\"Form_getForm_Country\"]/option");
		selectDropDownValueWithoutSelect(countryOptions, "India");
				
	}
	
	public static void selectDropDownValueWithoutSelect(By locator, String value) {		
		List<WebElement> contryList = driver.findElements(locator);		
		System.out.println(contryList.size());
		
		for(WebElement e: contryList) {
			String text = e.getText();
//			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
