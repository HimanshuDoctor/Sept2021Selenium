package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\himan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	WebDriver driver = new ChromeDriver();//launch chrom
	driver.get("https://www.google.com");
	String title = driver.getTitle();
	System.out.println("page title is; " + title);
	
	// Validation point/checkpoint:( act vs exp):
	
	if(title.equals("Google")) {
		System.out.println("Pass --  correct title");
	}
	else {
		System.out.println("Fail -- incorrect title");
	}
	
	System.out.println(driver.getCurrentUrl());
	
	// driver.quit();// close browser
	driver.close();
	
	
	
	
	
	
	
		
		

	}

}
