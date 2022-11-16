package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomerCSSSelector {
	
	static WebDriver driver;	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("justAnInputBox")).click();
		
//		List<WebElement> choiceList = 
//				driver.findElements(By.cssSelector("span.comboTreeItemTitle"));		
//		for(WebElement e : choiceList) {
//			String text = e.getText();
//			System.out.println(text); 
//		// ---(total 45 data ) 15 data print, Remaining is blank  how to handle blank,  
//				if(text.equals("choice 6 2 3")) {
//					e.click();
//					break;
//				}			
//		}
		
//		// tc_01: single selection:-> ( public static void selectChoice(By locator, String value)
		
		By choices = By.cssSelector("span.comboTreeItemTitle");
		selectChoice(choices, "choice 2");
//		selectChoice(choices, "choice 7");
		
//		// tc_02: multi selection:-> selectChoice(By locator, String... value)..string is 'array'
		
//		selectChoice(choices, "choice 1","choice 2","choice 3","choice 6 2 3" );
		
		// tc_03: All Selection
		
		
//		selectChoice(choices, "ALL");           
		
	}

	public static void selectChoice(By locator, String... value) {
		List<WebElement> choicesList = driver.findElements(locator);

		// Single Selection or Multiple Selection
		boolean flag = false;
		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement e : choicesList) {
				String text = e.getText();
				System.out.println(text);

				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						e.click();
						break;
					}
				}

//		// ---(total 45 data ) 15 data print, Remaining is blank  how to handle blank,  
//				if(text.equals(value)) {
//					e.click();
//					break;
//				}

			}
		} else {
			// all selection logic:
			try {
				for (WebElement e : choicesList) {
					e.click();
				}
			} catch(ElementNotInteractableException e) {
				System.out.println("all choices are over... ");

			}

		}
		if (flag == false) {
			System.out.println("choice is not available...");
		}

	}

}
