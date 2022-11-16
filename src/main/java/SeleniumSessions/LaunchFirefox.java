package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\himan\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();//launch Firefox
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
