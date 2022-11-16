package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WroungLocatorSyntax {

	static RemoteWebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		By firstName = By.xpath("//*[@id=\"Form_getForm_Name\"]");
//		By firstName = By.xpath("//*[id=\"Form_getForm_Name\"]");//worng xpath
//		// selenium.NoSuchElementException: n
		
		By firstName = By.xpath("//*[@id=\"Form_getForm_Name\"]");
		By phonNumber = By.cssSelector("#Form_getForm_Contact");
		By emailName = By.cssSelector("Form_getForm_Email");
		driver.findElement(firstName).sendKeys("Himanshu");
		driver.findElement(phonNumber).sendKeys("Naveen");
		driver.findElement(emailName).sendKeys("Himanshu@gmail.com");
		
		// *[@ id="Form_getForm_Name"] -- yes 
		// *[id="Form_getForm_Name"] -- no (NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//*[id="Form_getForm_Name"]"})
		// testing -- no (NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"testing"})
		// InvalidSelectorException
		
	
	}

}
