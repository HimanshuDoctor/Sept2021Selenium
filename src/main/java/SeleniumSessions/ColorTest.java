package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys; // Tab Key
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ColorTest {

		public static void main(String[] args){
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.id("email")).sendKeys("n@gmail.com@.com");
		driver.findElement(By.id("email")).sendKeys(Keys.TAB);// for Tab Key
		
		System.out.println(driver.findElement(By.cssSelector("div.form-group.form-error")).isDisplayed());
		// Result is :- true		
		
	}

}
