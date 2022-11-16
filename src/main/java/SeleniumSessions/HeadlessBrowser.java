package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessBrowser {

	public static void main(String[] args) {
		
		
		//headless:
		//no browser launch( not visible ) / hidden browser
		//testing is happening behind the scene
		//faster ( faster is compare in normal mode )
		
		
		// this is for ChromeOption
		
		 WebDriverManager.chromedriver().setup();
		 
		 ChromeOptions co = new ChromeOptions();
//		 co.addArguments("--headless");
		 co.addArguments("--incognito");
		 WebDriver driver = new ChromeDriver(co); // here browser not open.
			
		
		// this is for Firefox 
		 
//		WebDriverManager.firefoxdriver().setup();
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.addArguments("--headless");
//		WebDriver driver = new FirefoxDriver(fo);
		
		
		
		driver.get("http://www.amazon.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		
		driver.quit();				
		
		

	}

}
