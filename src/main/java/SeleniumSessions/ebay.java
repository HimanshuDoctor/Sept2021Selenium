package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ebay {
	
	
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?");
		ElementUtil elutil = new ElementUtil(driver);
		//Click on register..		
		//driver.findElement(By.linkText("REGISTER")).click();
		elutil.doClick("linkText", "REGISTER");
		// Enter the name.. 
//		driver.findElement(By.id("input-username")).sendKeys("A.P.Doctor");
//		driver.findElement(By.id("input-firstname")).sendKeys("Ashish");
//		driver.findElement(By.id("input-lastname")).sendKeys("Doctor");
//		driver.findElement(By.id("input-email")).sendKeys("Ashish@gmail.com");
		
		elutil.getElement("id", "input-username").sendKeys("Hiren");
		elutil.getElement("name", "firstname").sendKeys("Patel");
		elutil.getElement(By.id("input-lastname")).sendKeys("DDDDDD");
		// Handle drop box:
		Select select = new Select(driver.findElement(By.id("input-country")));
		select.selectByVisibleText("India");
		
		//Password
		driver.findElement(By.id("input-password")).sendKeys("Ashish@123");
		
		
	}

}
