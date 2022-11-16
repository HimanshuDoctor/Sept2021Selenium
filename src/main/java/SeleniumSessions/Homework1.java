package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homework1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		ElementUtil elutil = new ElementUtil(driver);
		
//		By Person = By.xpath("(((//div[@class='navFooterLinkCol navAccessibility'])[4])//li)[4]");
//		
//		elutil.doClick(Person);			

		By son2 = By.xpath("//a[text()='Twitter' ]");	

		elutil.doClick(son2);

	}

}
