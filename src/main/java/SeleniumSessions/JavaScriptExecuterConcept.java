package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecuterConcept {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.get("https://google.com/");
//		driver.get("https://classic.crmpro.com/index.html");
//		driver.get("https://www.amazon.com/");
		driver.get("https://www.linkedin.com/feed/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("Himanshu.p.doctor@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Mahant@14");
		driver.findElement(By.xpath("//button[@class = 'btn__primary--large from__button--floating']")).click();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("alert('hi')");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		
//		jsUtil.generateAlert("this is my js pop up");
		
//		String innerText = jsUtil.getPageInnerText();
//		System.out.println(innerText);
//		System.out.println(innerText.contains("customer service"));
		
//		jsUtil.refreshBrowserByJS();
		
//		WebElement login = driver.findElement(By.xpath("//input[@type ='submit']")); 
//		WebElement loginform = driver.findElement(By.id("loginForm")); 
//		jsUtil.drawBorder(loginform);
		
//		jsUtil.flash(loginform);
		
//		
//		WebElement register = driver.findElement(By.className("nav-link"));		
//		jsUtil.clickElementByJS(register);
		
//		jsUtil.scrollPageDown();
//		Thread.sleep(3000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(3000);
//		jsUtil.scrollPageDown("500");
		
		WebElement link = driver.findElement(By.xpath("//span[text()='Hitesh Choudhary']"));		
		jsUtil.scrollIntoView(link);

	}

}
